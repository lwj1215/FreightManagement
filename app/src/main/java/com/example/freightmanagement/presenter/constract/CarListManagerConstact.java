package com.example.freightmanagement.presenter.constract;

import com.example.freightmanagement.Base.BaseView;

import java.io.File;

/**
 * Created by songdechuan on 2020/8/13.
 */

public interface CarListManagerConstact {

    void getList();

    interface View extends BaseView {
        void success(String url, int type);
    }
}
