package com.example.freightmanagement.Activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;

import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.ToastUtils;

public class ChangePasswordActivity extends BaseActivity implements View.OnClickListener {

    private AutoCompleteTextView edtTxt_login_password1, edtTxt_login_password2, edtTxt_login_password3;

    @Override
    public int setLayoutResource() {
        return R.layout.activity_change_password;
    }

    @Override
    protected void onInitView() {
        edtTxt_login_password1 = (AutoCompleteTextView) bindView(R.id.edtTxt_login_password1);
        edtTxt_login_password2 = (AutoCompleteTextView) bindView(R.id.edtTxt_login_password2);
        edtTxt_login_password3 = (AutoCompleteTextView) bindView(R.id.edtTxt_login_password3);
        bindView(R.id.tv_srue).setOnClickListener(this);

    }

    @Override
    protected void onLoadData2Remote() {

    }

    @Override
    public void onClick(View v) {
        String s = edtTxt_login_password1.getText().toString();
        String s1 = edtTxt_login_password2.getText().toString();
        String s2 = edtTxt_login_password3.getText().toString();
        switch (v.getId()) {

            case R.id.tv_srue:
                if (TextUtils.isEmpty(s)){
                    ToastUtils.popUpToast("请输入旧密码");
                    return;
                } if (TextUtils.isEmpty(s1)){
                    ToastUtils.popUpToast("请输入新密码");
                    return;
                } if (TextUtils.isEmpty(s2)){
                    ToastUtils.popUpToast("请确认密码");
                    return;
                }
                finish();
                break;
        }
    }
}
