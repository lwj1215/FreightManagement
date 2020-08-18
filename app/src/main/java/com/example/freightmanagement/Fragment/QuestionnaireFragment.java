package com.example.freightmanagement.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.annotation.Nullable;

import com.example.freightmanagement.Base.BaseViewPageFragment;
import com.example.freightmanagement.Bean.TrainingStartBean;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.RadioCallBack;
import com.example.freightmanagement.Utils.StateCallBack;
import com.example.freightmanagement.View.QuestionnaireContentView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 普通问卷页面Fragment
 * author: Ray
 * Date: 2016/5/12 14:51
 */
public class QuestionnaireFragment extends BaseViewPageFragment implements StateCallBack {

    private String age;

    @Override
    public void onResume() {
        super.onResume();
    }

    private ScrollView scrollView;
    private LinearLayout linearLayout;
    /*问卷及答案实体*/
    private static List<TrainingStartBean.DataBean> mQuestionList;
    /*题目序号*/
    private int titleNum;
    public static Map<Integer, View> mViews = new TreeMap<>();
    private Map<Integer, List<ImageView>> mImags = new TreeMap<>();
    //切换下一页回调
    private RadioCallBack callBack;
    /*选项到底部的距离*/
    private String id;// 问卷id
    private int pagination;// 页码
    private QuestionnaireContentView mContentView;

    public static QuestionnaireFragment newInstance(List<TrainingStartBean.DataBean> questionList, int titleNum , int pagination) {
        mQuestionList = questionList;
        QuestionnaireFragment fragment = new QuestionnaireFragment();
        Bundle mBundle = new Bundle();
        mBundle.putInt("titleNum", titleNum);
        mBundle.putInt("pagination", pagination);
        fragment.setArguments(mBundle);
        return fragment;
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        showViewDatas();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof RadioCallBack) {
            callBack = (RadioCallBack) activity;
        }
    }

    /*显示页面元素*/
    private void showViewDatas() {
        linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        List<ImageView> list = new ArrayList<>();
        mImags.put(pagination, list);
        scrollView.removeAllViews();
        for (int i = 0, h = 0; i < mQuestionList.size(); i++) {
           if (mQuestionList.get(i).getIndex() > pagination) {
                break;
            }else{
                mContentView = new QuestionnaireContentView(mQuestionList.get(i), titleNum + h++, id,age, activity, callBack, this);
                linearLayout.addView(mContentView.getCurrentView());
            }
        }
        scrollView.addView(linearLayout);
    }


    private void judgeState(int position, int index, String type) {
        mViews.put(mQuestionList.get(position).getId(), mContentView.getCurrentView());
//        String value = mQuestionList.get(index).getValuelist().get(0).getAnswerValue();
//        mContentView.getCurrentView().setVisibility(type.equals(value) ? View.VISIBLE : View.GONE);
    }

    /*获取当前页码*/
    public int getPaginationNum() {
        return pagination;
    }

    @Override
    public int getPagination() {
        return getPaginationNum();
    }


    @Override
    public void stateCallBack(int pagination) {
        for (int i = 0, h = 0; i < mQuestionList.size(); i++) {
            TrainingStartBean.DataBean questionEntity = mQuestionList.get(i);
            if (questionEntity.getId() == pagination) {
            } else if (questionEntity.getId() > pagination) {
                break;
            }
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.ly_health_questionaire;
    }

    @Override
    protected void onInitView(Bundle savedInstanceState) {
        scrollView = (ScrollView) rootView.findViewById(R.id.health_question_viewpager_scrollview);
        scrollView.removeAllViews();
    }

    @Override
    protected void onLoadData2Remote() {
        titleNum = getArguments().getInt("titleNum");
        id = getArguments().getString("id");
        age = getArguments().getString("age");
        pagination = getArguments().getInt("pagination");

    }

}
