package com.example.freightmanagement.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.R;

public class ResponsibilityBookActivity extends BaseActivity {

    private WebView mWebView;

    @Override
    public int setLayoutResource() {
        return R.layout.activity_responsibility_book;
    }

    @Override
    protected void onInitView() {
        mWebView = (WebView) bindView(R.id.webView);
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
        mWebView.loadUrl("http://aicc.ctags.cn/cccc/letter/responsibility.html");
    }
}