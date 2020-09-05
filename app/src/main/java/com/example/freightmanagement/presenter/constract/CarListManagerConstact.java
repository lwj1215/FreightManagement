package com.example.freightmanagement.presenter.constract;

import com.example.freightmanagement.Base.BaseView;
import com.example.freightmanagement.model.CarExecuteParam;

import java.io.File;
import java.util.List;

/**
 * Created by songdechuan on 2020/8/13.
 */

public interface CarListManagerConstact {

    void getList();

    void delete(List<Integer> ids);

    interface View extends BaseView {
        void carListResult(String msg);

        void delResult(String json);

    }
}
