package com.example.freightmanagement.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.DialogUtils;
import com.example.freightmanagement.View.ElectronicSignature;

public class EmploymentContractActivity extends BaseActivity implements View.OnClickListener {

    private Dialog bottomDialog;
    private View bottomView;
    private ElectronicSignature vSignView;
    private ImageView vSignImg;

    @Override
    public int setLayoutResource() {
        return R.layout.activity_employment_contract;
    }

    @Override
    protected void onInitView() {
        bindView(R.id.tv_qz).setOnClickListener(this);
        vSignImg = (ImageView) bindView(R.id.img_sign);
        bottomView = LayoutInflater.from(this).inflate(R.layout.inflate_pop_item, null);
        bottomView.findViewById(R.id.btn_no).setOnClickListener(this);
        bottomView.findViewById(R.id.btn_yes).setOnClickListener(this);
        vSignView = (ElectronicSignature) bottomView.findViewById(R.id.sign_view);
    }

    @Override
    protected void onLoadData2Remote() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_qz:
                bottomDialog = DialogUtils.showBottomWindowDialog(EmploymentContractActivity.this, bottomDialog, bottomView);
                break;
            case R.id.btn_no:
                vSignView.clearCanvas();
                break;
            case R.id.btn_yes:
                if (bottomDialog != null) {
                    bottomDialog.dismiss();
                }
                Bitmap bitmap = vSignView.save();
                vSignImg.setImageBitmap(bitmap);
                break;
        }
    }
}
