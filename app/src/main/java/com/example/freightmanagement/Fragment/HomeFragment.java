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

import com.example.freightmanagement.Activity.CarListManageActivity;
import com.example.freightmanagement.Activity.ChangePasswordActivity;
import com.example.freightmanagement.Activity.DriverInformationActivity;
import com.example.freightmanagement.Activity.DriverListActivity;
import com.example.freightmanagement.Activity.EmploymentContractActivity;
import com.example.freightmanagement.Activity.PromiseBookActivity;
import com.example.freightmanagement.Activity.ResponsibilityBookActivity;
import com.example.freightmanagement.Activity.SWCameraStreamingActivity;
import com.example.freightmanagement.Activity.TrainingSelectActivity;
import com.example.freightmanagement.Activity.VehicleInformationActivity;
import com.example.freightmanagement.Adapter.HomeFragmentAdapter;
import com.example.freightmanagement.Base.BaseFragment;
import com.example.freightmanagement.Bean.HomeInfoBean;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.CameraConfig;
import com.example.freightmanagement.Utils.OnItemClickListener;
import com.example.freightmanagement.Utils.PermissionChecker;
import com.example.freightmanagement.Utils.PrefUtilsData;
import com.example.freightmanagement.Utils.ToastUtils;
import com.example.freightmanagement.enums.AdminTypeEnum;
import com.example.freightmanagement.presenter.HomePresenter;
import com.qiniu.pili.droid.streaming.CameraStreamingSetting;
import com.qiniu.pili.droid.streaming.StreamingEnv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HomeFragment extends BaseFragment<HomePresenter> implements HomePresenter.View {

    private RecyclerView recyclerView;
    private String[] mName = new String[]{"驾驶员信息", "车辆信息", "岗前培训", "聘用合同", "签订承诺书", "签订责任书", "公司例会", "修改密码", "关于"};
    private int[] icons;
    private HomeFragmentAdapter jp_adapter;
    private PermissionChecker mPermissionChecker;
    private String url = "rtmp://pili-publish.qnsdk.com/sdk-live/2a9b9dae-c229-411c-bfc6-940bda942d47?e=1595833142&token=QxZugR8TAhI38AiJ_cptTl3RbzLyca3t-AAiH-Hh:ioKtdeyOnxdnEsheNQvhCbyvlBY=";
    private String type;

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
        type = PrefUtilsData.getType();
        if(type.equals(AdminTypeEnum.DRIVER.getValue())){
            mName = new String[]{"驾驶员信息", "车辆信息", "岗前培训", "聘用合同", "公司例会", "修改密码"};
            icons = new int[]{R.mipmap.ic_xinxi, R.mipmap.ic_car, R.mipmap.ic_peixun, R.mipmap.ic_chengnuo, R.mipmap.ic_huiyi,R.mipmap.ic_password};
        }else if(type.equals(AdminTypeEnum.CAR_OWNER.getValue())){
            mName = new String[]{"车主信息", "车辆信息", "驾驶员列表", "修改密码"};
            icons = new int[]{R.mipmap.ic_xinxi, R.mipmap.ic_car, R.mipmap.ic_xinxi, R.mipmap.ic_password};
        }else if(type.equals(AdminTypeEnum.COMPANY.getValue())){
            mName = new String[]{"企业信息", "车辆信息", "驾驶员列表", "公司例会", "修改密码",};
            icons = new int[]{R.mipmap.ic_xinxi, R.mipmap.ic_car, R.mipmap.ic_xinxi, R.mipmap.ic_huiyi, R.mipmap.ic_password};
        }
        jp_adapter.setData(Arrays.asList(mName),icons);
        jp_adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if (position == 0) {
                    startActivity(new Intent(activity, DriverInformationActivity.class));
                }else if (position == 1) {
                    if(type.equals(AdminTypeEnum.DRIVER.getValue())){

                        startActivity(new Intent(activity, VehicleInformationActivity.class));
                    }else if(type.equals(AdminTypeEnum.CAR_OWNER.getValue())){
                        startActivity(new Intent(activity, CarListManageActivity.class));
                    }else if(type.equals(AdminTypeEnum.COMPANY.getValue())){
                        startActivity(new Intent(activity, CarListManageActivity.class));
                    }
                }else if (position == 2) {
                    if(type.equals(AdminTypeEnum.DRIVER.getValue())){
                        startActivity(new Intent(activity, TrainingSelectActivity.class));
                    }else if(type.equals(AdminTypeEnum.CAR_OWNER.getValue())){
                        startActivity(new Intent(activity, DriverListActivity.class));
                    }else if(type.equals(AdminTypeEnum.COMPANY.getValue())){
                        startActivity(new Intent(activity, DriverListActivity.class));
                    }
                }else if (position == 3) {
                    if(type.equals(AdminTypeEnum.DRIVER.getValue())){
//                        mPresenter.getContractComplete();
                        mPresenter.getTrainComplete();
                        startActivity(new Intent(activity, EmploymentContractActivity.class));
                    }else if(type.equals(AdminTypeEnum.CAR_OWNER.getValue())){
                        startActivity(new Intent(activity, ChangePasswordActivity.class));
                    }else if(type.equals(AdminTypeEnum.COMPANY.getValue())){
                        boolean isPermissionOK = Build.VERSION.SDK_INT < Build.VERSION_CODES.M || mPermissionChecker.checkPermission();
                        if (!isPermissionOK) {
                            return;
                        }
                        StreamingEnv.setLogLevel(Log.VERBOSE);
                        Intent intent = new Intent(activity, SWCameraStreamingActivity.class);
                        intent.putExtra("INPUT_TEXT", "");
                        intent.putExtra("TRANSFER_MODE_QUIC", false);
                        intent.putExtra("url", url);
                        intent.putExtra("CameraConfig", buildCameraConfig());
                        startActivity(intent);
                    }
                }else if (position == 4) {
                    if(type.equals(AdminTypeEnum.DRIVER.getValue())){
                        startActivity(new Intent(activity, ChangePasswordActivity.class));
                    }else if(type.equals(AdminTypeEnum.CAR_OWNER.getValue())){
                    }else if(type.equals(AdminTypeEnum.COMPANY.getValue())){
                        startActivity(new Intent(activity, ChangePasswordActivity.class));
                    }
                }else if (position == 5) {
                    startActivity(new Intent(activity, ResponsibilityBookActivity.class));
                }
//                else if (position==6){
//                    boolean isPermissionOK = Build.VERSION.SDK_INT < Build.VERSION_CODES.M || mPermissionChecker.checkPermission();
//                    if (!isPermissionOK) {
//                        return;
//                    }
//                    StreamingEnv.setLogLevel(Log.VERBOSE);
//                    Intent intent = new Intent(activity, SWCameraStreamingActivity.class);
//                    intent.putExtra("INPUT_TEXT", "");
//                    intent.putExtra("TRANSFER_MODE_QUIC", false);
//                    intent.putExtra("url", url);
//                    intent.putExtra("CameraConfig", buildCameraConfig());
//                    startActivity(intent);
//                }else if (position == 7) {
//                    startActivity(new Intent(activity, ChangePasswordActivity.class));
//                }
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


    @Override
    protected HomePresenter onInitLogicImpl() {
        return new HomePresenter();
    }


    @Override
    public void notComplete() {

    }

    @Override
    public void complete() {

    }
}
