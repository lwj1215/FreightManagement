package com.example.freightmanagement.Activity;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.R;

public class CommonImgActivity extends BaseActivity {
    private ImageView mImg;

    @Override
    public int setLayoutResource() {
        return R.layout.activity_common_img;
    }

    @Override
    protected void onInitView() {
        setDefaultTitle("合同");
        mImg = findViewById(R.id.img);

    }

    @Override
    protected void onLoadData2Remote() {
        String url = getIntent().getStringExtra("url");
        Glide.with(this).load(url).into(mImg);

    }
}
