package com.example.freightmanagement.presenter.constract;

import com.example.freightmanagement.Base.BaseView;
import com.example.freightmanagement.model.CarExecuteParam;

/**
 * Created by songdechuan on 2020/8/13.
 */

public interface DriverListConstact {

    void getList();

    void delete(CarExecuteParam param);

    interface View extends BaseView {
        void success(String msg);

        void delResult(String json);

    }
}
