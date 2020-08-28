package com.example.freightmanagement.presenter.constract;

import com.example.freightmanagement.Base.BaseView;
import com.example.freightmanagement.model.company.CompanySubmitParam;


public interface ChangePasswordConstact {

    void submit(CompanySubmitParam submitParam);

    interface View extends BaseView {
        void success();
    }
}
