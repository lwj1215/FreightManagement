package com.example.freightmanagement.Activity;


import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.R;

public class VehicleInformationActivity extends BaseActivity {

    @Override
    public int setLayoutResource() {
        return R.layout.activity_vehicle_information;
    }

    @Override
    protected void onInitView() {
       setDefaultTitle("车辆信息");
    }

    @Override
    protected void onLoadData2Remote() {

    }
}