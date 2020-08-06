package com.example.freightmanagement.Base;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

//import com.bumptech.glide.Glide;
import com.example.freightmanagement.R;

public class BaseDefaultView extends LinearLayout {

    //异常界面一个状态信息文本,和一个状态说明,重新加载当前页面接口
    private TextView base_tv_tips_state;
    private TextView base_tv_tips_state_explain;
    private TextView basic_tv_tips_try_again;

    //头布局  空页面,无数据页面,异常页面,内容（当前正常画面）页面
    private View mTitleLayout, mEmptyView, mNoDataView, mAbnormalView, mMainView;
    private FrameLayout frameLayout;
    private int mViewStateCode = 0;
    private TextView mTvNoDataStateExplain;
    //是否存在头部View现在出来，下面再显示三种状态
    private View mTopLayout;

    public BaseDefaultView(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        setOrientation(VERTICAL);
        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        frameLayout = new FrameLayout(getContext());
        addView(frameLayout, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 1));

        LayoutInflater layoutInflater = LayoutInflater.from(getContext());

        //初始为loading页面
        mEmptyView = layoutInflater.inflate(R.layout.base_empty_view, null);
        ImageView  progress_view= mEmptyView.findViewById(R.id.progress_view);
        Animation animation = AnimationUtils.loadAnimation(BaseApplication.getApp(), R.anim.rotate);
        LinearInterpolator lin = new LinearInterpolator();//设置动画匀速运动
        animation.setInterpolator(lin);
        //让旋转动画一直转，不停顿的重点
        animation.setRepeatCount(-1);
        progress_view.startAnimation(animation);
//        Glide.with(getContext()).load(R.mipmap.loading).into(progress_view);

        //没有数据页面
        mNoDataView = layoutInflater.inflate(R.layout.base_no_data_view, null);
        mTvNoDataStateExplain = (TextView) mNoDataView.findViewById(R.id.tv_no_data_state_explain);
        mNoDataView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnRefreshListener.onTryAgainData();
            }
        });

        //网络异常或则请求数据失败
        mAbnormalView = layoutInflater.inflate(R.layout.base_abnormal_view, null);
        base_tv_tips_state = (TextView) mAbnormalView.findViewById(R.id.base_tv_tips_state);
        base_tv_tips_state_explain = (TextView) mAbnormalView.findViewById(R.id.base_tv_tips_state_explain);
        basic_tv_tips_try_again = (TextView) mAbnormalView.findViewById(R.id.basic_tv_tips_try_again);
        basic_tv_tips_try_again.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (mViewStateCode == BaseDefaultViewCode.NET_ERROR) {
//                    Intent intent = new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS);
//                    view.getContext().startActivity(intent);
//                } else if (mViewStateCode == BaseDefaultViewCode.DATA_ERROR) {
                mOnRefreshListener.onTryAgainData();
//                }
            }
        });
    }

    public void setContentView(int contentView) {
        mMainView = LayoutInflater.from(getContext()).inflate(contentView, frameLayout);
    }

    /**
     * 动态设置初始空页面开始加载
     *
     * @return mEmptyView
     */
    public View setAddLoadingView() {
        frameLayout.addView(mEmptyView);
        mEmptyView.setVisibility(GONE);
        return mEmptyView;
    }

    /**
     * 动态设置无数据页面(默认)
     *
     * @return mNoDataView
     */
    public View setAddNoDataView() {
        frameLayout.addView(mNoDataView);
        mNoDataView.setVisibility(GONE);
        return mNoDataView;
    }

    /**
     * 动态设置无数据页面
     *
     * @param noDataContent textView 自定义内容
     * @return mNoDataView
     */
    public View setAddNoDataView(String noDataContent) {
        if (noDataContent != null) {
            mTvNoDataStateExplain.setText(noDataContent);
        }
        frameLayout.addView(mNoDataView);
        mNoDataView.setVisibility(GONE);
        return mNoDataView;
    }

    /**
     * 动态设置数据异常页面（默认值）
     *
     * @return mAbnormalView
     */
    private void addAbnormalView() {
        frameLayout.addView(mAbnormalView);
        mAbnormalView.setVisibility(GONE);
    }

    public View setAddAbnormalView() {
        addAbnormalView();
        return mAbnormalView;
    }

    /**
     * 动态设置数据异常页面（改变文本）
     *
     * @param abnormalTopContent 设置上面textView 自定义内容
     * @return mAbnormalView
     */
    public View setAddAbnormalView(String abnormalTopContent) {
        if (abnormalTopContent != null) {
            base_tv_tips_state.setText(abnormalTopContent);
        }
        addAbnormalView();
        return mAbnormalView;
    }

    /**
     * 动态设置数据异常页面（改变文本）
     *
     * @param abnormalTopContent    设置上面textView 自定义内容
     * @param AbnormalBottomContent 设置下面textView 自定义内容
     * @return mAbnormalView
     */
    public View setAddAbnormalView(String abnormalTopContent, String AbnormalBottomContent) {
        if (abnormalTopContent != null) {
            base_tv_tips_state.setText(abnormalTopContent);
        }
        if (AbnormalBottomContent != null) {
            base_tv_tips_state_explain.setText(AbnormalBottomContent);
        }
        addAbnormalView();
        return mAbnormalView;
    }

    private OnTryRefreshListener mOnRefreshListener;

    public void setNoDateText(String noDateText) {
//        throw new RuntimeException("修改提示信息");
    }

    public interface OnTryRefreshListener {
        void onTryAgainData();
    }

    public void setOnTryTRefreshListener(OnTryRefreshListener onRefreshListener) {
        this.mOnRefreshListener = onRefreshListener;
    }

    /**
     * 默认先显示空布局（网络请求完后无数据）
     *
     * @param viewStateCode 当前页面状态Code
     */
    public void selectView(@BaseDefaultViewCode int viewStateCode) {
        this.mViewStateCode = viewStateCode;

        mEmptyView.setVisibility(GONE);
        mNoDataView.setVisibility(GONE);
        mAbnormalView.setVisibility(GONE);

        if (viewStateCode == BaseDefaultViewCode.DATA_NORMAL) {
            mMainView.setVisibility(VISIBLE);
        }
        if (viewStateCode == BaseDefaultViewCode.DATA_LOADING) {//空页面+loading
            mEmptyView.setVisibility(VISIBLE);
        }
        if (viewStateCode == BaseDefaultViewCode.DATA_NULL) {//空数据页面，可以重新请求
            mNoDataView.setVisibility(VISIBLE);
        }
        if (viewStateCode == BaseDefaultViewCode.NET_ERROR ||
                viewStateCode == BaseDefaultViewCode.DATA_ERROR) {//网络异常，去手机系统设置网络 ||数据异常，重新加载
            mAbnormalView.setVisibility(VISIBLE);
        }
    }

    /**
     * 添加title布局下方的Tab一直显示
     *
     * @param topLayout
     */
    private void addTopLayout(View topLayout) {
        this.mTopLayout = topLayout;
    }

    /**
     * 添加title布局和Tab一直显示布局
     *
     * @param topLayout
     */
    final public View setAddTopLayout(int topLayout) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        View top_Layout = LayoutInflater.from(getContext()).inflate(topLayout, this, false);
        linearLayout.setLayoutParams(lp);
        linearLayout.addView(top_Layout);
        addView(linearLayout, 0);
        addTopLayout(top_Layout);
        return top_Layout;
    }

    /**
     * 添加title布局和Tab一直显示布局
     * 注意：如果需要添加Tab一直显示需要在方法之前addTopLayout(View)进入，不需要就不用调用
     *
     * @param titleLayout
     */
    private void addTitleAndTopLayout(View titleLayout, View topLayout) {
        this.mTitleLayout = titleLayout;
        this.mTopLayout = topLayout;
        addView(mTitleLayout, 0);
        if (topLayout != null) {
            addView(topLayout, 1);
        }
    }

    /**
     * 获取无包装并且添加进去的title
     * 注意：如果需要添加Tab一直显示需要在方法之前addTopLayout(View)进入
     */
    final public BaseTitleView setDefaultTitle() {
        BaseTitleView defaultTitle = TitleView.getTitle(getContext());
        addTitleAndTopLayout(defaultTitle, mTopLayout);
        return defaultTitle;
    }

    /**
     * 带返回按钮的title
     * 注意：如果需要添加Tab一直显示需要在方法之前addTopLayout(View)进入
     *
     * @param title
     */
    final public BaseTitleView setDefaultTitle(String title, OnClickListener onClickListener) {
        BaseTitleView defaultTitle = setDefaultTitle();
        defaultTitle.setLeftTitle(title, onClickListener);
        return defaultTitle;
    }

    /**
     * 带返回按钮的title
     * 注意：如果需要添加Tab一直显示需要在方法之前addTopLayout(View)进入
     *
     * @param title
     */
    final public BaseTitleView setDefaultTitle(String title) {
        BaseTitleView defaultTitle = setDefaultTitle();
        defaultTitle.setLeftTitle(title);
        return defaultTitle;
    }

    /**
     * 带返回按钮的title
     * 注意：如果需要添加Tab一直显示需要在方法之前addTopLayout(View)进入
     *
     * @param title
     */
    final public BaseTitleView setDefaultTitle(String title, final Activity activity) {
        BaseTitleView defaultTitle = setDefaultTitle();
        defaultTitle.setLeftTitle(title, new OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.onBackPressed();
            }
        });
        return defaultTitle;
    }

}