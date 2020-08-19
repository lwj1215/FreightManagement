package com.example.freightmanagement.presenter;

import com.example.freightmanagement.Base.BaseApiConstants;
import com.example.freightmanagement.Base.BasePresenter;
import com.example.freightmanagement.Bean.TrainAnswerListBean;
import com.example.freightmanagement.Bean.TrainingStartBean;
import com.example.freightmanagement.Utils.Network.OnRequestResultForCommon;
import com.example.freightmanagement.Utils.Network.RestApi;
import com.example.freightmanagement.presenter.constract.TrainingSelectConstact;
import com.google.gson.Gson;

/**
 * Created by songdechuan on 2020/8/6.
 */

public class TrainingSelectPresenter extends BasePresenter<TrainingSelectConstact.View> implements TrainingSelectConstact {
    @Override
    public void getAnswerResultList(String driverId) {
        RestApi.getInstance().get(BaseApiConstants.API_ANSWER_RESULT_LIST+driverId, new OnRequestResultForCommon() {
            @Override
            public void onSuccess(String json) {
                super.onSuccess(json);
                TrainAnswerListBean trainAnswerListBean = new Gson().fromJson(json, TrainAnswerListBean.class);
                mView.trainingList(trainAnswerListBean.getData());
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

//    @Override
//    public void getTestList(int id) {
//
//    }
}
