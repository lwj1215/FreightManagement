package com.example.freightmanagement.presenter.constract;

import com.example.freightmanagement.Base.BaseView;
import com.example.freightmanagement.model.CarOwnerSubmitParam;
import com.example.freightmanagement.model.company.CompanySubmitParam;

import java.io.File;

/**
 * Created by songdechuan on 2020/8/13.
 */

public interface CarOwnerConstact {

    void submit(CarOwnerSubmitParam submitParam);

    void upload(File file, int type);

    interface View extends BaseView {
        void success();
        void imageUrl(String url, int type);

    }
}
