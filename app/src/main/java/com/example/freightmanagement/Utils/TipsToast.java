package com.example.freightmanagement.Utils;

import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.freightmanagement.R;

/**
 * 自定义提示Toast
 *
 * @author ztc
 */
public class TipsToast extends Toast {

    public TipsToast(Context context) {
        super(context);
    }

    public static TipsToast makeText(Context context, CharSequence text, int duration) {
        TipsToast result = new TipsToast(context);

        LayoutInflater inflate = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflate.inflate(R.layout.tips_toast, null);
        TextView tv = (TextView) v.findViewById(R.id.tips_msg);
        tv.setText(text);

        result.setView(v);
        // setGravity方法用于设置位置，此处为垂直居中
        result.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER, 0, 0);
        result.setDuration(duration);

        return result;
    }

    public static TipsToast makeText(Context context, int resId, int duration) throws Resources.NotFoundException {
        return makeText(context, context.getResources().getText(resId), duration);
    }

    @Override
    public void setText(CharSequence s) {
        if (getView() == null) {
            throw new RuntimeException("This Toast was not created with Toast.makeText()");
        }
        TextView tv = (TextView) getView().findViewById(R.id.tips_msg);
        if (tv == null) {
            throw new RuntimeException("This Toast was not created with Toast.makeText()");
        }
        tv.setText(s);
    }



}
