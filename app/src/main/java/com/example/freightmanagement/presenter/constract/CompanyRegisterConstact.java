package com.example.freightmanagement.presenter.constract;

import com.example.freightmanagement.Base.BaseView;
import com.example.freightmanagement.Bean.QiYeBean;
import com.example.freightmanagement.model.DriverInfoSubmitParam;
import com.example.freightmanagement.model.company.CompanySubmitParam;

import java.io.File;

/**
 * Created by songdechuan on 2020/8/13.
 */

public interface CompanyRegisterConstact {

    void submit(CompanySubmitParam submitParam);
    void updata2(CompanySubmitParam submitParam);
    void getQyData();
    void upload(File file, int type);

    interface View extends BaseView {
        void success();
        void imageUrl(String url, int type);
        void qiyeSuc(QiYeBean.DataBean data);

    }
}
