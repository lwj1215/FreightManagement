package com.example.freightmanagement.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.StringUtils;
import com.example.freightmanagement.Utils.ToastUtils;
import com.example.freightmanagement.enums.RoleTypeEnum;
import com.example.freightmanagement.model.AccountParam;
import com.example.freightmanagement.presenter.LoginPresenter;

/**
 * Created by songdechuan on 2020/8/6.
 */

public class LoginActivity extends BaseActivity<LoginPresenter> implements  LoginPresenter.View,View.OnClickListener {
    /**
     * 请输入手机号
     */
    private EditText mEdtTxtYzmImg;
    /**
     * 请输入验证码
     */
    private EditText mEdtTxtPasswordPhone;
    /**
     * 注册账号
     */
    private TextView mTvRegister;
    /**
     * 忘记密码
     */
    private TextView mTvForget;
    /**
     * 登录
     */
    private TextView mTvSrue;

    @Override
    public int setLayoutResource() {
        return R.layout.activity_login;
    }

    @Override
    protected void onInitView() {
        initView();

    }

    @Override
    protected void onLoadData2Remote() {

    }


    public void initView() {
        mEdtTxtYzmImg = (EditText) findViewById(R.id.edtTxt_yzm_img);
        mEdtTxtPasswordPhone = (EditText) findViewById(R.id.edtTxt_password_phone);
        mTvRegister = (TextView) findViewById(R.id.tv_register);
        mTvRegister.setOnClickListener(this);
        mTvForget = (TextView) findViewById(R.id.tv_forget);
        mTvForget.setOnClickListener(this);
        mTvSrue = (TextView) findViewById(R.id.tv_srue);
        mTvSrue.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_register:
                startActivity(this,RegisterActivity.class);
                break;
            case R.id.tv_forget:
                startActivity(this,ForgetPasswordActivity.class);
                break;
            case R.id.tv_srue:
                String tel = mEdtTxtYzmImg.getText().toString();
                if(StringUtils.isEmpty(tel)){
                    ToastUtils.popUpToast(R.string.tel_cannot_be_empty);
                    return;
                }
                String password = mEdtTxtPasswordPhone.getText().toString();
                if(StringUtils.isEmpty(password)){
                    ToastUtils.popUpToast(R.string.password_cannot_be_empty);
                    return;
                }
                tel = tel.trim();
                password = password.trim();
                AccountParam accountParam = new AccountParam();
                accountParam.setPass(password);
                accountParam.setTel(tel);
                mPresenter.login(accountParam);
                break;
        }
    }

    @Override
    public void getDataSuc() {
        startActivity(this,MainActivity.class);
    }

    @Override
    public void onFailed(String error) {
        ToastUtils.popUpToast(error);
//                int code = 3;
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
    }

    @Override
    protected LoginPresenter onInitLogicImpl() {
        return new LoginPresenter();
    }
}
