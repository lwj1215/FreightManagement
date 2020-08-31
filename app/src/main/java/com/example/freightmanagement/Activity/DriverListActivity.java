package com.example.freightmanagement.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freightmanagement.Adapter.DriverListAdapter;
import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.Bean.DriverListBean;
import com.example.freightmanagement.R;
import com.example.freightmanagement.model.CarExecuteParam;
import com.example.freightmanagement.presenter.DriverListPresenter;
import com.example.freightmanagement.presenter.constract.DriverListConstact;
import com.google.gson.Gson;

import java.util.List;

public class DriverListActivity extends BaseActivity<DriverListPresenter> implements DriverListPresenter.View, DriverListAdapter.ItemClickListener, DriverListAdapter.ItemLongClickListener, View.OnClickListener {
    private RecyclerView mRvDriver;
    private DriverListAdapter driverListAdapter;
    private AlertDialog.Builder builder;
    private List<DriverListBean.DataBean> data;
    private TextView mTvSrue;

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
        mTvSrue = findViewById(R.id.tv_srue);
        mTvSrue.setOnClickListener(this);
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
        showTwo(position);
    }

    /**
     * 两个按钮的 dialog
     *
     * @param position
     */
    private void showTwo(final int position) {
        builder = new AlertDialog.Builder(this).setIcon(R.mipmap.ic_launcher).setTitle("删除车辆")
                .setMessage("是否确认删除此车辆").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //ToDo: 你想做的事情
                        Toast.makeText(DriverListActivity.this, "确定按钮", Toast.LENGTH_LONG).show();
                        CarExecuteParam carExecuteParam = new CarExecuteParam();
                        carExecuteParam.setCarId(data.get(position).getCarId());
                        mPresenter.delete(carExecuteParam);
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //ToDo: 你想做的事情
                        Toast.makeText(DriverListActivity.this, "关闭按钮", Toast.LENGTH_LONG).show();
                        dialogInterface.dismiss();
                    }
                });
        builder.create().show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_srue:
                Intent intent = new Intent(this, CarAddActivity.class);
                startActivity(intent);
                break;
        }
    }
}
