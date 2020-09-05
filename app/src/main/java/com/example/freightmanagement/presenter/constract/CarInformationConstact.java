package com.example.freightmanagement.presenter.constract;

import com.example.freightmanagement.Base.BaseView;
import com.example.freightmanagement.Bean.CarInfoBean;


/**
 * Created by songdechuan on 2020/8/6.
 */

public interface CarInformationConstact {


    void getTestList(int id);

    interface View extends BaseView{

        void testResult(CarInfoBean carInfoBean);

    }
}
