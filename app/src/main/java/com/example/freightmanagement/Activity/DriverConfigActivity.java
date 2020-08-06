package com.example.freightmanagement.Activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.baidu.ocr.sdk.OCR;
import com.baidu.ocr.ui.camera.CameraActivity;
import com.baidu.ocr.ui.camera.CameraNativeHelper;
import com.baidu.ocr.ui.camera.CameraView;
import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.FileUtil;

import androidx.core.app.ActivityCompat;

/**
 * Created by songdechuan on 2020/8/6.
 */

public class DriverConfigActivity extends BaseActivity implements View.OnClickListener {
    private static final int REQUEST_CODE_PICK_IMAGE_FRONT = 201;
    private static final int REQUEST_CODE_PICK_IMAGE_BACK = 202;
    private static final int REQUEST_CODE_CAMERA = 102;
    /**
     * 上传身份证正面照片
     */
    private TextView mTvCard1;
    private ImageView mIvCardFront;
    private ImageView mCloseImageViewFont;
    private RelativeLayout mRePic;
    /**
     * 上传身份证反面照片
     */
    private TextView mTvCard2;
    private ImageView mIvCardRevers;
    private ImageView mCloseImageViewReverse;
    private RelativeLayout mRePicReverse;
    /**
     * 请填写您的真实姓名
     */
    private EditText mEtRealName;
    /**
     * 请填写您的性别
     */
    private EditText mEtDetailAddress;
    /**
     * 请填写您的年龄
     */
    private TextView mTvCurrentAddress;
    private LinearLayout mLlCurrentAddress;
    /**
     * 请填写您的身份证号
     */
    private EditText mEtCardNum;
    /**
     * 请填写上岗证号码
     */
    private TextView mTvSignHint;
    private ImageView mImgSign;
    private LinearLayout mLinSign;
    /**
     * 有效期
     */
    private TextView mTvMobile;
    /**
     * 2020/08/4
     */
    private TextView mTvSignDate;
    /**
     * 60分
     */
    private TextView mTvSignFen;
    /**
     * KE8581
     */
    private TextView mTvSignCph;
    /**
     * Jeep
     */
    private TextView mTvSignPp;
    /**
     * 45sa
     */
    private TextView mTvSignXh;
    private RelativeLayout mActivityNewDoctorSignProtocol;

    @Override
    public int setLayoutResource() {
        return R.layout.activity_driver_config;
    }

    @Override
    protected void onInitView() {
        initView();

    }

    @Override
    protected void onLoadData2Remote() {
        //  初始化本地质量控制模型,释放代码在onDestory中
        //  调用身份证扫描必须加上 intent.putExtra(CameraActivity.KEY_NATIVE_MANUAL, true); 关闭自动初始化和释放本地模型
        CameraNativeHelper.init(this, OCR.getInstance(this).getLicense(),
                new CameraNativeHelper.CameraNativeInitCallback() {
                    @Override
                    public void onError(int errorCode, Throwable e) {
                        String msg;
                        switch (errorCode) {
                            case CameraView.NATIVE_SOLOAD_FAIL:
                                msg = "加载so失败，请确保apk中存在ui部分的so";
                                break;
                            case CameraView.NATIVE_AUTH_FAIL:
                                msg = "授权本地质量控制token获取失败";
                                break;
                            case CameraView.NATIVE_INIT_FAIL:
                                msg = "本地质量控制";
                                break;
                            default:
                                msg = String.valueOf(errorCode);
                        }
//                        infoTextView.setText("本地质量控制初始化错误，错误原因： " + msg);
                    }
                });
    }

    private boolean checkGalleryPermission() {
        int ret = ActivityCompat.checkSelfPermission(this, Manifest.permission
                .READ_EXTERNAL_STORAGE);
        if (ret != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    1000);
            return false;
        }
        return true;
    }


    public void initView() {
        mTvCard1 = (TextView) findViewById(R.id.tv_card1);
        mIvCardFront = (ImageView) findViewById(R.id.iv_card_front);
        mCloseImageViewFont = (ImageView) findViewById(R.id.closeImageViewFont);
        mRePic = (RelativeLayout) findViewById(R.id.re_pic);
        mRePic.setOnClickListener(this);
        mTvCard2 = (TextView) findViewById(R.id.tv_card2);
        mIvCardRevers = (ImageView) findViewById(R.id.iv_card_revers);
        mCloseImageViewReverse = (ImageView) findViewById(R.id.closeImageViewReverse);
        mRePicReverse = (RelativeLayout) findViewById(R.id.re_pic_reverse);
        mRePicReverse.setOnClickListener(this);
        mEtRealName = (EditText) findViewById(R.id.et_real_name);
        mEtDetailAddress = (EditText) findViewById(R.id.et_detail_address);
        mTvCurrentAddress = (TextView) findViewById(R.id.tv_current_address);
        mLlCurrentAddress = (LinearLayout) findViewById(R.id.ll_current_address);
        mEtCardNum = (EditText) findViewById(R.id.et_card_num);
        mTvSignHint = (TextView) findViewById(R.id.tv_sign_hint);
        mImgSign = (ImageView) findViewById(R.id.img_sign);
        mLinSign = (LinearLayout) findViewById(R.id.lin_sign);
        mTvMobile = (TextView) findViewById(R.id.tv_mobile);
        mTvSignDate = (TextView) findViewById(R.id.tv_sign_date);
        mTvSignFen = (TextView) findViewById(R.id.tv_sign_fen);
        mTvSignCph = (TextView) findViewById(R.id.tv_sign_cph);
        mTvSignPp = (TextView) findViewById(R.id.tv_sign_pp);
        mTvSignXh = (TextView) findViewById(R.id.tv_sign_xh);
        mActivityNewDoctorSignProtocol = (RelativeLayout) findViewById(R.id.activity_new_doctor_sign_protocol);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.re_pic:
                takeIDCard();
                break;
            case R.id.re_pic_reverse:
                takeIDCardReverse();
                break;
        }
    }

    /**
     * 正面身份证拍照
     */
    private void takeIDCard(){
        Intent intent = new Intent(DriverConfigActivity.this, CameraActivity.class);
        intent.putExtra(CameraActivity.KEY_OUTPUT_FILE_PATH,
                FileUtil.getSaveFile(getApplication()).getAbsolutePath());
        intent.putExtra(CameraActivity.KEY_NATIVE_ENABLE,
                true);
        // KEY_NATIVE_MANUAL设置了之后CameraActivity中不再自动初始化和释放模型
        // 请手动使用CameraNativeHelper初始化和释放模型
        // 推荐这样做，可以避免一些activity切换导致的不必要的异常
        intent.putExtra(CameraActivity.KEY_NATIVE_MANUAL,
                true);
        intent.putExtra(CameraActivity.KEY_CONTENT_TYPE, CameraActivity.CONTENT_TYPE_ID_CARD_FRONT);
        startActivityForResult(intent, REQUEST_CODE_CAMERA);
    }

    /**
     * 反面身份证扫描
     */
    private void takeIDCardReverse(){
        Intent intent = new Intent(DriverConfigActivity.this, CameraActivity.class);
        intent.putExtra(CameraActivity.KEY_OUTPUT_FILE_PATH,
                FileUtil.getSaveFile(getApplication()).getAbsolutePath());
        intent.putExtra(CameraActivity.KEY_NATIVE_ENABLE,
                true);
        // KEY_NATIVE_MANUAL设置了之后CameraActivity中不再自动初始化和释放模型
        // 请手动使用CameraNativeHelper初始化和释放模型
        // 推荐这样做，可以避免一些activity切换导致的不必要的异常
        intent.putExtra(CameraActivity.KEY_NATIVE_MANUAL,
                true);
        intent.putExtra(CameraActivity.KEY_CONTENT_TYPE, CameraActivity.CONTENT_TYPE_ID_CARD_BACK);
        startActivityForResult(intent, REQUEST_CODE_CAMERA);
    }
}
