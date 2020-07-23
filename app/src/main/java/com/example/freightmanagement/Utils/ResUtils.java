package com.example.freightmanagement.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;

import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

import com.example.freightmanagement.Base.BaseApplication;


/**
 * @author ztc
 * @Data 2019/8/2
 * 获取res资源的工具类
 */
public class ResUtils {

    public static String getString(@StringRes int resId) {
        return getString(BaseApplication.getApp(), resId);
    }

    public static String getString(Context context, @StringRes int resId) {
        return context.getResources().getString(resId);
    }

    public static int getDimen(@DimenRes int resId) {
        return getDimen(BaseApplication.getApp(), resId);
    }

    public static int getDimen(Context context, @DimenRes int resId) {
        return context.getResources().getDimensionPixelOffset(resId);
    }

    public static int getColor(@ColorRes int resId) {
        return getColor(BaseApplication.getApp(), resId);
    }

    public static int getColor(Context context, @ColorRes int resId) {
        return context.getResources().getColor(resId);
    }

    public static Drawable getDrawable(@DrawableRes int resId) {
        return BaseApplication.getApp().getResources().getDrawable(resId);
    }

    public static Bitmap getBitmap(@DrawableRes int resId) {
        return BitmapFactory.decodeResource(BaseApplication.getApp().getResources(), resId);
    }
}