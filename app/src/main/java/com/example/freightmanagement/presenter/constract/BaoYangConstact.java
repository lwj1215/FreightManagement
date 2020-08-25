package com.example.freightmanagement.presenter.constract;

import com.example.freightmanagement.Base.BaseView;


/**
 * Created by songdechuan on 2020/8/6.
 */

public interface BaoYangConstact {

    void getTrainingList(String carOwnerId,String content,double mileage,String picUrl,String time);


    interface View extends BaseView{

        void trainingList();

    }
}
