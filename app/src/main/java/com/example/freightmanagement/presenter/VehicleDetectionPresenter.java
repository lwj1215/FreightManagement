package com.example.freightmanagement.presenter;

import com.example.freightmanagement.Base.BaseApiConstants;
import com.example.freightmanagement.Base.BasePresenter;
import com.example.freightmanagement.Bean.TrainingStartBean;
import com.example.freightmanagement.Bean.VehicleDetectionBean;
import com.example.freightmanagement.Utils.Network.OnRequestResultForCommon;
import com.example.freightmanagement.Utils.Network.RestApi;
import com.example.freightmanagement.presenter.constract.VehicleDetectionConstact;
import com.example.freightmanagement.presenter.constract.VehicleInformationConstact;
import com.google.gson.Gson;

public class VehicleDetectionPresenter extends BasePresenter<VehicleDetectionConstact.View> implements VehicleDetectionConstact {

    @Override
    public void VehicleInformationData() {
        RestApi.getInstance().get(BaseApiConstants.API_JIANCEXIANG, new OnRequestResultForCommon() {
            @Override
            public void onSuccess(String json) {
                super.onSuccess(json);
                VehicleDetectionBean vehicleDetectionBean = new Gson().fromJson(json, VehicleDetectionBean.class);
                mView.trainingList(vehicleDetectionBean);
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
