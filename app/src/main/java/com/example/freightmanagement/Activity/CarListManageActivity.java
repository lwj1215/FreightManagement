package com.example.freightmanagement.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freightmanagement.Adapter.CarListAdapter;
import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.Bean.CarListBean;
import com.example.freightmanagement.R;
import com.example.freightmanagement.model.CarExecuteParam;
import com.example.freightmanagement.presenter.CarListManagerPresenter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class CarListManageActivity extends BaseActivity<CarListManagerPresenter> implements CarListManagerPresenter.View,CarListAdapter.ItemClickListener, CarListAdapter.ItemLongClickListener, View.OnClickListener {
    private RecyclerView mRvCar;
    private TextView mTvSrue;
    private CarListAdapter carListAdapter;
    private AlertDialog.Builder builder;
    private List<CarListBean.DataBean> data;

    @Override
    public int setLayoutResource() {
        return R.layout.activity_car_list;
    }

    @Override
    protected void onInitView() {
        setDefaultTitle("车辆信息");
        mRvCar = findViewById(R.id.rv_car);
        mTvSrue = findViewById(R.id.tv_srue);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRvCar.setLayoutManager(linearLayoutManager);
        carListAdapter = new CarListAdapter(this);
        mRvCar.setAdapter(carListAdapter);
        carListAdapter.setOnItemClickListener(this);
        carListAdapter.setOnItemLongClickListener(this);
        mTvSrue.setOnClickListener(this);
    }

    @Override
    protected void onLoadData2Remote() {
        mPresenter.getList();

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
//                        Toast.makeText(CarListManageActivity.this, "确定按钮", Toast.LENGTH_LONG).show();
//                        CarExecuteParam carExecuteParam = new CarExecuteParam();
//                        carExecuteParam.setCarId();
                        List<Integer> ids = new ArrayList<>();
                        ids.add(data.get(position).getId());
                        mPresenter.delete(ids);
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //ToDo: 你想做的事情
//                        Toast.makeText(CarListManageActivity.this, "关闭按钮", Toast.LENGTH_LONG).show();
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


    @Override
    public void carListResult(String msg) {
        CarListBean carListBean = new Gson().fromJson(msg, CarListBean.class);
        if(carListBean != null){
            data = carListBean.getData();
            carListAdapter.setData(data);
        }
    }

    @Override
    public void delResult(String json) {

    }

    @Override
    protected CarListManagerPresenter onInitLogicImpl() {
        return new CarListManagerPresenter();
    }
}
