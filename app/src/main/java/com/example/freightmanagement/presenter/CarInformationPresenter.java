package com.example.freightmanagement.presenter;

import com.example.freightmanagement.Base.BaseApiConstants;
import com.example.freightmanagement.Base.BasePresenter;
import com.example.freightmanagement.Bean.CarInfoBean;
import com.example.freightmanagement.Utils.Network.OnRequestResultForCommon;
import com.example.freightmanagement.Utils.Network.RestApi;
import com.example.freightmanagement.presenter.constract.CarInformationConstact;
import com.example.freightmanagement.presenter.constract.WeiXiuConstact;
import com.google.gson.Gson;


/**
 * Created by songdechuan on 2020/8/6.
 */

public class CarInformationPresenter extends BasePresenter<CarInformationConstact.View> implements CarInformationConstact {

    @Override
    public void getTestList(int id) {
        RestApi.getInstance().post(BaseApiConstants.API_CHELIANGXIANGQING+id,"", new OnRequestResultForCommon() {
            @Override
            public void onSuccess(String json) {
                CarInfoBean carInfoBean = new Gson().fromJson(json, CarInfoBean.class);
                mView.testResult(carInfoBean);
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
