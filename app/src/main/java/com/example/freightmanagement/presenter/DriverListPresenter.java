package com.example.freightmanagement.presenter;

import com.example.freightmanagement.Base.BasePresenter;
import com.example.freightmanagement.Bean.ImageUploadBean;
import com.example.freightmanagement.Utils.Network.OnRequestResultForCommon;
import com.example.freightmanagement.Utils.Network.RestApi;
import com.example.freightmanagement.model.CarExecuteParam;
import com.example.freightmanagement.presenter.constract.DriverListConstact;
import com.google.gson.Gson;

import static com.example.freightmanagement.Base.BaseApiConstants.API_CAR_DEL;
import static com.example.freightmanagement.Base.BaseApiConstants.API_DRIVER_LIST;

public class DriverListPresenter extends BasePresenter<DriverListConstact .View> implements DriverListConstact {

    @Override
    public void getList() {
        RestApi.getInstance().post(API_DRIVER_LIST, "", new OnRequestResultForCommon() {
            @Override
            public void onSuccess(String json) {
                super.onSuccess(json);
                mView.success(json);
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
    public void delete(CarExecuteParam param) {

    }
}
