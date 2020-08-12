package com.example.freightmanagement.Fragment;

import android.content.Intent;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freightmanagement.Activity.ChangePasswordActivity;
import com.example.freightmanagement.Activity.DriverInformationActivity;
import com.example.freightmanagement.Activity.EmploymentContractActivity;
import com.example.freightmanagement.Activity.PromiseBookActivity;
import com.example.freightmanagement.Activity.ResponsibilityBookActivity;
import com.example.freightmanagement.Activity.SWCameraStreamingActivity;
import com.example.freightmanagement.Activity.TrainingSelectActivity;
import com.example.freightmanagement.Activity.VehicleInformationActivity;
import com.example.freightmanagement.Adapter.HomeFragmentAdapter;
import com.example.freightmanagement.Base.BaseFragment;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.CameraConfig;
import com.example.freightmanagement.Utils.OnItemClickListener;
import com.example.freightmanagement.Utils.PermissionChecker;
import com.example.freightmanagement.Utils.ToastUtils;
import com.qiniu.pili.droid.streaming.CameraStreamingSetting;
import com.qiniu.pili.droid.streaming.StreamingEnv;

import java.util.Arrays;


public class HomeFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private String[] mName = new String[]{"驾驶员信息", "车辆信息", "岗前培训", "聘用合同", "签订承诺书", "签订责任书", "公司例会", "修改密码", "关于"};
    private HomeFragmentAdapter jp_adapter;
    private PermissionChecker mPermissionChecker;
    private String url = "rtmp://pili-publish.qnsdk.com/sdk-live/2a9b9dae-c229-411c-bfc6-940bda942d47?e=1595833142&token=QxZugR8TAhI38AiJ_cptTl3RbzLyca3t-AAiH-Hh:ioKtdeyOnxdnEsheNQvhCbyvlBY=";

    @Override
    protected int getLayoutResource() {
        return R.layout.home_fragment;
    }

    @Override
    protected void onInitView(Bundle savedInstanceState) {
        recyclerView = (RecyclerView) bindView(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 3, GridLayoutManager.VERTICAL, false);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        jp_adapter = new HomeFragmentAdapter(mContext);
        recyclerView.setAdapter(jp_adapter);

    }

    @Override
    protected void onLoadData2Remote() {
        mPermissionChecker = new PermissionChecker(activity);
        jp_adapter.setData(Arrays.asList(mName));
        jp_adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
//                ToastUtils.popUpToast(mName[position].toString());
                if (position == 0) {
                    startActivity(new Intent(activity, DriverInformationActivity.class));
                }else if (position == 1) {
                    startActivity(new Intent(activity, VehicleInformationActivity.class));
                }else if (position == 2) {
                    startActivity(new Intent(activity, TrainingSelectActivity.class));
                }else if (position == 3) {
                    startActivity(new Intent(activity, EmploymentContractActivity.class));
                }else if (position == 4) {
                    startActivity(new Intent(activity, PromiseBookActivity.class));
                }else if (position == 5) {
                    startActivity(new Intent(activity, ResponsibilityBookActivity.class));
                }else if (position==6){
                    boolean isPermissionOK = Build.VERSION.SDK_INT < Build.VERSION_CODES.M || mPermissionChecker.checkPermission();
                    if (!isPermissionOK) {
//                        ToastUtils.popUpToast("");
                        return;
                    }
                    StreamingEnv.setLogLevel(Log.VERBOSE);
                    Intent intent = new Intent(activity, SWCameraStreamingActivity.class);
                    intent.putExtra("INPUT_TEXT", "");
                    intent.putExtra("TRANSFER_MODE_QUIC", false);
                    intent.putExtra("url", url);
                    intent.putExtra("CameraConfig", buildCameraConfig());
                    startActivity(intent);
                }else if (position == 7) {
                    startActivity(new Intent(activity, ChangePasswordActivity.class));
                }
            }
        });
    }

    private CameraConfig buildCameraConfig() {
        CameraConfig cameraConfig = new CameraConfig();
        cameraConfig.mFrontFacing = true;
        cameraConfig.mSizeLevel = CameraStreamingSetting.PREVIEW_SIZE_LEVEL.MEDIUM;
        cameraConfig.mSizeRatio = CameraStreamingSetting.PREVIEW_SIZE_RATIO.RATIO_16_9;
        cameraConfig.mFocusMode = Camera.Parameters.FOCUS_MODE_CONTINUOUS_VIDEO;
        cameraConfig.mIsFaceBeautyEnabled = true;
        cameraConfig.mIsCustomFaceBeauty = false;
        cameraConfig.mContinuousAutoFocus = true;
        cameraConfig.mPreviewMirror = false;
        cameraConfig.mEncodingMirror = false;

        return cameraConfig;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        mPermissionChecker.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
