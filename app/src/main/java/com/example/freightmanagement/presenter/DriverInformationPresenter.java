package com.example.freightmanagement.presenter;

import com.example.freightmanagement.Base.BaseApiConstants;
import com.example.freightmanagement.Base.BasePresenter;
import com.example.freightmanagement.Bean.CarOwnerBean;
import com.example.freightmanagement.Bean.DriverInformationBean;
import com.example.freightmanagement.Bean.QiYeBean;
import com.example.freightmanagement.Bean.WrodIdBean;
import com.example.freightmanagement.Utils.Network.OnRequestResultForCommon;
import com.example.freightmanagement.Utils.Network.RestApi;
import com.example.freightmanagement.Utils.PrefUtilsData;
import com.example.freightmanagement.Utils.ToastUtils;
import com.example.freightmanagement.enums.ResponseCodeEnum;
import com.example.freightmanagement.presenter.constract.DriverInfomationConstact;
import com.google.gson.Gson;

public class DriverInformationPresenter extends BasePresenter<DriverInfomationConstact.View> implements DriverInfomationConstact {

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

    @Override
    public void getQyData() {
        RestApi.getInstance().post(BaseApiConstants.API_QIYEXINXI_GET, "", new OnRequestResultForCommon() {
            @Override
            public void onSuccess(String msg) {
                QiYeBean qiYeBean = new Gson().fromJson(msg, QiYeBean.class);
                mView.qiyeSuc(qiYeBean.getData());
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
    public void getCzData() {
        RestApi.getInstance().get(BaseApiConstants.API_CHEZHU_GET, new OnRequestResultForCommon() {
            @Override
            public void onSuccess(String msg) {
                CarOwnerBean carOwnerBean = new Gson().fromJson(msg, CarOwnerBean.class);
                if(carOwnerBean.getCode() == ResponseCodeEnum.SUCCESS.getCode()){
                    mView.chezhuSuc(carOwnerBean.getData());
                }else {
                    ToastUtils.popUpToast("获取车主信息失败");
                }
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
    public void getPeixun2Data() {
        RestApi.getInstance().get(BaseApiConstants.API_WROKID + PrefUtilsData.getUserId(), new OnRequestResultForCommon() {
            @Override
            public void onSuccess(String msg) {
                DriverInformationBean driverInformationBean = new Gson().fromJson(msg, DriverInformationBean.class);
                mView.getWrokIdData2Suc(driverInformationBean.getData());
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
