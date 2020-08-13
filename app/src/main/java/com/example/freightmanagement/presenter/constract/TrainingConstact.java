package com.example.freightmanagement.presenter.constract;

import com.example.freightmanagement.Base.BaseView;


/**
 * Created by songdechuan on 2020/8/6.
 */

public interface TrainingConstact {

    void getTrainingList();

    void getTestList(int id);

    interface View extends BaseView{

        String trainingList(String msg);

        void testResult(String msg);

    }
}
