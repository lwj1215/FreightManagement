package com.example.freightmanagement.presenter.constract;

import com.example.freightmanagement.Base.BaseView;

import com.example.freightmanagement.model.DriverInfoSubmitParam;

/**
 * Created by songdechuan on 2020/8/13.
 */

public interface DriverConfigConstact {

    void submit(DriverInfoSubmitParam submitParam);

    interface View extends BaseView {
        void success();
    }
}
