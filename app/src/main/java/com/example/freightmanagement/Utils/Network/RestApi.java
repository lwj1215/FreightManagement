package com.example.freightmanagement.Utils.Network;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Nullable;

import com.example.freightmanagement.Base.BaseApplication;
import com.example.freightmanagement.Base.TokenHeaderInterceptor;
import com.example.freightmanagement.Bean.TokenBean;
import com.example.freightmanagement.Utils.NetUtils;
import com.example.freightmanagement.Utils.PrefUtilsData;
import com.example.freightmanagement.Utils.StringUtils;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
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

    public RestApi() {
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
        Log.i(TAG, "post: "+jsonValue+url);
        RequestBody formBody = RequestBody.create(MEDIA_TYPE_BODY, jsonValue);
//        RequestBody formBody = FormBody.create(MediaType.parse("application/json"), jsonValue);

        Request request = new Request.Builder()
                .url(Host.BASE_URL + url)
                .post(formBody)
                .build();
        enqueue("", request, new OnRequestResultForCommon() {
            @Override
            public void onSuccess(String json) {
                //保存token
                TokenBean stateBean = new Gson().fromJson(json, TokenBean.class);
                if ("0".equals(stateBean.getCode())) {
                    PrefUtilsData.setToken(stateBean.getData().getToken());
                }
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
     * 请求公共方法
     */
    public void postJson(String url, String jsonValue, @Nullable final OnRequestResult callback) {
        Log.i(TAG, "post: "+jsonValue+url);
//        RequestBody formBody = new FormBody.Builder()
//                .add("", jsonValue)
//                .build();
        RequestBody formBody = RequestBody.create(MEDIA_TYPE_BODY, jsonValue);
//        RequestBody formBody = FormBody.create(MediaType.parse("application/json"), jsonValue);

        Request request = new Request.Builder()
                .url(Host.BASE_URL + url)
//                .addHeader("content-type", "application/json;charset:utf-8")
                .post(formBody)
                .build();
        enqueue("", request, new OnRequestResultForCommon() {
            @Override
            public void onSuccess(String json) {
                //保存token
                TokenBean stateBean = new Gson().fromJson(json, TokenBean.class);
                if ("0".equals(stateBean.getCode())) {
                    PrefUtilsData.setToken(stateBean.getData().getToken());
                }
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
     * 请求公共方法
     */
    public  void get(final String url, @Nullable final OnRequestResultForCommon callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Request request = new Request.Builder().url(Host.BASE_URL+url).build(); //添加头部信息
                mClient.newCall(request);
                enqueue("", request, new OnRequestResultForCommon() {
                    @Override
                    public void onSuccess(String json) {
//                        //保存token
//                        TokenBean stateBean = new Gson().fromJson(json, TokenBean.class);
//                        if ("0".equals(stateBean.getCode())) {
//                            PrefUtilsData.setToken(stateBean.getData().getToken());
//                        }
                        if (callback != null) callback.onSuccess(json);
                    }

                    @Override
                    public void onFail() {
                        if (callback != null) callback.onFail();
                    }

                    @Override
                    public void netUnlink() {
                        if (callback != null) callback.netUnlink();}
                });
            }

        }).start();

    }
    /**
     * 添加到请求队列请求
     */
    public void enqueue(final String tag, Request request, @Nullable final OnRequestResultForCommon callback) {
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
                                if (callback != null)
                                    callback.onSuccess(body);
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

    public void postImage(String url, File file, @Nullable final OnRequestResultForCommon callback) {
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
        enqueue("", request, new OnRequestResultForCommon() {
            @Override
            public void onSuccess(String json) {
                //保存token
//                TokenBean stateBean = new Gson().fromJson(json, TokenBean.class);
//                if (stateBean.getLoginstate()!=null&&stateBean.getLoginstate().equals("0")) {
//                    PrefUtilsData.setToken(stateBean.getUser_token());
//                }
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
     * 微信的第三方登录  qq需要另外的一个接口
     */
    public void loginForThird(String thirdId, String accessToken, String thirdSource, @Nullable final OnRequestResult callback) {
        RequestBody formBody = new FormBody.Builder()
                .add("openId", thirdId)
                .add("thirdSource", thirdSource)
                .add("weChatSys", "561D5D57512C70E58C7A661A14014334")
                .build();
        String url = "https://api.weixin.qq.com/sns/userinfo?access_token="
                + accessToken
                + "&openid="
                + thirdId;
        Request request = new Request.Builder()
                .url(url)
                .build();
        enqueue("第三方登录", request, new OnRequestResultForCommon() {
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

}