package com.example.freightmanagement.presenter;

import com.example.freightmanagement.Base.BaseApiConstants;
import com.example.freightmanagement.Base.BasePresenter;
import com.example.freightmanagement.Bean.ImageUploadBean;
import com.example.freightmanagement.Bean.WrodIdBean;
import com.example.freightmanagement.Utils.Network.OnRequestResultForCommon;
import com.example.freightmanagement.Utils.Network.RestApi;
import com.example.freightmanagement.model.ContractParam;
import com.example.freightmanagement.presenter.constract.EmploymentConstact;
import com.google.gson.Gson;

import java.io.File;

import static com.example.freightmanagement.Base.BaseApiConstants.API_ADD_CONTRACT;
import static com.example.freightmanagement.Base.BaseApiConstants.API_CONTRACT_GET;
import static com.example.freightmanagement.Base.BaseApiConstants.API_IMAGE_UPLOAD;

public class EmploymentContractPresenter extends BasePresenter<EmploymentConstact.View> implements EmploymentConstact {
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
    public void submit(ContractParam contractParam) {
        String json = new Gson().toJson(contractParam);
        RestApi.getInstance().post(API_ADD_CONTRACT, json, new OnRequestResultForCommon() {
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
    public void get(String id) {
        RestApi.getInstance().get(API_CONTRACT_GET.concat("/").concat(id), new OnRequestResultForCommon() {
            @Override
            public void onSuccess(String json) {
                super.onSuccess(json);
//                mView.success();
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
    public void getDriver() {
        RestApi.getInstance().get(BaseApiConstants.API_PEIXUNJIEGUO, new OnRequestResultForCommon() {
            @Override
            public void onSuccess(String msg) {
                WrodIdBean wrodIdBean = new Gson().fromJson(msg, WrodIdBean.class);
                mView.driverInfo(wrodIdBean);
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
