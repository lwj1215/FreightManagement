package com.example.freightmanagement.presenter;

import com.example.freightmanagement.Base.BaseApiConstants;
import com.example.freightmanagement.Base.BasePresenter;
import com.example.freightmanagement.Base.BaseResponse;
import com.example.freightmanagement.Utils.Network.OnRequestResultForCommon;
import com.example.freightmanagement.Utils.Network.RestApi;
import com.example.freightmanagement.enums.ResponseCodeEnum;
import com.example.freightmanagement.model.AccountParam;
import com.example.freightmanagement.presenter.constract.LoginConstact;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class LoginPresenter extends BasePresenter<LoginConstact.View> implements LoginConstact {


    @Override
    public void login(AccountParam accountParam) {
        String json = new Gson().toJson(accountParam);
        RestApi.getInstance().post(BaseApiConstants.API_LOGIN, json, new OnRequestResultForCommon() {
            @Override
            public void onSuccess(String json) {
                super.onSuccess(json);
                BaseResponse response = new Gson().fromJson(json, BaseResponse.class);
                int code = response.getCode();
                if(code == ResponseCodeEnum.SUCCESS.getCode()){
                    mView.getDataSuc();
                }else {
                    mView.onFailed(json);
                }

            }

            @Override
            public void onFail() {
//                super.onFail();
                mView.getDataSuc();
            }

            @Override
            public void netUnlink() {
                super.netUnlink();
            }
        });
    }
}
