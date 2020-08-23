package com.example.freightmanagement.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.freightmanagement.Adapter.GridAdapter;
import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.R;
import com.example.freightmanagement.listener.OnPicturesClickListener;
import com.giftedcat.picture.lib.PictureUseHelpr;
import com.giftedcat.picture.lib.selector.MultiImageSelector;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by songdechuan on 2020/8/19.
 */

public class MaintenanceRecordsActivity extends BaseActivity implements View.OnClickListener {
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
     * 添加照片
     */
    private TextView mTvAddPhoto;
    /**
     * 提交
     */
    private TextView mTvSrue;
    private List<String> mSelect;
    private RecyclerView mRvImages;
    private GridAdapter adapter;
    private PictureUseHelpr helpr;
    private static final  int REQUEST_IMAGE = 101;
    @Override
    public int setLayoutResource() {
        return R.layout.activity_maintenance_records;
    }

    @Override
    protected void onInitView() {
        setDefaultTitle("添加保养记录");
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
        mEtXingShiLiCheng = (EditText) findViewById(R.id.et_xing_shi_li_cheng);
        mEtBaoYangNeiRong = (EditText) findViewById(R.id.et_bao_yang_nei_rong);
        mTvBaoYangShiJian = (TextView) findViewById(R.id.tv_bao_yang_shi_jian);
        mTvBaoYangShiJian.setOnClickListener(this);
        mLlCurrentAddress = (LinearLayout) findViewById(R.id.ll_current_address);
//        mTvAddPhoto = (TextView) findViewById(R.id.tv_add_photo);
//        mTvAddPhoto.setOnClickListener(this);
        mTvSrue = (TextView) findViewById(R.id.tv_srue);
        mTvSrue.setOnClickListener(this);
        mRvImages = (RecyclerView) findViewById(R.id.rv_images);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_bao_yang_shi_jian:
                break;
//            case R.id.tv_add_photo:
//                // 自由配置选项
//
//                break;
            case R.id.tv_srue:
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

}
