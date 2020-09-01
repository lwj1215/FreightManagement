package com.example.freightmanagement.Activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

//import com.bumptech.glide.Glide;
import com.bumptech.glide.Glide;
import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.Bean.DriverInformationBean;
import com.example.freightmanagement.Bean.QiYeBean;
import com.example.freightmanagement.Bean.WrodIdBean;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.PrefUtilsData;
import com.example.freightmanagement.enums.AdminTypeEnum;
import com.example.freightmanagement.presenter.DriverInformationPresenter;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class DriverInformationActivity extends BaseActivity<DriverInformationPresenter> implements DriverInformationPresenter.View {

    private TextView name, tv_card, tv_sign_date, tv_sign_fen, et_real_name_qy, et_real_name_cz, et_card_num_cz, et_card_num_qy,
            et_code_qy, et_name_qy, et_jing_qy, tv_chengli_qy, et_fading_qy, et_address_qy, et_permit_type, tv_start_date, et_end_date,et_xuke_qy,
            tv_zheng_jian_you_xiao_qi;
    private ImageView iv_card_front1, iv_card_front2, iv_card_revers_cz, iv_card_front_qy, iv_card_front_cz, iv_card_revers_qy, iv_business_front, iv_driver_front,
            iv_work_front,iv_road_qy;

    @Override
    public int setLayoutResource() {
        if (PrefUtilsData.getType().equals(AdminTypeEnum.DRIVER.getValue())) {
            return R.layout.activity_driver_information;
        } else if (PrefUtilsData.getType().equals(AdminTypeEnum.CAR_OWNER.getValue())) {
            return R.layout.activity_car_owner2;
        } else {
            return R.layout.activity_company_register2;
        }
    }

    @Override
    protected void onInitView() {
        if (PrefUtilsData.getType().equals("1")) {
            setDefaultTitle("驾驶员信息");
        } else if (PrefUtilsData.getType().equals("2")) {
            setDefaultTitle("车主信息");
        } else {
            setDefaultTitle("企业信息");
        }

        name = bindView(R.id.tv_real_name);
        tv_card = bindView(R.id.et_card_num);
        tv_sign_date = bindView(R.id.tv_sign_date);
        tv_sign_fen = bindView(R.id.tv_sign_fen);
        iv_card_front1 = bindView(R.id.iv_card_front);
        iv_card_front2 = bindView(R.id.iv_card_revers);
        iv_card_front_cz = bindView(R.id.iv_card_front_cz);
        iv_card_revers_cz = bindView(R.id.iv_card_revers_cz);
        et_real_name_cz = bindView(R.id.et_real_name_cz);
        et_card_num_cz = bindView(R.id.et_card_num_cz);
        iv_card_front_qy = bindView(R.id.iv_card_front_qy);
        iv_card_revers_qy = bindView(R.id.iv_card_revers_qy);
        et_real_name_qy = bindView(R.id.et_real_name_qy);
        et_card_num_qy = bindView(R.id.et_card_num_qy);
        iv_business_front = bindView(R.id.iv_business_front);
        et_code_qy = bindView(R.id.et_code_qy);
        et_name_qy = bindView(R.id.et_name_qy);
        et_jing_qy = bindView(R.id.et_jing_qy);
        tv_chengli_qy = bindView(R.id.tv_chengli_qy);
        et_fading_qy = bindView(R.id.et_fading_qy);
        et_address_qy = bindView(R.id.et_address_qy);
        iv_driver_front = bindView(R.id.iv_driver_front);
        et_permit_type = bindView(R.id.et_permit_type);
        tv_start_date = bindView(R.id.tv_start_date);
        et_end_date = bindView(R.id.et_end_date);
        iv_work_front = bindView(R.id.iv_work_front);
        iv_road_qy = bindView(R.id.iv_road_qy);
        et_xuke_qy = bindView(R.id.et_xuke_qy);
        tv_zheng_jian_you_xiao_qi = bindView(R.id.tv_zheng_jian_you_xiao_qi);
    }

    @Override
    protected void onLoadData2Remote() {
        if (PrefUtilsData.getType().equals("1")) {
            mPresenter.getPeixunData();
        } else if (PrefUtilsData.getType().equals("2")) {
            mPresenter.getCzData();
        } else {
            mPresenter.getQyData();
        }
//        mPresenter.getPeixun2Data();
    }

    @Override
    protected DriverInformationPresenter onInitLogicImpl() {
        return new DriverInformationPresenter();
    }

    @Override
    public void getWrokIdDataSuc(WrodIdBean data) {
        WrodIdBean.DataBean.CertificateDriverBoBean certificateDriverBo = data.getData().getCertificateDriverBo();
        WrodIdBean.DataBean.CertificateIDBoBean certificateIDBo = data.getData().getCertificateIDBo();
        WrodIdBean.DataBean.CertificateWorkBoBean certificateWorkBo = data.getData().getCertificateWorkBo();
        name.setText(certificateIDBo.getName());
        tv_card.setText(certificateIDBo.getIdno());
        et_permit_type.setText(certificateDriverBo.getClasss() + "");
        tv_start_date.setText(timeStampToDate(certificateDriverBo.getCreateTime()) + "");
        et_end_date.setText(timeStampToDate(certificateDriverBo.getUpdateTime()) + "");

        if (!TextUtils.isEmpty(certificateIDBo.getPicUrl())) {
            Glide.with(getContext()).load(certificateIDBo.getPicUrl()).into(iv_card_front1);
        }
        if (!TextUtils.isEmpty(certificateIDBo.getPicUrl2())) {
            Glide.with(getContext()).load(certificateIDBo.getPicUrl2()).into(iv_card_front2);
        }
        Glide.with(getContext()).load(certificateDriverBo.getPicUrl()).into(iv_driver_front);
        Glide.with(getContext()).load(certificateDriverBo.getPicUrl()).into(iv_work_front);
        Glide.with(getContext()).load(certificateDriverBo.getPicUrl()).into(iv_card_front_qy);
    }

    @Override
    public void getWrokIdData2Suc(DriverInformationBean.DataBean data) {
        tv_sign_date.setText(data.getCreateTime() + "");
        tv_sign_fen.setText(data.getScore() + "");
    }

    @Override
    public void qiyeSuc(QiYeBean.DataBean data) {
        QiYeBean.DataBean.CertificateBusinessBoBean certificateBusinessBo = data.getCertificateBusinessBo();
        QiYeBean.DataBean.CertificateIDBoBean certificateIDBo = data.getCertificateIDBo();
        QiYeBean.DataBean.CertificateOperationBoBean certificateOperationBo = data.getCertificateOperationBo();
        Glide.with(getContext()).load(certificateIDBo.getPicUrl()).into(iv_card_front_qy);
        Glide.with(getContext()).load(certificateIDBo.getPicUrl2()).into(iv_card_revers_qy);
        et_real_name_qy.setText(certificateIDBo.getName()+"");
        et_card_num_qy.setText(certificateIDBo.getCarId()+"");
        Glide.with(getContext()).load(certificateBusinessBo.getPicUrl()).into(iv_business_front);
        et_code_qy.setText(certificateBusinessBo.getId()+"");
        et_name_qy.setText(certificateBusinessBo.getName()+"");
        et_jing_qy.setText(certificateBusinessBo.getScope()+"");
        tv_chengli_qy.setText(timeStampToDate(certificateBusinessBo.getCreateTime())+"");
        et_address_qy.setText(certificateBusinessBo.getRegistrationAuthority()+"");
        Glide.with(getContext()).load(certificateOperationBo.getPicUrl()).into(iv_road_qy);
        et_xuke_qy.setText(certificateOperationBo.getGrantNo() +"");
        tv_zheng_jian_you_xiao_qi.setText(certificateOperationBo.getValidityDate() +"");
    }

    @Override
    public void chezhuSuc() {

    }

    private String timeStampToDate(long tsp, String... format) {
        SimpleDateFormat sdf;
        if (format.length < 1) {
            sdf = new SimpleDateFormat("yyyy年MM月dd日", Locale.getDefault());
        } else {
            sdf = new SimpleDateFormat(format[0], Locale.getDefault());
        }
        return sdf.format(tsp);
    }
}