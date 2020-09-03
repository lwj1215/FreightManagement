package com.example.freightmanagement.presenter;

import com.example.freightmanagement.Base.BasePresenter;
import com.example.freightmanagement.Bean.ImageUploadBean;
import com.example.freightmanagement.Utils.Network.OnRequestResultForCommon;
import com.example.freightmanagement.Utils.Network.RestApi;
import com.example.freightmanagement.Utils.PrefUtilsData;
import com.example.freightmanagement.Utils.ToastUtils;
import com.example.freightmanagement.presenter.constract.HomeConstact;
import com.google.gson.Gson;

import static com.example.freightmanagement.Base.BaseApiConstants.API_CONTRACT_GET;
import static com.example.freightmanagement.Base.BaseApiConstants.API_TRAIN_GET;

public class HomePresenter extends BasePresenter<HomeConstact.View> implements HomeConstact {

    /**
     * 训练是否完成
     */
    @Override
    public void getTrainComplete() {
        RestApi.getInstance().get(API_TRAIN_GET.concat(PrefUtilsData.getUserId()), new OnRequestResultForCommon() {
            @Override
            public void onSuccess(String json) {
                super.onSuccess(json);
//                mView.imageUrl(imageUploadBean.getData(),type);
                ToastUtils.popUpToast("训练暂未完成，请先训练");
                return;

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
        RestApi.getInstance().get(API_CONTRACT_GET.concat(PrefUtilsData.getUserId()), new OnRequestResultForCommon() {
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
