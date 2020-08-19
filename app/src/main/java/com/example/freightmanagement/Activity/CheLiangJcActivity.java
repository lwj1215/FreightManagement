package com.example.freightmanagement.Activity;



import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.R;

public class CheLiangJcActivity extends BaseActivity {

    @Override
    public int setLayoutResource() {
        return R.layout.activity_che_liang_jc;
    }

    @Override
    protected void onInitView() {
        String type = getIntent().getStringExtra("type");
        if (type.equals("1")){
            setDefaultTitle("车辆检查情况");
        }else if (type.equals("2")){
            setDefaultTitle("车辆维修情况");
        }else {
            setDefaultTitle("车辆保养情况");
        }

    }

    @Override
    protected void onLoadData2Remote() {

    }

}