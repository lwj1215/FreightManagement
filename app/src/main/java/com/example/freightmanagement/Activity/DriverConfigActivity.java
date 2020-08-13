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
import android.widget.Toast;

import com.baidu.ocr.sdk.OCR;
import com.baidu.ocr.sdk.OnResultListener;
import com.baidu.ocr.sdk.exception.OCRError;
import com.baidu.ocr.sdk.model.IDCardParams;
import com.baidu.ocr.sdk.model.IDCardResult;
import com.baidu.ocr.ui.camera.CameraActivity;
import com.baidu.ocr.ui.camera.CameraNativeHelper;
import com.baidu.ocr.ui.camera.CameraView;
import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.DialogUtils;
import com.example.freightmanagement.Utils.FileUtil;
import com.example.freightmanagement.Utils.IDCardUtils;
import com.example.freightmanagement.Utils.StringUtils;
import com.example.freightmanagement.Utils.ToastUtils;
import com.example.freightmanagement.View.ElectronicSignature;
import com.example.freightmanagement.model.CertificateDriverParam;
import com.example.freightmanagement.model.CertificateWorkParam;
import com.example.freightmanagement.model.DriverInfoSubmitParam;
import com.example.freightmanagement.model.IDCardInfoFrontBean;
import com.example.freightmanagement.model.IDCardParam;
import com.google.gson.Gson;

import java.io.File;

import androidx.core.app.ActivityCompat;
import cn.qqtheme.framework.picker.DatePicker;
import cn.qqtheme.framework.picker.OptionPicker;
import cn.qqtheme.framework.util.ConvertUtils;
import cn.qqtheme.framework.widget.WheelView;

/**
 * Created by songdechuan on 2020/8/6.
 */

public class DriverConfigActivity extends BaseActivity implements View.OnClickListener {
    private static final int REQUEST_CODE_PICK_IMAGE_FRONT = 201;
    private static final int REQUEST_CODE_PICK_IMAGE_BACK = 202;
    private static final int REQUEST_CODE_CAMERA = 102;
    private static final int REQUEST_CODE_DRIVING_LICENSE = 121;
    private static final int DATE_TYPE_START_DATE = 300;
    private static final int DATE_TYPE_END_DATE = 301;
    private static final int DATE_TYPE_FIRST_RECEIVE_DATE = 302;
    private static final int DATE_TYPE_EFFECTIVE_DATE= 303;


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
//    private TextView mTvSignDate;
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
     * 请填写从业资格类别
     */
    private EditText mTvQualificationType;
    /**
     * 选择日期
     */
    private TextView mTvFirstReceive;
    /**
     * 选择日期
     */
    private TextView mTvEffectiveDate;

    private String idCardFrontPath = "";
    private String idCardBackPath = "";
    private String driverPath = "";
    private String signUrl = "";
    private String permitType;
    private String startTime;
    private String endTime;
    private String firstReceiveTime;
    private String effectiveTime;

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
        mTvCurrentAddress = (EditText) findViewById(R.id.tv_current_address);
        mLlCurrentAddress = (LinearLayout) findViewById(R.id.ll_current_address);
        mEtCardNum = (EditText) findViewById(R.id.et_card_num);
        mEtPostCard = (EditText) findViewById(R.id.et_post_card);
        mImgSign = (ImageView) findViewById(R.id.img_sign);
        mLinSign = (LinearLayout) findViewById(R.id.lin_sign);
//        mTvMobile = (TextView) findViewById(R.id.tv_mobile);
//        mTvSignDate = (TextView) findViewById(R.id.tv_sign_date);
        mTvSure = (TextView) findViewById(R.id.tv_srue);
        mTvSure.setOnClickListener(this);
//        mTvSignFen = (TextView) findViewById(R.id.tv_sign_fen);
//        mTvSignCph = (TextView) findViewById(R.id.tv_sign_cph);
//        mTvSignPp = (TextView) findViewById(R.id.tv_sign_pp);
//        mTvSignXh = (TextView) findViewById(R.id.tv_sign_xh);
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

        mTvQualificationType = (EditText) findViewById(R.id.tv_qualification_type);
        mTvFirstReceive = (TextView) findViewById(R.id.tv_first_receive);
        mTvFirstReceive.setOnClickListener(this);
        mTvEffectiveDate = (TextView) findViewById(R.id.tv_effective_date);
        mTvEffectiveDate.setOnClickListener(this);
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
            case R.id.close_driver_Font:
                break;
            case R.id.re_driver_pic:

                Intent intent = new Intent(this, CameraActivity.class);
                intent.putExtra(CameraActivity.KEY_OUTPUT_FILE_PATH,
                        FileUtil.getSaveFile(getApplication()).getAbsolutePath());
                intent.putExtra(CameraActivity.KEY_CONTENT_TYPE,
                        CameraActivity.CONTENT_TYPE_GENERAL);
                startActivityForResult(intent, REQUEST_CODE_DRIVING_LICENSE);
                break;
            case R.id.tv_driver2:
                break;
            case R.id.close_driver_reverse:
                break;
            case R.id.re_driver_reverse:
                break;
            case R.id.tv_first_receive:
                onYearMonthDayPicker(DATE_TYPE_START_DATE);
                break;
            case R.id.tv_effective_date:
                onYearMonthDayPicker(DATE_TYPE_END_DATE);
                break;
            case R.id.et_permit_type:
                onOptionPicker();
                break;
            case R.id.tv_start_date:
                onYearMonthDayPicker(DATE_TYPE_FIRST_RECEIVE_DATE);
                break;
            case R.id.et_end_date:
                onYearMonthDayPicker(DATE_TYPE_EFFECTIVE_DATE);
                break;
            case R.id.tv_srue:
                if(StringUtils.isEmpty(idCardFrontPath)){
                    ToastUtils.popUpToast("请选择身份证正面照片");
                }
                if(StringUtils.isEmpty(idCardBackPath)){
                    ToastUtils.popUpToast("请选择身份证反面照片");
                }
                String userName = mEtRealName.getText().toString();
                if(StringUtils.isEmpty(userName)){
                    ToastUtils.popUpToast("姓名不得为空");
                }
                String idCardNum = mEtCardNum.getText().toString();
                if(StringUtils.isEmpty(idCardNum)){
                    ToastUtils.popUpToast("身份证号不得为空");
                }
                String postCardNum = mEtPostCard.getText().toString();
                if(StringUtils.isEmpty(postCardNum)){
                    ToastUtils.popUpToast("上岗证号不得为空");
                }
                String qualificationType = mTvQualificationType.getText().toString();
                if(StringUtils.isEmpty(qualificationType)){
                    ToastUtils.popUpToast("从业资格类别不得为空");
                }
                if(StringUtils.isEmpty(permitType)){
                    ToastUtils.popUpToast("准驾车型不得为空");
                }
                if(StringUtils.isEmpty(startTime)){
                    ToastUtils.popUpToast("开始日期不得为空");
                }
                if(StringUtils.isEmpty(endTime)){
                    ToastUtils.popUpToast("结束日期不得为空");
                }
                if(StringUtils.isEmpty(firstReceiveTime)){
                    ToastUtils.popUpToast("初次领证日期不得为空");
                }
                if(StringUtils.isEmpty(effectiveTime)){
                    ToastUtils.popUpToast("有效起始日期不得为空");
                }
                DriverInfoSubmitParam driverInfoSubmitParam = new DriverInfoSubmitParam();
                driverInfoSubmitParam.setName("川");
                IDCardParam idCardParam = new IDCardParam();
                idCardParam.setIDNo(idCardNum);
                idCardParam.setName(userName);
                driverInfoSubmitParam.setCertificateIDBo(idCardParam);
                CertificateDriverParam certificateDriverParam = new CertificateDriverParam();
                certificateDriverParam.setClasss(permitType);
                certificateDriverParam.setStartTime(startTime);
                driverInfoSubmitParam.setCertificateDriverBo(certificateDriverParam);
                CertificateWorkParam certificateWorkParam = new CertificateWorkParam();
                certificateWorkParam.setFileNumber(postCardNum);
                certificateWorkParam.setCategory(qualificationType);
//                certificateWorkParam.setFirstTime(firstReceiveTime);
//                certificateWorkParam.set
//                mPresenter.
//                startActivity(new Intent(this,MainActivity.class));
                break;
        }
    }

    /**
     * 正面身份证拍照
     */
    private void takeIDCard() {
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
                        mEtRealName.setText(idCardInfoFrontBean.getName().getWords());
                        mEtDetailAddress.setText(idCardInfoFrontBean.getGender().getWords());
                        String number = idCardInfoFrontBean.getIdNumber().getWords();
                        int age = IDCardUtils.IdNOToAge(number);
                        mTvCurrentAddress.setText(String.valueOf(age));
                        mEtCardNum.setText(number);
                        idCardFrontPath = filePath;
                        break;
                    case BACK:
                        idCardBackPath = filePath;
                        break;
                }

            }
        });

    }
    /**
     * 反面身份证扫描
     */
    private void takeIDCardReverse() {
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


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //身份证正面返回
        if (requestCode == REQUEST_CODE_PICK_IMAGE_FRONT && resultCode == Activity.RESULT_OK) {
            Uri uri = data.getData();
            String filePath = getRealPathFromURI(uri);
            recIDCard(IDCardParams.ID_CARD_SIDE_FRONT, filePath);
        }
        //身份证反面返回
        if (requestCode == REQUEST_CODE_PICK_IMAGE_BACK && resultCode == Activity.RESULT_OK) {
            Uri uri = data.getData();
            String filePath = getRealPathFromURI(uri);
            recIDCard(IDCardParams.ID_CARD_SIDE_BACK, filePath);
        }
        //
        if (requestCode == REQUEST_CODE_CAMERA && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                String contentType = data.getStringExtra(CameraActivity.KEY_CONTENT_TYPE);
                String filePath = FileUtil.getSaveFile(getApplicationContext()).getAbsolutePath();
                if (!TextUtils.isEmpty(contentType)) {
                    if (CameraActivity.CONTENT_TYPE_ID_CARD_FRONT.equals(contentType)) {
                        recIDCard(IDCardParams.ID_CARD_SIDE_FRONT, filePath);
                    } else if (CameraActivity.CONTENT_TYPE_ID_CARD_BACK.equals(contentType)) {
                        recIDCard(IDCardParams.ID_CARD_SIDE_BACK, filePath);
                    }
                }
            }
        }
        // 识别成功回调，驾驶证识别
        if (requestCode == REQUEST_CODE_DRIVING_LICENSE && resultCode == Activity.RESULT_OK) {
            RecognizeService.recDrivingLicense(this, FileUtil.getSaveFile(getApplicationContext()).getAbsolutePath(),
                    new RecognizeService.ServiceListener() {
                        @Override
                        public void onResult(String result) {
//                            infoPopText(result);
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
                switch (type){
                    case DATE_TYPE_START_DATE:
                        startTime = year+"年"+month+"月"+day+"日";
                        break;
                    case DATE_TYPE_END_DATE:
                        endTime = year+"年"+month+"月"+day+"日";
                        break;
                    case DATE_TYPE_FIRST_RECEIVE_DATE:
                        firstReceiveTime = year+"年"+month+"月"+day+"日";
                        break;
                    case DATE_TYPE_EFFECTIVE_DATE:
                        effectiveTime = year+"年"+month+"月"+day+"日";
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
//    private boolean checkTokenStatus() {
//        if (!hasGotToken) {
//            Toast.makeText(getApplicationContext(), "token还未成功获取", Toast.LENGTH_LONG).show();
//        }
//        return hasGotToken;
//    }
}
