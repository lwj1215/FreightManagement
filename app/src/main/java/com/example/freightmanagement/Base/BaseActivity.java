package com.example.freightmanagement.Base;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.ColorRes;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

//import com.bumptech.glide.Glide;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.WindowUtils;

import org.greenrobot.eventbus.EventBus;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author: ztc
 * 2019/8/2
 */

public abstract class BaseActivity<P extends BasePresenter> extends FragmentActivity implements BaseView {

    private static final String TAG = BaseActivity.class.getSimpleName();
    public static final int REQUEST_READ = 10111; //请求码
    /**
     * 根布局文件
     */
    protected BaseDefaultView mViewRoot;
    //实现 baseView 中的方法
    private Dialog mDialog;
    private ImageView progress_view;

    /**
     * 返回主布局文件
     */
    public abstract int setLayoutResource();

    /**
     * 提取传递过来的参数 , 保证在其他回调过程中已经取值
     *
     * @param intent {@link  #getIntent()}  }
     */
    protected void onInitIntent(Intent intent) {
    }

    /**
     * 初始化视图
     */
    protected abstract void onInitView();

    /**
     * 请求加载网络数据
     */
    protected abstract void onLoadData2Remote();

    /**
     * 设置监听
     */
    protected void onInitListener() {
    }


    /**
     * 设置是否侵入状态栏
     *
     * @return true 不侵入系统栏  false  侵入系统栏
     */
    protected boolean getFitsSystemWindows() {
        return true;
    }


    protected P mPresenter;

    public BaseActivity<P> getContext() {
        return this;
    }

    /**
     * activity 加载完成
     *
     * @param savedInstanceState {@link #onCreate(Bundle)} 中的参数
     */
    protected void onCreateSuccess(Bundle savedInstanceState) {
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        onInitIntent(getIntent());
        super.onCreate(savedInstanceState);

        BaseApplication.getApp().addActivity(this);
//        initInAnim();

        int layoutResourceId = setLayoutResource();
        mPresenter = onInitLogicImpl();
        initDialog();
        immersionInit(getFitsSystemWindows() ? R.color.white : R.color.transparent);
        mViewRoot = new BaseDefaultView(this);
        mViewRoot.setContentView(layoutResourceId);
        mViewRoot.setFitsSystemWindows(getFitsSystemWindows());
        setContentView(mViewRoot);
        if (mPresenter != null) mPresenter.attachView(this);
        onInitView();
        onCreateSuccess(savedInstanceState);
        onLoadData2Remote();
        onInitListener();
        netWorkListener();
    }

    /**
     * 三种不同的View切换
     *
     * @param viewStateCode 详情请看注解说明
     */
    protected void selectView(@BaseDefaultViewCode int viewStateCode) {
        mViewRoot.selectView(viewStateCode);
        mViewRoot.setOnTryTRefreshListener(new BaseDefaultView.OnTryRefreshListener() {
            @Override
            public void onTryAgainData() {
                onLoadData2Remote();
            }
        });
    }

    /**
     * 初始添加三种不同状态的
     */
    protected void setThreeDefaultView() {
        setDefaultLoadingtView();
        setDefaultNoDataView();
        setDefaultAbnormalView();
    }

    protected View setDefaultLoadingtView() {
        return mViewRoot.setAddLoadingView();
    }

    protected View setDefaultNoDataView() {
        return mViewRoot.setAddNoDataView();
    }

    protected View setDefaultNoDataView(String noDataContent) {
        return mViewRoot.setAddNoDataView(noDataContent);
    }

    protected View setDefaultAbnormalView() {
        return mViewRoot.setAddAbnormalView();
    }

    protected View setDefaultAbnormalView(String abnormalTopContent) {
        return mViewRoot.setAddAbnormalView(abnormalTopContent);
    }

    protected View setDefaultAbnormalView(String abnormalTopContent, String AbnormalBottomContent) {
        return mViewRoot.setAddAbnormalView(abnormalTopContent, AbnormalBottomContent);
    }


    /**
     * 获取无包装并且添加进去的title
     */
    final protected BaseTitleView setDefaultTitle() {
        return mViewRoot.setDefaultTitle();
    }

    /**
     * 带返回按钮的title
     *
     * @param title
     */
    final protected BaseTitleView setDefaultTitle(String title, View.OnClickListener onClickListener) {
        return mViewRoot.setDefaultTitle(title, onClickListener);
    }

    /**
     * 带返回按钮的title
     *
     * @param title
     */
    final protected BaseTitleView setDefaultTitle(String title) {
        return mViewRoot.setDefaultTitle(title);
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    protected <T extends View> T bindView(@IdRes int id) {
        return (T) findViewById(id);
    }

    @Override
    public void finish() {
        super.finish();
//        initOutAnim();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onDestroy() {
        if (mPresenter != null && mPresenter.isViewBind()) {
            mPresenter.detachView();
        }
        unregisterReceiver(mReceiver);
        ImmersionBar.with(this).destroy(); //必须调用该方法，防止内存泄漏
        BaseApplication.getApp().removeActivity(this);
        super.onDestroy();
    }

    /**
     * * 判断某activity是否处于栈顶     * @return  true在栈顶 false不在栈顶
     */
    private boolean isActivityTop(Class cls, Context context) {
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        String name = manager.getRunningTasks(1).get(0).topActivity.getClassName();
        return name.equals(cls.getName());
    }

    private void initDialog() {
        mDialog = new Dialog(getContext(), R.style.refresh_dialog);
        RelativeLayout  loaing = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.refresh_dialog, null);
        progress_view = loaing.findViewById(R.id.progress_view);
//        Glide.with(getContext()).load(R.mipmap.loading).into(progress_view);
        mDialog.setContentView(loaing);
        mDialog.setCanceledOnTouchOutside(false);
    }

    @Override
    public void showLoading() {
        try {
            Animation animation = AnimationUtils.loadAnimation(BaseApplication.getApp(), R.anim.rotate);
            LinearInterpolator lin = new LinearInterpolator();//设置动画匀速运动
            animation.setInterpolator(lin);
            //让旋转动画一直转，不停顿的重点
            animation.setRepeatCount(-1);
            progress_view.startAnimation(animation);
            mDialog.show();
        } catch (Exception e) {
            Log.e(getClass().getSimpleName(), "showLoading: ", e);
        }
    }

    @Override
    public void hideLoading() {
        try {
            mDialog.dismiss();
            progress_view.clearAnimation();
        } catch (Exception e) {
            Log.e(getClass().getSimpleName(), "hideLoading: ", e);
        }
    }

    /**
     * 处理当网络从断开到重新连接
     */
    private boolean netChange;
    private int net_type;//   0为wifi   1为移动网络
    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            // 监听网络连接，总网络判断，即包括wifi和移动网络的监听
            if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
                NetworkInfo networkInfo = intent.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO);
                //连上的网络类型判断：wifi还是移动网络
                if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                    EventBus.getDefault().post("net_wifi");  //有网络
                    net_type = 0;
                } else if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                    EventBus.getDefault().post("net_yidong");  //有网络
                    net_type = 1;
                }
            }

            if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
                connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                info = connectivityManager.getActiveNetworkInfo();
                if (info != null && info.isAvailable()) {
                    EventBus.getDefault().post("net_ok");  //有网络
                    SharedPreferences sp1 = getSharedPreferences("Sp_Net", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor1 = sp1.edit();
                    editor1.putBoolean("havenet", true);
                    editor1.apply();

                    @SuppressLint("WifiManagerLeak") WifiManager wifiMng = (WifiManager) getSystemService(Context.WIFI_SERVICE);
                    WifiInfo WifiConnectInfo = wifiMng.getConnectionInfo();
                    if (wifiMng.isWifiEnabled() && WifiConnectInfo.getIpAddress() != 0) {
                        Log.d(TAG, " wifi MSG_WIFI...............CONNECT......");
                        netChange = true;
                        SharedPreferences sp_yidong = getSharedPreferences("Sp_Net_YIDONG", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor_yidong = sp_yidong.edit();
                        editor_yidong.putBoolean("Net_YIDONG", false);
                        editor_yidong.apply();
                    } else {
                        Log.d(TAG, " wifi MSG_WIFI................DISCONNECT......");
//                        PlayManager.pause();
                        netChange = false;
                    }

                    if (net_type == 1 && netChange == false) {
                        SharedPreferences sp_yidong = getSharedPreferences("Sp_Net_YIDONG", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor_yidong = sp_yidong.edit();
                        editor_yidong.putBoolean("Net_YIDONG", true);
                        editor_yidong.apply();
                    }


                } else {
                    EventBus.getDefault().post("net_no");  //没网络
                    SharedPreferences sp1 = getSharedPreferences("Sp_Net", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor1 = sp1.edit();
                    editor1.putBoolean("havenet", false);
                    editor1.apply();
                    if (net_type == 0) {
                        netChange = false;
                    }
                    if (net_type == 1) {
                        SharedPreferences sp_yidong = getSharedPreferences("Sp_Net_YIDONG", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor_yidong = sp_yidong.edit();
                        editor_yidong.putBoolean("Net_YIDONG", false);
                        editor_yidong.apply();
                    }
                }
            }

        }
    };


    private ConnectivityManager connectivityManager;
    private NetworkInfo info;
    private View networkView;


    public void netWorkListener() {
        ViewGroup decorView = (ViewGroup) getWindow().getDecorView();
        FrameLayout.LayoutParams fllp = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        fllp.setMargins(30, WindowUtils.getStatusHeight(this) + 160, 30, 0);

        networkView = LayoutInflater.from(this).inflate(R.layout.phone_no_network, null);
        decorView.addView(networkView, fllp);

        networkView.setVisibility(View.GONE);
        networkView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                //判断手机系统的版本  即API大于10 就是3.0或以上版本
                if (Build.VERSION.SDK_INT > 10) {
                    intent = new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS);
                } else {
                    intent = new Intent();
                    ComponentName component = new ComponentName("com.android.settings", "com.android.settings.WirelessSettings");
                    intent.setComponent(component);
                    intent.setAction("android.intent.action.VIEW");
                }
                startActivity(intent);
            }
        });
        IntentFilter mFilter = new IntentFilter();
        mFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);

        registerReceiver(mReceiver, mFilter);

    }

    /**
     * 自动生成 presenter , 需要无参构造方法(测试)
     */
    protected P onInitLogicImpl() {
        try {
            Type genericSuperclass = getClass().getGenericSuperclass();
            while (true) {
                if (genericSuperclass instanceof Class) {
                    genericSuperclass = ((Class) genericSuperclass).getGenericSuperclass();
                } else {
                    break;
                }
            }
            if (genericSuperclass instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    if (actualTypeArgument instanceof Class) {
                        Class aClass = (Class) actualTypeArgument;
                        if (BasePresenter.class.isAssignableFrom(aClass)) {
                            return (P) aClass.newInstance();
                        }
                    }
                }
            }
        } catch (Throwable e) {
        }
        return null;
    }

    protected void immersionInit(@ColorRes int color) {
        immersionInit(color, true);
    }

    protected void immersionInit(@ColorRes int color, boolean darkFont) {
        ImmersionBar.with(this)
                .statusBarDarkFont(darkFont)
                .barColor(color)
                .init();
    }

    //实现 通用的进出场动画 中的方法
    protected void initInAnim() {
        overridePendingTransition(R.anim.slide_in_bottom,R.anim.anim_no);
    }

    protected void initOutAnim() {
        overridePendingTransition(R.anim.anim_no,R.anim.slide_out_bottom);
    }
    //实现 通用的进出场动画 中的方法
    protected void initInAnim2() {
        overridePendingTransition(R.anim.push_left_in, R.anim.anim_no);
    }

    protected void initOutAnim2() {
        overridePendingTransition(R.anim.anim_no, R.anim.push_right_out);
    }


    /**
     * 判断是否有某项权限     * @param string_permission 权限     * @param request_code 请求码     * @return
     */
    public boolean checkReadPermission(String string_permission, int request_code) {
        boolean flag = false;
        if (ContextCompat.checkSelfPermission(this, string_permission) == PackageManager.PERMISSION_GRANTED) {//已有权限
            flag = true;
        } else {//申请权限
            ActivityCompat.requestPermissions(this, new String[]{string_permission}, request_code);
        }
        return flag;
    }



}