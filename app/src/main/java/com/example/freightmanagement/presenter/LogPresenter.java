package com.example.freightmanagement.presenter;

import com.example.freightmanagement.Base.BaseApiConstants;
import com.example.freightmanagement.Base.BasePresenter;
import com.example.freightmanagement.Utils.Network.OnRequestResultForCommon;
import com.example.freightmanagement.Utils.Network.RestApi;
import com.google.gson.JsonObject;

public class LogPresenter extends BasePresenter<LogConstact.View> implements LogConstact {


    @Override
    public void getCode() {//获取支付列表
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("userId", "");//需要上传得参数
        RestApi.getInstance().post(BaseApiConstants.API_LOG, jsonObject.toString(), new OnRequestResultForCommon() {
            @Override
            public void onSuccess(String json) {
                super.onSuccess(json);
                mView.getDataSuc();

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
