package com.example.freightmanagement.presenter;

import com.example.freightmanagement.Base.BaseApiConstants;
import com.example.freightmanagement.Base.BasePresenter;
import com.example.freightmanagement.Base.BaseResponse;
import com.example.freightmanagement.Bean.TrainResultBean;
import com.example.freightmanagement.Bean.WrodIdBean;
import com.example.freightmanagement.Utils.Network.OnRequestResultForCommon;
import com.example.freightmanagement.Utils.Network.RestApi;
import com.example.freightmanagement.presenter.constract.HomeConstact;
import com.google.gson.Gson;


import static com.example.freightmanagement.Base.BaseApiConstants.API_CONTRACT_GET;
import static com.example.freightmanagement.Base.BaseApiConstants.API_HETONG_LIST;
import static com.example.freightmanagement.Base.BaseApiConstants.API_WROKID;

public class HomePresenter extends BasePresenter<HomeConstact.View> implements HomeConstact {
    boolean trainComplete = false;
    boolean contractComplete = false;
    /**
     * 训练是否完成
     */
    @Override
    public void getTrainComplete() {

    }


    private void getHt(){
        RestApi.getInstance().get(API_CONTRACT_GET, new OnRequestResultForCommon() {
            @Override
            public void onSuccess(String json) {
                super.onSuccess(json);
                BaseResponse response = new Gson().fromJson(json, BaseResponse.class);
                if(response != null){
                    Object data = response.getData();
                    if(data == null){
                        contractComplete = false;
                    }else {
                        contractComplete = true;
                    }
                    if(contractComplete){
                        mView.completeResult(true);
                    }else {
                        mView.completeResult(false);
                    }
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
    public void getCompleteResult() {
        RestApi.getInstance().get(API_WROKID, new OnRequestResultForCommon() {
            @Override
            public void onSuccess(String json) {
                super.onSuccess(json);
                TrainResultBean trainResultBean = new Gson().fromJson(json, TrainResultBean.class);
                if(trainResultBean != null){
                    TrainResultBean.DataBean data = trainResultBean.getData();
                    if(data != null){
                        int isPass = data.getIsPass();
                        if(isPass == 1){
                            trainComplete = true;
                            getHt();
                        }else {
                            trainComplete = false;
                            mView.completeResult(false);
                        }
                    }
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

    /**
     * 驾驶员个人信息
     */
    @Override
    public void getDriverInfo() {
        RestApi.getInstance().get(BaseApiConstants.API_PEIXUNJIEGUO, new OnRequestResultForCommon() {
            @Override
            public void onSuccess(String msg) {
                WrodIdBean wrodIdBean = new Gson().fromJson(msg, WrodIdBean.class);
//                mView.driverInfoResult(wrodIdBean);
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
    public void getContractComplete() {
        RestApi.getInstance().get(API_CONTRACT_GET, new OnRequestResultForCommon() {
            @Override
            public void onSuccess(String json) {
                super.onSuccess(json);
                mView.contractResult(json);
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
    public void getHTResult() {
        RestApi.getInstance().get(API_HETONG_LIST, new OnRequestResultForCommon() {
            @Override
            public void onSuccess(String json) {
                super.onSuccess(json);
                mView.HtReResult(json);
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
