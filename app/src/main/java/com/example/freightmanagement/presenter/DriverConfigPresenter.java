package com.example.freightmanagement.presenter;

import com.example.freightmanagement.Base.BaseApiConstants;
import com.example.freightmanagement.Base.BasePresenter;
import com.example.freightmanagement.Bean.ImageUploadBean;
import com.example.freightmanagement.Bean.WrodIdBean;
import com.example.freightmanagement.Utils.Network.OnRequestResultForCommon;
import com.example.freightmanagement.Utils.Network.RestApi;
import com.example.freightmanagement.model.DriverInfoSubmitParam;
import com.example.freightmanagement.presenter.constract.DriverConfigConstact;
import com.google.gson.Gson;

import java.io.File;

import static com.example.freightmanagement.Base.BaseApiConstants.API_IMAGE_UPLOAD;

/**
 * Created by songdechuan on 2020/8/13.
 */

public class DriverConfigPresenter extends BasePresenter<DriverConfigConstact.View> implements DriverConfigConstact {


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
    public void submit(DriverInfoSubmitParam submitParam) {
        String json = new Gson().toJson(submitParam);
        RestApi.getInstance().post(BaseApiConstants.API_DRIVER_REGISTER, json, new OnRequestResultForCommon() {
            @Override
            public void onSuccess(String json) {
                super.onSuccess(json);
                mView.success(json);
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
    public void updata2(DriverInfoSubmitParam submitParam) {
        String json = new Gson().toJson(submitParam);
        RestApi.getInstance().post(BaseApiConstants.API_JIASHIYUANXINXIXIUGAI, json, new OnRequestResultForCommon() {
            @Override
            public void onSuccess(String json) {
                super.onSuccess(json);
                mView.success(json);
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
    public void getPeixunData() {
        RestApi.getInstance().get(BaseApiConstants.API_PEIXUNJIEGUO, new OnRequestResultForCommon() {
            @Override
            public void onSuccess(String msg) {
                WrodIdBean wrodIdBean = new Gson().fromJson(msg, WrodIdBean.class);
                mView.getWrokIdDataSuc(wrodIdBean);
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
