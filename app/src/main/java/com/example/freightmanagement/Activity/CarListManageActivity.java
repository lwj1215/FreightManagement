package com.example.freightmanagement.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freightmanagement.Adapter.CarListAdapter;
import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.Bean.CarListBean;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.PrefUtilsData;
import com.example.freightmanagement.presenter.CarListManagerPresenter;
import com.example.freightmanagement.presenter.constract.CarListManagerConstact;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class CarListManageActivity extends BaseActivity<CarListManagerPresenter> implements CarListManagerPresenter.View, CarListAdapter.ItemClickListener, CarListAdapter.ItemLongClickListener, View.OnClickListener {
    private RecyclerView mRvCar;
    private TextView mTvSrue;
    private CarListAdapter carListAdapter;
    private AlertDialog.Builder builder;
    private List<CarListBean.DataBean> data;
    private TextView mTvCljc;
    private LinearLayout mLinCeliang;
    private TextView mTvClwx;
    private LinearLayout mLinCeliangwx;
    private TextView mTvClby;
    private LinearLayout mLinChebaoyang;
    private String owner;
    private String owner2;
    @Override
    public int setLayoutResource() {
        return R.layout.activity_car_list;
    }

    @Override
    protected void onInitView() {
        setDefaultTitle("车辆信息");
        EventBus.getDefault().register(this);
        mRvCar = findViewById(R.id.rv_car);
        mTvSrue = findViewById(R.id.tv_srue);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRvCar.setLayoutManager(linearLayoutManager);
        carListAdapter = new CarListAdapter(this);
        mRvCar.setAdapter(carListAdapter);
        carListAdapter.setOnItemClickListener(this);
        carListAdapter.setOnItemLongClickListener(this);
        mTvSrue.setOnClickListener(this);
        mTvCljc = findViewById(R.id.tv_cljc);
        mLinCeliang = findViewById(R.id.lin_celiang);
        mLinCeliang.setOnClickListener(this);
        mTvClwx = findViewById(R.id.tv_clwx);
        mLinCeliangwx = findViewById(R.id.lin_celiangwx);
        mLinCeliangwx.setOnClickListener(this);
        mTvClby = findViewById(R.id.tv_clby);
        mLinChebaoyang = findViewById(R.id.lin_chebaoyang);
        mLinChebaoyang.setOnClickListener(this);
    }

    @Override
    protected void onLoadData2Remote() {
        mPresenter.getList();

    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, CarInformationActivity.class);
        intent.putExtra("carId", data.get(position).getId());
        startActivity(intent);
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
        switch (view.getId()) {
            case R.id.tv_srue:
                Intent addIntent = new Intent(this, CarAddActivity.class);
                startActivity(addIntent);
                break;
            case R.id.lin_celiang:
                if (PrefUtilsData.getType().equals("1")) {
                    Intent intent = new Intent(this, VehicleDetectionActivity.class);
                    intent.putExtra("name1", owner);
                    intent.putExtra("name2", owner2);
                    startActivity(intent);
                } else if (PrefUtilsData.getType().equals("2")) {
                    getTz("1");
                } else {
                    getTz("1");
                }

                break;
            case R.id.lin_celiangwx:
                if (PrefUtilsData.getType().equals("1")) {
                    Intent intent = new Intent(this, WeiXiuJiLuActivity.class);
                    startActivity(intent);
                } else if (PrefUtilsData.getType().equals("2")) {
                    getTz("2");
                } else {
                    getTz("2");
                }

                break;
            case R.id.lin_chebaoyang:
                if (PrefUtilsData.getType().equals("1")) {
                    Intent intent = new Intent(this, MaintenanceRecordsActivity.class);
                    startActivity(intent);
                } else if (PrefUtilsData.getType().equals("2")) {
                    getTz("3");
                } else {
                    getTz("3");
                }

                break;
        }
    }
    private void getTz(String type) {
        Intent intent = new Intent(this, CheLiangJcActivity.class);
        intent.putExtra("type", type);
        startActivity(intent);
    }

    @Override
    public void carListResult(String msg) {
        CarListBean carListBean = new Gson().fromJson(msg, CarListBean.class);
        if (carListBean != null) {
            data = carListBean.getData();
            carListAdapter.setData(data);
        }
    }

    @Override
    public void delResult(String json) {

    }

    @Subscribe
    public void onEventMainThread(String msg) {
        if (msg.equals("addCarSuccess")) {
            mPresenter.getList();
        }
    }

    @Override
    protected CarListManagerPresenter onInitLogicImpl() {
        return new CarListManagerPresenter();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
