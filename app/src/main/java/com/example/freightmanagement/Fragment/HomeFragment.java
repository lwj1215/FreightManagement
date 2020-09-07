package com.example.freightmanagement.Fragment;

import android.content.Intent;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.freightmanagement.Activity.CarListManageActivity;
import com.example.freightmanagement.Activity.ChangePasswordActivity;
import com.example.freightmanagement.Activity.CommonHtmlActivity;
import com.example.freightmanagement.Activity.CommonImgActivity;
import com.example.freightmanagement.Activity.DriverInformationActivity;
import com.example.freightmanagement.Activity.DriverListActivity;
import com.example.freightmanagement.Activity.SWCameraStreamingActivity;
import com.example.freightmanagement.Activity.SelectCarActivity;
import com.example.freightmanagement.Activity.TrainingSelectActivity;
import com.example.freightmanagement.Activity.VehicleInformationActivity;
import com.example.freightmanagement.Adapter.HomeFragmentAdapter;
import com.example.freightmanagement.Base.BaseFragment;
import com.example.freightmanagement.Base.BaseResponse;
import com.example.freightmanagement.Bean.ContractBean;
import com.example.freightmanagement.Bean.HtResultBean;
import com.example.freightmanagement.Bean.TrainResultBean;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.CameraConfig;
import com.example.freightmanagement.Utils.OnItemClickListener;
import com.example.freightmanagement.Utils.PermissionChecker;
import com.example.freightmanagement.Utils.PrefUtilsData;
import com.example.freightmanagement.Utils.ToastUtils;
import com.example.freightmanagement.enums.AdminTypeEnum;
import com.example.freightmanagement.enums.ResponseCodeEnum;
import com.example.freightmanagement.presenter.HomePresenter;
import com.google.gson.Gson;
import com.qiniu.pili.droid.streaming.CameraStreamingSetting;
import com.qiniu.pili.droid.streaming.StreamingEnv;
import java.util.Arrays;

public class HomeFragment extends BaseFragment<HomePresenter> implements HomePresenter.View {

    private RecyclerView recyclerView;
    private String[] mName = new String[]{"驾驶员信息", "车辆信息", "岗前培训", "聘用合同", "签订承诺书", "签订责任书", "公司例会", "修改密码", "关于"};
    private int[] icons;
    private HomeFragmentAdapter jp_adapter;
    private PermissionChecker mPermissionChecker;
    private String url = "rtmp://pili-publish.qnsdk.com/sdk-live/2a9b9dae-c229-411c-bfc6-940bda942d47?e=1595833142&token=QxZugR8TAhI38AiJ_cptTl3RbzLyca3t-AAiH-Hh:ioKtdeyOnxdnEsheNQvhCbyvlBY=";
    private String type;
    private boolean trainComplete = false;
    private boolean contractComplete = false;
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
            icons = new int[]{R.mipmap.img_jiashiyuan, R.mipmap.img_clxx, R.mipmap.img_peixun, R.mipmap.img_hetong, R.mipmap.img_lihui,R.mipmap.img_mima};
        }else if(type.equals(AdminTypeEnum.CAR_OWNER.getValue())){
            mName = new String[]{"车主信息", "车辆信息", "驾驶员列表", "修改密码"};
            icons = new int[]{R.mipmap.img_jiashiyuan, R.mipmap.img_clxx, R.mipmap.img_jiashiyuan, R.mipmap.img_mima};
        }else if(type.equals(AdminTypeEnum.COMPANY.getValue())){
            mName = new String[]{"企业信息", "车辆信息", "驾驶员列表", "公司例会", "修改密码",};
            icons = new int[]{R.mipmap.img_jiashiyuan, R.mipmap.img_clxx, R.mipmap.img_jiashiyuan, R.mipmap.img_lihui, R.mipmap.img_mima};
        }
        jp_adapter.setData(Arrays.asList(mName),icons);
        jp_adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if (position == 0) {
                    startActivity(new Intent(activity, DriverInformationActivity.class));
                }else if (position == 1) {
                    if(type.equals(AdminTypeEnum.DRIVER.getValue())){
                        mPresenter.getCompleteResult();
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
                        mPresenter.getHTResult();
//                        mPresenter.getTrainComplete();
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
                    }else if(type.equals(AdminTypeEnum.CAR_OWNER.getValue())){
                    }else if(type.equals(AdminTypeEnum.COMPANY.getValue())){
                        startActivity(new Intent(activity, ChangePasswordActivity.class));
                    }
                }else if (position == 5) {
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


    @Override
    protected HomePresenter onInitLogicImpl() {
        return new HomePresenter();
    }


    @Override
    public void trainResult(String msg) {
        TrainResultBean trainResultBean = new Gson().fromJson(msg, TrainResultBean.class);
        if(trainResultBean != null){
            TrainResultBean.DataBean data = trainResultBean.getData();
            if(data != null){
                int isPass = data.getIsPass();
                if(isPass == 1){
                    trainComplete = true;
                }else {
                    trainComplete = false;
                }
            }
        }
    }

    @Override
    public void contractResult(String msg) {
        ContractBean response = new Gson().fromJson(msg, ContractBean.class);
        if(response != null){
            Object data = response.getData();
            if(data == null){
                startActivity(new Intent(activity, SelectCarActivity.class));
            }else {
                String contractUrl = response.getData().getContractUrl();
                Intent intent = new Intent(activity, CommonImgActivity.class);
                intent.putExtra("htUrl",contractUrl);
                intent.putExtra("zrUrl",contractUrl);
                intent.putExtra("cnUrl",contractUrl);
                startActivity(intent);
            }
        }
    }

    @Override
    public void completeResult(boolean result) {
        if(result){
            startActivity(new Intent(activity, VehicleInformationActivity.class));
        }else {
            ToastUtils.popUpToast("聘用合同暂未签署或者暂未培训，无法进入");
        }

    }

    @Override
    public void HtReResult(String msg) {
        HtResultBean htResultBean = new Gson().fromJson(msg, HtResultBean.class);
        if(htResultBean.getCode() == ResponseCodeEnum.SUCCESS.getCode()){
            HtResultBean.DataBean data = htResultBean.getData();
            HtResultBean.DataBean.LetterContractBoBean letterContractBo = data.getLetterContractBo();
            HtResultBean.DataBean.LetterCommitmentBoBean letterCommitmentBo = data.getLetterCommitmentBo();
            HtResultBean.DataBean.ResponsibilityBoBean responsibilityBo = data.getResponsibilityBo();
            if(letterCommitmentBo == null || letterContractBo == null || responsibilityBo == null){
                startActivity(new Intent(activity, SelectCarActivity.class));
            }else {
                String contractUrl = letterContractBo.getContractUrl();
                String commitmentUrl = letterCommitmentBo.getCommitmentUrl();
                String responsibilityUrl = responsibilityBo.getResponsibilityUrl();
                Intent intent = new Intent(activity, CommonImgActivity.class);
                intent.putExtra("htUrl",contractUrl);
                intent.putExtra("zrUrl",responsibilityUrl);
                intent.putExtra("cnUrl",commitmentUrl);
                startActivity(intent);
            }

        }
    }
}
