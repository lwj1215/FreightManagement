package com.example.freightmanagement.Activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freightmanagement.Adapter.CarListAdapter;
import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.R;
import com.example.freightmanagement.presenter.CarListManagerPresenter;

public class CarListManageActivity extends BaseActivity<CarListManagerPresenter> implements CarListManagerPresenter.View,CarListAdapter.ItemClickListener, CarListAdapter.ItemLongClickListener, View.OnClickListener {
    private RecyclerView mRvCar;
    private TextView mTvSrue;
    private CarListAdapter carListAdapter;
    private AlertDialog.Builder builder;

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
     * @param position
     */
    private void showTwo(int position) {
        builder = new AlertDialog.Builder(this).setIcon(R.mipmap.ic_launcher).setTitle("删除车辆")
                .setMessage("是否确认删除此车辆").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //ToDo: 你想做的事情
                        Toast.makeText(CarListManageActivity.this, "确定按钮", Toast.LENGTH_LONG).show();
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //ToDo: 你想做的事情
                        Toast.makeText(CarListManageActivity.this, "关闭按钮", Toast.LENGTH_LONG).show();
                        dialogInterface.dismiss();
                    }
                });
        builder.create().show();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_srue:

                break;
        }
    }

    @Override
    public void success(String url, int type) {

    }

    @Override
    protected CarListManagerPresenter onInitLogicImpl() {
        return new CarListManagerPresenter();
    }
}
