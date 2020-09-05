package com.example.freightmanagement.Activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baidu.ocr.ui.camera.CameraActivity;
import com.bumptech.glide.Glide;
import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.Base.BaseResponse;
import com.example.freightmanagement.Bean.JiDongBean;
import com.example.freightmanagement.Bean.RoadCardBean;
import com.example.freightmanagement.Bean.VehicleBackBean;
import com.example.freightmanagement.Bean.VehicleBean;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.DatePickerDialog;
import com.example.freightmanagement.Utils.DateUtil;
import com.example.freightmanagement.Utils.FileUtil;
import com.example.freightmanagement.Utils.StringUtil;
import com.example.freightmanagement.Utils.StringUtils;
import com.example.freightmanagement.Utils.ToastUtils;
import com.example.freightmanagement.model.CarBo;
import com.example.freightmanagement.model.CertificateDriving;
import com.example.freightmanagement.model.CertificateRegistration;
import com.example.freightmanagement.model.CertificateTransport;
import com.example.freightmanagement.presenter.CarAddPresenter;
import com.google.gson.Gson;

import java.io.File;
import java.util.Date;
import java.util.List;

import static com.example.freightmanagement.Base.BaseApiConstants.IMAGE_BASE_URL;
import static com.example.freightmanagement.Utils.DateUtil.ymd;
import static com.example.freightmanagement.common.ImageUploadConstants.UPLOAD_JIDONG;
import static com.example.freightmanagement.common.ImageUploadConstants.UPLOAD_ROAD;
import static com.example.freightmanagement.common.ImageUploadConstants.UPLOAD_VEHICLE;
import static com.example.freightmanagement.common.ImageUploadConstants.UPLOAD_VEHICLE_REVERSE;


public class CarAddActivity extends BaseActivity<CarAddPresenter> implements CarAddPresenter.View, View.OnClickListener {
    private static final int REQUEST_CODE_VEHICLE_LICENSE = 120;
    private static final int REQUEST_CODE_VEHICLE_REVERSE_LICENSE = 121;
    private static final int REQUEST_CODE_CARD_ROAD_LICENSE = 122;
    private static final int REQUEST_CODE_CARD_JIDONG_LICENSE = 123;
    private static final String TEMPLATE_ROAD_SIGN = "7687cab0e4a577476de317601f418ef5";
    private static final String TEMPLATE_JIDONG_SIGN = "bb46a6619810e8240a80560b0c77068f";
    private static final String FRONT = "front";
    private static final String BACK = "back";

    private TextView mTvCard1;
    private ImageView mIvCardFront;
    private ImageView mCloseImageViewFont;
    private RelativeLayout mRePic;
    private EditText mEtCarNum;
    private EditText mEtCarType;
    private EditText mEtXingZhi;
    private LinearLayout mLlCurrentAddress;
    private EditText mEtBrandXingHao;
    private TextView mTvDateZhuce;
    private TextView mTvDateSend;
    private EditText mEtDangAn;
    private EditText mEtZongZhi;
    private EditText mEtHeDing;
    private TextView mTvCardYunShu;
    private ImageView mIvCardYunShu;
    private ImageView mCloseYunShu;
    private RelativeLayout mReYunShuPic;
    private EditText mEtYunYingNum;
    private EditText mEtYeHuName;
    private EditText mEtJingYingNum;
    private EditText mEtYunYingFanWei;
    private TextView mTvCardJiDong;
    private ImageView mIvCardJiDong;
    private ImageView mCloseJiDong;
    private EditText mEtOwner;
    private EditText mEtJiGuan;
    private TextView mTvDengJiDate;
    private EditText mEtDengJiNum;
    private EditText mEtDengJiCarType;
    private EditText mEtDengJiCarBrand;
    private EditText mEtDengJiCarModel;
    private EditText mEtDengJiCarCode;
    private EditText mEtDengJiCarEngine;
    private EditText mEtDengJiRanLiao;
    private EditText mEtDengJiPaiLiang;
    private EditText mEtDengJiBuildName;
    private EditText mEtDengJiTires;
    private EditText mEtDengJiChang;
    private EditText mEtDengJiKuan;
    private EditText mEtDengJiGao;
    private EditText mEtDengJiQianYin;
    private EditText mEtDengJiJiaShiShi;
    private EditText mEtDengJiUseXingZhi;
    private TextView mEtDengJiSendDate;
    private TextView mTvSign;
    private ImageView mIvSign;
    private RelativeLayout mRlSign;
    private TextView mTvSrue;
    private RelativeLayout mReJiDongPic;
    private String xingshiPath;
    private String yunshuPath;
    private String jidongPath;
    private String vehicleUrl;
    private String roadUrl;
    private String jidongUrl;
    private TextView mTvCard2;
    private ImageView mIvCardRevers;
    private ImageView mCloseImageViewReverse;
    private RelativeLayout mRePicReverse;
    private String xingshiReversePath;
    private String vehicleReverseUrl;
    private EditText mEtCheliangNum;
    private TextView mTvSendDate;
    private Dialog dateDialog;
    private String zhuceTime;
    private String xsSendTime;
    private String roadSendTime;
    private String djTime;
    private String jdSendTime;
    private String nowDate;

    @Override
    public int setLayoutResource() {
        return R.layout.activity_car_add;

    }

    @Override
    protected void onInitView() {
        setDefaultTitle("添加车辆");
        mTvCard1 = findViewById(R.id.tv_card1);
        mIvCardFront = findViewById(R.id.iv_card_front);
        mCloseImageViewFont = findViewById(R.id.closeImageViewFont);
        mRePic = findViewById(R.id.re_pic);
        mRePic.setOnClickListener(this);
        mEtCarNum = findViewById(R.id.et_car_num);
        mEtCarType = findViewById(R.id.et_car_type);
        mEtXingZhi = findViewById(R.id.et_xing_zhi);
        mLlCurrentAddress = findViewById(R.id.ll_current_address);
        mEtBrandXingHao = findViewById(R.id.et_brand_xing_hao);
        mTvDateZhuce = findViewById(R.id.tv_date_zhuce);
        mTvDateZhuce.setOnClickListener(this);
        mTvDateSend = findViewById(R.id.tv_date_send);
        mTvDateSend.setOnClickListener(this);
        mEtDangAn = findViewById(R.id.et_dang_an);
        mEtZongZhi = findViewById(R.id.et_zong_zhi);
        mEtHeDing = findViewById(R.id.et_he_ding);
        mTvCardYunShu = findViewById(R.id.tv_card_yun_shu);
        mIvCardYunShu = findViewById(R.id.iv_card_yun_shu);
        mCloseYunShu = findViewById(R.id.close_yun_shu);
        mReYunShuPic = findViewById(R.id.re_yun_shu_pic);
        mReYunShuPic.setOnClickListener(this);
        mEtYunYingNum = findViewById(R.id.et_yun_ying_num);
        mEtYeHuName = findViewById(R.id.et_ye_hu_name);
        mEtJingYingNum = findViewById(R.id.et_jing_ying_num);
        mEtYunYingFanWei = findViewById(R.id.et_yun_ying_fan_wei);
        mTvCardJiDong = findViewById(R.id.tv_card_ji_dong);
        mIvCardJiDong = findViewById(R.id.iv_card_ji_dong);
        mCloseJiDong = findViewById(R.id.close_ji_dong);
        mReJiDongPic = findViewById(R.id.re_ji_dong_pic);
        mReJiDongPic.setOnClickListener(this);
        mEtOwner = findViewById(R.id.et_owner);
        mEtJiGuan = findViewById(R.id.et_ji_guan);
        mTvDengJiDate = findViewById(R.id.tv_deng_ji_date);
        mTvDengJiDate.setOnClickListener(this);
        mEtDengJiNum = findViewById(R.id.et_deng_ji_num);
        mEtDengJiCarType = findViewById(R.id.et_deng_ji_car_type);
        mEtDengJiCarBrand = findViewById(R.id.et_deng_ji_car_brand);
        mEtDengJiCarModel = findViewById(R.id.et_deng_ji_car_model);
        mEtDengJiCarCode = findViewById(R.id.et_deng_ji_car_code);
        mEtDengJiCarEngine = findViewById(R.id.et_deng_ji_car_engine);
        mEtDengJiRanLiao = findViewById(R.id.et_deng_ji_ran_liao);
        mEtDengJiPaiLiang = findViewById(R.id.et_deng_ji_pai_liang);
        mEtDengJiBuildName = findViewById(R.id.et_deng_ji_build_name);
        mEtDengJiTires = findViewById(R.id.et_deng_ji_tires);
        mEtDengJiChang = findViewById(R.id.et_deng_ji_chang);
        mEtDengJiKuan = findViewById(R.id.et_deng_ji_kuan);
        mEtDengJiGao = findViewById(R.id.et_deng_ji_gao);
        mEtDengJiQianYin = findViewById(R.id.et_deng_ji_qian_yin);
        mEtDengJiJiaShiShi = findViewById(R.id.et_deng_ji_jia_shi_shi);
        mEtDengJiUseXingZhi = findViewById(R.id.et_deng_ji_use_xing_zhi);
        mEtDengJiSendDate = findViewById(R.id.et_deng_ji_send_date);
        mEtDengJiSendDate.setOnClickListener(this);
        mTvSign = findViewById(R.id.tv_sign);
        mIvSign = findViewById(R.id.iv_sign);
        mRlSign = findViewById(R.id.rl_sign);
        mTvSrue = findViewById(R.id.tv_srue);
        mTvSrue.setOnClickListener(this);
        mTvCard2 = findViewById(R.id.tv_card2);
        mIvCardRevers = findViewById(R.id.iv_card_revers);
        mCloseImageViewReverse = findViewById(R.id.closeImageViewReverse);
        mRePicReverse = findViewById(R.id.re_pic_reverse);
        mRePicReverse.setOnClickListener(this);
        mEtCheliangNum = findViewById(R.id.et_cheliang_num);
        mTvSendDate = findViewById(R.id.tv_send_date);
        mTvSendDate.setOnClickListener(this);
    }

    @Override
    protected void onLoadData2Remote() {
        Date date = new Date();
        nowDate = DateUtil.date2String(date,ymd);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.re_pic:
                taskXingshiPhoto();
                break;
            case R.id.re_pic_reverse:
                taskXingshiReversePhoto();
                break;
            case R.id.tv_date_zhuce:
                showDateDialog(DateUtil.getDateForString(nowDate),0);
                break;
            case R.id.tv_date_send:
                showDateDialog(DateUtil.getDateForString(nowDate),1);
                break;
            case R.id.tv_send_date:
                showDateDialog(DateUtil.getDateForString(nowDate),2);
                break;
            case R.id.re_yun_shu_pic:
                taskYunShuPhoto();
                break;
            case R.id.re_ji_dong_pic:
                taskJidongPhoto();
                break;
            case R.id.tv_deng_ji_date:
                showDateDialog(DateUtil.getDateForString(nowDate),3);
                break;
            case R.id.et_deng_ji_send_date:
                showDateDialog(DateUtil.getDateForString(nowDate),4);
                break;
            case R.id.tv_srue:
                uploadToast();
                CarBo carBo = new CarBo();
                CertificateDriving certificateDriving = new CertificateDriving();
                certificateDriving.setPicUrl(vehicleUrl);
                certificateDriving.setPlateNo(mEtCarNum.getText().toString());
                certificateDriving.setWchicheType(mEtCarType.getText().toString());
                certificateDriving.setUseCharacter(mEtXingZhi.getText().toString());
                certificateDriving.setModel(mEtBrandXingHao.getText().toString());
                String zhuceStr = mTvDateZhuce.getText().toString();
                if(!DateUtil.isValidDate(zhuceStr)){
                    ToastUtils.popUpToast("注册日期错误，请重新选择");
                    return;
                }
                certificateDriving.setRegistrationDate(zhuceStr);
                String issueDate = mTvDateSend.getText().toString();
                if(!DateUtil.isValidDate(issueDate)){
                    ToastUtils.popUpToast("行驶证发证日期错误，请重新选择");
                    return;
                }
                certificateDriving.setIssueDate(issueDate);
                certificateDriving.setFileNo(mEtDangAn.getText().toString());
                certificateDriving.setAllWeight(mEtZongZhi.getText().toString());
                certificateDriving.setApprovedWeight(mEtHeDing.getText().toString());
                CertificateTransport certificateTransport = new CertificateTransport();
                certificateTransport.setPlateNo(mEtYunYingNum.getText().toString());
                certificateTransport.setPicUrl(roadUrl);
                certificateTransport.setName(mEtYeHuName.getText().toString());
                certificateTransport.setScope(mEtYunYingFanWei.getText().toString());
                certificateTransport.setGrantDate(mTvSendDate.getText().toString());

                CertificateRegistration certificateRegistration = new CertificateRegistration();
                certificateRegistration.setPicUrl(jidongUrl);
                certificateRegistration.setOwner(mEtOwner.getText().toString());
                certificateRegistration.setCarType(mEtDengJiCarType.getText().toString());
                certificateRegistration.setCarBrand(mEtDengJiCarBrand.getText().toString());
                certificateRegistration.setCarModel(mEtDengJiCarModel.getText().toString());
                certificateRegistration.setCarNo(mEtDengJiCarBrand.getText().toString());
                certificateRegistration.setEngineNo(mEtDengJiCarEngine.getText().toString());
                certificateRegistration.setFuelType(mEtDengJiRanLiao.getText().toString());
                certificateRegistration.setPower(mEtDengJiPaiLiang.getText().toString());
                certificateRegistration.setDisplacement(mEtDengJiPaiLiang.getText().toString());
                certificateRegistration.setMaker(mEtDengJiBuildName.getText().toString());
                certificateRegistration.setTireCount(mEtDengJiTires.getText().toString());
                certificateRegistration.setUseNature(mEtDengJiUseXingZhi.getText().toString());
                certificateRegistration.setIssueDate(mEtDengJiSendDate.getText().toString());
                certificateRegistration.setPassengersCount(mEtDengJiJiaShiShi.getText().toString());
                carBo.setCertificateDrivingBo(certificateDriving);
                carBo.setCertificateRegistrationBo(certificateRegistration);
                carBo.setCertificateTransportBo(certificateTransport);
                mPresenter.submit(carBo);
                break;
        }
    }
    /**
     * 选择生日
     */
    private void showDateDialog(List<Integer> date, final int type) {
        DatePickerDialog.Builder builder = new DatePickerDialog.Builder(this);
        builder.setOnDateSelectedListener(new DatePickerDialog.OnDateSelectedListener() {
            @Override
            public void onDateSelected(int[] dates) {
                switch (type){
                    case 0:
                        zhuceTime = dates[0] + "-" + (dates[1] > 9 ? dates[1] : ("0" + dates[1])) + "-"
                                + (dates[2] > 9 ? dates[2] : ("0" + dates[2]));
                        mTvDateZhuce.setText(zhuceTime);
                        break;
                    case 1:
                        xsSendTime = dates[0] + "-" + (dates[1] > 9 ? dates[1] : ("0" + dates[1])) + "-"
                                + (dates[2] > 9 ? dates[2] : ("0" + dates[2]));
                        mTvDateSend.setText(xsSendTime);
                        break;
                    case 2:
                        roadSendTime = dates[0] + "-" + (dates[1] > 9 ? dates[1] : ("0" + dates[1])) + "-"
                                + (dates[2] > 9 ? dates[2] : ("0" + dates[2]));
                        mTvSendDate.setText(roadSendTime);
                        break;
                    case 3:
                        djTime = dates[0] + "-" + (dates[1] > 9 ? dates[1] : ("0" + dates[1])) + "-"
                                + (dates[2] > 9 ? dates[2] : ("0" + dates[2]));
                        mTvDengJiDate.setText(djTime);
                        break;
                    case 4:
                        jdSendTime = dates[0] + "-" + (dates[1] > 9 ? dates[1] : ("0" + dates[1])) + "-"
                                + (dates[2] > 9 ? dates[2] : ("0" + dates[2]));
                        mEtDengJiSendDate.setText(jdSendTime);
                        break;
                }
            }

            @Override
            public void onCancel() {
            }
        })
                .setSelectYear(date.get(0) - 1)
                .setSelectMonth(date.get(1) - 1)
                .setSelectDay(date.get(2) - 1);

        builder.setMaxYear(DateUtil.getYear());
        builder.setMaxMonth(DateUtil.getDateForString(DateUtil.getToday()).get(1));
        builder.setMaxDay(DateUtil.getDateForString(DateUtil.getToday()).get(2));
        dateDialog = builder.create();
        dateDialog.show();
    }
    private void uploadToast() {
        /**
         * 行驶证
         */
        if(StringUtil.isEmpty(vehicleUrl)){
            ToastUtils.popUpToast("行驶证正页照片不得为空");
            return;
        }
        if(StringUtil.isEmpty(vehicleReverseUrl)){
            ToastUtils.popUpToast("行驶证正页照片不得为空");
            return;
        }
        if(StringUtil.isEmpty(mEtCarNum.getText().toString())){
            ToastUtils.popUpToast("号牌号码不得为空");
            return;
        }
        if(StringUtil.isEmpty(mEtCarType.getText().toString())){
            ToastUtils.popUpToast("车辆类型不得为空");
            return;
        }
        if(StringUtil.isEmpty(mEtXingZhi.getText().toString())){
            ToastUtils.popUpToast("使用性质不得为空");
            return;
        }
        if(StringUtil.isEmpty(mEtBrandXingHao.getText().toString())){
            ToastUtils.popUpToast("品牌型号不得为空");
            return;
        }
        if(StringUtil.isEmpty(mTvDateZhuce.getText().toString())){
            ToastUtils.popUpToast("行驶证注册日期不得为空");
            return;
        }
        if(StringUtil.isEmpty(mTvDateSend.getText().toString())){
            ToastUtils.popUpToast("行驶证发证日期不得为空");
            return;
        }
        if(StringUtil.isEmpty(mEtDangAn.getText().toString())){
            ToastUtils.popUpToast("档案编号不得为空");
            return;
        }
        if(StringUtil.isEmpty(mEtZongZhi.getText().toString())){
            ToastUtils.popUpToast("总质量不得为空");
            return;
        }
        if(StringUtil.isEmpty(mEtHeDing.getText().toString())){
            ToastUtils.popUpToast("核定载质量不得为空");
            return;
        }
        /**
         * 道路运输证
         */
        if(StringUtil.isEmpty(roadUrl)){
            ToastUtils.popUpToast("请上传道路运输证照片");
            return;
        }
        if(StringUtil.isEmpty(mEtYunYingNum.getText().toString())){
            ToastUtils.popUpToast("运营号不得为空");
            return;
        }
        if(StringUtil.isEmpty(mEtYeHuName.getText().toString())){
            ToastUtils.popUpToast("业户名称不得为空");
            return;
        }
        if(StringUtil.isEmpty(mEtCheliangNum.getText().toString())){
            ToastUtils.popUpToast("道路运输证车牌号码不得为空");
            return;
        }
        if(StringUtil.isEmpty(mEtJingYingNum.getText().toString())){
            ToastUtils.popUpToast("经营许可证号不得为空");
            return;
        }
        if(StringUtil.isEmpty(mEtYunYingFanWei.getText().toString())){
            ToastUtils.popUpToast("经营范围不得为空");
            return;
        }
        if(StringUtil.isEmpty(mTvSendDate.getText().toString())){
            ToastUtils.popUpToast("道路运输证发证日期不得为空");
            return;
        }
        if(StringUtil.isEmpty(mEtHeDing.getText().toString())){
            ToastUtils.popUpToast("核定载质量不得为空");
            return;
        }
        /**
         * 机动车登记证书
         */
        if(StringUtil.isEmpty(jidongUrl)){
            ToastUtils.popUpToast("请上传机动车登记证书照片");
            return;
        }
        if(StringUtil.isEmpty(mEtJiGuan.getText().toString())){
            ToastUtils.popUpToast("请填写您的登记机关");
            return;
        }
        if(StringUtil.isEmpty(mTvDengJiDate.getText().toString())){
            ToastUtils.popUpToast("请选择机动车登记日期");
            return;
        }
        if(StringUtil.isEmpty(mEtDengJiNum.getText().toString())){
            ToastUtils.popUpToast("请填写您的登记编号");
            return;
        }
        if(StringUtil.isEmpty(mEtDengJiCarType.getText().toString())){
            ToastUtils.popUpToast("请填写您的机动车车辆类型");
            return;
        }
        if(StringUtil.isEmpty(mEtDengJiCarBrand.getText().toString())){
            ToastUtils.popUpToast("请填写您的机动车车辆品牌");
            return;
        }
        if(StringUtil.isEmpty(mEtDengJiCarModel.getText().toString())){
            ToastUtils.popUpToast("请填写您的机动车车辆型号");
            return;
        }
        if(StringUtil.isEmpty(mEtDengJiCarEngine.getText().toString())){
            ToastUtils.popUpToast("请填写您的机动车发动机号");
            return;
        }
        if(StringUtil.isEmpty(mEtDengJiRanLiao.getText().toString())){
            ToastUtils.popUpToast("请填写您的机动车燃料种类");
            return;
        }
        if(StringUtil.isEmpty(mEtDengJiPaiLiang.getText().toString())){
            ToastUtils.popUpToast("请填写您的机动车排量/功率");
            return;
        }
        if(StringUtil.isEmpty(mEtDengJiBuildName.getText().toString())){
            ToastUtils.popUpToast("请填写您的机动车制造厂名称");
            return;
        }
        if(StringUtil.isEmpty(mEtDengJiTires.getText().toString())){
            ToastUtils.popUpToast("请填写您的机动车轮胎数");
            return;
        }
        if(StringUtil.isEmpty(mEtDengJiChang.getText().toString()) ||
                StringUtil.isEmpty(mEtDengJiKuan.getText().toString())||
                 StringUtil.isEmpty(mEtDengJiGao.getText().toString())){
            ToastUtils.popUpToast("请填写您的机动车长/宽/高");
            return;
        }
        if(StringUtil.isEmpty(mEtDengJiQianYin.getText().toString())){
            ToastUtils.popUpToast("请填写您的机动车准牵引总质量");
            return;
        }
        if(StringUtil.isEmpty(mEtDengJiJiaShiShi.getText().toString())){
            ToastUtils.popUpToast("请填写您的机动车驾驶室载客数");
            return;
        }
        if(StringUtil.isEmpty(mEtDengJiUseXingZhi.getText().toString())){
            ToastUtils.popUpToast("请填写您的机动车使用性质");
            return;
        }
//        if(StringUtil.isEmpty(mEtDengJiSendDate.getText().toString())){
//            ToastUtils.popUpToast("请填写您的机动车发证日期");
//            return;
//        }
    }

    /**
     * 行驶证正页调用相机
     */
    private void taskXingshiPhoto() {
        xingshiPath = "xingshi_" + System.currentTimeMillis();
        Intent intent = new Intent(this, CameraActivity.class);
        intent.putExtra(CameraActivity.KEY_OUTPUT_FILE_PATH,
                FileUtil.getSaveFile(getApplication(), xingshiPath).getAbsolutePath());
        intent.putExtra(CameraActivity.KEY_CONTENT_TYPE,
                CameraActivity.CONTENT_TYPE_GENERAL);
        startActivityForResult(intent, REQUEST_CODE_VEHICLE_LICENSE);

    }

    /**
     * 行驶证副页
     */
    private void taskXingshiReversePhoto() {
        xingshiReversePath = "xingshi_" + System.currentTimeMillis();
        Intent intent = new Intent(this, CameraActivity.class);
        intent.putExtra(CameraActivity.KEY_OUTPUT_FILE_PATH,
                FileUtil.getSaveFile(getApplication(), xingshiReversePath).getAbsolutePath());
        intent.putExtra(CameraActivity.KEY_CONTENT_TYPE,
                CameraActivity.CONTENT_TYPE_GENERAL);
        startActivityForResult(intent, REQUEST_CODE_VEHICLE_REVERSE_LICENSE);
    }

    /**
     * 机动车登记证
     */
    private void taskJidongPhoto() {
        jidongPath = "jidong_" + System.currentTimeMillis();
        Intent intent = new Intent(this, CameraActivity.class);
        intent.putExtra(CameraActivity.KEY_OUTPUT_FILE_PATH,
                FileUtil.getSaveFile(getApplication(), jidongPath).getAbsolutePath());
        intent.putExtra(CameraActivity.KEY_CONTENT_TYPE,
                CameraActivity.CONTENT_TYPE_GENERAL);
        startActivityForResult(intent, REQUEST_CODE_CARD_JIDONG_LICENSE);
    }

    /**
     * 运输证调用相机
     */
    private void taskYunShuPhoto() {
        yunshuPath = "yunshu_" + System.currentTimeMillis();
        Intent intent = new Intent(this, CameraActivity.class);
        intent.putExtra(CameraActivity.KEY_OUTPUT_FILE_PATH,
                FileUtil.getSaveFile(getApplication(), yunshuPath).getAbsolutePath());
        intent.putExtra(CameraActivity.KEY_CONTENT_TYPE,
                CameraActivity.CONTENT_TYPE_GENERAL);
        startActivityForResult(intent, REQUEST_CODE_CARD_ROAD_LICENSE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 识别成功回调，行驶证识别
        if (requestCode == REQUEST_CODE_VEHICLE_LICENSE && resultCode == Activity.RESULT_OK) {
            final String filePath = FileUtil.getSaveFile(getApplicationContext(), xingshiPath).getAbsolutePath();
            RecognizeService.recVehicleLicense(this, filePath, FRONT,
                    new RecognizeService.ServiceListener() {
                        @Override
                        public void onResult(String result) {
                            ToastUtils.popUpToast("此识别结果仅供参考，请仔细比对检查");
                            boolean json = StringUtils.isJson(result);
                            if(!json){
                                ToastUtils.popUpToast("识别错误，请重新上传");
                                return;
                            }
                            VehicleBean vehicleBean = new Gson().fromJson(result, VehicleBean.class);
                            if (vehicleBean == null) {
                                ToastUtils.popUpToast("识别错误，请重新上传");
                                return;
                            }
                            VehicleBean.WordsResultBean words_result = vehicleBean.getWords_result();
                            if (words_result == null) {
                                ToastUtils.popUpToast("识别错误，请重新上传");
                                return;
                            }
                            VehicleBean.WordsResultBean.号牌号码Bean 号牌号码 = words_result.get号牌号码();
                            VehicleBean.WordsResultBean.车辆类型Bean 车辆类型 = words_result.get车辆类型();
                            VehicleBean.WordsResultBean.使用性质Bean 使用性质 = words_result.get使用性质();
                            VehicleBean.WordsResultBean.品牌型号Bean 品牌型号 = words_result.get品牌型号();
                            VehicleBean.WordsResultBean.注册日期Bean 注册日期 = words_result.get注册日期();
                            VehicleBean.WordsResultBean.发证日期Bean 发证日期 = words_result.get发证日期();
                            mEtCarNum.setText(号牌号码.getWords());
                            mEtCarType.setText(车辆类型.getWords());
                            mEtXingZhi.setText(使用性质.getWords());
                            mEtBrandXingHao.setText(品牌型号.getWords());
                            mTvDateZhuce.setText(注册日期.getWords());
                            mTvDateSend.setText(发证日期.getWords());
                            mIvCardFront.setVisibility(View.VISIBLE);
                            mTvCard1.setVisibility(View.GONE);
                            Glide.with(getContext()).load(filePath).into(mIvCardFront);
                            mPresenter.upload(new File(filePath), UPLOAD_VEHICLE);
                        }
                    });
        }
        // 识别成功回调，行驶证副页识别
        if (requestCode == REQUEST_CODE_VEHICLE_REVERSE_LICENSE && resultCode == Activity.RESULT_OK) {
            final String filePath = FileUtil.getSaveFile(getApplicationContext(), xingshiReversePath).getAbsolutePath();
            RecognizeService.recVehicleLicense(this, filePath, BACK,
                    new RecognizeService.ServiceListener() {
                        @Override
                        public void onResult(String result) {
                            ToastUtils.popUpToast("此识别结果仅供参考，请仔细比对检查");
                            boolean json = StringUtils.isJson(result);
                            if(!json){
                                ToastUtils.popUpToast("识别错误，请重新上传");
                                return;
                            }
                            VehicleBackBean vehicleBackBean = new Gson().fromJson(result, VehicleBackBean.class);
                            if (vehicleBackBean == null) {
                                ToastUtils.popUpToast("识别错误，请重新上传");
                                return;
                            }
                            VehicleBackBean.WordsResultBean words_result = vehicleBackBean.getWords_result();
                            VehicleBackBean.WordsResultBean.档案编号Bean 档案编号 = words_result.get档案编号();
                            VehicleBackBean.WordsResultBean.总质量Bean 总质量 = words_result.get总质量();
                            VehicleBackBean.WordsResultBean.核定载质量Bean 核定载质量 = words_result.get核定载质量();
                            mEtDangAn.setText(档案编号.getWords());
                            mEtZongZhi.setText(总质量.getWords());
                            mEtHeDing.setText(核定载质量.getWords());
                            mIvCardRevers.setVisibility(View.VISIBLE);
                            mTvCard2.setVisibility(View.GONE);
                            Glide.with(getContext()).load(filePath).into(mIvCardRevers);
                            mPresenter.upload(new File(filePath), UPLOAD_VEHICLE_REVERSE);
                        }
                    });
        }
        // 识别成功回调，道路运输证识别
        if (requestCode == REQUEST_CODE_CARD_ROAD_LICENSE && resultCode == Activity.RESULT_OK) {
            final String filePath = FileUtil.getSaveFile(getApplicationContext(), yunshuPath).getAbsolutePath();
            RecognizeService.recCustom(this, filePath, TEMPLATE_ROAD_SIGN, 0,
                    new RecognizeService.ServiceListener() {
                        @Override
                        public void onResult(String result) {
                            ToastUtils.popUpToast("此识别结果仅供参考，请仔细比对检查");
                            Glide.with(getContext()).load(filePath).into(mIvCardYunShu);
                            mIvCardYunShu.setVisibility(View.VISIBLE);
                            mTvCardYunShu.setVisibility(View.GONE);

                            mPresenter.upload(new File(filePath), UPLOAD_ROAD);
                            boolean json = StringUtils.isJson(result);
                            if(!json){
                                ToastUtils.popUpToast("识别错误，请重新上传");
                                return;
                            }
                            RoadCardBean roadCardBean = new Gson().fromJson(result, RoadCardBean.class);
                            if (roadCardBean == null) {
                                ToastUtils.popUpToast("识别错误，请重新上传");
                                return;
                            }
                            RoadCardBean.DataBean roadCardBeanData = roadCardBean.getData();
                            if (roadCardBeanData == null) {
                                ToastUtils.popUpToast("识别错误，请重新上传");
                                return;
                            }
                            List<RoadCardBean.DataBean.RetBean> ret = roadCardBeanData.getRet();
                            for (RoadCardBean.DataBean.RetBean retBean : ret) {
                                String word_name = retBean.getWord_name();
                                String word = retBean.getWord();
                                if (word_name.equals("number")) {
                                    mEtYunYingNum.setText(word);
                                }
                                if (word_name.equals("name")) {
                                    mEtYeHuName.setText(word);
                                }
                                if (word_name.equals("vehicle_number")) {
                                    mEtCarNum.setText(word);
                                }
                                if (word_name.equals("经营许可证号")) {
                                    mEtJingYingNum.setText(word);
                                }
                                if (word_name.equals("business_scope")) {
                                    mEtYunYingFanWei.setText(word);
                                }
                                if (word_name.equals("sendTime")) {
                                    mTvSendDate.setText(word);
                                }
                            }

                        }
                    });
        }
        // 识别成功回调，机动车登记证识别
        if (requestCode == REQUEST_CODE_CARD_JIDONG_LICENSE && resultCode == Activity.RESULT_OK) {
            final String filePath = FileUtil.getSaveFile(getApplicationContext(), jidongPath).getAbsolutePath();

            RecognizeService.recCustom(this, filePath, TEMPLATE_JIDONG_SIGN, 0,
                    new RecognizeService.ServiceListener() {
                        @Override
                        public void onResult(String result) {
                            ToastUtils.popUpToast("此识别结果仅供参考，请仔细比对检查");
                            boolean json = StringUtils.isJson(result);
                            if(!json){
                                ToastUtils.popUpToast("识别错误，请重新上传");
                                return;
                            }
                            JiDongBean jiDongBean = new Gson().fromJson(result, JiDongBean.class);
                            if (jiDongBean == null) {
                                ToastUtils.popUpToast("识别错误，请重新上传");
                                return;
                            }
                            JiDongBean.DataBean jiDongBeanData = jiDongBean.getData();
                            if (jiDongBeanData == null) {
                                ToastUtils.popUpToast("识别错误，请重新上传");
                                return;
                            }
                            List<JiDongBean.DataBean.RetBean> ret = jiDongBeanData.getRet();
                            for (JiDongBean.DataBean.RetBean retBean : ret) {
                                String word_name = retBean.getWord_name();
                                String word = retBean.getWord();
                                if (word_name.equals("owner")) {
                                    mEtOwner.setText(word);
                                }
                                if (word_name.equals("登记机关")) {
                                    mEtJiGuan.setText(word);
                                }
                                if (word_name.equals("登记日期")) {
                                    mTvDengJiDate.setText(word);
                                }
                                if (word_name.equals("登记编号")) {
                                    mEtDengJiNum.setText(word);
                                }
                                if (word_name.equals("车辆类型")) {
                                    mEtDengJiCarType.setText(word);
                                }
                                if (word_name.equals("车辆品牌")) {
                                    mEtDengJiCarBrand.setText(word);
                                }
                                if (word_name.equals("车辆型号")) {
                                    mEtDengJiCarModel.setText(word);
                                }

                                if (word_name.equals("车架号")) {
                                    mEtDengJiCarCode.setText(word);
                                }
                                if (word_name.equals("发动机号")) {
                                    mEtDengJiCarEngine.setText(word);
                                }
                                if (word_name.equals("燃料种类")) {
                                    mEtDengJiRanLiao.setText(word);
                                }
                                if (word_name.equals("排量功率")) {
                                    mEtDengJiPaiLiang.setText(word);
                                }

                                if (word_name.equals("制造厂名称")) {
                                    mEtDengJiBuildName.setText(word);
                                }
                                if (word_name.equals("长")) {
                                    mEtDengJiChang.setText(word);
                                }
                                if (word_name.equals("宽")) {
                                    mEtDengJiKuan.setText(word);
                                }
                                if (word_name.equals("高")) {
                                    mEtDengJiGao.setText(word);
                                }

                                if (word_name.equals("准牵引总质量")) {
                                    mEtDengJiQianYin.setText(word);
                                }
                                if (word_name.equals("驾驶室载客")) {
                                    mEtDengJiJiaShiShi.setText(word);
                                }
                                if (word_name.equals("使用性质")) {
                                    mEtDengJiUseXingZhi.setText(word);
                                }
                                if (word_name.equals("发证日期")) {
                                    mTvDengJiDate.setText(word);
                                }
                            }
                            mIvCardJiDong.setVisibility(View.VISIBLE);
                            mTvCardJiDong.setVisibility(View.GONE);
                            Glide.with(getContext()).load(filePath).into(mIvCardJiDong);
                            mPresenter.upload(new File(filePath), UPLOAD_JIDONG);
                        }
                    });
        }
    }

    @Override
    protected CarAddPresenter onInitLogicImpl() {
        return new CarAddPresenter();
    }

    @Override
    public void imageUrl(String url, int type) {
        switch (type) {
            case UPLOAD_VEHICLE:
                vehicleUrl = IMAGE_BASE_URL + url;
                break;
            case UPLOAD_VEHICLE_REVERSE:
                vehicleReverseUrl = IMAGE_BASE_URL + url;
                break;
            case UPLOAD_ROAD:
                roadUrl = IMAGE_BASE_URL + url;
                break;
            case UPLOAD_JIDONG:
                jidongUrl = IMAGE_BASE_URL + url;
                break;

        }
    }

    @Override
    public void submitResult(String msg) {
        BaseResponse response = new Gson().fromJson(msg,BaseResponse.class);
        if(response.getCode() == 0){
            ToastUtils.popUpToast("提交成功");
            Intent intent = new Intent(this, CarListManageActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
