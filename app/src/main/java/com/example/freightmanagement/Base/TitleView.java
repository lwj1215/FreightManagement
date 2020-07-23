package com.example.freightmanagement.Base;

import android.content.Context;

/**
 * @author by : ztc
 * @date :2019/8/2
 * @Deprecated 可以直接new 或者 在xml中使用
 */
public class TitleView {

    public static BaseTitleView getTitle(Context context) {
        return new BaseTitleView(context);
    }

}