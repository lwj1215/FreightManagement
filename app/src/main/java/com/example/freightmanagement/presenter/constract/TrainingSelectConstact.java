package com.example.freightmanagement.presenter.constract;

import com.example.freightmanagement.Base.BaseView;


public interface TrainingSelectConstact {

    void getTrainingList();

    interface View extends BaseView{

        String trainingList(String msg);
    }
}
