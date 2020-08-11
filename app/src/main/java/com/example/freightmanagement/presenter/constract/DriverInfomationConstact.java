package com.example.freightmanagement.presenter.constract;

import com.example.freightmanagement.Base.BaseView;
import com.example.freightmanagement.Bean.DriverInformationBean;
import com.example.freightmanagement.Bean.WrodIdBean;


public interface DriverInfomationConstact {

    void getPeixunData();
    void getPeixun2Data();

    interface View extends BaseView{
        void getWrokIdDataSuc(WrodIdBean data);
        void getWrokIdData2Suc(DriverInformationBean.DataBean data);
    }
}
