package com.example.freightmanagement.presenter;

import com.example.freightmanagement.Base.BasePresenter;
import com.example.freightmanagement.Base.BaseResponse;
import com.example.freightmanagement.Utils.Network.OnRequestResultForCommon;
import com.example.freightmanagement.Utils.Network.RestApi;
import com.example.freightmanagement.enums.ResponseCodeEnum;
import com.example.freightmanagement.model.AdminParam;
import com.example.freightmanagement.presenter.constract.ChangePasswordConstact;
import com.google.gson.Gson;

import static com.example.freightmanagement.Base.BaseApiConstants.API_CHANGE_PASS;

public class ChangePasswordPresenter extends BasePresenter<ChangePasswordConstact.View> implements ChangePasswordConstact {

    @Override
    public void submit(AdminParam submitParam) {
        String json = new Gson().toJson(submitParam);
        RestApi.getInstance().post(API_CHANGE_PASS, json, new OnRequestResultForCommon() {
            @Override
            public void onSuccess(String json) {
                super.onSuccess(json);
                BaseResponse response = new Gson().fromJson(json,BaseResponse.class);
                if(response.getCode() == ResponseCodeEnum.SUCCESS.getCode()){
                    mView.success();
                }else {
                    mView.failed(json);
                }
            }

            @Override
            public void onFail() {
                super.onFail();
                mView.failed("");
            }

            @Override
            public void netUnlink() {
                super.netUnlink();
            }

        });
    }
}
