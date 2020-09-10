package com.example.freightmanagement.Activity;


import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.Bean.CheliangBean;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.PrefUtilsData;
import com.example.freightmanagement.presenter.VehicleInformationPresenter;
import com.example.freightmanagement.presenter.constract.VehicleInformationConstact;

/**
 * 驾驶员 是可以上报车辆检查情况  维修情况  和保养情况
 * 车主和企业 是可以查看
 */
public class VehicleInformationActivity extends BaseActivity<VehicleInformationPresenter> implements VehicleInformationPresenter.View, View.OnClickListener {

    private TextView et_real_name, et_detail_address, tv_current_address;
    private LinearLayout lin_celiang, lin_celiangwx, lin_chebaoyang;
    private TextView tv_cljc, tv_clwx, tv_clby;
    private String owner;
    private String owner2;
    private TextView mTvDriverName;
    private TextView mTvCarNum;
    private TextView mTvCompany;
    private TextView mTvCarType;
    private TextView mTvBrandXing;
    private TextView mTvCarShibie;
    private TextView mTvZhuceDate;
    private TextView mTvCarYunyingNum;
    private TextView mTvYunyingYxq;
    private String name;

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
        lin_celiang = bindView(R.id.lin_celiang);
        lin_celiangwx = bindView(R.id.lin_celiangwx);
        lin_chebaoyang = bindView(R.id.lin_chebaoyang);
        tv_cljc = bindView(R.id.tv_cljc);
        tv_clwx = bindView(R.id.tv_clwx);
        tv_clby = bindView(R.id.tv_clby);
        mTvDriverName = findViewById(R.id.tv_driver_name);
        mTvCarNum = findViewById(R.id.tv_car_num);
        mTvCompany = findViewById(R.id.tv_company);
        mTvCarType = findViewById(R.id.tv_car_type);
        mTvBrandXing = findViewById(R.id.tv_brand_xing);
        mTvCarShibie = findViewById(R.id.tv_car_shibie);
        mTvZhuceDate = findViewById(R.id.tv_zhuce_date);
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
        mTvCarYunyingNum = findViewById(R.id.tv_car_yunying_num);
        mTvYunyingYxq = findViewById(R.id.tv_yunying_yxq);
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
                    intent.putExtra("name1", name);
                    intent.putExtra("name2", owner2);

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
        CheliangBean.DataBean data = cheliangBean.getData();
        if (data != null) {
            CheliangBean.DataBean.CarBoBean carBo = data.getCarBo();
            CheliangBean.DataBean.CertificateIDBoBean idCardBo = data.getCertificateIDBo();
            if (idCardBo != null) {
                name = idCardBo.getName();
                mTvDriverName.setText(idCardBo.getName());
            }
            if (carBo != null) {
                CheliangBean.DataBean.CarBoBean.CertificateTransportBoBean certificateTransportBo = carBo.getCertificateTransportBo();
                CheliangBean.DataBean.CarBoBean.CertificateDrivingBoBean certificateDrivingBo = carBo.getCertificateDrivingBo();
                if (certificateTransportBo != null) {
                    mTvCarNum.setText(certificateDrivingBo.getPlateNo());
                }
            }
            CheliangBean.DataBean.CarBoBean.CertificateDrivingBoBean certificateDrivingBo = carBo.getCertificateDrivingBo();
            if (certificateDrivingBo != null) {
                mTvCarType.setText(certificateDrivingBo.getWchicheType());
                mTvCompany.setText(certificateDrivingBo.getOwner());
                mTvBrandXing.setText(certificateDrivingBo.getModel());
                mTvCarShibie.setText(certificateDrivingBo.getVin());
                mTvZhuceDate.setText(certificateDrivingBo.getRegistrationDate());
            }

            CheliangBean.DataBean.CarBoBean.CertificateTransportBoBean certificateTransportBo = carBo.getCertificateTransportBo();
            if (certificateTransportBo != null) {
                mTvCarYunyingNum.setText(certificateTransportBo.getPlateNo());
                mTvYunyingYxq.setText(certificateTransportBo.getLicence());
            }

        }
    }
}