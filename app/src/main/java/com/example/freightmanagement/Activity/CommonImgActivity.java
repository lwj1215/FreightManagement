package com.example.freightmanagement.Activity;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freightmanagement.Adapter.ImageListAdapter;
import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class CommonImgActivity extends BaseActivity {

    private RecyclerView mRv;
    private List<String> list = new ArrayList<>();
    private ImageListAdapter imageListAdapter;

    @Override
    public int setLayoutResource() {
        return R.layout.activity_common_img;
    }

    @Override
    protected void onInitView() {
        setDefaultTitle("合同");
        mRv = findViewById(R.id.rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRv.setLayoutManager(linearLayoutManager);
        imageListAdapter = new ImageListAdapter(this);
        mRv.setAdapter(imageListAdapter);
    }

    @Override
    protected void onLoadData2Remote() {
        String htUrl = getIntent().getStringExtra("htUrl");
        String zrUrl = getIntent().getStringExtra("zrUrl");
        String cnUrl = getIntent().getStringExtra("cnUrl");
        if(StringUtil.isNotEmpty(htUrl)){
            list.add(htUrl);
        }
        if(StringUtil.isNotEmpty(zrUrl)){
            list.add(zrUrl);
        }
        if(StringUtil.isNotEmpty(cnUrl)){
            list.add(cnUrl);
        }
        imageListAdapter.setData(list);
    }
}
