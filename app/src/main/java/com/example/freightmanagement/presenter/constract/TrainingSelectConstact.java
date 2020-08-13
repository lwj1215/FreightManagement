package com.example.freightmanagement.presenter.constract;

import com.example.freightmanagement.Base.BaseView;
import com.example.freightmanagement.Bean.TrainingSelectBean;

import java.util.List;


public interface TrainingSelectConstact {

    void getTrainingList();

    interface View extends BaseView{

        void trainingList(List<TrainingSelectBean.DataBean> data);
    }
}
