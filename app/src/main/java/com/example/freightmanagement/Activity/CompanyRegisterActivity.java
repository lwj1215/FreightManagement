package com.example.freightmanagement.Activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
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

import com.baidu.ocr.sdk.OCR;
import com.baidu.ocr.sdk.OnResultListener;
import com.baidu.ocr.sdk.exception.OCRError;
import com.baidu.ocr.sdk.model.IDCardParams;
import com.baidu.ocr.sdk.model.IDCardResult;
import com.baidu.ocr.ui.camera.CameraActivity;
import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.DialogUtils;
import com.example.freightmanagement.Utils.FileUtil;
import com.example.freightmanagement.Utils.IDCardUtils;
import com.example.freightmanagement.Utils.StringUtils;
import com.example.freightmanagement.Utils.ToastUtils;
import com.example.freightmanagement.View.ElectronicSignature;
import com.example.freightmanagement.model.IDCardInfoFrontBean;
import com.example.freightmanagement.model.IDCardParam;
import com.example.freightmanagement.model.company.CertificateBusiness;
import com.example.freightmanagement.model.company.CertificateTransport;
import com.example.freightmanagement.model.company.CompanySubmitParam;
import com.example.freightmanagement.presenter.CompanyRegisterPresenter;
import com.example.freightmanagement.presenter.constract.CompanyRegisterConstact;
import com.google.gson.Gson;

import java.io.File;

import cn.qqtheme.framework.picker.DatePicker;
import cn.qqtheme.framework.util.ConvertUtils;

import static com.example.freightmanagement.Base.BaseApiConstants.IMAGE_BASE_URL;
import static com.example.freightmanagement.common.ImageUploadConstants.UPLOAD_BUSINESS;
import static com.example.freightmanagement.common.ImageUploadConstants.UPLOAD_ID_CARD_BACK;
import static com.example.freightmanagement.common.ImageUploadConstants.UPLOAD_ID_CARD_FRONT;
import static com.example.freightmanagement.common.ImageUploadConstants.UPLOAD_ROAD_TRANSPORT_PERMIT;

/**
 * Created by songdechuan on 2020/8/10.
 */

public class CompanyRegisterActivity extends BaseActivity<CompanyRegisterPresenter> implements CompanyRegisterConstact.View, View.OnClickListener {

    private static final int REQUEST_CODE_PICK_IMAGE_FRONT = 201;
    private static final int REQUEST_CODE_PICK_IMAGE_BACK = 202;
    private static final int REQUEST_CODE_CAMERA = 102;
    private static final int REQUEST_CODE_BUSINESS_LICENSE = 123;

    private final String FRONT = "front";
    private final String BACK = "back";
    private final int TYPE_CHENG_LI = 0;
    private final int TYPE_YOU_XIAO_QI = 1;

    private View mLine;
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
     * 上传身份证正面照片
     */
    private TextView mTvBusiness1;
    private ImageView mIvBusinessFront;
    private ImageView mCloseBusinessFont;
    private RelativeLayout mReBusiness;
    /**
     * 上传身份证反面照片
     */
//    private TextView mTvBusiness;
//    private ImageView mIvBusinessRevers;
//    private ImageView mCloseBusinessReverse;
//    private RelativeLayout mReBusinessReverse;
    /**
     * 电子签名
     */
    private TextView mTvSign;
    private ImageView mIvSign;
    private RelativeLayout mRlSign;
    /**
     * 提交
     */
    private TextView mTvSrue;
    private RelativeLayout mActivityNewDoctorSignProtocol;
    private Dialog bottomDialog;
    private View bottomView;
    private ElectronicSignature vSignView;
    /**
     * 请填写您统一社会信用代码
     */
    private EditText mEtCode;
    /**
     * 请填写您的公司名称
     */
    private EditText mEtName;
    /**
     * 请填写您的法定代表人
     */
    private EditText mEtFading;
    /**
     * 请填写您的经营范围
     */
    private EditText mEtJing;
    /**
     * 请填写您统一社会信用代码
     */
    private TextView mTvChengli;
    /**
     * 请填写您的住所
     */
    private EditText mEtAddress;
    private String idCardFrontUrl = "1";
    private String idCardBackUrl = "2";
    private String businessUrl = "3";
    private String roadTransportPermit = "4";
    /**
     * 请填写您的许可证号
     */
    private EditText mEtXuke;
    /**
     * 请选择您的证件有效期
     */
    private TextView mTvZhengJianYouXiaoQi;

    @Override
    public int setLayoutResource() {
        return R.layout.activity_company_register;
    }

    @Override
    protected void onInitView() {
        initView();

    }

    @Override
    protected void onLoadData2Remote() {

    }

    public void initView() {
        mLine = (View) findViewById(R.id.line);
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
        mTvBusiness1 = (TextView) findViewById(R.id.tv_business1);
        mIvBusinessFront = (ImageView) findViewById(R.id.iv_business_front);
        mCloseBusinessFont = (ImageView) findViewById(R.id.close_business_font);
        mReBusiness = (RelativeLayout) findViewById(R.id.re_business);
        mReBusiness.setOnClickListener(this);
        mTvSign = (TextView) findViewById(R.id.tv_sign);
        mIvSign = (ImageView) findViewById(R.id.iv_sign);
        mIvSign.setOnClickListener(this);
        mRlSign = (RelativeLayout) findViewById(R.id.rl_sign);
        mRlSign.setOnClickListener(this);
        mTvSrue = (TextView) findViewById(R.id.tv_srue);
        mTvSrue.setOnClickListener(this);
        mActivityNewDoctorSignProtocol = (RelativeLayout) findViewById(R.id.activity_new_doctor_sign_protocol);
        bottomView = LayoutInflater.from(this).inflate(R.layout.inflate_pop_item, null);
        bottomView.findViewById(R.id.btn_no).setOnClickListener(this);
        bottomView.findViewById(R.id.btn_yes).setOnClickListener(this);
        vSignView = (ElectronicSignature) bottomView.findViewById(R.id.sign_view);
        mEtCode = (EditText) findViewById(R.id.et_code);
        mEtName = (EditText) findViewById(R.id.et_name);
        mEtFading = (EditText) findViewById(R.id.et_fading);
        mEtJing = (EditText) findViewById(R.id.et_jing);
        mTvChengli = (TextView) findViewById(R.id.tv_chengli);
        mTvChengli.setOnClickListener(this);
        mEtAddress = (EditText) findViewById(R.id.et_address);
        mEtXuke = (EditText) findViewById(R.id.et_xuke);
        mTvZhengJianYouXiaoQi = (TextView) findViewById(R.id.tv_zheng_jian_you_xiao_qi);
        mTvZhengJianYouXiaoQi.setOnClickListener(this);
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
            case R.id.tv_business1:
                break;
            case R.id.tv_chengli:
                onYearMonthDayPicker(TYPE_CHENG_LI);
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
                String mCode = mEtCode.getText().toString();
                if (StringUtils.isEmpty(mCode)) {
                    ToastUtils.popUpToast("信用代码不得为空");
                    return;
                }
                String mName = mEtName.getText().toString();
                if (StringUtils.isEmpty(mName)) {
                    ToastUtils.popUpToast("从业资格类别不得为空");
                    return;
                }
                String mFading = mEtFading.getText().toString();
                if (StringUtils.isEmpty(mFading)) {
                    ToastUtils.popUpToast("法定代表人不得为空");
                    return;
                }
                String mJingYing = mEtJing.getText().toString();
                if (StringUtils.isEmpty(mFading)) {
                    ToastUtils.popUpToast("经营范围不得为空");
                    return;
                }
                String mChengli = mTvChengli.getText().toString();
                if (StringUtils.isEmpty(mChengli)) {
                    ToastUtils.popUpToast("成立日期不得为空");
                    return;
                }
                String mAddress = mEtAddress.getText().toString();
                if (StringUtils.isEmpty(mFading)) {
                    ToastUtils.popUpToast("住所不得为空");
                    return;
                }
                if (StringUtils.isEmpty(businessUrl)) {
                    ToastUtils.popUpToast("营业执照照片不得为空");
                    return;
                }
                if (StringUtils.isEmpty(roadTransportPermit)) {
                    ToastUtils.popUpToast("道路运输许可证不得为空不得为空");
                    return;
                }
                String mXuKe = mEtXuke.getText().toString();
                if (StringUtils.isEmpty(mXuKe)) {
                    ToastUtils.popUpToast("许可证不得为空");
                    return;
                }
                String mYouXiaoQi = mTvZhengJianYouXiaoQi.getText().toString();
                if (StringUtils.isEmpty(mYouXiaoQi)) {
                    ToastUtils.popUpToast("证件有效期不得为空");
                    return;
                }
                CompanySubmitParam submitParam = new CompanySubmitParam();

                IDCardParam idCardParam = new IDCardParam();
                idCardParam.setIDNo(idCardNum);
                idCardParam.setName(userName);
                idCardParam.setPicUrl(idCardFrontUrl);
                idCardParam.setPicUrl2(idCardBackUrl);
                submitParam.setIdBo(idCardParam);

                CertificateBusiness certificateBusiness = new CertificateBusiness();
                certificateBusiness.setName(mName);
                certificateBusiness.setLegalPerson(mFading);
                certificateBusiness.setScope(mJingYing);
                certificateBusiness.setEstablishmentDate(mChengli);
                certificateBusiness.setRegistrationAuthority(mAddress);
                certificateBusiness.setPicUrl(businessUrl);
                submitParam.setCertificateBusinessBo(certificateBusiness);

                CertificateTransport certificateOperation = new CertificateTransport();
                certificateOperation.setGrantNo(mXuKe);
                certificateOperation.setValidityDate(mYouXiaoQi);
                certificateOperation.setPicUrl(roadTransportPermit);
                submitParam.setCertificateOperationBo(certificateOperation);
                mPresenter.submit(submitParam);
                break;
            case R.id.tv_zheng_jian_you_xiao_qi:
                onYearMonthDayPicker(TYPE_YOU_XIAO_QI);

                break;
        }
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
                String time = year + "年" + month + "月" + day + "日";
                switch (type){
                    case TYPE_CHENG_LI:
                        mTvChengli.setText(time);
                        break;
                    case TYPE_YOU_XIAO_QI:
                        mTvZhengJianYouXiaoQi.setText(time);
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

    /**
     * 正面身份证拍照
     */
    private void takeIDCard() {
        Intent intent = new Intent(this, CameraActivity.class);
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
        Intent intent = new Intent(this, CameraActivity.class);
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
        if (requestCode == REQUEST_CODE_PICK_IMAGE_FRONT && resultCode == Activity.RESULT_OK) {
            Uri uri = data.getData();
            String filePath = getRealPathFromURI(uri);
            recIDCard(IDCardParams.ID_CARD_SIDE_FRONT, filePath);
        }

        if (requestCode == REQUEST_CODE_PICK_IMAGE_BACK && resultCode == Activity.RESULT_OK) {
            Uri uri = data.getData();
            String filePath = getRealPathFromURI(uri);
            recIDCard(IDCardParams.ID_CARD_SIDE_BACK, filePath);
        }

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
        // 识别成功回调，营业执照识别
        if (requestCode == REQUEST_CODE_BUSINESS_LICENSE && resultCode == Activity.RESULT_OK) {
            RecognizeService.recBusinessLicense(this, FileUtil.getSaveFile(getApplicationContext()).getAbsolutePath(),
                    new RecognizeService.ServiceListener() {
                        @Override
                        public void onResult(String result) {

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

    @Override
    public void success() {
        ToastUtils.popUpToast("注册成功");
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
            case UPLOAD_BUSINESS:
                businessUrl = IMAGE_BASE_URL + url;
                break;
            case UPLOAD_ROAD_TRANSPORT_PERMIT:
                roadTransportPermit = IMAGE_BASE_URL + url;
                break;
        }
    }
}
