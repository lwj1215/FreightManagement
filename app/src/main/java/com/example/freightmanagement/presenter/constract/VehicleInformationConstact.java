package com.example.freightmanagement.presenter.constract;

import com.example.freightmanagement.Base.BaseView;
import com.example.freightmanagement.Bean.TrainingStartBean;

import java.util.List;


public interface VehicleInformationConstact {

    void VehicleInformationData();

    interface View extends BaseView{

        void trainingList(List<TrainingStartBean.DataBean> data);
    }
}