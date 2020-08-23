package com.example.freightmanagement.Activity;


import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freightmanagement.Adapter.TrainingAdapter;
import com.example.freightmanagement.Adapter.VehicleFetectionAdapter;
import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.Bean.VehicleDetectionBean;
import com.example.freightmanagement.R;
import com.example.freightmanagement.presenter.VehicleDetectionPresenter;

public class VehicleDetectionActivity extends BaseActivity<VehicleDetectionPresenter> implements VehicleDetectionPresenter.View{

    private RecyclerView recyclerView1;
    private VehicleFetectionAdapter vehicleFetectionAdapter;

    @Override
    public int setLayoutResource() {
        return R.layout.activity_vehicle_detection;
    }

    @Override
    protected void onInitView() {
        setDefaultTitle("车辆检查情况");
        recyclerView1 = bindView(R.id.recyclerView1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView1.setLayoutManager(linearLayoutManager);
        vehicleFetectionAdapter = new VehicleFetectionAdapter(this);
        recyclerView1.setAdapter(vehicleFetectionAdapter);
    }

    @Override
    protected void onLoadData2Remote() {
       mPresenter.VehicleInformationData();
    }


    @Override
    protected VehicleDetectionPresenter onInitLogicImpl() {
        return new VehicleDetectionPresenter();
    }

    @Override
    public void trainingList(VehicleDetectionBean vehicleDetectionBean) {
        vehicleFetectionAdapter.setPages(vehicleDetectionBean.getData());
    }
}