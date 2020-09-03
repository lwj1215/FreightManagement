package com.example.freightmanagement.Activity;

import android.app.AlertDialog;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freightmanagement.Adapter.DriverListAdapter;
import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.Bean.DriverListBean;
import com.example.freightmanagement.R;
import com.example.freightmanagement.presenter.DriverListPresenter;
import com.google.gson.Gson;

import java.util.List;

public class DriverListActivity extends BaseActivity<DriverListPresenter> implements DriverListPresenter.View, DriverListAdapter.ItemClickListener, DriverListAdapter.ItemLongClickListener, View.OnClickListener {
    private RecyclerView mRvDriver;
    private DriverListAdapter driverListAdapter;
    private AlertDialog.Builder builder;
    private List<DriverListBean.DataBean> data;

    @Override
    public int setLayoutResource() {
        return R.layout.activity_driver_list;
    }

    @Override
    protected void onInitView() {
        setDefaultTitle("驾驶员列表");
        mRvDriver = findViewById(R.id.rv_driver);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRvDriver.setLayoutManager(linearLayoutManager);
        driverListAdapter = new DriverListAdapter(this);
        mRvDriver.setAdapter(driverListAdapter);
        driverListAdapter.setOnItemClickListener(this);
        driverListAdapter.setOnItemLongClickListener(this);
    }

    @Override
    protected void onLoadData2Remote() {
        mPresenter.getList();
    }

    @Override
    public void success(String msg) {
        DriverListBean driverListBean = new Gson().fromJson(msg, DriverListBean.class);
        data = driverListBean.getData();
        driverListAdapter.setData(data);
    }

    @Override
    public void delResult(String json) {

    }

    @Override
    protected DriverListPresenter onInitLogicImpl() {
        return new DriverListPresenter();
    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onItemLongClick(int position) {
//        showTwo(position);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

        }
    }
}
