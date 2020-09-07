package com.example.freightmanagement.presenter.constract;

import com.example.freightmanagement.Base.BaseView;
import com.example.freightmanagement.Bean.WrodIdBean;

public interface HomeConstact {

    void getTrainComplete();

    void getContractComplete();

    void getCompleteResult();

    void getDriverInfo();

    void getHTResult();

    interface View extends BaseView {
        void trainResult(String msg);
        void contractResult(String msg);
        void completeResult(boolean result);
//        void driverInfoResult(WrodIdBean wrodIdBean);
        void HtReResult(String msg);
    }


}
