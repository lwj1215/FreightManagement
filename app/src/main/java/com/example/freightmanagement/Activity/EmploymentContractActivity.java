package com.example.freightmanagement.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
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
    private WebView mWebView;

    @Override
    public int setLayoutResource() {
        return R.layout.activity_employment_contract;
    }

    @Override
    protected void onInitView() {
        setDefaultTitle("签订承诺书");
        bindView(R.id.tv_qz).setOnClickListener(this);
        vSignImg = (ImageView) bindView(R.id.img_sign);
        mWebView = (WebView) bindView(R.id.webView);
        bottomView = LayoutInflater.from(this).inflate(R.layout.inflate_pop_item, null);
        bottomView.findViewById(R.id.btn_no).setOnClickListener(this);
        bottomView.findViewById(R.id.btn_yes).setOnClickListener(this);
        vSignView = (ElectronicSignature) bottomView.findViewById(R.id.sign_view);
    }

    @Override
    protected void onLoadData2Remote() {
        mWebView.setClickable(true);
        WebSettings settings = mWebView.getSettings();
        // 设置WebView支持JavaScript
        settings.setJavaScriptEnabled(true);
        //支持自动适配
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(false);  //支持放大缩小
        settings.setBuiltInZoomControls(true); //显示缩放按钮
        settings.setBlockNetworkImage(true);// 把图片加载放在最后来加载渲染
        settings.setAllowFileAccess(true); // 允许访问文件
        settings.setSaveFormData(true);
        settings.setGeolocationEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);/// 支持通过JS打开新窗口
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        //设置不让其跳转浏览器
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });

        // 添加客户端支持
        mWebView.setWebChromeClient(new WebChromeClient());
        mWebView.loadUrl("http://aicc.ctags.cn/cccc/letter/contract.html");
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
