package com.example.freightmanagement.presenter.constract;

import com.example.freightmanagement.Base.BaseView;

import com.example.freightmanagement.model.DriverInfoSubmitParam;

import java.io.File;

/**
 * Created by songdechuan on 2020/8/13.
 */

public interface DriverConfigConstact {

    void submit(DriverInfoSubmitParam param);

    void upload(File file,int type);

    interface View extends BaseView {
        void imageUrl(String url,int type);

        void success(String json);

    }
}
