package com.example.freightmanagement.presenter.constract;

import com.example.freightmanagement.Base.BaseView;
import com.example.freightmanagement.model.DriverInfoSubmitParam;

import java.io.File;

public interface PromiseBookConstact {


    void upload(File file, int type);

    interface View extends BaseView {
        void success();
        void imageUrl(String url, int type);

    }
}
