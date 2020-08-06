package com.example.freightmanagement.Base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.baidu.ocr.sdk.OCR;
import com.baidu.ocr.sdk.OnResultListener;
import com.baidu.ocr.sdk.exception.OCRError;
import com.baidu.ocr.sdk.model.AccessToken;
import com.qiniu.pili.droid.streaming.StreamingEnv;

import java.util.ArrayList;
import java.util.List;

import static com.example.freightmanagement.common.ApiConstants.BAIDU_API_KEY;
import static com.example.freightmanagement.common.ApiConstants.BAIDU_SECRET_KEY;

/**
 * @author: ztc
 * 2019/8/2
 */

public class BaseApplication extends Application {
    private static BaseApplication mBaseApplication;
    private List<Activity> mActivityList = new ArrayList<>();

    @Override
    final protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mBaseApplication = this;
        StreamingEnv.init(mBaseApplication);
        initAccessTokenWithAkSk();
    }
    /**
     * 用明文ak，sk初始化
     */
    private void initAccessTokenWithAkSk() {
        OCR.getInstance(this).initAccessTokenWithAkSk(new OnResultListener<AccessToken>() {
            @Override
            public void onResult(AccessToken result) {
                String token = result.getAccessToken();
//                hasGotToken = true;
            }

            @Override
            public void onError(OCRError error) {
                error.printStackTrace();
//                alertText("AK，SK方式获取token失败", error.getMessage());
            }
        }, getApplicationContext(),  BAIDU_API_KEY, BAIDU_SECRET_KEY);
    }

    /**
     * 把界面添加到集合
     *
     * @param activity activity对象
     */
    final public void addActivity(Activity activity) {
        if (!mActivityList.contains(activity)) {
            mActivityList.add(activity);
        }
    }

    /**
     * 移除Activity
     *
     * @param activity activity对象
     */
    final public void removeActivity(Activity activity) {
        if (!mActivityList.isEmpty()) {
            mActivityList.remove(activity);
        }
    }

    /**
     * 移除所有Activity
     */
    final public void clearActivity() {
        for (int i = mActivityList.size(); i > 0; i--) {
            Activity activity = mActivityList.get(i - 1);
            if (activity != null) {
                activity.finish();
            }
            mActivityList.remove(i - 1);
        }
    }

    public static BaseApplication getApp() {
        return mBaseApplication;
    }

}