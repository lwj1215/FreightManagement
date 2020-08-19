package com.example.freightmanagement.Activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.Bean.TrainAnswerListBean;
import com.example.freightmanagement.Bean.TrainingStartBean;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.PrefUtilsData;
import com.example.freightmanagement.presenter.TrainingSelectPresenter;

import java.util.List;

/**
 * Created by songdechuan on 2020/8/10.
 */

public class TrainingSelectActivity extends BaseActivity<TrainingSelectPresenter> implements TrainingSelectPresenter.View,View.OnClickListener {


    /**
     * 开始培训
     */
    private TextView mTvStartTraining;
    /**
     * 开始答题
     */
    private TextView mTvStartAnswer;
    private LinearLayout mLl;

    @Override
    public int setLayoutResource() {
        return R.layout.activity_training_select;
    }

    @Override
    protected void onInitView() {
        setDefaultTitle("岗前培训");
        initView();

    }

    @Override
    protected void onLoadData2Remote() {
        mPresenter.getAnswerResultList(PrefUtilsData.getDriverId());
    }

    @Override
    protected TrainingSelectPresenter onInitLogicImpl() {
        return new TrainingSelectPresenter();
    }

    public void initView() {

        mTvStartTraining =  findViewById(R.id.tv_start_training);
        mTvStartTraining.setOnClickListener(this);
        mTvStartAnswer =  findViewById(R.id.tv_start_answer);
        mTvStartAnswer.setOnClickListener(this);
        mLl =  findViewById(R.id.ll);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_start_training:
                startActivity(this,TrainingStartActivity.class);
                break;
            case R.id.tv_start_answer:
                startActivity(this,TrainingStartActivity.class);
                break;
        }
    }

    @Override
    public void trainingList(TrainAnswerListBean.DataBean data) {

    }
}
