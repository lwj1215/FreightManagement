package com.example.freightmanagement.presenter.constract;

import com.example.freightmanagement.Base.BaseView;

import java.io.File;

public interface ResponsibilityBookConstact {


    void upload(File file, int type);

    interface View extends BaseView {
        void success();
        void imageUrl(String url, int type);

    }
}
