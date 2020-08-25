package com.example.freightmanagement.presenter.constract;


import com.example.freightmanagement.Base.BaseView;
import com.example.freightmanagement.Bean.CheliangByBean;
import com.example.freightmanagement.Bean.CheliangJcBean;
import com.example.freightmanagement.Bean.CheliangWeiXiuBean;

import java.util.List;

public interface CheLiangJcConstact {

    /**
     * 获取驾驶员信息
     *
     * @param
     */
    void getData1();

    void getData2();

    void getData3();

    interface View extends BaseView {

        /**
         * 回调成功
         * @param
         * @param
         * @param
         * @param
         * @param data
         */
        void getData1Suc(List<CheliangJcBean.DataBean> data);

        void getData2Suc(List<CheliangWeiXiuBean.DataBean> data);

        void getData3Suc(List<CheliangByBean.DataBean> data);

        void onFailed(String error);
    }
}
