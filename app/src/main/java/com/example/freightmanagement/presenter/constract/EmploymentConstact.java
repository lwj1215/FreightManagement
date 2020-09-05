package com.example.freightmanagement.presenter.constract;

import com.example.freightmanagement.Base.BaseView;
import com.example.freightmanagement.Bean.WrodIdBean;
import com.example.freightmanagement.model.ContractParam;
import com.example.freightmanagement.model.company.CompanySubmitParam;

import java.io.File;

/**
 * Created by songdechuan on 2020/8/13.
 */

public interface EmploymentConstact {


    void upload(File file, int type);

    void submit(ContractParam contractParam);

    void get(String id);

    void getDriver();

    interface View extends BaseView {
        void success();
        void imageUrl(String url, int type);

        void driverInfo(WrodIdBean wrodIdBean);
    }
}
