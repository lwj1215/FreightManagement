package com.example.freightmanagement.presenter;


import com.example.freightmanagement.Base.BaseView;

public interface LogConstact {

    /**
     * 调取登录接口
     *
     * @param
     */
    void getCode();

    interface View extends BaseView {

        /**
         * 回调成功
         *  @param
         * @param
         * @param
         * @param
         */

        void getDataSuc();

    }
}
