package com.example.freightmanagement.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.R;
import com.example.freightmanagement.presenter.LogPresenter;

public class SignUpActivity extends BaseActivity<LogPresenter> implements  LogPresenter.View,View.OnClickListener {

    @Override
    public int setLayoutResource() {
        return R.layout.activity_sign_up;
    }

    @Override
    protected void onInitView() {
        bindView(R.id.tv_srue).setOnClickListener(this);
    }

    @Override
    protected void onLoadData2Remote() {
     mPresenter.getCode();//调用
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_srue:
                startActivity(new Intent(this,MainActivity.class));
                finish();
                break;
        }
    }

    @Override
    public void getDataSuc() {//请求成功回调

    }

    @Override
    protected LogPresenter onInitLogicImpl() {//实例化p层
        return new LogPresenter();
    }
}
