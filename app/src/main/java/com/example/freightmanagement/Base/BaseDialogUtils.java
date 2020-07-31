package com.example.freightmanagement.Base;

import android.app.Dialog;
import android.content.Context;

import com.example.freightmanagement.R;

public class BaseDialogUtils {

    /***
     * 刷新Dialog
     */
    public static Dialog showRefreshDialog(Context context) {
        Dialog dialog = new Dialog(context, R.style.refresh_dialog);
        dialog.setContentView(R.layout.refresh_dialog);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        return dialog;
    }

}
