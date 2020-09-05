package com.example.freightmanagement.presenter;

import android.util.Log;

import com.example.freightmanagement.Base.BasePresenter;
import com.example.freightmanagement.Bean.ImageUploadBean;
import com.example.freightmanagement.Utils.Network.OnRequestResultForCommon;
import com.example.freightmanagement.Utils.Network.RestApi;
import com.example.freightmanagement.model.CarBo;
import com.example.freightmanagement.presenter.constract.CarAddConstact;
import com.example.freightmanagement.presenter.constract.DriverConfigConstact;
import com.google.gson.Gson;

import java.io.File;

import static com.example.freightmanagement.Base.BaseApiConstants.API_ADD_CAR;
import static com.example.freightmanagement.Base.BaseApiConstants.API_IMAGE_UPLOAD;

/**
 * Created by songdechuan on 2020/8/13.
 */

public class CarAddPresenter extends BasePresenter<CarAddConstact.View> implements CarAddConstact {


    @Override
    public void upload(File file, final int type) {

        RestApi.getInstance().postImage(API_IMAGE_UPLOAD, file, new OnRequestResultForCommon() {
            @Override
            public void onSuccess(String json) {
                super.onSuccess(json);
                ImageUploadBean imageUploadBean = new Gson().fromJson(json, ImageUploadBean.class);
                mView.imageUrl(imageUploadBean.getData(),type);
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
    public void submit(CarBo carBo) {
        String json = new Gson().toJson(carBo);
        Log.i("zxz",json);
        RestApi.getInstance().post(API_ADD_CAR, json, new OnRequestResultForCommon() {
            @Override
            public void onSuccess(String json) {
                super.onSuccess(json);
                mView.submitResult(json);
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
