package com.example.freightmanagement.Activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.collection.ArraySet;
import androidx.fragment.app.Fragment;

import com.example.freightmanagement.Adapter.QuestionnaireAdapter;
import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.Base.BaseViewPageFragment;
import com.example.freightmanagement.Bean.TrainingSelectBean;
import com.example.freightmanagement.Fragment.QuestionnaireFragment;
import com.example.freightmanagement.R;
import com.example.freightmanagement.View.HomeWorkViewPager;
import com.example.freightmanagement.presenter.TrainingSelectPresenter;
import com.example.freightmanagement.presenter.constract.TrainingSelectConstact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by songdechuan on 2020/8/10.
 */

public class TrainingStartActivity extends BaseActivity<TrainingSelectPresenter> implements TrainingSelectPresenter.View, View.OnClickListener {
    private HomeWorkViewPager viewPager;
    private ArraySet<TrainingSelectBean.DataBean> answerList;
    /**
     * 上一页
     */
    private Button question_back;
    /**
     * 下一页
     */
    private Button question_next;
    private QuestionnaireAdapter pagerAdapter;
    private ArrayList<BaseViewPageFragment> fragmentList;
    private int currentPage=1;
    private TextView question_now_number;
    private String wenjuanFlag="1";

    @Override
    public int setLayoutResource() {
        return R.layout.activity_training_start;
    }

    @Override
    protected void onInitView() {
        question_now_number = bindView(R.id.health_fillout_questionnare_now_number);//当前页码
        viewPager = bindView(R.id.health_fillout_questionnare_viewpager);
        question_back = bindView(R.id.health_fillout_questionnare_back);
        question_next = bindView(R.id.health_fillout_questionnare_next);
        question_back.setOnClickListener(this);//上一页点击事件
        question_next.setOnClickListener(this);//下一页点击事件
    }

    @Override
    protected void onLoadData2Remote() {
        mPresenter.getTrainingList();
    }

    @Override
    public void trainingList(List<TrainingSelectBean.DataBean> data) {
        createFragmentList(data);
        pagerAdapter = new QuestionnaireAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(pagerAdapter);
        // 将数据页面缓存出来
        viewPager.setOffscreenPageLimit(1);
        viewPager.setScrollable(false);
        viewPager.setChangeViewCallback(new HomeWorkViewPager.ChangeViewCallback() {



            @Override
            public void getCurrentPageIndex(int index) {
                currentPage = index + 1;
                showPageNumTitle();
            }

            @Override
            public void changeView(boolean left, boolean right) {
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.health_fillout_questionnare_back:
                break;

            case R.id.health_fillout_questionnare_next:
                break;
        }
    }
    private List<Integer> mPagers = new ArrayList<>();//页
    /*分不同类型  创建不同的Fragment*/
    private void createFragmentList(List<TrainingSelectBean.DataBean> data) {
        fragmentList = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            BaseViewPageFragment baseFragment = null;
            switch (data.get(i).getType()) {
                case 1:
                case 2:
                    baseFragment = QuestionnaireFragment.newInstance(data, i + 1, data.get(i).getId());
                    break;
            }
            fragmentList.add(baseFragment);
            mPagers.add(data.get(i).getId());
        }
    }
    /**
     * 显示页面页数标题
     */
    private void showPageNumTitle() {
        question_now_number.setText(currentPage + "");
        showPageText();
    }

    /**
     * 根据页面显示上一页下一页
     */
    private void showPageText() {
        if (currentPage == 1) {
            question_back.setText("上一页");
            question_back.setBackgroundResource(R.drawable.yuanjiao20);
            question_back.setTextColor(getResources().getColor(R.color.color_333));
        } else if (currentPage > 1 && currentPage < fragmentList.size()) {
            question_back.setText("上一页");
            question_back.setBackgroundResource(R.drawable.yuanjiao20);
            question_back.setTextColor(getResources().getColor(R.color.white));

            question_next.setText("下一页");
            question_next.setBackgroundResource(R.drawable.yuanjiao20);
            question_next.setTextColor(getResources().getColor(R.color.white));
        } else if (currentPage == fragmentList.size()) {
            if (wenjuanFlag.equals("1") || wenjuanFlag.equals("2")) {
                question_next.setText("下一页");
                question_next.setBackgroundResource(R.drawable.yuanjiao20);
                question_next.setTextColor(getResources().getColor(R.color.white));
            } else {
                question_next.setText("下一页");
                question_next.setBackgroundResource(R.drawable.yuanjiao20);
                question_next.setTextColor(getResources().getColor(R.color.blue_079EEB));
            }


        }
    }
}
