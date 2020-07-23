package com.example.freightmanagement.Base;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.ClickUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


/**
 * @author: ztc
 * 2019/8/5
 */

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView, View.OnClickListener {
    private static final String TAG = BaseFragment.class.getSimpleName();

    protected abstract int getLayoutResource();

    protected abstract void onInitView(Bundle savedInstanceState);

    protected abstract void onLoadData2Remote();

    protected BaseDefaultView rootView;
    protected Activity mContext = null;
    protected Activity activity;
    private Dialog mDialog;
    protected P mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.activity = getActivity();
        this.mContext = getActivity();
        mPresenter = onInitLogicImpl();
        if (mPresenter != null) mPresenter.attachView(this);
        initDialog();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onLoadData2Remote();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = new BaseDefaultView(mContext);
        rootView.setContentView(getLayoutResource());
        onInitView(savedInstanceState);
        return rootView;
    }

    /**
     * 三种不同的View切换
     *
     * @param viewStateCode 详情请看注解说明
     */
    protected void selectView(@BaseDefaultViewCode int viewStateCode) {
        rootView.selectView(viewStateCode);
        rootView.setOnTryTRefreshListener(new BaseDefaultView.OnTryRefreshListener() {
            @Override
            public void onTryAgainData() {
                onLoadData2Remote();
            }
        });
    }

    /**
     * 初始添加三种不同状态的
     */
    protected void setThreeDefaultView() {
        setDefaultLoadingtView();
        setDefaultNoDataView();
        setDefaultAbnormalView();
    }

    protected View setDefaultLoadingtView() {
        return rootView.setAddLoadingView();
    }

    protected View setDefaultNoDataView() {
        return rootView.setAddNoDataView();
    }

    protected View setDefaultNoDataView(String noDataContent) {
        return rootView.setAddNoDataView(noDataContent);
    }

    protected View setDefaultAbnormalView() {
        return rootView.setAddAbnormalView();
    }

    protected View setDefaultAbnormalView(String abnormalTopContent) {
        return rootView.setAddAbnormalView(abnormalTopContent);
    }

    protected View setDefaultAbnormalView(String abnormalTopContent, String AbnormalBottomContent) {
        return rootView.setAddAbnormalView(abnormalTopContent, AbnormalBottomContent);
    }

    /**
     * 获取无包装并且添加进去的title
     */
    protected BaseTitleView setDefaultTitle() {
        return rootView.setDefaultTitle();
    }

    /**
     * 带返回按钮的title
     *
     * @param title
     */
    protected BaseTitleView setDefaultTitle(String title) {
        return rootView.setDefaultTitle(title, activity);
    }

    /**
     * 带返回按钮的title
     *
     * @param title
     */
    protected BaseTitleView setDefaultTitle(String title, View.OnClickListener onClickListener) {
        return rootView.setDefaultTitle(title, onClickListener);
    }

    /**
     * 带TopLayout一直上方显示
     * @param topLayout
     */
    protected View setDefaultTop(int topLayout) {
        return rootView.setAddTopLayout(topLayout);
    }

    protected <T extends View> T bindView(@IdRes int id) {
        View viewById = rootView.findViewById(id);
        return (T) viewById;
    }

    /**
     * 子类实现此方法处理点击事件
     *
     * @param v
     * @param id
     */
    public void onClick(View v, int id) {
    }

    @Override
    public void onClick(View v) {
        if (ClickUtils.isClick()) {
            onClick(v, v.getId());
        }
    }


    @Override
    public void onDestroy() {
        hideLoading();
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        if (mPresenter != null && mPresenter.isViewBind()) {
            mPresenter.detachView();
        }
        super.onDetach();
    }

    private void initDialog() {
        mDialog = new Dialog(mContext, R.style.refresh_dialog);
        RelativeLayout refresh_dialog = (RelativeLayout) LayoutInflater.from(mContext).inflate(R.layout.refresh_dialog, null);
        RelativeLayout.LayoutParams layoutParams =   new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        mDialog.setContentView(refresh_dialog,layoutParams);
        mDialog.setCanceledOnTouchOutside(false);
    }

    @Override
    public void showLoading() {
        try {
            mDialog.show();
        } catch (Exception e) {
            Log.e(getClass().getSimpleName(), "showLoading: ", e);
        }
    }

    @Override
    public void hideLoading() {
        try {
            mDialog.dismiss();
        } catch (Exception e) {
            Log.e(getClass().getSimpleName(), "hideLoading: ", e);
        }
    }

    /**
     * 自动生成 presenter , 需要无参构造方法(测试)
     */
    protected P onInitLogicImpl() {
        try {
            Type genericSuperclass = getClass().getGenericSuperclass();
            while (true) {
                if (genericSuperclass instanceof Class) {
                    genericSuperclass = ((Class) genericSuperclass).getGenericSuperclass();
                } else {
                    break;
                }
            }
            if (genericSuperclass instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    if (actualTypeArgument instanceof Class) {
                        Class aClass = (Class) actualTypeArgument;
                        if (BasePresenter.class.isAssignableFrom(aClass)) {
                            return (P) aClass.newInstance();
                        }
                    }
                }
            }
            Log.e(TAG, getClass().getName() + " 没有使用presenter");
        } catch (Throwable e) {
            Log.e(TAG, getClass().getName() + " " + e.getMessage());
        }
        return null;
    }

}
