package com.example.freightmanagement.presenter;

import com.example.freightmanagement.Base.BaseApiConstants;
import com.example.freightmanagement.Base.BasePresenter;
import com.example.freightmanagement.Utils.Network.OnRequestResultForCommon;
import com.example.freightmanagement.Utils.Network.RestApi;
import com.example.freightmanagement.presenter.constract.TrainingConstact;

import static com.example.freightmanagement.BuildConfig.BASE_URL;

/**
 * Created by songdechuan on 2020/8/6.
 */

public class TrainingSelectPresenter extends BasePresenter<TrainingConstact.View> implements TrainingConstact {



    @Override
    public void getTrainingList() {
        RestApi.getInstance().post(BaseApiConstants.API_XUNLIANTIMU, "", new OnRequestResultForCommon() {
            @Override
            public void onSuccess(String json) {
                mView.trainingList(json);
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
