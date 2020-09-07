package com.example.freightmanagement.Activity;

import android.content.Intent;
import android.view.View;

import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freightmanagement.Adapter.TrainingHtmlAdapter;
import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.Bean.TrainListBean;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.OnItemClickListener;
import com.example.freightmanagement.presenter.TrainingPresenter;
import com.example.freightmanagement.presenter.constract.TrainingConstact;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by songdechuan on 2020/8/6.
 */

public class TrainingActivity extends BaseActivity<TrainingPresenter> implements TrainingConstact.View {

    private RecyclerView mRvHtml;
    private List<String> htmlList = new ArrayList<>();
    private List<String> videoList = new ArrayList<>();
    private TrainingHtmlAdapter trainingAdapter;

    @Override
    public int setLayoutResource() {
        return R.layout.activity_training;

    }

    @Override
    protected void onInitView() {
        setDefaultTitle("训练列表");

        mRvHtml = findViewById(R.id.rv_html);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRvHtml.setLayoutManager(linearLayoutManager);
        trainingAdapter = new TrainingHtmlAdapter(this);
        mRvHtml.setAdapter(trainingAdapter);
        trainingAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String s = htmlList.get(position);
                if(s.contains(".html")){
                    Intent intent = new Intent(getContext(),CommonHtmlActivity.class);
                    intent.putExtra("url",s);
                    startActivity(intent);
                }else if(s.contains(".mp4")){
                    Intent intent = new Intent(getContext(),CommonVideoActivity.class);
                    intent.putExtra("videoPath",s);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onLoadData2Remote() {
        mPresenter.getTrainingList();
    }


    @Override
    protected TrainingPresenter onInitLogicImpl() {
        return new TrainingPresenter();
    }

    @Override
    public void trainingList(String msg) {
        TrainListBean trainListBean = new Gson().fromJson(msg, TrainListBean.class);

        List<TrainListBean.DataBean> data = trainListBean.getData();
        for (TrainListBean.DataBean datum : data) {
            String content = datum.getContent();
//            if(content.contains(".html")){
//                htmlList.add(content);
//            }else if(content.contains(".mp4") || content.contains(".avi")){
//                videoList.add(content);
//            }
            htmlList.add(content);

        }
//        htmlList.add("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4");
        trainingAdapter.setData(htmlList);

    }

    @Override
    public void testResult(String msg) {

    }
}
