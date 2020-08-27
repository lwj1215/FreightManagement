package com.example.freightmanagement.presenter;

import com.example.freightmanagement.Base.BaseApiConstants;
import com.example.freightmanagement.Base.BasePresenter;
import com.example.freightmanagement.Utils.Network.OnRequestResultForCommon;
import com.example.freightmanagement.Utils.Network.RestApi;
import com.example.freightmanagement.Utils.PrefUtilsData;
import com.example.freightmanagement.presenter.constract.BaoYangConstact;
import com.example.freightmanagement.presenter.constract.WeiXiuConstact;
import com.google.gson.JsonObject;


/**
 * Created by songdechuan on 2020/8/6.
 */

public class BaoYangPresenter extends BasePresenter<BaoYangConstact.View> implements BaoYangConstact {



    @Override
    public void getTrainingList(String carOwnerId,String content,double mileage,String picUrl,String time) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("carOwnerId", carOwnerId);
        jsonObject.addProperty("content", content);
        jsonObject.addProperty("driverId", PrefUtilsData.getUserId());
        jsonObject.addProperty("mileage", mileage);
        jsonObject.addProperty("picUrl", picUrl);
        jsonObject.addProperty("time", time);
        RestApi.getInstance().post(BaseApiConstants.API_ADDBAOYANG, jsonObject.toString(), new OnRequestResultForCommon() {
            @Override
            public void onSuccess(String json) {
                mView.mSuc();
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
