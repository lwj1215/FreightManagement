package com.example.freightmanagement.Activity;


import android.content.Intent;
import android.view.View;

import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.R;
import com.example.freightmanagement.presenter.LoginPresenter;

public class SignUpActivity extends BaseActivity<LoginPresenter> implements  LoginPresenter.View,View.OnClickListener {

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
//        int code = 3;
//        RoleTypeEnum roleTypeEnum = RoleTypeEnum.find(code);
//        switch (roleTypeEnum){
//            case COMPANY:
//                break;
//            case CAR_OWNER:
//                break;
//            case DRIVER:
//                break;
//            default:
//                startActivity(new Intent(this,RoleSelectActivity.class));
//                break;
//        }

//     mPresenter.getCode();//调用
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
    public void onFailed(String error) {

    }

    @Override
    protected LoginPresenter onInitLogicImpl() {//实例化p层
        return new LoginPresenter();
    }
}
