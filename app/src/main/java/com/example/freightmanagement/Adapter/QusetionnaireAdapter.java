package com.example.freightmanagement.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.freightmanagement.Bean.TrainingSelectBean;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.StringUtils;

import java.util.List;

/**
 *
 */
public class QusetionnaireAdapter extends BaseAdapter {

    private final Context mContext;
    private TextView textView;

    private int selectorPosition;
    private List<TrainingSelectBean.DataBean> mDatas;

    public QusetionnaireAdapter(Context context) {
        this.mContext = context;
    }


    public void setData(List<TrainingSelectBean.DataBean> answerList) {
        this.mDatas = answerList;
        notifyDataSetChanged();
    }

    /*保存单选题、多选题答案*/
    private void saveCurrentSelectValue(String value, String answerName) {
        for (int i = 0; i < mDatas.size(); i++) {
            TrainingSelectBean.DataBean answerEntity = mDatas.get(i);
            if (answerEntity.getContent().equals(answerName)) {
//                answerEntity.setAnswerValue(value);
            }

        }

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

        viewHodler.text.setText(mDatas.get(position).getContent());
//        if (!StringUtils.isEmpty(item.getAnswerValue()) && item.getAnswerValue().equals(String.valueOf(item.getUpload_id()))) {
//            item.setSelect(true);
//        }
        viewHodler.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                for (int i = 0; i < mDatas.size(); i++) {
//                    mDatas.get(i).setSelect(false);
//                }
//                item.setSelect(true);
//                notifyDataSetChanged();
//                saveCurrentSelectValue(String.valueOf(mDatas.get(position).getUpload_id()), mDatas.get(position).getBean_name());
            }
        });

//        if (item.isSelect()) {
//            viewHodler.ll.setBackgroundResource(R.color.blue_079EEB);
//            textView.setTextColor(Color.WHITE);
//            Drawable rightDrawable = mContext.getResources().getDrawable(R.drawable.yuanjiao20);
//            rightDrawable.setBounds(0, 0, rightDrawable.getMinimumWidth(), rightDrawable.getMinimumHeight());
//            textView.setCompoundDrawables(rightDrawable, null, null, null);
//
//        } else {
//            viewHodler.ll.setBackgroundResource(R.color.white);
//            textView.setTextColor(Color.parseColor("#333333"));
//            Drawable rightDrawable = mContext.getResources().getDrawable(R.drawable.yuanjiao20);
//            rightDrawable.setBounds(0, 0, rightDrawable.getMinimumWidth(), rightDrawable.getMinimumHeight());
//            textView.setCompoundDrawables(rightDrawable, null, null, null);
//        }
        return convertView;
    }


    class ViewHodler {
        TextView text;
        LinearLayout ll;
    }
}
