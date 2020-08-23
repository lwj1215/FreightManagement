package com.example.freightmanagement.presenter.constract;

import com.example.freightmanagement.Base.BaseView;
import com.example.freightmanagement.Bean.VehicleDetectionBean;


public interface VehicleDetectionConstact {

    void VehicleInformationData();

    interface View extends BaseView{

        void trainingList(VehicleDetectionBean vehicleDetectionBean);
    }
}
