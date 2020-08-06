package com.example.freightmanagement.Utils.Network;


import androidx.annotation.CallSuper;

/**
 * <p/>
 * {@linkplain OnRequestResult 本类为{@link OnRequestResult}的实现类,点击查看具体的实现类}
 */
public abstract class OnRequestResultForCommon implements OnRequestResult {

    @Override
    public void onSuccess(String json) {

    }


    @Override
    @CallSuper
    public void onFail() {
//        ToastUtils.popUpToast("网络请求失败,请重试!");
    }


    @Override
    @CallSuper
    public void netUnlink() {
//        ToastUtils.popUpToast("网络连接异常,请检查网络设置!");
    }
}
