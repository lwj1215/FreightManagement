package com.example.freightmanagement.Activity;


import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.Bean.TrainingStartBean;
import com.example.freightmanagement.R;
import com.example.freightmanagement.presenter.VehicleInformationPresenter;

import java.util.List;

public class VehicleInformationActivity extends BaseActivity<VehicleInformationPresenter> implements VehicleInformationPresenter.View, View.OnClickListener {

    private TextView et_real_name, et_detail_address, tv_current_address, tv_sign_hint, tv_mobile;
    private LinearLayout lin_celiang, lin_celiangwx, lin_chebaoyang;

    @Override
    public int setLayoutResource() {
        return R.layout.activity_vehicle_information;
    }

    @Override
    protected void onInitView() {
        setDefaultTitle("车辆信息");
        et_real_name = bindView(R.id.et_real_name);
        et_detail_address = bindView(R.id.et_detail_address);
        tv_current_address = bindView(R.id.tv_current_address);
        tv_sign_hint = bindView(R.id.tv_sign_hint);
        tv_mobile = bindView(R.id.tv_mobile);
        lin_celiang = bindView(R.id.lin_celiang);
        lin_celiangwx = bindView(R.id.lin_celiangwx);
        lin_chebaoyang = bindView(R.id.lin_chebaoyang);
        lin_celiang.setOnClickListener(this);
        lin_celiangwx.setOnClickListener(this);
        lin_chebaoyang.setOnClickListener(this);
    }

    @Override
    protected void onLoadData2Remote() {

    }

    @Override
    public void trainingList(List<TrainingStartBean.DataBean> data) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lin_celiang:
                getTz("1");
                break;
            case R.id.lin_celiangwx:
                getTz("2");
                break;
            case R.id.lin_chebaoyang:
                getTz("3");
                break;

        }
    }

    private void getTz(String type) {
        Intent intent = new Intent(VehicleInformationActivity.this, CheLiangJcActivity.class);
        intent.putExtra("type", type);
        startActivity(intent);
    }
}