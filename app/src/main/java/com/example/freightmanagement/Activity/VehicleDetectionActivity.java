package com.example.freightmanagement.Activity;


import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freightmanagement.Adapter.VehicleFetectionAdapter;
import com.example.freightmanagement.Adapter.VehicleFetectionXx2Adapter;
import com.example.freightmanagement.Adapter.VehicleFetectionXx3Adapter;
import com.example.freightmanagement.Adapter.VehicleFetectionXxAdapter;
import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.Bean.VehicleDetectionBean;
import com.example.freightmanagement.Bean.VerAddBean;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.OnItemClickListener;
import com.example.freightmanagement.Utils.PrefUtilsData;
import com.example.freightmanagement.Utils.ToastUtils;
import com.example.freightmanagement.presenter.VehicleDetectionPresenter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class VehicleDetectionActivity extends BaseActivity<VehicleDetectionPresenter> implements VehicleDetectionPresenter.View, View.OnClickListener {

    private RecyclerView recyclerView1;
    private TextView et_real_name,et_siji_name;
    private RecyclerView recycler2;
    private RecyclerView recycler3;
    private RecyclerView recycler1;
    private VehicleFetectionXxAdapter adapter1;
    private VehicleFetectionXx2Adapter adapter2;
    private VehicleFetectionXx3Adapter adapter3;

    @Override
    public int setLayoutResource() {
        return R.layout.activity_vehicle_detection;
    }

    @Override
    protected void onInitView() {
        setDefaultTitle("车辆检查情况");
        bindView(R.id.tv_srue).setOnClickListener(this);
        et_real_name = bindView(R.id.et_real_name);
        et_siji_name = bindView(R.id.et_siji_name);

        TextView textView1 = findViewById(R.id.text1);
        TextView textView2 = findViewById(R.id.text2);
        TextView textView3 = findViewById(R.id.text3);
        recycler1 = findViewById(R.id.recycler1);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler1.setLayoutManager(gridLayoutManager);
        adapter1 = new VehicleFetectionXxAdapter(this);
        recycler1.setAdapter(adapter1);

        recycler2 = findViewById(R.id.recycler2);
        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler2.setLayoutManager(gridLayoutManager2);
        adapter2 = new VehicleFetectionXx2Adapter(this);
        recycler2.setAdapter(adapter2);


        recycler3 = findViewById(R.id.recycler3);
        GridLayoutManager gridLayoutManager3 = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler3.setLayoutManager(gridLayoutManager3);
        adapter3 = new VehicleFetectionXx3Adapter(this);
        recycler3.setAdapter(adapter3);

        textView1.setOnClickListener(this);
        textView2.setOnClickListener(this);
        textView3.setOnClickListener(this);
    }

    @Override
    protected void onLoadData2Remote() {
        et_real_name.setText(getIntent().getStringExtra("name1"));
        et_siji_name.setText(getIntent().getStringExtra("name2"));
        mPresenter.VehicleInformationData();
    }


    @Override
    protected VehicleDetectionPresenter onInitLogicImpl() {
        return new VehicleDetectionPresenter();
    }
    private VerAddBean verAddBean=new VerAddBean();
    private VerAddBean.CompleteBosBean completeBosBean=new VerAddBean.CompleteBosBean();
    private List<VerAddBean.CompleteBosBean> lisBean=new ArrayList<>();
    @Override
    public void trainingList(final VehicleDetectionBean vehicleDetectionBean) {
        adapter1.setPages(vehicleDetectionBean.getData().getType1());
        adapter1.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                completeBosBean.setChechDataId(vehicleDetectionBean.getData().getType1().get(position).getId());
                completeBosBean.setState(1);
                completeBosBean.setReslut("");
                lisBean.add(completeBosBean);
                verAddBean.setCompleteBos(lisBean);
            }
        });
        adapter2.setPages(vehicleDetectionBean.getData().getType2());
        adapter2.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                completeBosBean.setChechDataId(vehicleDetectionBean.getData().getType2().get(position).getId());
                completeBosBean.setState(1);
                completeBosBean.setReslut("");
                lisBean.add(completeBosBean);
                verAddBean.setCompleteBos(lisBean);
            }
        });
        adapter3.setPages(vehicleDetectionBean.getData().getType3());
        adapter3.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                completeBosBean.setChechDataId(vehicleDetectionBean.getData().getType3().get(position).getId());
                completeBosBean.setState(1);
                completeBosBean.setReslut("");
                lisBean.add(completeBosBean);
                verAddBean.setCompleteBos(lisBean);
            }
        });
    }

    @Override
    public void mSuc() {
        ToastUtils.popUpToast("提交成功");
        finish();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_srue:
                if (verAddBean==null||verAddBean.getCompleteBos().size() == 0) {
                    ToastUtils.popUpToast("提交检测结果为空");
                } else {
                    verAddBean.setDriverId(Integer.parseInt(PrefUtilsData.getUserId()));
                    String json = new Gson().toJson(verAddBean);
                    mPresenter.addVehicleData(json);
                }
                break;
            case R.id.text1:
                recycler1.setVisibility(View.VISIBLE);
                recycler2.setVisibility(View.GONE);
                recycler3.setVisibility(View.GONE);
                break;
            case R.id.text2:
                recycler2.setVisibility(View.VISIBLE);
                recycler1.setVisibility(View.GONE);
                recycler3.setVisibility(View.GONE);
                break;
            case R.id.text3:
                recycler3.setVisibility(View.VISIBLE);
                recycler1.setVisibility(View.GONE);
                recycler2.setVisibility(View.GONE);
                break;
        }
    }
}