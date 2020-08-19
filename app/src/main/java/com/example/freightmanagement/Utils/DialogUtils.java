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
    /***
     * 选择提示对话框Dialog
     */
    public static Dialog showTipsSelectDialog(Context context, String content, String button1, String button2,
                                              final View.OnClickListener cl, final View.OnClickListener cr, boolean isTouchClose) {
        final Dialog dialog = new Dialog(context, R.style.dialog_anim);
        View view = LayoutInflater.from(context).inflate(R.layout.tips_select_dialog, null);
        dialog.setContentView(view);
        ((TextView) view.findViewById(R.id.content)).setText(content);
        if (button1 != null && !button1.equals(""))
            ((TextView) view.findViewById(R.id.button1)).setText(button1);
        if (button2 != null && !button2.equals(""))
            ((TextView) view.findViewById(R.id.button2)).setText(button2);
        view.findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                dialog.dismiss();
                if (cl != null) {
                    cl.onClick(arg0);
                }
            }
        });
        view.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                dialog.dismiss();
                if (cr != null) {
                    cr.onClick(arg0);
                }
            }
        });
        dialog.setCanceledOnTouchOutside(isTouchClose);
        dialog.show();
        return dialog;
    }
}
