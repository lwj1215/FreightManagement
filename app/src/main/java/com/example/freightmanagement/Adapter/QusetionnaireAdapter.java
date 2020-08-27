package com.example.freightmanagement.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.freightmanagement.Bean.AnswerBean;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.PrefUtilsData;

import java.util.List;
import java.util.Map;

import static com.example.freightmanagement.Activity.TrainingStartActivity.driverDataBosBean;
import static com.example.freightmanagement.Activity.TrainingStartActivity.lisBean;
import static com.example.freightmanagement.Activity.TrainingStartActivity.wenJuanAnserBean;

/**
 *
 */
public class QusetionnaireAdapter extends BaseAdapter {

    private final Context mContext;
    private TextView textView;

    private int selectorPosition;
    private List<AnswerBean> mDatas;

    public QusetionnaireAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(List<AnswerBean> answerList) {
        this.mDatas = answerList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mDatas != null && mDatas.size() > 0 ? mDatas.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHodler viewHodler = null;
        if (convertView == null) {
            viewHodler = new QusetionnaireAdapter.ViewHodler();
            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.item_health_questionnaire_gridview, null);

            viewHodler.text = convertView.findViewById(R.id.text);
            viewHodler.ll = convertView.findViewById(R.id.question_gridview_ll);
            convertView.setTag(viewHodler);


        } else {
            viewHodler = (QusetionnaireAdapter.ViewHodler) convertView.getTag();
        }
        viewHodler.text.setText(mDatas.get(position).getAnswer());

        if (mDatas == null) {

        } else {
            viewHodler.text.setText(mDatas.get(position).getKey() + ":" + mDatas.get(position).getAnswer());
//        if (!StringUtils.isEmpty(item.getAnswerValue()) && item.getAnswerValue().equals(String.valueOf(item.getUpload_id()))) {
//            item.setSelect(true);
//        }
            viewHodler.ll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    for (int i = 0; i < mDatas.size(); i++) {
                        mDatas.get(i).setIsSelect(false);
                    }
                    mDatas.get(position).setIsSelect(true);
                    notifyDataSetChanged();
                    wenJuanAnserBean.setDirverId(Integer.parseInt(PrefUtilsData.getUserId()));
                    driverDataBosBean.setAnswer(mDatas.get(position).getAnswer());
                    driverDataBosBean.setDriverId(Integer.parseInt(PrefUtilsData.getUserId()));
                    lisBean.add(driverDataBosBean);
                    wenJuanAnserBean.setDriverDataBos(lisBean);
                }
            });

        if (mDatas.get(position).getIsSelect()) {
            viewHodler.ll.setBackgroundResource(R.color.blue_079EEB);
            viewHodler.text.setTextColor(Color.WHITE);
            Drawable rightDrawable = mContext.getResources().getDrawable(R.drawable.yuanjiao20);
            rightDrawable.setBounds(0, 0, rightDrawable.getMinimumWidth(), rightDrawable.getMinimumHeight());
            viewHodler.text.setCompoundDrawables(rightDrawable, null, null, null);

        } else {
            viewHodler.ll.setBackgroundResource(R.color.white);
            viewHodler.text.setTextColor(Color.parseColor("#333333"));
            Drawable rightDrawable = mContext.getResources().getDrawable(R.drawable.yuanjiao20);
            rightDrawable.setBounds(0, 0, rightDrawable.getMinimumWidth(), rightDrawable.getMinimumHeight());
            viewHodler.text.setCompoundDrawables(rightDrawable, null, null, null);
        }
        }

        return convertView;
    }


    class ViewHodler {
        TextView text;
        LinearLayout ll;
    }
}
