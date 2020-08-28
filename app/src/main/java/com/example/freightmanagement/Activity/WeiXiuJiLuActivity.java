package com.example.freightmanagement.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.freightmanagement.Adapter.GridAdapter;
import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.Bean.WeiXiuBean;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.DatePickerDialog;
import com.example.freightmanagement.Utils.DateUtil;
import com.example.freightmanagement.Utils.PrefUtilsData;
import com.example.freightmanagement.Utils.ToastUtils;
import com.example.freightmanagement.listener.OnPicturesClickListener;
import com.example.freightmanagement.presenter.WeiXiuPresenter;
import com.giftedcat.picture.lib.PictureUseHelpr;
import com.giftedcat.picture.lib.selector.MultiImageSelector;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by songdechuan on 2020/8/19.
 */

public class WeiXiuJiLuActivity extends BaseActivity<WeiXiuPresenter> implements WeiXiuPresenter.View, View.OnClickListener {
    /**
     * 请输入您的行驶里程
     */
    private EditText mEtXingShiLiCheng;
    /**
     * 请输入您的保养内容
     */
    private EditText mEtBaoYangNeiRong;
    /**
     * 请选择您的保养时间
     */
    private TextView mTvBaoYangShiJian;
    private LinearLayout mLlCurrentAddress;
    /**
     * 提交
     */
    private TextView mTvSrue;
    private List<String> mSelect;
    private RecyclerView mRvImages;
    private GridAdapter adapter;
    private PictureUseHelpr helpr;
    private static final int REQUEST_IMAGE = 101;
    private WeiXiuBean bean = new WeiXiuBean();
    private EditText et_wei_xiu_dan_wei;
    private EditText et_wei_xiu_nei_rong;
    private EditText et_bu_jian_chang_jia;
    private TextView tv_wei_xiu_shi_jian;
    private Dialog dateDialog;

    @Override
    public int setLayoutResource() {
        return R.layout.activity_wei_xiu_ji_lu;
    }

    @Override
    protected void onInitView() {
        setDefaultTitle("添加维修记录");
        initView();
        mSelect = new ArrayList<>();
        helpr = PictureUseHelpr.init(this).
                setMaxNum(9).
                origin(mSelect).
                bindRecyclerView(mRvImages, R.id.iv_thum);
        initAdapter();

    }

    @Override
    protected void onLoadData2Remote() {

    }

    private void initAdapter() {
        adapter = new GridAdapter(this, mSelect);

        mRvImages.setLayoutManager(new GridLayoutManager(this, 3));
        mRvImages.setAdapter(adapter);
        adapter.setOnAddPicturesListener(new OnPicturesClickListener() {
            @Override
            public void onClick(int position) {
                helpr.show(position);
            }

            @Override
            public void onAdd() {
                helpr.pickImage(REQUEST_IMAGE);
            }
        });
    }

    public void initView() {
        mEtXingShiLiCheng = findViewById(R.id.et_xing_shi_li_cheng);
        et_wei_xiu_dan_wei = findViewById(R.id.et_wei_xiu_dan_wei);
        mEtBaoYangNeiRong = findViewById(R.id.et_bao_yang_nei_rong);
        et_wei_xiu_nei_rong = findViewById(R.id.et_wei_xiu_nei_rong);
        et_bu_jian_chang_jia = findViewById(R.id.et_bu_jian_chang_jia);
        tv_wei_xiu_shi_jian = findViewById(R.id.tv_wei_xiu_shi_jian);
        tv_wei_xiu_shi_jian.setOnClickListener(this);
        mLlCurrentAddress = findViewById(R.id.ll_current_address);
//        mTvAddPhoto =  findViewById(R.id.tv_add_photo);
        mTvSrue = findViewById(R.id.tv_srue);
        mTvSrue.setOnClickListener(this);
        mRvImages = findViewById(R.id.rv_images);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_wei_xiu_shi_jian:
                showDateDialog(DateUtil.getDateForString("1990-01-01"));
                break;
            case R.id.tv_srue:
                if (mSelect.size() > 0) {
                    bean.setPicUrl(mSelect.get(0).toString());
                }
                bean.setDriverId(PrefUtilsData.getUserId());
                if (TextUtils.isEmpty(mEtXingShiLiCheng.getText().toString())) {
                    ToastUtils.popUpToast("请补全信息");
                    return;
                }
                if (TextUtils.isEmpty(et_wei_xiu_dan_wei.getText().toString())) {
                    ToastUtils.popUpToast("请补全信息");
                    return;
                }
                if (TextUtils.isEmpty(et_wei_xiu_nei_rong.getText().toString())) {
                    ToastUtils.popUpToast("请补全信息");
                    return;
                }
                if (TextUtils.isEmpty(et_bu_jian_chang_jia.getText().toString())) {
                    ToastUtils.popUpToast("请补全信息");
                    return;
                }
                if (TextUtils.isEmpty(tv_wei_xiu_shi_jian.getText().toString())) {
                    ToastUtils.popUpToast("请补全信息");
                    return;
                }
                bean.setPartMaker(mEtXingShiLiCheng.getText().toString());
                bean.setServicer(et_wei_xiu_dan_wei.getText().toString());
                bean.setContent(et_wei_xiu_nei_rong.getText().toString());
                bean.setBillPicUrl(et_bu_jian_chang_jia.getText().toString());
                bean.setTime(tv_wei_xiu_shi_jian.getText().toString());
                String json = new Gson().toJson(bean);
                mPresenter.addWeiXiu(json);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE) {
            if (resultCode == RESULT_OK) {
                List<String> select = data.getStringArrayListExtra(MultiImageSelector.EXTRA_RESULT);
                mSelect.clear();
                mSelect.addAll(select);
                adapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    protected WeiXiuPresenter onInitLogicImpl() {
        return new WeiXiuPresenter();
    }


    @Override
    public void mSuc() {
        ToastUtils.popUpToast("提交成功");
        finish();
    }

    @Override
    public void testResult(String msg) {

    }

    /**
     * 选择生日
     */
    private void showDateDialog(List<Integer> date) {
        DatePickerDialog.Builder builder = new DatePickerDialog.Builder(this);
        builder.setOnDateSelectedListener(new DatePickerDialog.OnDateSelectedListener() {
            @Override
            public void onDateSelected(int[] dates) {
                tv_wei_xiu_shi_jian.setText(dates[0] + "." + (dates[1] > 9 ? dates[1] : ("0" + dates[1])) + "."
                        + (dates[2] > 9 ? dates[2] : ("0" + dates[2])));

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
}
