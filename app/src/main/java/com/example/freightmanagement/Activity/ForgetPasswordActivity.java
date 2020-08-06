package com.example.freightmanagement.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.Base.BaseResponse;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.StringUtils;
import com.example.freightmanagement.Utils.ToastUtils;
import com.example.freightmanagement.enums.ResponseCodeEnum;
import com.example.freightmanagement.model.AccountParam;
import com.example.freightmanagement.presenter.ForgetPwdPresenter;
import com.example.freightmanagement.presenter.constract.FoegetPwdConstact;
import com.google.gson.Gson;

/**
 * Created by songdechuan on 2020/8/6.
 */

public class ForgetPasswordActivity extends BaseActivity<ForgetPwdPresenter> implements FoegetPwdConstact.View, View.OnClickListener {

    /**
     * 请输入手机号
     */
    private EditText mEdtTxtMobile;
    /**
     * 请输入验证码
     */
    private EditText mEdtTxtYzmPhone;
    /**
     * 获取验证码
     */
    private TextView mTvHqyzm;
    /**
     * 请输入新密码
     */
    private EditText mEdtTxtPassword;
    /**
     * 注册
     */
    private TextView mTvSrue;
    private String smsCode = "123456";


    private Handler mCountDownHandler = new Handler() {
    @Override
    public void handleMessage(Message msg) {
            //时间
            if ((msg.arg1 -= 1) <= 0) {
                //重置
                mTvHqyzm.setText("重新发送");
                mTvHqyzm.setClickable(true);
//                mTvHqyzm.setTextColor(getResources().getColor(R.color.color_FFFF5C1F));
//                mTvHqyzm.setBackground(getResources().getDrawable(R.drawable.yellow_line90));
            } else {
                //赋值
                mTvHqyzm.setText("重新发送(" + msg.arg1+"s)");
                Message message = mCountDownHandler.obtainMessage();
                message.arg1 = msg.arg1;
                mCountDownHandler.sendMessageDelayed(message, 1000);
//                mTvHqyzm.setTextColor(getResources().getColor(R.color.color_ccc));
                mTvHqyzm.setBackground(getResources().getDrawable(R.drawable.g_button_background));
            }
        }
    };
    @Override
    public int setLayoutResource() {
        return R.layout.activity_forget_password;
    }

    @Override
    protected void onInitView() {
        initView();
    }

    @Override
    protected void onLoadData2Remote() {

    }

    public void initView() {
        mEdtTxtMobile = (EditText) findViewById(R.id.edtTxt_mobile);
        mEdtTxtYzmPhone = (EditText) findViewById(R.id.edtTxt_yzm_phone);
        mTvHqyzm = (TextView) findViewById(R.id.tv_hqyzm);
        mTvHqyzm.setOnClickListener(this);
        mEdtTxtPassword = (EditText) findViewById(R.id.edtTxt_password);
        mTvSrue = (TextView) findViewById(R.id.tv_srue);
        mTvSrue.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_hqyzm:
                String tel = mEdtTxtMobile.getText().toString();
                if(StringUtils.isEmpty(tel)){
                    ToastUtils.popUpToast(R.string.tel_cannot_be_empty);
                    return;
                }
                Message message = mCountDownHandler.obtainMessage();
                message.arg1 = 60;
                mCountDownHandler.sendMessage(message);
                tel = tel.trim();
                mPresenter.getCode(tel);
                break;
            case R.id.tv_srue:
                tel = mEdtTxtMobile.getText().toString();
                if(StringUtils.isEmpty(tel)){
                    ToastUtils.popUpToast(R.string.tel_cannot_be_empty);
                    return;
                }
                smsCode = mEdtTxtYzmPhone.getText().toString();
                smsCode = "123456";

                if(StringUtils.isEmpty(smsCode)){
                    ToastUtils.popUpToast(R.string.sms_code_cannot_be_empty);
                    return;
                }
                String password = mEdtTxtPassword.getText().toString();
                if(StringUtils.isEmpty(password)){
                    ToastUtils.popUpToast(R.string.password_cannot_be_empty);
                    return;
                }
                tel = tel.trim();
                password = password.trim();
                AccountParam accountParam = new AccountParam();
                accountParam.setMsCode(smsCode);
                accountParam.setPass(password);
                accountParam.setTel(tel);
                mPresenter.retrievePassword(accountParam);
                break;
        }
    }

    @Override
    public void smsCode(String msg) {
        String smsCode = "123456";
        this.smsCode = smsCode;
    }

    @Override
    public void result(String msg) {
        BaseResponse response = new Gson().fromJson(msg, BaseResponse.class);
        if(response.getCode() == ResponseCodeEnum.SUCCESS.getCode()){
            startActivity(this,LoginActivity.class);
        }else {

        }
    }

    @Override
    protected ForgetPwdPresenter onInitLogicImpl() {
        return new ForgetPwdPresenter();
    }
}
