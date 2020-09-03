package com.example.freightmanagement.Activity;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;

import com.baidu.ocr.sdk.OCR;
import com.baidu.ocr.sdk.OnResultListener;
import com.baidu.ocr.sdk.exception.OCRError;
import com.baidu.ocr.sdk.model.IDCardParams;
import com.baidu.ocr.sdk.model.IDCardResult;
import com.baidu.ocr.ui.camera.CameraActivity;
import com.baidu.ocr.ui.camera.CameraNativeHelper;
import com.baidu.ocr.ui.camera.CameraView;
import com.bumptech.glide.Glide;
import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.Bean.DriverLicenseBean;
import com.example.freightmanagement.Bean.WorkBean;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.DateUtil;
import com.example.freightmanagement.Utils.DialogUtils;
import com.example.freightmanagement.Utils.FileUtil;
import com.example.freightmanagement.Utils.IDCardUtils;
import com.example.freightmanagement.Utils.PrefUtilsData;
import com.example.freightmanagement.Utils.StringUtils;
import com.example.freightmanagement.Utils.ToastUtils;
import com.example.freightmanagement.View.ElectronicSignature;
import com.example.freightmanagement.model.CertificateDriverParam;
import com.example.freightmanagement.model.CertificateWorkParam;
import com.example.freightmanagement.model.DriverInfoSubmitParam;
import com.example.freightmanagement.model.IDCardInfoFrontBean;
import com.example.freightmanagement.model.IDCardParam;
import com.example.freightmanagement.presenter.DriverConfigPresenter;
import com.example.freightmanagement.presenter.constract.DriverConfigConstact;
import com.google.gson.Gson;

import java.io.File;
import java.text.ParseException;
import java.util.List;

import cn.qqtheme.framework.picker.DatePicker;
import cn.qqtheme.framework.picker.OptionPicker;
import cn.qqtheme.framework.util.ConvertUtils;
import cn.qqtheme.framework.widget.WheelView;

import static com.example.freightmanagement.Base.BaseApiConstants.IMAGE_BASE_URL;
import static com.example.freightmanagement.common.ImageUploadConstants.UPLOAD_DRIVER;
import static com.example.freightmanagement.common.ImageUploadConstants.UPLOAD_ID_CARD_BACK;
import static com.example.freightmanagement.common.ImageUploadConstants.UPLOAD_ID_CARD_FRONT;
import static com.example.freightmanagement.common.ImageUploadConstants.UPLOAD_WORK;

/**
 * Created by songdechuan on 2020/8/6.
 */

public class DriverConfigActivity extends BaseActivity<DriverConfigPresenter> implements DriverConfigConstact.View, View.OnClickListener {
    private static final int REQUEST_CODE_PICK_IMAGE_FRONT = 201;
    private static final int REQUEST_CODE_PICK_IMAGE_BACK = 202;
    private static final int REQUEST_CODE_CAMERA = 102;
    private static final int REQUEST_CODE_DRIVING_LICENSE = 121;
    private static final int REQUEST_CODE_WORK_LICENSE = 122;

    private static final int DATE_TYPE_START_DATE = 300;
    private static final int DATE_TYPE_END_DATE = 301;
    private static final int DATE_TYPE_FIRST_RECEIVE_DATE = 302;
    private static final int DATE_TYPE_EFFECTIVE_DATE = 303;
    private static final int DATE_TYPE_VALID_DATE = 304;
    private static final String TEMPLATE_WORK_SIGN = "be14fc9fd2d9a508fc95a3f8fbbe37d9";

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
    private EditText mTvCurrentAddress;
    private LinearLayout mLlCurrentAddress;
    /**
     * 请填写您的身份证号
     */
    private EditText mEtCardNum;
    /**
     * 请填写上岗证号码
     */
    private EditText mEtPostCard;
    private ImageView mImgSign;
    private LinearLayout mLinSign;
    /**
     * 有效期
     */
//    private TextView mTvMobile;
    /**
     * 2020/08/4
     */
    private TextView mTvSignDate;
    /**
     * 60分
     */
//    private TextView mTvSignFen;
    /**
     * KE8581
     */
//    private TextView mTvSignCph;
    /**
     * Jeep
     */
//    private TextView mTvSignPp;
    /**
     * 45sa
     */
//    private TextView mTvSignXh;
    private RelativeLayout mActivityNewDoctorSignProtocol;
    private final String FRONT = "front";
    private final String BACK = "back";
    private TextView mTvSure;
    private RelativeLayout mRlSign;
    private TextView mTvSign;
    private ImageView mIvSign;
    private Dialog bottomDialog;
    private View bottomView;
    private ElectronicSignature vSignView;
    /**
     * 上传驾驶证正页照片
     */
    private TextView mTvDriver;
    private ImageView mIvDriverFront;
    private ImageView mCloseDriverFont;
    private RelativeLayout mReDriverPic;
    /**
     * 上传驾驶证副页照片
     */
    private TextView mTvDriver2;
    private ImageView mIvDriverReverse;
    private ImageView mCloseDriverReverse;
    private RelativeLayout mReDriverReverse;
    /**
     * 请选择您的准驾类型
     */
    private TextView mEtPermitType;
    /**
     * 开始日期
     */
    private TextView mTvStartDate;
    /**
     * 结束日期
     */
    private TextView mEtEndDate;

    /**
     * 选择日期
     */
    private TextView mTvFirstReceive;
    /**
     * 选择日期
     */

    private String idCardFrontUrl = "";
    private String idCardBackUrl = "";
    private String driverUrl = "";
    private String signUrl = "";
    private String permitType;
    private String startTime;
    private String endTime;
    private String firstReceiveTime;
    private String frontPath;
    private String backPath;
    private String driverPath;
    private String driverNum;
    private TextView mTvWork;
    private ImageView mIvWorkFront;
    private RelativeLayout mReWorkPic;
    private String workPath;
    private TextView mTvYouXiaoQi;
    private String workUrl;
    private String youxiaoqiTime;

    @Override
    public int setLayoutResource() {
        return R.layout.activity_driver_config;

    }

    @Override
    protected void onInitView() {
        setDefaultTitle("驾驶员注册");
        checkGalleryPermission();
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
        int wet = ActivityCompat.checkSelfPermission(this, Manifest.permission
                .WRITE_EXTERNAL_STORAGE);
        if (ret != PackageManager.PERMISSION_GRANTED && wet != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE},
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
        mTvCurrentAddress = (EditText) findViewById(R.id.tv_current_address);
        mLlCurrentAddress = (LinearLayout) findViewById(R.id.ll_current_address);
        mEtCardNum = (EditText) findViewById(R.id.et_card_num);
        mEtPostCard = (EditText) findViewById(R.id.et_post_card);
        mImgSign = (ImageView) findViewById(R.id.img_sign);
        mLinSign = (LinearLayout) findViewById(R.id.lin_sign);
        mTvSure = (TextView) findViewById(R.id.tv_srue);
        mTvSure.setOnClickListener(this);
        mTvSign = (TextView) findViewById(R.id.tv_sign);
        mIvSign = (ImageView) findViewById(R.id.iv_sign);
        mRlSign = (RelativeLayout) findViewById(R.id.rl_sign);
        mRlSign.setOnClickListener(this);
        mTvSign.setOnClickListener(this);
        mActivityNewDoctorSignProtocol = (RelativeLayout) findViewById(R.id.activity_new_doctor_sign_protocol);
        bottomView = LayoutInflater.from(this).inflate(R.layout.inflate_pop_item, null);
        bottomView.findViewById(R.id.btn_no).setOnClickListener(this);
        bottomView.findViewById(R.id.btn_yes).setOnClickListener(this);
        vSignView = (ElectronicSignature) bottomView.findViewById(R.id.sign_view);
        mTvDriver = (TextView) findViewById(R.id.tv_driver);
        mIvDriverFront = (ImageView) findViewById(R.id.iv_driver_front);
        mCloseDriverFont = (ImageView) findViewById(R.id.close_driver_Font);
        mCloseDriverFont.setOnClickListener(this);
        mReDriverPic = (RelativeLayout) findViewById(R.id.re_driver_pic);
        mReDriverPic.setOnClickListener(this);
        mTvDriver2 = (TextView) findViewById(R.id.tv_driver2);
        mTvDriver2.setOnClickListener(this);
        mIvDriverReverse = (ImageView) findViewById(R.id.iv_driver_reverse);
        mCloseDriverReverse = (ImageView) findViewById(R.id.close_driver_reverse);
        mCloseDriverReverse.setOnClickListener(this);
        mReDriverReverse = (RelativeLayout) findViewById(R.id.re_driver_reverse);
        mReDriverReverse.setOnClickListener(this);
        mEtPermitType = (TextView) findViewById(R.id.et_permit_type);
        mTvStartDate = (TextView) findViewById(R.id.tv_start_date);
        mEtEndDate = (TextView) findViewById(R.id.et_end_date);
        mTvYouXiaoQi = findViewById(R.id.tv_you_xiao_qi);
        mTvYouXiaoQi.setOnClickListener(this);
        mTvFirstReceive = (TextView) findViewById(R.id.tv_first_receive);
        mTvWork = findViewById(R.id.tv_work);
        mIvWorkFront = findViewById(R.id.iv_work_front);
        mReWorkPic = findViewById(R.id.re_work_pic);
        mReWorkPic.setOnClickListener(this);

        mTvFirstReceive.setOnClickListener(this);

        mEtPermitType.setOnClickListener(this);
        mTvStartDate.setOnClickListener(this);
        mEtEndDate.setOnClickListener(this);
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
            case R.id.rl_sign:
                bottomDialog = DialogUtils.showBottomWindowDialog(this, bottomDialog, bottomView);
                break;
            case R.id.tv_sign:
                bottomDialog = DialogUtils.showBottomWindowDialog(this, bottomDialog, bottomView);
                break;
            case R.id.btn_no:
                vSignView.clearCanvas();
                break;
            case R.id.btn_yes:
                if (bottomDialog != null) {
                    bottomDialog.dismiss();
                }
                Bitmap bitmap = vSignView.save();
                mTvSign.setVisibility(View.GONE);
                mIvSign.setImageBitmap(bitmap);
                break;
            case R.id.tv_you_xiao_qi:
                onYearMonthDayPicker(DATE_TYPE_VALID_DATE);
                break;
            case R.id.re_driver_pic:
                driverPath = "driver_" + System.currentTimeMillis();
                takeDriverPhoto(driverPath);
                break;
            case R.id.tv_driver2:
                break;
            case R.id.close_driver_reverse:
                break;
            case R.id.re_driver_reverse:
                break;
            case R.id.tv_first_receive:
                onYearMonthDayPicker(DATE_TYPE_FIRST_RECEIVE_DATE);
                break;
//            case R.id.tv_effective_date:
//                onYearMonthDayPicker(DATE_TYPE_EFFECTIVE_DATE);
//                break;
            case R.id.et_permit_type:
                onOptionPicker();
                break;
            case R.id.tv_start_date:
                onYearMonthDayPicker(DATE_TYPE_START_DATE);
                break;
            case R.id.et_end_date:
                onYearMonthDayPicker(DATE_TYPE_END_DATE);
                break;
            case R.id.re_work_pic:
                workPath = "work_" + System.currentTimeMillis();
                takeWorkPhoto(workPath);
                break;
            case R.id.tv_srue:
                if (StringUtils.isEmpty(idCardFrontUrl)) {
                    ToastUtils.popUpToast("请选择身份证正面照片");
                    return;
                }
                if (StringUtils.isEmpty(idCardBackUrl)) {
                    ToastUtils.popUpToast("请选择身份证反面照片");
                    return;
                }
                String userName = mEtRealName.getText().toString();
                if (StringUtils.isEmpty(userName)) {
                    ToastUtils.popUpToast("姓名不得为空");
                    return;
                }
                String idCardNum = mEtCardNum.getText().toString();
                if (StringUtils.isEmpty(idCardNum)) {
                    ToastUtils.popUpToast("身份证号不得为空");
                    return;
                }
                String postCardNum = mEtPostCard.getText().toString();
                if (StringUtils.isEmpty(postCardNum)) {
                    ToastUtils.popUpToast("上岗证号不得为空");
                    return;
                }
                if (StringUtils.isEmpty(permitType)) {
                    ToastUtils.popUpToast("准驾车型不得为空");
                    return;
                }
                if (StringUtils.isEmpty(startTime)) {
                    ToastUtils.popUpToast("开始日期不得为空");
                    return;
                }
                if (StringUtils.isEmpty(endTime)) {
                    ToastUtils.popUpToast("结束日期不得为空");
                    return;
                }
                if (StringUtils.isEmpty(firstReceiveTime)) {
                    ToastUtils.popUpToast("初次领证日期不得为空");
                    return;
                }
                DriverInfoSubmitParam driverInfoSubmitParam = new DriverInfoSubmitParam();
                driverInfoSubmitParam.setName(userName);
                driverInfoSubmitParam.setTel(PrefUtilsData.getMobile());
                IDCardParam idCardParam = new IDCardParam();
                idCardParam.setIDNo(idCardNum);
                idCardParam.setName(userName);
                idCardParam.setPicUrl(idCardFrontUrl);
                idCardParam.setPicUrl2(idCardBackUrl);
                driverInfoSubmitParam.setCertificateIDBo(idCardParam);

                CertificateDriverParam certificateDriverParam = new CertificateDriverParam();
                certificateDriverParam.setClasss(permitType);
                certificateDriverParam.setStartTime(startTime);
                certificateDriverParam.setPicUrl(driverUrl);
                certificateDriverParam.setFileNumber(String.valueOf(driverNum));
                driverInfoSubmitParam.setCertificateDriverBo(certificateDriverParam);

                CertificateWorkParam certificateWorkParam = new CertificateWorkParam();
                certificateWorkParam.setGrantNo(mEtPostCard.getText().toString());
                certificateWorkParam.setFileNumber(postCardNum);
                try {
                    certificateWorkParam.setFirstTime(DateUtil.string2Date(mTvFirstReceive.getText().toString()));
                    certificateWorkParam.setValidityStartTime(DateUtil.string2Date(mTvYouXiaoQi.getText().toString()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                certificateWorkParam.setPicUrl(workUrl);
                driverInfoSubmitParam.setCertificateWorkBo(certificateWorkParam);
                Intent intent1 = new Intent(this, SelectCarActivity.class);
                intent1.putExtra("driverInfo", driverInfoSubmitParam);
                startActivity(intent1);
                break;
        }
    }

    private void takeWorkPhoto(String workPath) {
        Intent intent = new Intent(this, CameraActivity.class);
        intent.putExtra(CameraActivity.KEY_OUTPUT_FILE_PATH,
                FileUtil.getSaveFile(getApplication(), workPath).getAbsolutePath());
        intent.putExtra(CameraActivity.KEY_CONTENT_TYPE,
                CameraActivity.CONTENT_TYPE_GENERAL);
        startActivityForResult(intent, REQUEST_CODE_WORK_LICENSE);
    }

    private void takeDriverPhoto(String driverPath) {
        Intent intent = new Intent(this, CameraActivity.class);
        intent.putExtra(CameraActivity.KEY_OUTPUT_FILE_PATH,
                FileUtil.getSaveFile(getApplication(), driverPath).getAbsolutePath());
        intent.putExtra(CameraActivity.KEY_CONTENT_TYPE,
                CameraActivity.CONTENT_TYPE_GENERAL);
        startActivityForResult(intent, REQUEST_CODE_DRIVING_LICENSE);
    }

    /**
     * 正面身份证拍照
     */
    private void takeIDCard() {
        frontPath = FRONT + "_" + System.currentTimeMillis();
        Intent intent = new Intent(DriverConfigActivity.this, CameraActivity.class);
        intent.putExtra(CameraActivity.KEY_OUTPUT_FILE_PATH,
                FileUtil.getSaveFile(getApplication(), frontPath).getAbsolutePath());
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

    private void recIDCard(final String idCardSide, final String filePath) {
        IDCardParams param = new IDCardParams();
        param.setImageFile(new File(filePath));
        // 设置身份证正反面
        param.setIdCardSide(idCardSide);
        // 设置方向检测
        param.setDetectDirection(true);
        // 设置图像参数压缩质量0-100, 越大图像质量越好但是请求时间越长。 不设置则默认值为20
        param.setImageQuality(20);

        OCR.getInstance(this).recognizeIDCard(param, new OnResultListener<IDCardResult>() {
            @Override
            public void onResult(IDCardResult result) {
                if (result != null) {
                    result.getAddress();
//                    alertText(idCardSide, new Gson().toJson(result));
                    setIDCardInfo(idCardSide, new Gson().toJson(result), filePath);
                }
            }

            @Override
            public void onError(OCRError error) {
                alertText("", error.getMessage());
            }
        });
    }

    private void setIDCardInfo(final String idCardSide, final String result, final String filePath) {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                switch (idCardSide) {
                    case FRONT:
//                        Glide.
                        IDCardInfoFrontBean idCardInfoFrontBean = new Gson().fromJson(result, IDCardInfoFrontBean.class);
                        if (idCardInfoFrontBean == null) {
                            ToastUtils.popUpToast("身份证选择失败，请重新选择");
                            break;

                        }
                        if (!idCardInfoFrontBean.getImageStatus().equals("normal")) {
                            ToastUtils.popUpToast("身份证照片不正常，请重新选择");
                            break;
                        }
                        mEtRealName.setText(idCardInfoFrontBean.getName().getWords());
                        mEtDetailAddress.setText(idCardInfoFrontBean.getGender().getWords());
                        String number = idCardInfoFrontBean.getIdNumber().getWords();
                        int age = IDCardUtils.IdNOToAge(number);
                        mTvCurrentAddress.setText(String.valueOf(age));
                        mEtCardNum.setText(number);
                        mPresenter.upload(new File(filePath), UPLOAD_ID_CARD_FRONT);
                        break;
                    case BACK:
                        mPresenter.upload(new File(filePath), UPLOAD_ID_CARD_BACK);
                        break;
                }

            }
        });

    }

    /**
     * 反面身份证扫描
     */
    private void takeIDCardReverse() {
        backPath = BACK + "_" + System.currentTimeMillis();
        Intent intent = new Intent(DriverConfigActivity.this, CameraActivity.class);
        intent.putExtra(CameraActivity.KEY_OUTPUT_FILE_PATH,
                FileUtil.getSaveFile(getApplication(), backPath).getAbsolutePath());
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


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //身份证正面返回
        if (requestCode == REQUEST_CODE_PICK_IMAGE_FRONT && resultCode == Activity.RESULT_OK) {
            Uri uri = data.getData();
            String filePath = getRealPathFromURI(uri);
            mIvCardFront.setVisibility(View.VISIBLE);
            Glide.with(this).load(filePath).into(mIvCardFront);
            mTvCard1.setVisibility(View.GONE);
            recIDCard(IDCardParams.ID_CARD_SIDE_FRONT, filePath);
        }
        //身份证反面返回
        if (requestCode == REQUEST_CODE_PICK_IMAGE_BACK && resultCode == Activity.RESULT_OK) {
            Uri uri = data.getData();
            String filePath = getRealPathFromURI(uri);
            recIDCard(IDCardParams.ID_CARD_SIDE_BACK, filePath);
            Glide.with(this).load(filePath).into(mIvCardRevers);
            mIvCardRevers.setVisibility(View.VISIBLE);
            mTvCard2.setVisibility(View.GONE);
        }
        //
        if (requestCode == REQUEST_CODE_CAMERA && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                String contentType = data.getStringExtra(CameraActivity.KEY_CONTENT_TYPE);
                String filePath = "";
                if (!TextUtils.isEmpty(contentType)) {
                    if (CameraActivity.CONTENT_TYPE_ID_CARD_FRONT.equals(contentType)) {
                        filePath = FileUtil.getSaveFile(getApplicationContext(), frontPath).getAbsolutePath();
                        recIDCard(IDCardParams.ID_CARD_SIDE_FRONT, filePath);
                        Glide.with(this).load(filePath).into(mIvCardFront);
                        mTvCard1.setVisibility(View.GONE);
                        mIvCardFront.setVisibility(View.VISIBLE);

                    } else if (CameraActivity.CONTENT_TYPE_ID_CARD_BACK.equals(contentType)) {
                        filePath = FileUtil.getSaveFile(getApplicationContext(), backPath).getAbsolutePath();

                        Glide.with(this).load(filePath).into(mIvCardRevers);
                        mTvCard2.setVisibility(View.GONE);
                        mIvCardRevers.setVisibility(View.VISIBLE);
                        recIDCard(IDCardParams.ID_CARD_SIDE_BACK, filePath);
                    }
                }
            }
        }
        // 识别成功回调，驾驶证识别
        if (requestCode == REQUEST_CODE_DRIVING_LICENSE && resultCode == Activity.RESULT_OK) {
            final String filePath = FileUtil.getSaveFile(getApplicationContext(), driverPath).getAbsolutePath();

            RecognizeService.recDrivingLicense(this, FileUtil.getSaveFile(getApplicationContext(), driverPath).getAbsolutePath(),
                    new RecognizeService.ServiceListener() {
                        @Override
                        public void onResult(String result) {
                            DriverLicenseBean driverLicenseBean = new Gson().fromJson(result, DriverLicenseBean.class);
                            DriverLicenseBean.WordsResultBean words_result = driverLicenseBean.getWords_result();
                            DriverLicenseBean.WordsResultBean.准驾车型Bean 准驾车型 = words_result.get准驾车型();
                            DriverLicenseBean.WordsResultBean.有效期限Bean 有效期限 = words_result.get有效期限();
//                            DriverLicenseBean.WordsResultBean.至Bean 至 = words_result.get至();
                            DriverLicenseBean.WordsResultBean.证号Bean 证号 = words_result.get证号();
                            driverNum = 证号.getWords();
                            permitType = 准驾车型.getWords();
                            mPresenter.upload(new File(filePath), UPLOAD_DRIVER);
                            mEtPermitType.setText(准驾车型.getWords());
                            mTvStartDate.setText(有效期限.getWords());
                            startTime = 有效期限.getWords();
//                            mEtEndDate.setText(至.getWords());
                            mIvDriverFront.setVisibility(View.VISIBLE);
                            mTvDriver.setVisibility(View.GONE);
                            Glide.with(getContext()).load(filePath).into(mIvDriverFront);

                        }
                    });
        }
        // 识别成功回调，自定义模板上岗证回调
        if (requestCode == REQUEST_CODE_WORK_LICENSE && resultCode == Activity.RESULT_OK) {
            final String filePath = FileUtil.getSaveFile(getApplicationContext(), workPath).getAbsolutePath();

            RecognizeService.recCustom(this, FileUtil.getSaveFile(getApplicationContext(), workPath).getAbsolutePath(), TEMPLATE_WORK_SIGN, 0,
                    new RecognizeService.ServiceListener() {
                        @Override
                        public void onResult(String result) {
                            ToastUtils.popUpToast("此识别结果仅供参考，请仔细比对检查");
                            Glide.with(getContext()).load(filePath).into(mIvWorkFront);
                            mPresenter.upload(new File(filePath), UPLOAD_WORK);
                            boolean json = StringUtils.isJson(result);

                            if(!json){
                                ToastUtils.popUpToast("上传失败请重试");
                                return;
                            }
                            WorkBean workBean = new Gson().fromJson(result, WorkBean.class);
                            if (workBean != null) {
                                WorkBean.DataBean workBeanData = workBean.getData();
                                List<WorkBean.DataBean.RetBean> ret = workBeanData.getRet();
                                if (ret != null) {
                                    for (WorkBean.DataBean.RetBean retBean : ret) {
                                        String word_name = retBean.getWord_name();
                                        String word = retBean.getWord();
                                        if (word_name.equals("certificateNum")) {
                                            mEtPostCard.setText(word);
                                        } else if (word_name.equals("sendTime")) {
                                            if(word.contains("日")){
                                                word = word.substring(0,word.indexOf("日")+1);
                                            }
                                            firstReceiveTime = word;
                                            mTvFirstReceive.setText(word);
                                        } else if (word_name.equals("validPeriod")) {
                                            mTvYouXiaoQi.setText(word);
                                        }
                                    }
                                }
                            } else {
                                ToastUtils.popUpToast("识别失败请重新上传或者手动填写");
                            }
                        }
                    });
        }
    }

    private String getRealPathFromURI(Uri contentURI) {
        String result;
        Cursor cursor = getContentResolver().query(contentURI, null, null, null, null);
        if (cursor == null) { // Source is Dropbox or other similar local file path
            result = contentURI.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            result = cursor.getString(idx);
            cursor.close();
        }
        return result;
    }

    private void alertText(final String title, final String message) {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ToastUtils.popUpToast(title);

                ToastUtils.popUpToast(message);
                Log.d("title", title);
                Log.d("message", message);

            }
        });
    }

    /**
     * 准驾车型选择
     */
    public void onOptionPicker() {
        OptionPicker picker = new OptionPicker(this, new String[]{
                "A1", "A2", "B1", "B2", "C1", "C2"
        });
        picker.setCanceledOnTouchOutside(false);
        picker.setDividerRatio(WheelView.DividerConfig.FILL);
//        picker.setShadowColor(Color.RED, 40);
        picker.setSelectedIndex(1);
        picker.setCycleDisable(true);
        picker.setTextSize(18);
        picker.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
            @Override
            public void onOptionPicked(int index, String item) {
//                showToast("index=" + index + ", item=" + item);
                permitType = item;
            }
        });
        picker.show();
    }

    public void onYearMonthDayPicker(final int type) {
        final DatePicker picker = new DatePicker(this);
        picker.setCanceledOnTouchOutside(true);
        picker.setTextSize(20);
        picker.setUseWeight(true);
        picker.setTopPadding(ConvertUtils.toPx(this, 10));
        picker.setRangeEnd(2111, 1, 11);
        picker.setRangeStart(2016, 8, 29);
        picker.setSelectedItem(2050, 10, 14);
        picker.setResetWhileWheel(false);
        picker.setOnDatePickListener(new DatePicker.OnYearMonthDayPickListener() {
            @Override
            public void onDatePicked(String year, String month, String day) {
                switch (type) {
                    case DATE_TYPE_START_DATE:
                        startTime = year + "年" + month + "月" + day + "日";
                        mTvStartDate.setText(startTime);
                        break;
                    case DATE_TYPE_END_DATE:
                        endTime = year + "年" + month + "月" + day + "日";
                        mEtEndDate.setText(endTime);
                        break;
                    case DATE_TYPE_FIRST_RECEIVE_DATE:
                        firstReceiveTime = year + "年" + month + "月" + day + "日";
                        mTvFirstReceive.setText(firstReceiveTime);
                        break;
                    case DATE_TYPE_VALID_DATE:
                        youxiaoqiTime = year + "年" + month + "月" + day + "日";
                        mTvYouXiaoQi.setText(youxiaoqiTime);
                        break;
                }
            }
        });
        picker.setOnWheelListener(new DatePicker.OnWheelListener() {
            @Override
            public void onYearWheeled(int index, String year) {
                picker.setTitleText(year + "-" + picker.getSelectedMonth() + "-" + picker.getSelectedDay());
            }

            @Override
            public void onMonthWheeled(int index, String month) {
                picker.setTitleText(picker.getSelectedYear() + "-" + month + "-" + picker.getSelectedDay());
            }

            @Override
            public void onDayWheeled(int index, String day) {
                picker.setTitleText(picker.getSelectedYear() + "-" + picker.getSelectedMonth() + "-" + day);
            }
        });
        picker.show();
    }


    @Override
    public void imageUrl(String url, int type) {
        switch (type) {
            case UPLOAD_ID_CARD_FRONT:
                idCardFrontUrl = IMAGE_BASE_URL + url;
                break;
            case UPLOAD_ID_CARD_BACK:
                idCardBackUrl = IMAGE_BASE_URL + url;
                break;
            case UPLOAD_DRIVER:
                driverUrl = IMAGE_BASE_URL + url;
                break;
            case UPLOAD_WORK:
                workUrl = IMAGE_BASE_URL + url;
                break;
        }
    }
//    private boolean checkTokenStatus() {
//        if (!hasGotToken) {
//            Toast.makeText(getApplicationContext(), "token还未成功获取", Toast.LENGTH_LONG).show();
//        }
//        return hasGotToken;
//    }

}
