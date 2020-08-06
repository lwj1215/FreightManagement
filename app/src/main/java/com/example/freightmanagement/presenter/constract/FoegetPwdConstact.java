package com.example.freightmanagement.presenter.constract;

import com.example.freightmanagement.Base.BaseView;
import com.example.freightmanagement.model.AccountParam;

/**
 * Created by songdechuan on 2020/8/6.
 */

public interface FoegetPwdConstact {

    void getCode(String tel);

    void retrievePassword(AccountParam accountParam);

    interface View extends BaseView{
        void smsCode(String msg);
        void result(String msg);
    }
}
