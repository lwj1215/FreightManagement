package com.example.freightmanagement.presenter.constract;

import com.example.freightmanagement.Base.BaseView;
import com.example.freightmanagement.Bean.VehicleDetectionBean;


public interface VehicleDetectionConstact {

    void VehicleInformationData();

    void  addVehicleData(String json);
    interface View extends BaseView{

        void trainingList(VehicleDetectionBean vehicleDetectionBean);

        void mSuc();
    }
}
