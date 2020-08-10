package com.example.freightmanagement.presenter.constract;


import com.example.freightmanagement.Base.BaseView;
import com.example.freightmanagement.model.AccountParam;

public interface PersonConstact {

    /**
     * 获取驾驶员信息
     *
     * @param
     */
    void getData(String usrId);

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
