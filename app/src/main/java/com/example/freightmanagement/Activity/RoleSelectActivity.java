package com.example.freightmanagement.Activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.R;

public class RoleSelectActivity extends BaseActivity implements View.OnClickListener {

    /**
     * 企业,车主,驾驶员
     */
    private TextView mTvCompany,mTvCarOwner,mTvDriver;

    @Override
    public int setLayoutResource() {
        return R.layout.activity_role_select;
    }

    @Override
    protected void onInitView() {
        initView();

    }

    @Override
    protected void onLoadData2Remote() {

    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_role_select);
//    }

    private void initView() {
        mTvCompany = (TextView) findViewById(R.id.tv_company);
        mTvCompany.setOnClickListener(this);
        mTvCarOwner = (TextView) findViewById(R.id.tv_car_owner);
        mTvCarOwner.setOnClickListener(this);
        mTvDriver = (TextView) findViewById(R.id.tv_driver);
        mTvDriver.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_company:

                break;
            case R.id.tv_car_owner:
                break;
            case R.id.tv_driver:
                startActivity(DriverConfigActivity.class);
                break;
        }
    }
    private void startActivity(Class<? extends BaseActivity> cls){
        startActivity(new Intent(this,cls));
    }
}
