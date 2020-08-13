package com.example.freightmanagement.Base;

/**
 * Created by LiuHW on 2017/11/24.
 */

public abstract class BaseViewPageFragment<P extends BasePresenter> extends BaseFragment<P> {

    public int getPagination() {
        return 0;
    }
}
