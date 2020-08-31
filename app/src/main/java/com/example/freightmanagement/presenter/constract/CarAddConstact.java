package com.example.freightmanagement.presenter.constract;

import com.example.freightmanagement.Base.BaseView;

import java.io.File;

/**
 * Created by songdechuan on 2020/8/13.
 */

public interface CarAddConstact {

    void upload(File file, int type);

    interface View extends BaseView {
        void imageUrl(String url, int type);

    }
}
