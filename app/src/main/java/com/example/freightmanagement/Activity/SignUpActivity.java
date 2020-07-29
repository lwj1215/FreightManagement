package com.example.freightmanagement.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.R;

public class SignUpActivity extends BaseActivity implements View.OnClickListener {

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
}
