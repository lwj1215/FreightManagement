package com.example.freightmanagement.Base;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.ResUtils;
import com.example.freightmanagement.Utils.WindowUtils;

public class BaseTitleView extends FrameLayout {
    private ViewGroup mRootView;
    //左侧布局容器
    private LinearLayout mLeftTitleGroup;
    //中间标题
    private TextView mMiddleTitle;
    //右侧布局容器
    private LinearLayout mRightTitleGroup;

    public BaseTitleView(Context context) {
        this(context, null);
    }

    public BaseTitleView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseTitleView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    /**
     * 初始化布局
     */
    private void initView() {
        View.inflate(getContext(), R.layout.base_title_view, this);
        mRootView =  findViewById(R.id.base_activity_title);
        mLeftTitleGroup =  findViewById(R.id.ll_left_title_group);
        mMiddleTitle = findViewById(R.id.tv_left_title);
        mRightTitleGroup =  findViewById(R.id.ll_right_title_group);
    }


    /**
     * 添加右侧文字按钮
     */
    public TextView addRightTextButton(String string, OnClickListener onClickListener) {
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, getDimension(R.dimen.x28));
        textView.setPadding(getDimension(R.dimen.x30), getDimension(R.dimen.x10), getDimension(R.dimen.x10), getDimension(R.dimen.x10));
        textView.setTextColor(getColor(R.color.color_666));
        textView.setGravity(Gravity.CENTER);
        textView.setText(string);
        textView.setOnClickListener(onClickListener);
        mRightTitleGroup.setVisibility(VISIBLE);
        mRightTitleGroup.addView(textView);
        ImageView leftBack = (ImageView) findViewById(R.id.iv_left_back);
        leftBack.setVisibility(VISIBLE);
        leftBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) getContext()).onBackPressed();
            }
        });
        return textView;
    }

    /**
     * 添加左侧文字按钮
     * 注意: 右侧按钮容器添加了一个paddingRight
     * 如果有右侧按钮,使用时需要调一下padding值
     */
    public TextView addLeftTextButton(String string, OnClickListener onClickListener) {
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, getDimension(R.dimen.x26));
        textView.setPadding(getDimension(R.dimen.x30), getDimension(R.dimen.x30), getDimension(R.dimen.x30), getDimension(R.dimen.x30));
        textView.setTextColor(getColor(R.color.color_333));
        textView.setGravity(Gravity.CENTER);
        textView.setText(string);
        textView.setOnClickListener(onClickListener);
        mLeftTitleGroup.setVisibility(VISIBLE);
        mLeftTitleGroup.addView(textView);
        return textView;
    }


    /**
     * 添加右侧图片按钮
     */
    public ImageView addRightImgButton( Drawable drawable, OnClickListener onClickListener) {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams((int)getResources().getDimension(R.dimen.x72), (int)getResources().getDimension(R.dimen.x72)));
       imageView.setPadding(getDimension(R.dimen.x0), getDimension(R.dimen.x0), getDimension(R.dimen.x0), getDimension(R.dimen.x0));
        imageView.setBackgroundResource(R.drawable.title_btn_color_selector);
        imageView.setBackground(drawable);
        imageView.setOnClickListener(onClickListener);
        mRightTitleGroup.setVisibility(VISIBLE);
        mRightTitleGroup.addView(imageView);
        return imageView;
    }

    /**
     * 添加左侧图片按钮
     */
    public ImageView addLeftImgButton(@DrawableRes int id, OnClickListener onClickListener) {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(getDimension(R.dimen.x68), ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setPadding(getDimension(R.dimen.x17), getDimension(R.dimen.x33), getDimension(R.dimen.x17), getDimension(R.dimen.x33));
        imageView.setBackgroundResource(R.drawable.title_btn_color_selector);
        imageView.setImageResource(id);
        imageView.setOnClickListener(onClickListener);
        mLeftTitleGroup.setVisibility(VISIBLE);
        mLeftTitleGroup.addView(imageView);
        return imageView;
    }


    /**
     * 设置左侧标题,默认启用返回按钮
     *
     * @param title 中间标题名称
     */
    public TextView setLeftTitle(String title) {
        return setLeftTitle(title, new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) getContext()).onBackPressed();
            }
        });
    }

    /**
     * 设置左侧标题,默认启用返回按钮
     *
     * @param title 中间标题名称
     */
    public TextView setLeftTitleAndLeftIcon(String title, int leftImg) {
        TextView textView = setLeftTitle(title, new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) getContext()).onBackPressed();
            }
        });
        ImageView leftBack = (ImageView) findViewById(R.id.iv_left_back);
        leftBack.setImageResource(leftImg);
        return textView;
    }

    /**
     * 设置左侧标题,默认启用返回按钮
     *
     * @param title 中间标题名称
     */
    public TextView setLeftTitleAndLeftIcon(String title, int leftImg, int padding) {
        TextView textView = setLeftTitle(title, new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) getContext()).onBackPressed();
            }
        });
        ImageView leftBack = (ImageView) findViewById(R.id.iv_left_back);
        leftBack.setPadding(padding, padding, padding, padding);
        leftBack.setImageResource(leftImg);
        return textView;
    }

    /**
     * 设置左侧标题,默认启用返回按钮
     *
     * @param title 中间标题名称
     */
    public TextView setLeftTitle(String title, OnClickListener onClickListener) {
        View leftBack = findViewById(R.id.iv_left_back);
        TextView leftTitle = (TextView) findViewById(R.id.tv_left_title);
        leftBack.setVisibility(VISIBLE);
        leftTitle.setVisibility(VISIBLE);
        leftTitle.setText(title);
        leftBack.setOnClickListener(onClickListener);
        return leftTitle;
    }

    /**
     * 设置中间标题
     *
     * @param title 中间标题名称
     */
    public TextView setMiddleTitle(String title) {
        mMiddleTitle.setVisibility(VISIBLE);
        mMiddleTitle.setText(title);
        View leftBack = findViewById(R.id.iv_left_back);
        leftBack.setVisibility(GONE);
        return mMiddleTitle;
    }

    /**
     * 设置中间标题
     *
     * @param title 中间标题名称
     * @param bool  是否显示左侧返回键
     * @return 中间标题名称
     */
    public TextView setMiddleTitle(String title, boolean bool) {
        if (bool) {
            return setMiddleTitle(title, new OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((Activity) getContext()).onBackPressed();
                }
            });
        } else {
            return setMiddleTitle(title);
        }
    }

    /**
     * 设置中间标题
     *
     * @param title           中间标题名称
     * @param onClickListener 左侧返回按钮点击事件
     * @return 中间标题名称
     */
    public TextView setMiddleTitle(String title, OnClickListener onClickListener) {
        mMiddleTitle.setVisibility(VISIBLE);
        mMiddleTitle.setText(title);
        View leftBack = findViewById(R.id.iv_left_back);
        leftBack.setVisibility(VISIBLE);
        leftBack.setOnClickListener(onClickListener);
        return mMiddleTitle;
    }

    /**
     * 左侧按钮使用自定义图片
     *
     * @return 左侧按钮
     */
    public ImageView setDefaultBackButtonImage(@DrawableRes int resId) {
        ImageView leftBack = (ImageView) findViewById(R.id.iv_left_back);
        leftBack.setImageResource(resId);
        return leftBack;
    }

    /**
     * 是否显示下方线条
     *
     * @param isShow true 显示 false 不显示
     */
    public void showOrHideBottomLine(boolean isShow) {
        findViewById(R.id.bottom_line).setVisibility(isShow ? VISIBLE : GONE);
    }


    /**
     * 使用自定义布局时,
     * BaseTitleView只负责宽高与背景颜色
     */
    public void useCustomLayout(View view) {
        //移除原有布局
        mRootView.removeAllViews();
        //使用自定义布局
        mRootView.addView(view);
    }

    /**
     * 添加状态栏高度
     */
    public BaseTitleView addStatusBarHeight() {
        mRootView.getLayoutParams().height += WindowUtils.getStatusHeight(getContext());
        mRootView.setPadding(0, WindowUtils.getStatusHeight(getContext()), 0, 0);
        return this;
    }

    public int getTitleHeight() {
        return mRootView.getHeight();
    }

    /**
     * 设置背景颜色
     */
    @Override
    public void setBackgroundColor(@ColorInt int color) {
        mRootView.setBackgroundColor(color);
    }

    /**
     * 获取dimens
     */
    private int getDimension(@DimenRes int id) {
        return ResUtils.getDimen(id);
    }

    /**
     * 获取颜色
     */
    private int getColor(@ColorRes int id) {
        return ResUtils.getColor(id);
    }


}