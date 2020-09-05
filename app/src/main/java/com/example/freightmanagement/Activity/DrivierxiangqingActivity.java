package com.example.freightmanagement.Activity;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.Base.BaseApiConstants;
import com.example.freightmanagement.Bean.WrodIdBean;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.Network.OnRequestResultForCommon;
import com.example.freightmanagement.Utils.Network.RestApi;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class DrivierxiangqingActivity extends BaseActivity {

    private TextView name, tv_card,
            et_permit_type, tv_start_date, et_end_date,
            et_post_card, tv_first_receive, tv_you_xiao_qi;
    private ImageView iv_card_front1, iv_card_front2, iv_business_front, iv_driver_front,
            iv_work_front;

    @Override
    public int setLayoutResource() {
        return R.layout.activity_driver_information;
    }

    @Override
    protected void onInitView() {
        setDefaultTitle("驾驶员信息");

        name = (TextView) bindView(R.id.tv_real_name);
        tv_card = (TextView) bindView(R.id.et_card_num);
        iv_card_front1 = (ImageView) bindView(R.id.iv_card_front);
        iv_card_front2 = (ImageView) bindView(R.id.iv_card_revers);
        iv_business_front = (ImageView) bindView(R.id.iv_business_front);
        iv_driver_front = (ImageView) bindView(R.id.iv_driver_front);
        et_permit_type = (TextView) bindView(R.id.et_permit_type);
        tv_start_date = (TextView) bindView(R.id.tv_start_date);
        et_end_date = (TextView) bindView(R.id.et_end_date);
        iv_work_front = (ImageView) bindView(R.id.iv_work_front);
        et_post_card = (TextView) bindView(R.id.et_post_card);
        tv_first_receive = (TextView) bindView(R.id.tv_first_receive);
        tv_you_xiao_qi = (TextView) bindView(R.id.tv_you_xiao_qi);
    }

    @Override
    protected void onLoadData2Remote() {
        RestApi.getInstance().get(BaseApiConstants.API_JIASHIYUAN + getIntent().getIntExtra("Id", 0), new OnRequestResultForCommon() {
            @Override
            public void onSuccess(String msg) {
                WrodIdBean wrodIdBean = new Gson().fromJson(msg, WrodIdBean.class);
                WrodIdBean.DataBean.CertificateDriverBoBean certificateDriverBo = wrodIdBean.getData().getCertificateDriverBo();
                WrodIdBean.DataBean.CertificateIDBoBean certificateIDBo = wrodIdBean.getData().getCertificateIDBo();
                WrodIdBean.DataBean.CertificateWorkBoBean certificateWorkBo = wrodIdBean.getData().getCertificateWorkBo();
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
                Glide.with(getContext()).load(certificateWorkBo.getPicUrl()).into(iv_work_front);
//        Glide.with(getContext()).load(certificateDriverBo.getPicUrl()).into(iv_card_front_qy);
                et_post_card.setText(certificateWorkBo.getGrantNo() + "");
                tv_first_receive.setText(certificateWorkBo.getValidityStartTime() + "");
                tv_you_xiao_qi.setText(certificateWorkBo.getValidityEndTime() + "");
            }

            @Override
            public void onFail() {
                super.onFail();
            }

            @Override
            public void netUnlink() {
                super.netUnlink();
            }
        });
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