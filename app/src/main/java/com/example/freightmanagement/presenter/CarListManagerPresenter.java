package com.example.freightmanagement.presenter;

import com.example.freightmanagement.Base.BasePresenter;
import com.example.freightmanagement.Bean.ImageUploadBean;
import com.example.freightmanagement.Utils.Network.OnRequestResultForCommon;
import com.example.freightmanagement.Utils.Network.RestApi;
import com.example.freightmanagement.model.CarExecuteParam;
import com.example.freightmanagement.presenter.constract.CarListManagerConstact;
import com.google.gson.Gson;

import java.util.List;

import static com.example.freightmanagement.Base.BaseApiConstants.API_CAR_DEL;
import static com.example.freightmanagement.Base.BaseApiConstants.API_CAR_LIST;
import static com.example.freightmanagement.Base.BaseApiConstants.API_DRIVER_LIST;
import static com.example.freightmanagement.Base.BaseApiConstants.API_IMAGE_UPLOAD;

public class CarListManagerPresenter extends BasePresenter<CarListManagerConstact.View> implements CarListManagerConstact {

    @Override
    public void getList() {
        RestApi.getInstance().post(API_CAR_LIST, "", new OnRequestResultForCommon() {
            @Override
            public void onSuccess(String json) {
                super.onSuccess(json);
               mView.carListResult(json);
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
    public void delete(List<Integer> ids) {
        String json = new Gson().toJson(ids);
        RestApi.getInstance().post(API_CAR_DEL ,json, new OnRequestResultForCommon() {
            @Override
            public void onSuccess(String json) {
                super.onSuccess(json);
                mView.delResult(json);
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
