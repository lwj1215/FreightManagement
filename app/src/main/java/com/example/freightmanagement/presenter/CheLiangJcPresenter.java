package com.example.freightmanagement.presenter;

import com.example.freightmanagement.Base.BaseApiConstants;
import com.example.freightmanagement.Base.BasePresenter;
import com.example.freightmanagement.Bean.CheliangByBean;
import com.example.freightmanagement.Bean.CheliangJcBean;
import com.example.freightmanagement.Bean.CheliangWeiXiuBean;
import com.example.freightmanagement.Utils.Network.OnRequestResultForCommon;
import com.example.freightmanagement.Utils.Network.RestApi;
import com.example.freightmanagement.Utils.PrefUtilsData;
import com.example.freightmanagement.presenter.constract.CheLiangJcConstact;
import com.google.gson.Gson;

public class CheLiangJcPresenter extends BasePresenter<CheLiangJcConstact.View> implements CheLiangJcConstact {


    @Override
    public void getData1() {
        RestApi.getInstance().get(BaseApiConstants.API_CHEJIANCE + PrefUtilsData.getUserId(), new OnRequestResultForCommon() {
            @Override
            public void onSuccess(String json) {
                CheliangJcBean cheliangJcBean = new Gson().fromJson(json, CheliangJcBean.class);
                mView.getData1Suc(cheliangJcBean.getData());
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
    public void getData2() {
        RestApi.getInstance().get(BaseApiConstants.API_CHEWEIXIU + PrefUtilsData.getUserId(), new OnRequestResultForCommon() {
            @Override
            public void onSuccess(String json) {
                CheliangWeiXiuBean cheliangWeiXiuBean = new Gson().fromJson(json, CheliangWeiXiuBean.class);
                mView.getData2Suc(cheliangWeiXiuBean.getData());
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
    public void getData3() {
        RestApi.getInstance().get(BaseApiConstants.API_CHEBAOYANG + PrefUtilsData.getUserId(), new OnRequestResultForCommon() {
            @Override
            public void onSuccess(String json) {
                CheliangByBean cheliangByBean = new Gson().fromJson(json, CheliangByBean.class);
                mView.getData3Suc(cheliangByBean.getData());
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
