package com.example.freightmanagement.presenter.constract;

import com.example.freightmanagement.Base.BaseView;
import com.example.freightmanagement.Bean.TrainAnswerListBean;
import com.example.freightmanagement.Bean.TrainingStartBean;

import java.util.List;


public interface TrainingSelectConstact {

    void getAnswerResultList(String driverId);

    interface View extends BaseView{

        void trainingList(TrainAnswerListBean.DataBean data);
    }
}
