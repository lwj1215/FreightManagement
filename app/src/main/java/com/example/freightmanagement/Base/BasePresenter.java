package com.example.freightmanagement.Base;

/**
 * @author: ztc
 * 2019/8/2
 */
public abstract class BasePresenter<V extends BaseView> implements Presenter<V> {

    protected V mView;

    @Override
    public void attachView(V mvpView) {
        this.mView = mvpView;
    }

    @Override
    public void detachView() {
        this.mView = null;
    }

    public boolean isViewBind() {
        return mView != null;
    }


    public V getView() {
        return mView;
    }
}
