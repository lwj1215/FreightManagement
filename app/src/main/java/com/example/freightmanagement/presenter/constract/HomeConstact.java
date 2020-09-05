package com.example.freightmanagement.presenter.constract;

import com.example.freightmanagement.Base.BaseView;

public interface HomeConstact {

    void getTrainComplete();

    void getContractComplete();

    void getCompleteResult();

    interface View extends BaseView {
        void trainResult(String msg);
        void contractResult(String msg);
        void completeResult(boolean result);

    }


}
