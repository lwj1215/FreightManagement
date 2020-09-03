package com.example.freightmanagement.presenter.constract;

import com.example.freightmanagement.Base.BaseView;
import com.example.freightmanagement.model.CarBo;

import java.io.File;

/**
 * Created by songdechuan on 2020/8/13.
 */

public interface CarAddConstact {

    void upload(File file, int type);

    void submit(CarBo carBo);

    interface View extends BaseView {
        void imageUrl(String url, int type);
        void submitResult(String msg);

    }
}
