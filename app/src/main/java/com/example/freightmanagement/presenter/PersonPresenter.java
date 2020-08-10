package com.example.freightmanagement.presenter;

import com.example.freightmanagement.Base.BaseApiConstants;
import com.example.freightmanagement.Base.BasePresenter;
import com.example.freightmanagement.Base.BaseResponse;
import com.example.freightmanagement.Utils.Network.OnRequestResultForCommon;
import com.example.freightmanagement.Utils.Network.RestApi;
import com.example.freightmanagement.enums.ResponseCodeEnum;
import com.example.freightmanagement.model.AccountParam;
import com.example.freightmanagement.presenter.constract.LoginConstact;
import com.example.freightmanagement.presenter.constract.PersonConstact;
import com.google.gson.Gson;

public class PersonPresenter extends BasePresenter<PersonConstact.View> implements PersonConstact {


    @Override
    public void getData(String usrId) {
        RestApi.getInstance().get(BaseApiConstants.API_DRIVERINFORMATION.concat(usrId), new OnRequestResultForCommon() {
            @Override
            public void onSuccess(String json) {
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
