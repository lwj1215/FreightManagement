package com.example.freightmanagement.presenter.constract;

import com.example.freightmanagement.Base.BaseView;
import com.example.freightmanagement.model.AdminParam;
import com.example.freightmanagement.model.company.CompanySubmitParam;


public interface ChangePasswordConstact {

    void submit(AdminParam submitParam);

    interface View extends BaseView {
        void success();
        void failed(String error);
    }
}
