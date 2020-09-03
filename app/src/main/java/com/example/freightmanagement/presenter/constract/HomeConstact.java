package com.example.freightmanagement.presenter.constract;

import com.example.freightmanagement.Base.BaseView;

public interface HomeConstact {

    void getTrainComplete();



    interface View extends BaseView {
        void notComplete();
        void complete();
    }


}
