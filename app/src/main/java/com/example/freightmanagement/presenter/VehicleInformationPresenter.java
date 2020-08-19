package com.example.freightmanagement.presenter;

import com.example.freightmanagement.Base.BaseApiConstants;
import com.example.freightmanagement.Base.BasePresenter;
import com.example.freightmanagement.Bean.TrainingStartBean;
import com.example.freightmanagement.Utils.Network.OnRequestResultForCommon;
import com.example.freightmanagement.Utils.Network.RestApi;
import com.example.freightmanagement.presenter.constract.VehicleInformationConstact;
import com.google.gson.Gson;

public class VehicleInformationPresenter extends BasePresenter<VehicleInformationConstact.View> implements VehicleInformationConstact {

    @Override
    public void VehicleInformationData() {
        RestApi.getInstance().get(BaseApiConstants.API_XUNLIANTIMU, new OnRequestResultForCommon() {
            @Override
            public void onSuccess(String json) {
                super.onSuccess(json);
                TrainingStartBean trainingSelectBean = new Gson().fromJson(json, TrainingStartBean.class);
                mView.trainingList(trainingSelectBean.getData());
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
