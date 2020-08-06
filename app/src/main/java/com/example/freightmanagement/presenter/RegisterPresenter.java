package com.example.freightmanagement.presenter;

import com.example.freightmanagement.Base.BaseApiConstants;
import com.example.freightmanagement.Base.BasePresenter;
import com.example.freightmanagement.Utils.Network.OnRequestResultForCommon;
import com.example.freightmanagement.Utils.Network.RestApi;
import com.example.freightmanagement.model.AccountParam;
import com.example.freightmanagement.presenter.constract.RegisterConstact;
import com.google.gson.Gson;

public class RegisterPresenter extends BasePresenter<RegisterConstact.View> implements RegisterConstact {


    @Override
    public void getCode(String tel) {//获取支付列表
        RestApi.getInstance().get(BaseApiConstants.API_SMS_CODE.concat(tel), new OnRequestResultForCommon() {
            @Override
            public void onSuccess(String json) {
                mView.smsCode(json);
            }

            @Override
            public void onFail() {
                super.onFail();
            }

            @Override
            public void netUnlink() {
                super.netUnlink();
            }
        });
    }

    @Override
    public void register(AccountParam accountParam) {
        String json = new Gson().toJson(accountParam);
        RestApi.getInstance().post(BaseApiConstants.API_REGISTER, json, new OnRequestResultForCommon() {
            @Override
            public void onSuccess(String msg) {
                mView.registerResult(msg);
            }

            @Override
            public void onFail() {
                super.onFail();
            }

            @Override
            public void netUnlink() {
                super.netUnlink();
            }
        });
    }

}
