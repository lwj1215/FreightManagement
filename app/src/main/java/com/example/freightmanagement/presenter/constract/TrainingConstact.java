package com.example.freightmanagement.presenter.constract;

import com.example.freightmanagement.Base.BaseView;


/**
 * Created by songdechuan on 2020/8/6.
 */

public interface TrainingConstact {

    void getTrainingList();

    interface View extends BaseView{

        String trainingList(String msg);
    }
}
