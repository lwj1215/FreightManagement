package com.example.freightmanagement.presenter;

import com.example.freightmanagement.Base.BaseApiConstants;
import com.example.freightmanagement.Base.BasePresenter;
import com.example.freightmanagement.Utils.Network.OnRequestResultForCommon;
import com.example.freightmanagement.Utils.Network.RestApi;
import com.example.freightmanagement.model.AccountParam;
import com.example.freightmanagement.presenter.constract.FoegetPwdConstact;
import com.google.gson.Gson;

/**
 * Created by songdechuan on 2020/8/6.
 */

public class ForgetPwdPresenter extends BasePresenter<FoegetPwdConstact.View> implements FoegetPwdConstact {


    @Override
    public void getCode(String tel) {
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
    public void retrievePassword(AccountParam accountParam) {
        String json = new Gson().toJson(accountParam);
        RestApi.getInstance().post(BaseApiConstants.API_RETRIEVE_PWD, json, new OnRequestResultForCommon() {
            @Override
            public void onSuccess(String msg) {
                mView.result(msg);
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
