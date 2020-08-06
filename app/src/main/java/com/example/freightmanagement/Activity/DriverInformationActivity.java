package com.example.freightmanagement.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.R;

public class DriverInformationActivity extends BaseActivity {

    @Override
    public int setLayoutResource() {
        return R.layout.activity_driver_information;
    }

    @Override
    protected void onInitView() {
      setDefaultTitle("驾驶员信息");
    }

    @Override
    protected void onLoadData2Remote() {

    }

}