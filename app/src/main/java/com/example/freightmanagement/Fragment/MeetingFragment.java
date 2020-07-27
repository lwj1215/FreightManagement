package com.example.freightmanagement.Fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.freightmanagement.Activity.SWCameraStreamingActivity;
import com.example.freightmanagement.Base.BaseFragment;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.PermissionChecker;
import com.example.freightmanagement.Utils.ToastUtils;
import com.qiniu.pili.droid.streaming.StreamingEnv;


public class MeetingFragment extends BaseFragment {

    private PermissionChecker mPermissionChecker;
   private String url="rtmp://pili-publish.qnsdk.com/sdk-live/2a9b9dae-c229-411c-bfc6-940bda942d47?e=1595833142&token=QxZugR8TAhI38AiJ_cptTl3RbzLyca3t-AAiH-Hh:ioKtdeyOnxdnEsheNQvhCbyvlBY=";
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
        mPermissionChecker = new PermissionChecker(activity);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        mPermissionChecker.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_sphy:
                boolean isPermissionOK = Build.VERSION.SDK_INT < Build.VERSION_CODES.M || mPermissionChecker.checkPermission();
                if (!isPermissionOK) {
                    ToastUtils.popUpToast("Some permissions is not approved !!!");
                    return;
                }
                StreamingEnv.setLogLevel(Log.VERBOSE);
                Intent intent = new Intent(activity, SWCameraStreamingActivity.class);
                intent.putExtra("INPUT_TEXT", "");
                intent.putExtra("TRANSFER_MODE_QUIC", false);
                intent.putExtra("url", url);
                startActivity(intent);
                break;
        }
    }
}
