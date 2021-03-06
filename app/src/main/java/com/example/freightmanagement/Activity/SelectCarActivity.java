package com.example.freightmanagement.Activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freightmanagement.Adapter.CheLiangWxAdapter;
import com.example.freightmanagement.Adapter.SelectCarAdapter;
import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.Base.BaseResponse;
import com.example.freightmanagement.Bean.SelectCarBean;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.PrefUtilsData;
import com.example.freightmanagement.Utils.StringUtil;
import com.example.freightmanagement.Utils.ToastUtils;
import com.example.freightmanagement.model.DriverInfoSubmitParam;
import com.example.freightmanagement.presenter.SelectCarPresenter;
import com.google.gson.Gson;

import java.util.List;

public class SelectCarActivity extends BaseActivity<SelectCarPresenter> implements SelectCarPresenter.View, View.OnClickListener {
    private RecyclerView mRecyclerView;
    private TextView mTvSrue;
//    private DriverInfoSubmitParam submitParam;
    private SelectCarAdapter selectCarAdapter;
    private List<SelectCarBean.DataBean> data;
    private Integer id;
    private Integer enterpriseId;
    private String sealUrl;
    private String address;
    private String legalPerson;
    private String signature;
    private String companyName;

    @Override
    public int setLayoutResource() {
        return R.layout.activity_select_car;
    }

    @Override
    protected void onInitView() {
        setDefaultTitle("车辆选择");
        mRecyclerView = findViewById(R.id.recyclerView);
        mTvSrue = findViewById(R.id.tv_srue);
        mTvSrue.setOnClickListener(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        selectCarAdapter = new SelectCarAdapter(this);
        mRecyclerView.setAdapter(selectCarAdapter);
        selectCarAdapter.setOnItemClickListener(new SelectCarAdapter.ItemClickListener() {
            @Override
            public void onItemClick(int position) {
                id = data.get(position).getId();
                enterpriseId = data.get(position).getEnterpriseId();
                SelectCarBean.DataBean.EnterpriseBoBean enterpriseBo = data.get(position).getEnterpriseBo();
                if(enterpriseBo != null){
                    sealUrl = enterpriseBo.getSealUrl();
                    SelectCarBean.DataBean.EnterpriseBoBean.CertificateBusinessBoBean certificateBusinessBo = enterpriseBo.getCertificateBusinessBo();
                    address = certificateBusinessBo.getRegistrationAuthority();
                    legalPerson = certificateBusinessBo.getLegalPerson();
                    signature = enterpriseBo.getSignature();
                    companyName = certificateBusinessBo.getName();
                }


            }
        });
    }

    @Override
    protected void onLoadData2Remote() {
//        submitParam = (DriverInfoSubmitParam) getIntent().getSerializableExtra("driverInfo");
        mPresenter.getCar();
    }

    @Override
    public void carList(String msg) {
        SelectCarBean selectCarBean = new Gson().fromJson(msg, SelectCarBean.class);
        data = selectCarBean.getData();
        selectCarAdapter.setData(data);
    }

    @Override
    public void success(String json) {
        BaseResponse baseResponse = new Gson().fromJson(json, BaseResponse.class);
        int code = baseResponse.getCode();
        if (code == 0) {
            ToastUtils.popUpToast("提交成功");
            Intent intent = new Intent(this,MainActivity.class);
//            intent.putExtra("name",submitParam.getCertificateIDBo().getName());
//            intent.putExtra("certificateNo",submitParam.getCertificateDriverBo().getFileNumber());
//            intent.putExtra("tel", PrefUtilsData.getMobile());
//            intent.putExtra("carId",id);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected SelectCarPresenter onInitLogicImpl() {
        return new SelectCarPresenter();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_srue:
                if(StringUtil.isEmpty(id)){
                    ToastUtils.popUpToast("请选择一辆车");
                    return;
                }
                Intent intent = new Intent(this, EmploymentContractActivity.class);
                intent.putExtra("id",id);
                intent.putExtra("enterpriseId",enterpriseId);
                intent.putExtra("address",address);
                intent.putExtra("legalPerson",legalPerson);
                intent.putExtra("sealUrl",sealUrl);
                intent.putExtra("signature",signature);
                intent.putExtra("companyName",companyName);

                startActivity(intent);
                break;
        }
    }
}
