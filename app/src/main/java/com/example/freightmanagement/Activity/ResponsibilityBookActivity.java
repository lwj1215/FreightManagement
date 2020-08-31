package com.example.freightmanagement.Activity;

import android.Manifest;
import android.app.Dialog;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;

import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.DatePickerDialog;
import com.example.freightmanagement.Utils.DateUtil;
import com.example.freightmanagement.Utils.DialogUtils;
import com.example.freightmanagement.Utils.FileUtil;
import com.example.freightmanagement.Utils.ToastUtils;
import com.example.freightmanagement.View.ElectronicSignature;
import com.example.freightmanagement.View.UserWebView;
import com.example.freightmanagement.presenter.PromiseBookPresenter;
import com.example.freightmanagement.presenter.ResponsibilityBookPresenter;

import java.io.File;
import java.util.List;

import static com.example.freightmanagement.Base.BaseApiConstants.IMAGE_BASE_URL;


public class ResponsibilityBookActivity extends BaseActivity<ResponsibilityBookPresenter> implements ResponsibilityBookPresenter.View, View.OnClickListener {
    private TextView mTvEndTime;
    private TextView mTvSubmit;
    private TextView mTvSign;
    private Dialog bottomDialog;
    private View bottomView;
    private ElectronicSignature vSignView;
    private UserWebView mWebView;
    private String endTime;
    private Dialog dateDialog;
    private int webViewHeight;                                   //webview整体的高度
    private String signUrl;
    private File file;

    @Override
    public int setLayoutResource() {
        return R.layout.activity_responsibility_book;
    }

    @Override
    protected void onInitView() {
        mWebView = (UserWebView) bindView(R.id.webView);
        mTvEndTime = findViewById(R.id.tv_endTime);
        mTvEndTime.setOnClickListener(this);
        mTvSubmit = findViewById(R.id.tv_submit);
        mTvSubmit.setOnClickListener(this);
        bottomView = LayoutInflater.from(this).inflate(R.layout.inflate_pop_item, null);
        bottomView.findViewById(R.id.btn_no).setOnClickListener(this);
        bottomView.findViewById(R.id.btn_yes).setOnClickListener(this);
        vSignView = (ElectronicSignature) bottomView.findViewById(R.id.sign_view);
        mTvSign = findViewById(R.id.tv_sign);
        mTvSign.setOnClickListener(this);
        checkGalleryPermission();
    }
    private boolean checkGalleryPermission() {
        int ret = ActivityCompat.checkSelfPermission(this, Manifest.permission
                .READ_EXTERNAL_STORAGE);
        int wet = ActivityCompat.checkSelfPermission(this, Manifest.permission
                .WRITE_EXTERNAL_STORAGE);
        if (ret != PackageManager.PERMISSION_GRANTED && wet != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    1000);
            return false;
        }
        return true;
    }
    @Override
    protected void onLoadData2Remote() {
        setDefaultTitle("签订责任书");
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
        mWebView.getSettings().setBlockNetworkImage(false); // 解决图片不显示
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mWebView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
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


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_sign:
                bottomDialog = DialogUtils.showBottomWindowDialog(this, bottomDialog, bottomView);
                break;
            case R.id.tv_endTime:
//                Glide.with(getContext()).load(file).into(mImgSign);
                showDateDialog(DateUtil.getDateForString("2020-08-29"));
                break;
            case R.id.btn_yes:
                if (bottomDialog != null) {
                    bottomDialog.dismiss();
                }
                Bitmap bitmap = vSignView.save();
                File file = FileUtil.saveImage(bitmap);
                if (file == null) {
                    return;
                }
                mPresenter.upload(new File(file.getAbsolutePath()), 0);
                break;
            case R.id.tv_submit:
                if(TextUtils.isEmpty(endTime)){
                    ToastUtils.popUpToast("请选择合同截止日期");
                    return;
                }
                if(TextUtils.isEmpty(signUrl)){
                    ToastUtils.popUpToast("请签名");
                    return;
                }
                mPresenter.upload(this.file, 1);

                break;
        }
    }

    /**
     * 选择生日
     */
    private void showDateDialog(List<Integer> date) {
        DatePickerDialog.Builder builder = new DatePickerDialog.Builder(this);
        builder.setOnDateSelectedListener(new DatePickerDialog.OnDateSelectedListener() {
            @Override
            public void onDateSelected(int[] dates) {
                endTime = dates[0] + "-" + (dates[1] > 9 ? dates[1] : ("0" + dates[1])) + "-"
                        + (dates[2] > 9 ? dates[2] : ("0" + dates[2]));
                mWebView.loadUrl("javascript:setEndTime('" + endTime + "')");

            }

            @Override
            public void onCancel() {
            }
        })
                .setSelectYear(date.get(0) - 1)
                .setSelectMonth(date.get(1) - 1)
                .setSelectDay(date.get(2) - 1);

        builder.setMaxYear(DateUtil.getYear());
        builder.setMaxMonth(DateUtil.getDateForString(DateUtil.getToday()).get(1));
        builder.setMaxDay(DateUtil.getDateForString(DateUtil.getToday()).get(2));
        dateDialog = builder.create();
        dateDialog.show();
    }

    @Override
    protected ResponsibilityBookPresenter onInitLogicImpl() {
        return new ResponsibilityBookPresenter();
    }


    @Override
    public void success() {

    }

    @Override
    public void imageUrl(String url, int type) {
        signUrl = IMAGE_BASE_URL.concat(url);

        mWebView.loadUrl("javascript:setSign('" + signUrl + "')");
//        Bitmap bitmapFromView = FileUtil.createBitmapFromView(mWebView);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (judgeAndroidVersion()) {                                         //可以通过获取缩放，然后设置值从而控制webview快照的高度
                    float scale = mWebView.getScale() - 1;
                    webViewHeight = (int) (mWebView.getPageHeight() * 1);
                } else {
                    webViewHeight = mWebView.getPageHeight();
                }
                final Bitmap bitmap = Bitmap.createBitmap(mWebView.getPageWidth(), webViewHeight, Bitmap.Config.RGB_565);
                Canvas canvas = new Canvas(bitmap);
                mWebView.draw(canvas);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //把整体的图片保存到本地下
                        file = FileUtil.saveBitmapFile(bitmap, "/sign_" + System.currentTimeMillis() + ".jpg",getContext());

//                        mImgSign.setVisibility(View.VISIBLE);
                    }
                }).start();

            }
        }, 1000);
    }

    /**
     * 判断安卓版本
     */
    public Boolean judgeAndroidVersion() {
        //如果要是5.0
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return true;
        }
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}