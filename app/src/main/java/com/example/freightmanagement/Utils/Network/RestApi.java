package com.example.freightmanagement.Utils.Network;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.freightmanagement.Base.BaseApplication;
import com.example.freightmanagement.Base.TokenHeaderInterceptor;
import com.example.freightmanagement.Utils.NetUtils;
import com.example.freightmanagement.Utils.PrefUtilsData;
import com.example.freightmanagement.Utils.StringUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RestApi {
    private static final String TAG = "测试";
    private static RestApi sRestApi = null;
    private final Handler mDelivery;
    private OkHttpClient mClient;
    private static final MediaType MEDIA_TYPE_BODY = MediaType.parse("application/json; charset=utf-8");

    private RestApi() {
        if (mClient == null) {
            mClient = new OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(20, TimeUnit.SECONDS)
                    .addNetworkInterceptor(new TokenHeaderInterceptor())
                    .build();
        }
        mDelivery = new Handler(Looper.getMainLooper());
    }


    public static synchronized RestApi getInstance() {
        if (sRestApi == null) {
            sRestApi = new RestApi();
        }
        return sRestApi;
    }


    /**
     * 请求公共方法
     */
    public void post(String url, String jsonValue, @Nullable final OnRequestResult callback) {
        Log.i("提交", "post: " + jsonValue + url);
        RequestBody formBody = RequestBody.create(MEDIA_TYPE_BODY, jsonValue);
        Request request = new Request.Builder()
                .url(Host.BASE_URL + url)
                .post(formBody)
                .build();
        enqueue("", request, new OnRequestResult() {
            @Override
            public void onSuccess(String json) {
                if (callback != null) callback.onSuccess(json);
            }

            @Override
            public void onFail() {
                if (callback != null) callback.onFail();

            }

            @Override
            public void netUnlink() {
                if (callback != null) callback.netUnlink();
            }
        });
    }

    /**
     * 添加到请求队列请求
     */
    public void enqueue(final String tag, Request request, @Nullable final OnRequestResult callback) {
        if (BaseAppUtils.isDebug()) {
            RequestBody body = request.body();
            if (body == null) {
                Log.e(TAG, tag + "无请求数据");
            } else if (body instanceof FormBody) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < ((FormBody) body).size(); i++) {
                    String name = ((FormBody) body).name(i);
                    String value = ((FormBody) body).value(i);
                    if (stringBuilder.length() != 0) stringBuilder.append("    ");
                    stringBuilder.append(name).append("=").append(value);
                }
                Log.w(TAG, tag + "请求的数据 : " + stringBuilder.toString());
            } else {
                Log.w(TAG, tag + "请求的数据类型为 : " + body.getClass());
            }
        }
        if (!NetUtils.isNetworkconnected(BaseApplication.getApp())) {
            try {
                if (callback != null) callback.netUnlink();
            } catch (Exception e) {
                Log.e(TAG, "crashInfo: ", e);
            }
            return;
        }
        mClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.w(TAG, tag + "返回的数据 : " + e.getMessage());
                mDelivery.post(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            if (callback != null) callback.onFail();
                        } catch (Exception e) {
                            Log.e(TAG, "crashInfo: ", e);
                        }
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String body = response.body().string();
                Log.i(TAG, "onResponse: " + body);
                if (!StringUtils.isJson(body)) {
                    onFailure(call, new IOException("不是json"));
                } else {
                    mDelivery.post(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                //请求成功
                                if (callback != null) callback.onSuccess(body);

                                JSONObject jsonObject = new JSONObject(body);
                                String token = jsonObject.getString("token");
                                PrefUtilsData.setToken(token);

                            } catch (Exception e) {
                                Log.e(TAG, "crashInfo: ", e);
                            }
                        }
                    });
                }
            }
        });
    }

    /**
     * 图片上传
     */

    public void postImage(String url, File file, @Nullable final OnRequestResult callback) {
        String encode = "";
        try {
            encode = URLEncoder.encode(file.getName(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        RequestBody fileBody = RequestBody.create(MediaType.parse("application/octet-stream"), file);
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file", encode, fileBody)
                .build();
        Request request = new Request.Builder()
                .url(Host.BASE_URL + url)
                .post(requestBody)
                .build();
        enqueue("", request, new OnRequestResult() {
            @Override
            public void onSuccess(String json) {
                //保存token
                if (callback != null) callback.onSuccess(json);
            }

            @Override
            public void onFail() {
                if (callback != null) callback.onFail();

            }

            @Override
            public void netUnlink() {
                if (callback != null) callback.netUnlink();
            }
        });
    }


    public void get(final String url, @Nullable final OnRequestResult callback) {

        Log.i("提交", "post: " + url);
        new Thread(new Runnable() {
            @Override
            public void run() {
                Request request = new Request.Builder().url(Host.BASE_URL + url).build(); //添加头部信息
                mClient.newCall(request);
                enqueue("", request, new OnRequestResult() {
                    @Override
                    public void onSuccess(String json) {
                        //保存token
                        if (callback != null) callback.onSuccess(json);
                    }

                    @Override
                    public void onFail() {
                        if (callback != null) callback.onFail();
                    }

                    @Override
                    public void netUnlink() {
                        if (callback != null) callback.netUnlink();
                    }
                });
            }

        }).start();

    }
}