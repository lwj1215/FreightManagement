package com.example.freightmanagement.Activity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.Bean.TokenBean;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.PrefUtilsData;
import com.example.freightmanagement.Utils.StringUtils;
import com.example.freightmanagement.Utils.ToastUtils;
import com.example.freightmanagement.enums.AdminTypeEnum;
import com.example.freightmanagement.model.AccountParam;
import com.example.freightmanagement.presenter.LoginPresenter;
import com.google.gson.Gson;

import java.util.Map;

import static com.example.freightmanagement.common.Constants.ADMIN_TYPE;

/**
 * Created by songdechuan on 2020/8/6.
 */

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginPresenter.View, View.OnClickListener, RadioGroup.OnCheckedChangeListener {
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
    /**
     * 驾驶员
     */
    private RadioButton mLoginRb1;
    /**
     * 车主
     */
    private RadioButton mLoginRb2;
    /**
     * 企业
     */
    private RadioButton mLoginRb3;
    private RadioGroup mLoginRg;
    private String type = "1";
    private int code = 1;

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
        mLoginRb1 = (RadioButton) findViewById(R.id.login_rb1);
        mLoginRb2 = (RadioButton) findViewById(R.id.login_rb2);
        mLoginRb3 = (RadioButton) findViewById(R.id.login_rb3);
        mLoginRg = (RadioGroup) findViewById(R.id.login_rg);
        mLoginRg.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_register:
                startActivity(this, RegisterActivity.class);
                break;
            case R.id.tv_forget:
                startActivity(this, ForgetPasswordActivity.class);
                break;
            case R.id.tv_srue:
                String tel = mEdtTxtYzmImg.getText().toString();
                if (StringUtils.isEmpty(tel)) {
                    ToastUtils.popUpToast(R.string.tel_cannot_be_empty);
                    return;
                }
                String password = mEdtTxtPasswordPhone.getText().toString();
                if (StringUtils.isEmpty(password)) {
                    ToastUtils.popUpToast(R.string.password_cannot_be_empty);
                    return;
                }
                tel = tel.trim();
                password = password.trim();
                AccountParam accountParam = new AccountParam();
                accountParam.setPass(password);
                accountParam.setTel(tel);
                accountParam.setType(type);
                mPresenter.login(accountParam);
                PrefUtilsData.setType(type);
                break;
        }
    }

    @Override
    public void getDataSuc(TokenBean data) {
        if (data != null) {
            TokenBean.DataBean dataBean = data.getData();
            TokenBean.DataBean.UserBean user = dataBean.getUser();
            int type = dataBean.getType();
            switch (type){
                case 0:
                    if(this.code == 1){
                        startActivity(DriverConfigActivity.class,type);
                    }else if(this.code == 2){
                        startActivity(CarOwnerActivity.class,type);
                    }else if(this.code == 3){
                        startActivity(CompanyRegisterActivity.class,type);
                    }
                    break;
                case 1:
                    startActivity( MainActivity.class,code);
                    break;
                case 2:
                    startActivity( MainActivity.class,code);
                    break;
                case 3:
                    startActivity( MainActivity.class,code);
                    break;
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

    private void startActivity(Class<?> cls, int type) {
        Intent intent = new Intent(this, cls);
        intent.putExtra("flag", "0");
        intent.putExtra(ADMIN_TYPE, type);
        startActivity(intent);
        finish();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

        switch (checkedId){
            case R.id.login_rb1:
                type = AdminTypeEnum.DRIVER.getValue();
                code = AdminTypeEnum.DRIVER.getCode();
                break;
            case R.id.login_rb2:
                type = AdminTypeEnum.CAR_OWNER.getValue();
                code = AdminTypeEnum.CAR_OWNER.getCode();
                break;
            case R.id.login_rb3:
                type = AdminTypeEnum.COMPANY.getValue();
                code = AdminTypeEnum.COMPANY.getCode();
                break;
        }
    }
}
