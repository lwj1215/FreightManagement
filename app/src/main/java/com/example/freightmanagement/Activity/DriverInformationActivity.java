package com.example.freightmanagement.Activity;

import android.view.View;
import android.widget.TextView;

import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.Bean.DriverInformationBean;
import com.example.freightmanagement.Bean.WrodIdBean;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.PrefUtilsData;
import com.example.freightmanagement.presenter.DriverInformationPresenter;

public class DriverInformationActivity extends BaseActivity<DriverInformationPresenter> implements DriverInformationPresenter.View {

    private TextView name, age, sex, tv_card, tv_workid, tv_time,tv_sign_date,tv_sign_fen;

    @Override
    public int setLayoutResource() {
        return R.layout.activity_driver_information;
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
        sex = bindView(R.id.tv_detail_sex);
        age = bindView(R.id.tv_age);
        tv_card = bindView(R.id.tv_card);
        tv_workid = bindView(R.id.tv_workid);
        tv_time = bindView(R.id.tv_time);
        tv_sign_date = bindView(R.id.tv_sign_date);
        tv_sign_fen = bindView(R.id.tv_sign_fen);
    }

    @Override
    protected void onLoadData2Remote() {
        mPresenter.getPeixunData();
        mPresenter.getPeixun2Data();
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

        if (PrefUtilsData.getType().equals("1")) {
            name.setText(certificateIDBo.getName());
            if (certificateIDBo.getSix().equals("0")) {
                sex.setText("女");
            } else {
                sex.setText("男");
            }
            age.setText(certificateIDBo.getBirthDay());
            tv_card.setText(certificateIDBo.getIdno());

            tv_workid.setText(certificateWorkBo.getGrantNo());
            tv_time.setText(certificateWorkBo.getCreateTime() + "");
        } else if (PrefUtilsData.getType().equals("2")) {
            name.setText(certificateIDBo.getName());
            if (certificateIDBo.getSix().equals("0")) {
                sex.setText("女");
            } else {
                sex.setText("男");
            }
            age.setText(certificateIDBo.getBirthDay());
            tv_card.setText(certificateIDBo.getIdno());

            tv_workid.setText(certificateWorkBo.getGrantNo());
            tv_time.setText(certificateWorkBo.getCreateTime() + "");
        } else {
            name.setText(certificateIDBo.getName());
            if (certificateIDBo.getSix().equals("0")) {
                sex.setText("女");
            } else {
                sex.setText("男");
            }
            age.setText(certificateIDBo.getBirthDay());
            tv_card.setText(certificateIDBo.getIdno());

            tv_workid.setText(certificateWorkBo.getGrantNo());
            tv_time.setText(certificateWorkBo.getCreateTime() + "");

        }
    }

    @Override
    public void getWrokIdData2Suc(DriverInformationBean.DataBean data) {
        tv_sign_date.setText(data.getCreateTime()+"");
        tv_sign_fen.setText(data.getScore()+"");
    }

}