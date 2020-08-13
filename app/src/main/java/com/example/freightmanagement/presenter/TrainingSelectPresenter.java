package com.example.freightmanagement.presenter;

import com.example.freightmanagement.Base.BaseApiConstants;
import com.example.freightmanagement.Base.BasePresenter;
import com.example.freightmanagement.Bean.TrainingSelectBean;
import com.example.freightmanagement.Utils.Network.OnRequestResultForCommon;
import com.example.freightmanagement.Utils.Network.RestApi;
import com.example.freightmanagement.presenter.constract.TrainingSelectConstact;
import com.google.gson.Gson;

/**
 * Created by songdechuan on 2020/8/6.
 */

public class TrainingSelectPresenter extends BasePresenter<TrainingSelectConstact.View> implements TrainingSelectConstact {
    @Override
    public void getTrainingList() {
        RestApi.getInstance().get(BaseApiConstants.API_XUNLIANTIMU, new OnRequestResultForCommon() {
            @Override
            public void onSuccess(String json) {
                super.onSuccess(json);
                TrainingSelectBean trainingSelectBean = new Gson().fromJson(json, TrainingSelectBean.class);
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
