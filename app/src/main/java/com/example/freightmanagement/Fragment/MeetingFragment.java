package com.example.freightmanagement.Fragment;

import android.content.Intent;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.example.freightmanagement.Activity.SWCameraStreamingActivity;
import com.example.freightmanagement.Base.BaseFragment;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.CameraConfig;
import com.example.freightmanagement.Utils.PermissionChecker;
import com.example.freightmanagement.Utils.ToastUtils;
import com.qiniu.pili.droid.streaming.CameraStreamingSetting;
import com.qiniu.pili.droid.streaming.StreamingEnv;


public class MeetingFragment extends BaseFragment {


    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_meeting;
    }

    @Override
    protected void onInitView(Bundle savedInstanceState) {
        bindView(R.id.tv_sphy).setOnClickListener(this);
    }

    @Override
    protected void onLoadData2Remote() {

    }


    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_sphy:

        }
    }


}
