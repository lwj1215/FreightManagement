package com.example.freightmanagement.Activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.DatePickerDialog;
import com.example.freightmanagement.Utils.DateUtil;

import java.util.List;

public class RoleSelectActivity extends BaseActivity implements View.OnClickListener {

    /**
     * 企业,车主,驾驶员
     */
    private TextView mTvCompany,mTvCarOwner,mTvDriver;
    private DatePickerDialog dateDialog;

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
                showDateDialog(DateUtil.getDateForString("1990-01-01"));
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

    /**
     * 选择生日
     */
    private void showDateDialog(List<Integer> date) {
        DatePickerDialog.Builder builder = new DatePickerDialog.Builder(this);
        builder.setOnDateSelectedListener(new DatePickerDialog.OnDateSelectedListener() {
            @Override
            public void onDateSelected(int[] dates) {
//                tv.setText(dates[0] + "." + (dates[1] > 9 ? dates[1] : ("0" + dates[1])) + "."
//                        + (dates[2] > 9 ? dates[2] : ("0" + dates[2])));

            }

            @Override
            public void onCancel() {
            }
        })
                .setSelectYear(date.get(0) - 1)
                .setSelectMonth(date.get(1) - 1)
                .setSelectDay(date.get(2) - 1);

        builder.setMaxYear(DateUtil.getYear());
        builder.setMaxMonth(DateUtil.getDateForString(DateUtil.getToday()).get(1));
        builder.setMaxDay(DateUtil.getDateForString(DateUtil.getToday()).get(2));
        dateDialog = builder.create();
        dateDialog.show();
    }
}
