package com.example.freightmanagement.View;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.freightmanagement.Adapter.QusetionnaireAdapter;
import com.example.freightmanagement.Bean.TrainingSelectBean;
import com.example.freightmanagement.Fragment.QuestionnaireFragment;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.FullyGridLayoutManager;
import com.example.freightmanagement.Utils.RadioCallBack;

/**
 * 普通问卷页面
 */
public class QuestionnaireContentView extends View  {

    private String mAge;
    private Context context;
    private Activity mActivity;
    private TextView question;
    private ScrollView scrollView;
    /*问卷及答案实体*/
    private TrainingSelectBean.DataBean questionEntity;
    /*题目序号*/
    private int titleNum;

    //切换下一页回调
    private QuestionnaireFragment fragment;
    private LayoutInflater inflater;
    /*选项到底部的距离*/
    private String id;// 问卷id
    private RecyclerView mRecyclerView;
    private View mView;
    private TextView mCurrentQuestionNumText;
    private int age;
//    private List<NewHealthAnswerAll> answerList;
    private EditText editText;

    private QuestionnaireContentView(Context context) {
        super(context);
        this.context = context;
    }

    public QuestionnaireContentView(TrainingSelectBean.DataBean questionEntity, int titleNum, String id, String mage, Activity activity, RadioCallBack callBack,
                                    QuestionnaireFragment fragment) {
        super(activity);
//        String birthDate = PrefUtilsData.getBirthDate();
        this.questionEntity = questionEntity;
        this.titleNum = titleNum;
        this.id = id;
        this.mAge = mage;
        mActivity = activity;
        this.fragment = fragment;
        if (TextUtils.isEmpty(mAge)) {
            age = 18;
        } else {
            age = Integer.parseInt(mAge);
        }
        mView = initView();
        initData();
    }

    public void initData() {
        mRecyclerView = new RecyclerView(mActivity);
        mRecyclerView.setLayoutManager(new FullyGridLayoutManager(mActivity, 2));
//        answerList = questionEntity.getValuelist();
        showViewDatas();
    }

    public View initView() {
        inflater = LayoutInflater.from(mActivity);
        View view = inflater.inflate(R.layout.health_questionnaire_layout, null);
        question = (TextView) view.findViewById(R.id.health_fillout_question_one_viewpager_question);
        scrollView = (ScrollView) view.findViewById(R.id.health_fillout_question_one_viewpager_scrollview);
        scrollView.removeAllViews();
        return view;
    }

    /*显示页面元素*/
    private void showViewDatas() {
        question.setText("Q" + String.valueOf(titleNum) + ": " + questionEntity.getId());
        createMoreEditTextView();

    }


    /*3*/
    private void createMoreEditTextView() {
        View view3 = LayoutInflater.from(getContext()).inflate(R.layout.item_health_questionnaire2, null);
        ListView listView = (ListView) view3.findViewById(R.id.listView);
        QusetionnaireAdapter listAdapter = new QusetionnaireAdapter(getContext());
        listView.setAdapter(listAdapter);
//        listAdapter.setData(answerList);
        scrollView.addView(view3);
    }


    /*保存单选题、多选题答案*/
    private void saveCurrentSelectValue(String value, String answerName) {
//        List<NewHealthAnswerAll> answerList = questionEntity.getValuelist();
//        for (int i = 0; i < answerList.size(); i++) {
//            NewHealthAnswerAll answerEntity = answerList.get(i);
//            if (answerEntity.getBean_name().equals(answerName)) {
//                answerEntity.setAnswerValue(value);
//            }
//
//        }

    }

    /* 获取当前View*/
    public View getCurrentView() {
        return mView;
    }

}
