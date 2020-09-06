package com.example.freightmanagement.presenter;

import com.example.freightmanagement.Base.BaseApiConstants;
import com.example.freightmanagement.Base.BasePresenter;
import com.example.freightmanagement.Bean.TrainingStartBean;
import com.example.freightmanagement.Utils.Network.OnRequestResultForCommon;
import com.example.freightmanagement.Utils.Network.RestApi;
import com.example.freightmanagement.presenter.constract.TrainingStartConstact;
import com.google.gson.Gson;

/**
 * Created by songdechuan on 2020/8/6.
 */

public class TrainingStartPresenter extends BasePresenter<TrainingStartConstact.View> implements TrainingStartConstact {

    @Override
    public void getTrainingList() {
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

    @Override
    public void subWenJuan(String  json) {
        RestApi.getInstance().post(BaseApiConstants.API_TIJIAOWENJUAN,json, new OnRequestResultForCommon() {
            @Override
            public void onSuccess(String json) {
                super.onSuccess(json);
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
