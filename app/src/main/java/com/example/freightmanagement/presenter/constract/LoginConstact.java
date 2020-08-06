package com.example.freightmanagement.presenter.constract;


import com.example.freightmanagement.Base.BaseView;
import com.example.freightmanagement.model.AccountParam;

public interface LoginConstact {

    /**
     * 调取登录接口
     *
     * @param
     */
    void login(AccountParam accountParam);

    interface View extends BaseView {

        /**
         * 回调成功
         *  @param
         * @param
         * @param
         * @param
         */
        void getDataSuc();

        void onFailed(String error);
    }
}
