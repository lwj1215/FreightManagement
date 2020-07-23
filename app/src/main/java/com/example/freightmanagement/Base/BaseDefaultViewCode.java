package com.example.freightmanagement.Base;


import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({BaseDefaultViewCode.DATA_LOADING, BaseDefaultViewCode.DATA_NULL, BaseDefaultViewCode.NET_ERROR,
        BaseDefaultViewCode.DATA_ERROR, BaseDefaultViewCode.DATA_NORMAL})
@Retention(RetentionPolicy.SOURCE)
public @interface BaseDefaultViewCode {

    /**
     * 开始请求（空白页面）
     */
    int DATA_LOADING = 155563;
    /**
     * 无数据内容  (暂无相关数据)
     */
    int DATA_NULL = 155564;
    /**
     * 无网络页面 (4G、WIFI关闭)
     */
    int NET_ERROR = 155565;
    /**
     * 获取数据失败“重新加载”页面
     */
    int DATA_ERROR = 155566;
    /**
     * 数据内容显示正常（隐藏异常页面）
     */
    int DATA_NORMAL = 155567;

}
