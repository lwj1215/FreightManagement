package com.example.freightmanagement.Activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.freightmanagement.Adapter.QuestionnaireAdapter;
import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.Base.BaseViewPageFragment;
import com.example.freightmanagement.Bean.TrainingStartBean;
import com.example.freightmanagement.Bean.VerAddBean;
import com.example.freightmanagement.Bean.WenJuanAnserBean;
import com.example.freightmanagement.Fragment.QuestionnaireFragment;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.DialogUtils;
import com.example.freightmanagement.Utils.StringUtils;
import com.example.freightmanagement.Utils.ToastUtils;
import com.example.freightmanagement.View.HomeWorkViewPager;
import com.example.freightmanagement.presenter.TrainingStartPresenter;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by songdechuan on 2020/8/10.
 */

public class TrainingStartActivity extends BaseActivity<TrainingStartPresenter> implements TrainingStartPresenter.View, View.OnClickListener {
    private HomeWorkViewPager viewPager;
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
    private int currentPage = 1;
    private TextView question_now_number;
    private String wenjuanFlag = "1";
    private List<TrainingStartBean.DataBean> questList;
    private WenJuanAnserBean wenJuanAnserBean = new WenJuanAnserBean();
    private List<WenJuanAnserBean.DriverDataBosBean> mDatas = new ArrayList<>();

    @Override
    public int setLayoutResource() {
        return R.layout.activity_training_start;
    }

    @Override
    protected void onInitView() {
        setDefaultTitle("答题");
        question_now_number = bindView(R.id.health_fillout_questionnare_now_number);//当前页码
        viewPager = bindView(R.id.health_fillout_questionnare_viewpager);
        question_back = bindView(R.id.health_fillout_questionnare_back);
        question_next = bindView(R.id.health_fillout_questionnare_next);
        question_back.setOnClickListener(this);//上一页点击事件
        question_next.setOnClickListener(this);//下一页点击事件
    }

    @Override
    protected void onLoadData2Remote() {
        EventBus.getDefault().register(this);
        mPresenter.getTrainingList();
    }

    @Override
    public void trainingList(List<TrainingStartBean.DataBean> data) {
        this.questList = data;
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
                if (questList.size() != 0) {
//                    checkPhysicalExaminationAnswer();
                    if (currentPage > 1) {
                        currentPage--;
                        jumpReduceViewPager(currentPage);
                    } else {
                        ToastUtils.popUpToast("当前已经是第一道题！");
                    }
                }
                break;

            case R.id.health_fillout_questionnare_next:
                if (questList.size() != 0) {
//                    checkPhysicalExaminationAnswer();
                    if (currentPage < fragmentList.size()) {
                        jumpAddViewPager(currentPage);
                    } else if (StringUtils.isEmpty(wenjuanFlag) || !wenjuanFlag.equals("1")) {
                        //跳转到最后一题时,弹出提交对话框
//                        showCommitSaveDialog();
                    } else {
//                        ToastUtils.popUpToast("问卷已提交,仅供查看!");
                        DialogUtils.showTipsSelectDialog(this, "确认提交？", "取消", "确定", new View.OnClickListener() {

                            @Override
                            public void onClick(View arg0) {

//                                    conversionBeanToJson(2);
                            }
                        }, new View.OnClickListener() {
                            @Override
                            public void onClick(View arg0) {
                                String json = new Gson().toJson(wenJuanAnserBean);
                                mPresenter.subWenJuan(json);
                                finish();
                            }
                        }, true);
                    }
                }
                break;
        }
    }

    private String[] jumpCountArr = null, stateJumpCountArr = null;//跳转题号数据[格式：开始题目_结果题目_总题目数]

    /*ViewPager向上一页*/
    private void jumpReduceViewPager(int currentTopic) {
        BaseViewPageFragment fragment = fragmentList.get(currentTopic);
        jumpCountArr = null;//重置数组
        int beginTopicId = 0;
        for (int h = questList.size() - 1; h >= 0; h--) {
            TrainingStartBean.DataBean questionEntity = questList.get(h);
            if (questionEntity.getIndex() < fragment.getPagination()) {
//                getJumpCountArray(questionEntity, false);
            }
            if (jumpCountArr != null) {
                beginTopicId = questionEntity.getIndex();
                break;
            }
        }

        if (jumpCountArr != null) {
            int firstNum = Integer.parseInt(jumpCountArr[0]);
            int lastNum = Integer.parseInt(jumpCountArr[1]);
            int totalNum = Integer.parseInt(jumpCountArr[2]);
            int currentNum = fragment.getPagination();
            if (totalNum + 1 >= currentNum) {
                if (firstNum == 0 && lastNum == 0) {
                    int jumpCount = totalNum - beginTopicId - 1;
                    currentTopic -= jumpCount;
                } else if (firstNum == fragment.getPagination()) {
                    int jumpCount = firstNum - beginTopicId - 1;
                    currentTopic -= jumpCount;
                }
            }
        }

        viewPager.setCurrentItem(currentTopic - 1, false);
    }

    private void jumpAddViewPager(int currentTopic) {
        boolean hasCompue = true;
        boolean hasCompue1 = true;
        boolean hasCompue2 = true;
        boolean hasCompue3 = true;
        boolean hasCompue4 = true;
        BaseViewPageFragment fragment = fragmentList.get(currentTopic - 1);
        for (int h = 0; h < questList.size(); h++) {
            TrainingStartBean.DataBean questionEntity = questList.get(h);

            if (questionEntity.getIndex() == fragment.getPagination()) {
                if (hasCompue1 & hasCompue2 & hasCompue3 & hasCompue4) {
                    hasCompue = true;
                } else {
                    hasCompue = false;
                }


                if (!hasCompue) {
                    if (fragment instanceof QuestionnaireFragment)
                        ((QuestionnaireFragment) fragment).stateCallBack(fragment.getPagination());
                    ToastUtils.popUpToast("当前页面题目未做完!");
                    return;
                }
                //获取数据是否需要根据选项来跳转各题
//                getJumpCountArray(questionEntity, false);

            } else if (questionEntity.getIndex() > fragment.getPagination()) {
                break;
            }
        }
        //分析跳转页数
        if (jumpCountArr != null) {
            int firstNum = Integer.parseInt(jumpCountArr[0]);
            int lastNum = Integer.parseInt(jumpCountArr[1]);
            int totalNum = Integer.parseInt(jumpCountArr[2]);
            if (fragment.getPagination() < firstNum) {
                int jumpCount = firstNum - fragment.getPagination() - 1;
                currentTopic += jumpCount;
            } else if (fragment.getPagination() == lastNum) {
                int jumpCount = totalNum - lastNum - 1;
                currentTopic += jumpCount;
            } else if (firstNum == 0 && lastNum == 0 && totalNum > fragment.getPagination()) {
                int jumpCount = totalNum - fragment.getPagination() - 1;
                currentTopic += jumpCount;
            }
        }
        if (hasCompue) {
            viewPager.setCurrentItem(currentTopic, false);
        }

    }

    private List<Integer> mPagers = new ArrayList<>();//页

    /**
     * 显示页面页数标题
     */
    private void showPageNumTitle() {
        question_now_number.setText(currentPage + "");
        showPageText();
    }

    /*分不同类型  创建不同的Fragment*/
    private void createFragmentList(List<TrainingStartBean.DataBean> data) {
        fragmentList = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            BaseViewPageFragment baseFragment = null;
            switch (data.get(i).getType()) {
                case 1:
                case 2:
                    baseFragment = QuestionnaireFragment.newInstance(data, i + 1, data.get(i).getIndex());
                    break;
            }
            fragmentList.add(baseFragment);
            mPagers.add(data.get(i).getIndex());
        }
    }

    /**
     * 根据页面显示上一页下一页
     */
    private void showPageText() {
        if (currentPage == 1) {
            question_back.setText("上一页");
            question_next.setText("下一页");
            question_next.setBackgroundResource(R.drawable.yuanjiao20);
            question_next.setTextColor(getResources().getColor(R.color.white));
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
            question_next.setText("提交");
            question_next.setBackgroundResource(R.drawable.yuanjiao20);
            question_next.setTextColor(getResources().getColor(R.color.blue_079EEB));
        }
    }

    @Subscribe
    public void onEventMainThread(WenJuanAnserBean.DriverDataBosBean event) {
        mDatas.add(event);
        wenJuanAnserBean.setDriverDataBos(mDatas);
    }

    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
}