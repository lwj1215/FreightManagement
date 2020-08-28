package com.example.freightmanagement.presenter.constract;

import com.example.freightmanagement.Base.BaseView;


/**
 * Created by songdechuan on 2020/8/6.
 */

public interface WeiXiuConstact {

    void addWeiXiu(String json);

    void getTestList(int id);

    interface View extends BaseView{

        void mSuc();

        void testResult(String msg);

    }
}
