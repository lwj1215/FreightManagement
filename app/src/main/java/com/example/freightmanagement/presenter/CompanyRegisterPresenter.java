package com.example.freightmanagement.presenter;

import com.example.freightmanagement.Base.BaseApiConstants;
import com.example.freightmanagement.Base.BasePresenter;
import com.example.freightmanagement.Base.BaseResponse;
import com.example.freightmanagement.Bean.ImageUploadBean;
import com.example.freightmanagement.Utils.Network.OnRequestResultForCommon;
import com.example.freightmanagement.Utils.Network.RestApi;
import com.example.freightmanagement.model.CarOwnerSubmitParam;
import com.example.freightmanagement.model.DriverInfoSubmitParam;
import com.example.freightmanagement.model.company.CompanySubmitParam;
import com.example.freightmanagement.presenter.constract.CompanyRegisterConstact;
import com.google.gson.Gson;

import java.io.File;

import static com.example.freightmanagement.Base.BaseApiConstants.API_COMPANY_REGISTER;
import static com.example.freightmanagement.Base.BaseApiConstants.API_IMAGE_UPLOAD;

/**
 * Created by songdechuan on 2020/8/18.
 */

public class CompanyRegisterPresenter extends BasePresenter<CompanyRegisterConstact.View> implements CompanyRegisterConstact {
    @Override
    public void submit(CompanySubmitParam submitParam) {
        String json = new Gson().toJson(submitParam);
        RestApi.getInstance().post(API_COMPANY_REGISTER, json, new OnRequestResultForCommon() {
            @Override
            public void onSuccess(String json) {
                super.onSuccess(json);

                    mView.success();
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
    public void updata2(CompanySubmitParam submitParam) {
        String json = new Gson().toJson(submitParam);
        RestApi.getInstance().post(BaseApiConstants.API_QIYEXINXIXIUGAI, json, new OnRequestResultForCommon() {
            @Override
            public void onSuccess(String json) {
                super.onSuccess(json);

                    mView.success();
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
}
