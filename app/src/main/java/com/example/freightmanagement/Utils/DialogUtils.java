package com.example.freightmanagement.Utils;


import android.app.Dialog;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.freightmanagement.Base.BaseDialogUtils;
import com.example.freightmanagement.R;

/***
 * 对话框工具类
 *
 * @author CRay
 */
public class DialogUtils extends BaseDialogUtils {

    public static void getDialogLocation(Dialog dialog) {
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialogWindow.getAttributes());
        lp.x = WindowManager.LayoutParams.MATCH_PARENT / 2;
        lp.y = WindowManager.LayoutParams.MATCH_PARENT / 2;
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        lp.gravity = Gravity.CENTER;
        dialogWindow.setAttributes(lp);
    }

    /***
     * 从底部弹出提示框
     *
     * @param mContext
     * @param myDialog
     * @param view
     * @return
     */
    public static Dialog showBottomWindowDialog(Context mContext, Dialog myDialog, View view) {
        if (myDialog == null) {
            myDialog = new Dialog(mContext, R.style.dialog_anim);
            myDialog.setContentView(view);
        }
        myDialog.show();
        Window window = myDialog.getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.gravity = Gravity.BOTTOM;
        window.setAttributes(params);
        return myDialog;
    }

}
