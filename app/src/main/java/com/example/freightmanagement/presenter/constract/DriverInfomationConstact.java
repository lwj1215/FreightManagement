package com.example.freightmanagement.presenter.constract;

import com.example.freightmanagement.Base.BaseView;
import com.example.freightmanagement.Bean.CarOwnerBean;
import com.example.freightmanagement.Bean.DriverInformationBean;
import com.example.freightmanagement.Bean.QiYeBean;
import com.example.freightmanagement.Bean.WrodIdBean;


public interface DriverInfomationConstact {

    void getPeixunData();
    void getPeixun2Data();
    void getQyData();
    void getCzData();

    interface View extends BaseView{
        void getWrokIdDataSuc(WrodIdBean data);
        void getWrokIdData2Suc(DriverInformationBean.DataBean data);
        void qiyeSuc(QiYeBean.DataBean data);
        void chezhuSuc(CarOwnerBean.DataBean data);
    }
}
