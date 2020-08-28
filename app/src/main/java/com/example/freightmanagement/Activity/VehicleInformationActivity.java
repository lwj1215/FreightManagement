package com.example.freightmanagement.Activity;


import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.Bean.CheliangBean;
import com.example.freightmanagement.Bean.TrainingStartBean;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.PrefUtilsData;
import com.example.freightmanagement.presenter.VehicleInformationPresenter;

import java.util.List;

/**
 * 驾驶员 是可以上报车辆检查情况  维修情况  和保养情况
 * 车主和企业 是可以查看
 */
public class VehicleInformationActivity extends BaseActivity<VehicleInformationPresenter> implements VehicleInformationPresenter.View, View.OnClickListener {

    private TextView et_real_name, et_detail_address, tv_current_address, tv_sign_hint, tv_mobile;
    private LinearLayout lin_celiang, lin_celiangwx, lin_chebaoyang;
    private TextView tv_cljc, tv_clwx, tv_clby;
    private String owner;
    private String owner2;

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
        tv_cljc = bindView(R.id.tv_cljc);
        tv_clwx = bindView(R.id.tv_clwx);
        tv_clby = bindView(R.id.tv_clby);
        lin_celiang.setOnClickListener(this);
        lin_celiangwx.setOnClickListener(this);
        lin_chebaoyang.setOnClickListener(this);
        if (PrefUtilsData.getType().equals("1")) {
//            setDefaultTitle("驾驶员信息");
            tv_cljc.setText("上报车辆检查情况");
            tv_clwx.setText("上报车辆维修情况");
            tv_clby.setText("上报车辆保养情况");
        } else if (PrefUtilsData.getType().equals("2")) {
//            setDefaultTitle("车主信息");
            tv_cljc.setText("查看车辆检查情况");
            tv_clwx.setText("查看车辆维修情况");
            tv_clby.setText("查看车辆保养情况");
        } else {
//            setDefaultTitle("企业信息");
            tv_cljc.setText("查看车辆检查情况");
            tv_clwx.setText("查看车辆维修情况");
            tv_clby.setText("查看车辆保养情况");
        }
    }

    @Override
    protected void onLoadData2Remote() {
        mPresenter.VehicleInformationData();
    }

    @Override
    protected VehicleInformationPresenter onInitLogicImpl() {
        return new VehicleInformationPresenter();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lin_celiang:
                if (PrefUtilsData.getType().equals("1")) {
                    Intent intent = new Intent(VehicleInformationActivity.this, VehicleDetectionActivity.class);
                    intent.putExtra("name1",owner);
                    intent.putExtra("name2",owner2);
                    startActivity(intent);
                } else if (PrefUtilsData.getType().equals("2")) {
                    getTz("1");
                } else {
                    getTz("1");
                }

                break;
            case R.id.lin_celiangwx:
                if (PrefUtilsData.getType().equals("1")) {
                    Intent intent = new Intent(VehicleInformationActivity.this, WeiXiuJiLuActivity.class);
                    startActivity(intent);
                } else if (PrefUtilsData.getType().equals("2")) {
                    getTz("2");
                } else {
                    getTz("2");
                }

                break;
            case R.id.lin_chebaoyang:
                if (PrefUtilsData.getType().equals("1")) {
                    Intent intent = new Intent(VehicleInformationActivity.this, MaintenanceRecordsActivity.class);
                    startActivity(intent);
                } else if (PrefUtilsData.getType().equals("2")) {
                    getTz("3");
                } else {
                    getTz("3");
                }

                break;

        }
    }

    private void getTz(String type) {
        Intent intent = new Intent(VehicleInformationActivity.this, CheLiangJcActivity.class);
        intent.putExtra("type", type);
        startActivity(intent);
    }

    @Override
    public void mSuc(CheliangBean cheliangBean) {
        owner = cheliangBean.getData().getCertificateRegistrationBo().getOwner();
        owner2 = cheliangBean.getData().getCertificateIDBo().getName();
        et_real_name.setText(cheliangBean.getData().getCertificateRegistrationBo().getCarModel()+"");
        et_detail_address.setText(cheliangBean.getData().getCertificateRegistrationBo().getCarBrand()+"");
        tv_current_address.setText(cheliangBean.getData().getCertificateRegistrationBo().getCarType()+"");
        tv_sign_hint.setText(cheliangBean.getData().getCertificateTransportBo().getPlateNo()+"");
        tv_mobile.setText(cheliangBean.getData().getCertificateTransportBo().getGrantDate()+"");
    }
}