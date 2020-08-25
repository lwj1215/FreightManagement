package com.example.freightmanagement.Activity;


import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freightmanagement.Adapter.VehicleFetectionAdapter;
import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.Bean.VehicleDetectionBean;
import com.example.freightmanagement.Bean.VerAddBean;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.OnItemClickListener;
import com.example.freightmanagement.Utils.PrefUtilsData;
import com.example.freightmanagement.Utils.ToastUtils;
import com.example.freightmanagement.presenter.VehicleDetectionPresenter;
import com.google.gson.Gson;

public class VehicleDetectionActivity extends BaseActivity<VehicleDetectionPresenter> implements VehicleDetectionPresenter.View, View.OnClickListener {

    private RecyclerView recyclerView1;
    private VehicleFetectionAdapter vehicleFetectionAdapter;
    private VerAddBean mList;
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
        bindView(R.id.tv_srue).setOnClickListener(this);
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
        vehicleFetectionAdapter.setOnHdListener(new VehicleFetectionAdapter.OnHdListener() {

            @Override
            public void onItemClick(VerAddBean verAddBean) {
              mList = verAddBean;
            }
        });
    }

    @Override
    public void addVehicleDataSuc() {
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_srue:
                if (mList==null||mList.getCompleteBos().size() == 0) {
                    ToastUtils.popUpToast("提交检测结果为空");
                } else {
                    mList.setDriverId(Integer.parseInt(PrefUtilsData.getUserId()));
                    String json = new Gson().toJson(mList);
                    mPresenter.addVehicleData(json);
                }
                break;
        }
    }
}