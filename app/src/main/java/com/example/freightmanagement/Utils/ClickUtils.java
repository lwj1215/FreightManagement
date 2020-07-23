package com.example.freightmanagement.Utils;

/**
 * @author ztc
 * @Data 2019/8/5
 */

public class ClickUtils {

    private static final int CLICK_INTERVAL = 1000;
    private static long lastClickTime = 0;

    /**
     * 是否可以点击
     *
     * @return true 点击有效 false 点击无效
     */
    public static boolean isClick() {
        boolean flag = true;
        long curClickTime = System.currentTimeMillis();
        if (curClickTime - lastClickTime <=CLICK_INTERVAL) {
            flag = false;
        }
        lastClickTime = curClickTime;
        return flag;
    }


}
