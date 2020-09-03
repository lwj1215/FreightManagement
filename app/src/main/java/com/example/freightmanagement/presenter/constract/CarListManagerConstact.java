package com.example.freightmanagement.presenter.constract;

import com.example.freightmanagement.Base.BaseView;
import com.example.freightmanagement.model.CarExecuteParam;

import java.io.File;

/**
 * Created by songdechuan on 2020/8/13.
 */

public interface CarListManagerConstact {

    void getList();

    void delete(CarExecuteParam param);

    interface View extends BaseView {
        void success(String url, int type);

        void delResult(String json);

    }
}
