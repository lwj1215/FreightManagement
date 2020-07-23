package com.example.freightmanagement.Utils;

import android.os.Handler;

import com.example.freightmanagement.Base.BaseApplication;

import java.util.Timer;
import java.util.TimerTask;


/**
 * @author ztc
 */
public class ToastUtils {
    private ToastUtils() {
    }

    private static TipsToast mToast;
    private static final int mDuration = 1400;

    public static void popUpToast(String text) {
        try {
//            if (mToast != null) {
//                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
//                    mToast.cancel();
//                }
//            } else {
//            }
            mToast = TipsToast.makeText(BaseApplication.getApp(), text, TipsToast.LENGTH_SHORT);
            mToast.setText(text);
            final Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    mToast.show();
                }
            }, 0, mDuration);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mToast.cancel();
                    timer.cancel();
                }
            }, mDuration);
//            new Timer().schedule(new TimerTask() {
//                @Override
//                public void run() {
//                    mToast.cancel();
//                    timer.cancel();
//                }
//            }, mDuration);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void popUpToast(int resId) {
        popUpToast(ResUtils.getString(resId));
    }
}
