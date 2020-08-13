package com.example.freightmanagement.Activity;

import com.example.freightmanagement.Adapter.TrainingAdapter;
import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.Base.BaseResponse;
import com.example.freightmanagement.R;
import com.example.freightmanagement.model.TrainingListBean;
import com.example.freightmanagement.presenter.constract.TrainingConstact;
import com.example.freightmanagement.presenter.TrainingPresenter;
import com.google.gson.Gson;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by songdechuan on 2020/8/6.
 */

public class TrainingActivity extends BaseActivity<TrainingPresenter> implements TrainingConstact.View{

    private RecyclerView recyclerView;

    @Override
    public int setLayoutResource() {
        return R.layout.activity_training;
    }

    @Override
    protected void onInitView() {
        recyclerView = (RecyclerView) bindView(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        TrainingAdapter trainingAdapter = new TrainingAdapter(this);
        recyclerView.setAdapter(trainingAdapter);
    }

    @Override
    protected void onLoadData2Remote() {

    }



    @Override
    protected TrainingPresenter onInitLogicImpl() {
        return new TrainingPresenter();
    }

    @Override
    public String trainingList(String msg) {
        BaseResponse baseResponse = new Gson().fromJson(msg, BaseResponse.class);
        List<TrainingListBean> data = (List<TrainingListBean>) baseResponse.getData();
        for (TrainingListBean datum : data) {

        }
        return null;
    }

    @Override
    public void testResult(String msg) {

    }
}
