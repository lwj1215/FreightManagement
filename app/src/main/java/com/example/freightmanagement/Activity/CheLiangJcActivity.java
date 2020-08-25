package com.example.freightmanagement.Activity;



import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freightmanagement.Adapter.CheLiangByAdapter;
import com.example.freightmanagement.Adapter.CheLiangJcAdapter;
import com.example.freightmanagement.Adapter.CheLiangWxAdapter;
import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.Bean.CheliangByBean;
import com.example.freightmanagement.Bean.CheliangJcBean;
import com.example.freightmanagement.Bean.CheliangWeiXiuBean;
import com.example.freightmanagement.R;
import com.example.freightmanagement.presenter.CheLiangJcPresenter;

import java.util.List;

public class CheLiangJcActivity extends BaseActivity<CheLiangJcPresenter> implements CheLiangJcPresenter.View{

    private CheLiangJcAdapter cheLiangJcAdapter;
    private CheLiangWxAdapter cheLiangWxAdapter;
    private CheLiangByAdapter cheLiangByAdapter;

    @Override
    public int setLayoutResource() {
        return R.layout.activity_che_liang_jc;
    }

    @Override
    protected void onInitView() {
        RecyclerView recyclerView1 = bindView(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView1.setLayoutManager(linearLayoutManager);

        String type = getIntent().getStringExtra("type");
        if (type.equals("1")){
            setDefaultTitle("车辆检查情况");
            cheLiangJcAdapter = new CheLiangJcAdapter(this);
            recyclerView1.setAdapter(cheLiangJcAdapter);
            mPresenter.getData1();
        }else if (type.equals("2")){
            setDefaultTitle("车辆维修情况");
            cheLiangWxAdapter = new CheLiangWxAdapter(this);
            mPresenter.getData2();
        }else {
            setDefaultTitle("车辆保养情况");
            recyclerView1.setAdapter(cheLiangWxAdapter);
            cheLiangByAdapter = new CheLiangByAdapter(this);
            recyclerView1.setAdapter(cheLiangByAdapter);
            mPresenter.getData3();
        }

    }

    @Override
    protected void onLoadData2Remote() {

    }


    @Override
    public void getData1Suc(List<CheliangJcBean.DataBean> data) {
        cheLiangJcAdapter.setPages(data);
    }

    @Override
    public void getData2Suc(List<CheliangWeiXiuBean.DataBean> data) {
        cheLiangWxAdapter.setPages(data);
    }


    @Override
    public void getData3Suc(List<CheliangByBean.DataBean> data) {
        cheLiangByAdapter.setPages(data);
    }

    @Override
    public void onFailed(String error) {

    }

    @Override
    protected CheLiangJcPresenter onInitLogicImpl() {
        return  new CheLiangJcPresenter();
    }
}