package com.example.freightmanagement.Activity;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
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
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;

import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.Bean.WrodIdBean;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.DatePickerDialog;
import com.example.freightmanagement.Utils.DateUtil;
import com.example.freightmanagement.Utils.DialogUtils;
import com.example.freightmanagement.Utils.FileUtil;
import com.example.freightmanagement.Utils.PrefUtilsData;
import com.example.freightmanagement.Utils.ToastUtils;
import com.example.freightmanagement.View.ElectronicSignature;
import com.example.freightmanagement.View.UserWebView;
import com.example.freightmanagement.enums.ResponseCodeEnum;
import com.example.freightmanagement.model.ContractParam;
import com.example.freightmanagement.presenter.EmploymentContractPresenter;
import com.example.freightmanagement.presenter.constract.EmploymentConstact;

import java.io.File;
import java.text.ParseException;
import java.util.List;

import static android.webkit.WebView.enableSlowWholeDocumentDraw;
import static com.example.freightmanagement.Base.BaseApiConstants.IMAGE_BASE_URL;
import static com.example.freightmanagement.common.ImageUploadConstants.UPLOAD_CN;
import static com.example.freightmanagement.common.ImageUploadConstants.UPLOAD_HT;
import static com.example.freightmanagement.common.ImageUploadConstants.UPLOAD_ZR;

public class EmploymentContractActivity extends BaseActivity<EmploymentContractPresenter> implements EmploymentContractPresenter.View, View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private Dialog bottomDialog;
    private View bottomView;
    private ElectronicSignature vSignView;
//    private UserWebView mWebView;
    //    private ImageView mImgSign;
    private int webViewHeight;                                   //webview整体的高度
    private File htFile;
    private Dialog dateDialog;
    private String endTime;
    private TextView mTvSubmit;
    private String signUrl;
    private String employmentUrl;
    private int carId;
    private RadioButton mRbApply;
    private boolean apply = false;
    private UserWebView mWebViewHt;
    private UserWebView mWebViewZr;
    private UserWebView mWebViewCn;
    private File zrFile;
    private File cnFile;

    @Override
    public int setLayoutResource() {
        if (judgeAndroidVersion()) {
            //如果要是5.0手机以上，必须要使用该属性,否则快照内容不全
            enableSlowWholeDocumentDraw();
        }
        return R.layout.activity_employment_contract;
    }

    @Override
    protected void onInitView() {
        setDefaultTitle("聘用合同");
        checkGalleryPermission();
        bindView(R.id.tv_sign).setOnClickListener(this);
        bindView(R.id.tv_endTime).setOnClickListener(this);
        bottomView = LayoutInflater.from(this).inflate(R.layout.inflate_pop_item, null);
        bottomView.findViewById(R.id.btn_no).setOnClickListener(this);
        bottomView.findViewById(R.id.btn_yes).setOnClickListener(this);
        vSignView = (ElectronicSignature) bottomView.findViewById(R.id.sign_view);
        mTvSubmit = findViewById(R.id.tv_submit);
        mRbApply = findViewById(R.id.rb_apply);
        mTvSubmit.setOnClickListener(this);
        mRbApply.setOnCheckedChangeListener(this);
        mWebViewHt = findViewById(R.id.webView_ht);
        mWebViewZr = findViewById(R.id.webView_zr);
        mWebViewCn = findViewById(R.id.webView_cn);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onLoadData2Remote() {
        carId = getIntent().getIntExtra("id", 0);
        int enterpriseId = getIntent().getIntExtra("enterpriseId", 0);
//        carId = getIntent().getIntExtra("carId", -1);
        mPresenter.get(PrefUtilsData.getUserId());
        mPresenter.getDriver();
        if (Build.VERSION.SDK_INT >= 21) {
            enableSlowWholeDocumentDraw();
        }
        hetongWeb();
        cnWeb();
        zrWeb();
    }

    /**
     * 责任书
     */
    private void zrWeb() {
        WebSettings settings = mWebViewZr.getSettings();
        // 设置WebView支持JavaScript
        settings.setJavaScriptEnabled(true);
        //支持自动适配
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(false);  //支持放大缩小
        settings.setBuiltInZoomControls(true); //显示缩放按钮
        settings.setSaveFormData(true);
        settings.setGeolocationEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setAllowFileAccess(true);
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setJavaScriptCanOpenWindowsAutomatically(true);/// 支持通过JS打开新窗口
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        //设置不让其跳转浏览器
        mWebViewZr.getSettings().setBlockNetworkImage(false); // 解决图片不显示
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mWebViewCn.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        mWebViewZr.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        // 添加客户端支持
        mWebViewZr.setWebChromeClient(new WebChromeClient());
    }
    /**
     * 承诺书
     */
    private void cnWeb() {
        WebSettings settings = mWebViewCn.getSettings();
        // 设置WebView支持JavaScript
        settings.setJavaScriptEnabled(true);
        //支持自动适配
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(false);  //支持放大缩小
        settings.setBuiltInZoomControls(true); //显示缩放按钮
        settings.setSaveFormData(true);
        settings.setGeolocationEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setAllowFileAccess(true);
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setJavaScriptCanOpenWindowsAutomatically(true);/// 支持通过JS打开新窗口
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        //设置不让其跳转浏览器
        mWebViewCn.getSettings().setBlockNetworkImage(false); // 解决图片不显示
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mWebViewCn.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        mWebViewCn.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        // 添加客户端支持
        mWebViewCn.setWebChromeClient(new WebChromeClient());
    }

    /**
     * 聘用合同
     */
    private void hetongWeb() {
        WebSettings settings = mWebViewHt.getSettings();
        mWebViewHt.setClickable(true);
        // 设置WebView支持JavaScript
        settings.setJavaScriptEnabled(true);
        //支持自动适配
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(false);  //支持放大缩小
        settings.setBuiltInZoomControls(true); //显示缩放按钮
        settings.setSaveFormData(true);
        settings.setGeolocationEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setAllowFileAccess(true);
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setJavaScriptCanOpenWindowsAutomatically(true);/// 支持通过JS打开新窗口
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        //设置不让其跳转浏览器
        mWebViewHt.getSettings().setBlockNetworkImage(false); // 解决图片不显示
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mWebViewHt.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        mWebViewHt.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        // 添加客户端支持
        mWebViewHt.setWebChromeClient(new WebChromeClient());

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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_sign:
                bottomDialog = DialogUtils.showBottomWindowDialog(EmploymentContractActivity.this, bottomDialog, bottomView);
                break;
            case R.id.tv_endTime:
//                Glide.with(getContext()).load(file).into(mImgSign);
                showDateDialog(DateUtil.getDateForString("2018-08-29"));
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
                if (!apply) {
                    ToastUtils.popUpToast("请先同意签署");
                    return;
                }
                if (TextUtils.isEmpty(endTime)) {
                    ToastUtils.popUpToast("请选择合同截止日期");
                    return;
                }
                if (TextUtils.isEmpty(signUrl)) {
                    ToastUtils.popUpToast("请签名");
                    return;
                }
//                if(TextUtils.isEmpty(employmentUrl)){
//                    ToastUtils.popUpToast("合同暂未生成");
//                    return;
//                }
                if (carId == -1) {
                    ToastUtils.popUpToast("车辆不得为空");
                    return;
                }
                boolean b = FileUtil.fileIsExists(this.htFile.getAbsolutePath());
                if (b) {
//                    ToastUtils.popUpToast("文件存在，路径是："+this.file.getAbsolutePath());
                    mPresenter.upload(new File(this.htFile.getAbsolutePath()), UPLOAD_HT);
                    mPresenter.upload(new File(this.zrFile.getAbsolutePath()), UPLOAD_ZR);
                    mPresenter.upload(new File(this.cnFile.getAbsolutePath()), UPLOAD_CN);

                } else {
//                    ToastUtils.popUpToast("文件不存在");
                }
                break;
        }
    }

    @Override
    public void success() {
        ToastUtils.popUpToast("提交成功");
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void imageUrl(String url, int type) {
        switch (type) {
            case 0:
                signUrl = IMAGE_BASE_URL.concat(url);
                mWebViewCn.loadUrl("javascript:setSign('" + signUrl + "')");
                mWebViewZr.loadUrl("javascript:setSign('" + signUrl + "')");
                mWebViewHt.loadUrl("javascript:setSign('" + signUrl + "')");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (judgeAndroidVersion()) {                                         //可以通过获取缩放，然后设置值从而控制webview快照的高度
                            float scale = mWebViewHt.getScale() - 1;
                            webViewHeight = (int) (mWebViewHt.getPageHeight() * 1);
                        } else {
                            webViewHeight = mWebViewHt.getPageHeight();
                        }
                        final Bitmap bitmap = Bitmap.createBitmap(mWebViewHt.getPageWidth(), webViewHeight, Bitmap.Config.RGB_565);
                        Canvas canvas = new Canvas(bitmap);
                        mWebViewHt.draw(canvas);
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                //把整体的图片保存到本地下
                                htFile = FileUtil.saveBitmapFile(bitmap, "/sign_" + System.currentTimeMillis() + ".jpg", getContext());
                            }
                        }).start();

                    }
                }, 1000);
                mWebViewZr.loadUrl("javascript:setSign('" + signUrl + "')");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (judgeAndroidVersion()) {                                         //可以通过获取缩放，然后设置值从而控制webview快照的高度
                            float scale = mWebViewZr.getScale() - 1;
                            webViewHeight = (int) (mWebViewZr.getPageHeight() * 1);
                        } else {
                            webViewHeight = mWebViewZr.getPageHeight();
                        }
                        final Bitmap bitmap = Bitmap.createBitmap(mWebViewZr.getPageWidth(), webViewHeight, Bitmap.Config.RGB_565);
                        Canvas canvas = new Canvas(bitmap);
                        mWebViewZr.draw(canvas);
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                //把整体的图片保存到本地下
                                zrFile = FileUtil.saveBitmapFile(bitmap, "/sign_" + System.currentTimeMillis() + ".jpg", getContext());
                            }
                        }).start();

                    }
                }, 1000);
                mWebViewCn.loadUrl("javascript:setSign('" + signUrl + "')");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (judgeAndroidVersion()) {                                         //可以通过获取缩放，然后设置值从而控制webview快照的高度
                            float scale = mWebViewCn.getScale() - 1;
                            webViewHeight = (int) (mWebViewCn.getPageHeight() * 1);
                        } else {
                            webViewHeight = mWebViewCn.getPageHeight();
                        }
                        final Bitmap bitmap = Bitmap.createBitmap(mWebViewCn.getPageWidth(), webViewHeight, Bitmap.Config.RGB_565);
                        Canvas canvas = new Canvas(bitmap);
                        mWebViewCn.draw(canvas);
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                //把整体的图片保存到本地下
                                cnFile = FileUtil.saveBitmapFile(bitmap, "/sign_" + System.currentTimeMillis() + ".jpg", getContext());
                            }
                        }).start();

                    }
                }, 1000);
                break;
            case UPLOAD_HT:
                employmentUrl = IMAGE_BASE_URL.concat(url);
                ContractParam contractParam = new ContractParam();
                contractParam.setContractUrl(employmentUrl);
                try {
                    contractParam.setEndTime(DateUtil.string2Date(endTime));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                contractParam.setCarId(carId);
                mPresenter.submit(contractParam);
                break;
            case UPLOAD_CN:
                String zrUrl = IMAGE_BASE_URL.concat(url);
//                ContractParam contractParam = new ContractParam();
//                contractParam.setContractUrl(employmentUrl);
//                try {
//                    contractParam.setEndTime(DateUtil.string2Date(endTime));
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//                contractParam.setCarId(carId);
//                mPresenter.submit(contractParam);
                break;
            case UPLOAD_ZR:
//                String cnUrl  = IMAGE_BASE_URL.concat(url);
//                ContractParam contractParam = new ContractParam();
//                contractParam.setContractUrl(employmentUrl);
//                try {
//                    contractParam.setEndTime(DateUtil.string2Date(endTime));
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//                contractParam.setCarId(carId);
//                mPresenter.submit(contractParam);
                break;
        }
    }

    @Override
    public void driverInfo(WrodIdBean wrodIdBean) {
        int code = wrodIdBean.getCode();
        if (code == ResponseCodeEnum.SUCCESS.getCode()) {
            WrodIdBean.DataBean data = wrodIdBean.getData();
            final String name = data.getCertificateIDBo().getName();
            WrodIdBean.DataBean.CertificateDriverBoBean certificateDriverBo = data.getCertificateDriverBo();
            final String fileNumber = certificateDriverBo.getFileNumber();
            mWebViewHt.loadUrl("http://aicc.ctags.cn/cccc/letter/contract.html");
            mWebViewHt.setWebChromeClient(new WebChromeClient() {
                public void onProgressChanged(WebView view, int progress) {
                    if (progress == 100) {
                        //加载完成
                        mWebViewHt.loadUrl("javascript:setName('" + name + "')");
                        mWebViewHt.loadUrl("javascript:setNo('" + fileNumber + "')");
                        mWebViewHt.loadUrl("javascript:setTel('" + PrefUtilsData.getMobile() + "')");
                    }
                }
            });

            mWebViewZr.loadUrl("http://aicc.ctags.cn/cccc/letter/responsibility.html");
            mWebViewZr.setWebChromeClient(new WebChromeClient() {
                public void onProgressChanged(WebView view, int progress) {
                    if (progress == 100) {
                        //加载完成
//                        mWebViewZr.loadUrl("javascript:setName('" + name + "')");
//                        mWebViewZr.loadUrl("javascript:setNo('" + fileNumber + "')");
//                        mWebViewZr.loadUrl("javascript:setTel('" + PrefUtilsData.getMobile() + "')");
                    }
                }
            });
            mWebViewCn.loadUrl("http://aicc.ctags.cn/cccc/letter/commitment.html");
            mWebViewCn.setWebChromeClient(new WebChromeClient() {
                public void onProgressChanged(WebView view, int progress) {
                    if (progress == 100) {
                        //加载完成
//                        mWebViewZr.loadUrl("javascript:setName('" + name + "')");
//                        mWebViewZr.loadUrl("javascript:setNo('" + fileNumber + "')");
//                        mWebViewZr.loadUrl("javascript:setTel('" + PrefUtilsData.getMobile() + "')");
                    }
                }
            });

        }
    }

    @Override
    protected EmploymentContractPresenter onInitLogicImpl() {
        return new EmploymentContractPresenter();
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
                mWebViewHt.loadUrl("javascript:setEndTime('" + endTime + "')");
                mWebViewZr.loadUrl("javascript:setEndTime('" + endTime + "')");
                mWebViewCn.loadUrl("javascript:setEndTime('" + endTime + "')");

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
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        apply = b;
    }
}
