package com.example.freightmanagement.Base;

/**
 * @author: ztc
 * 2019/8/2
 */
public interface Presenter<V> {
    void attachView(V mvpView);

    void detachView();
}
