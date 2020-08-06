package com.example.freightmanagement.presenter.constract;

import com.example.freightmanagement.Base.BaseView;
import com.example.freightmanagement.model.AccountParam;

/**
 * Created by songdechuan on 2020/8/6.
 */

public interface RegisterConstact {

    void getCode(String tel);

    void register(AccountParam accountParam);

    interface View extends BaseView{
        void smsCode(String msg);
        void registerResult(String msg);
    }
}
