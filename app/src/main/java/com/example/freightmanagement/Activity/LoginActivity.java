package com.example.freightmanagement.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.Base.BaseResponse;
import com.example.freightmanagement.Bean.TokenBean;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.StringUtils;
import com.example.freightmanagement.Utils.ToastUtils;
import com.example.freightmanagement.enums.AdminTypeEnum;
import com.example.freightmanagement.model.AccountParam;
import com.example.freightmanagement.model.AdminBean;
import com.example.freightmanagement.presenter.LoginPresenter;

import static com.example.freightmanagement.common.Constants.ADMIN_TYPE;
import static com.example.freightmanagement.common.Constants.ID;

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
                accountParam.setType("1");
                mPresenter.login(accountParam);
                break;
        }
    }

    @Override
    public void getDataSuc(TokenBean data) {
        if(data != null){
            TokenBean.DataBean dataBean = data.getData();
            TokenBean.DataBean.UserBean user = dataBean.getUser();
            int driverCertificateId = user.getDriverCertificateId();
            int idcertificateId = user.getIdcertificateId();
            int workCertificateId = user.getWorkCertificateId();
            if(driverCertificateId != 0){
                startActivity(driverCertificateId,MainActivity.class, AdminTypeEnum.DRIVER.getCode());
            }else if(idcertificateId != 0){
                startActivity(idcertificateId,MainActivity.class,AdminTypeEnum.DRIVER.getCode());
            }else if(workCertificateId != 0){
                startActivity(workCertificateId,MainActivity.class,AdminTypeEnum.DRIVER.getCode());
            }else{
                startActivity(new Intent(this,RoleSelectActivity.class));
            }
        }
    }

    @Override
    public void onFailed(String error) {
        ToastUtils.popUpToast("登录失败!");
    }

    @Override
    protected LoginPresenter onInitLogicImpl() {
        return new LoginPresenter();
    }
    private void startActivity(int id,Class<?> cls,int type){
        Intent intent = new Intent(this, cls);
        intent.putExtra(ID,id);
        intent.putExtra(ADMIN_TYPE,type);
        startActivity(intent);
        finish();
    }
}
