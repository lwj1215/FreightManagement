package com.example.freightmanagement.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.freightmanagement.Bean.CheliangByBean;
import com.example.freightmanagement.Bean.CheliangJcBean;
import com.example.freightmanagement.R;

import java.util.List;

/**
 * Created by songdechuan on 2020/8/6.
 */

public class CheLiangByAdapter extends RecyclerView.Adapter<CheLiangByAdapter.TrainingViewHolder> {
    private final LayoutInflater layoutInflater;
    private Context context;
    private List<CheliangByBean.DataBean> pages;

    public CheLiangByAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public TrainingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CheLiangByAdapter.TrainingViewHolder(layoutInflater.inflate(R.layout.cheliang_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(TrainingViewHolder holder, int position) {
        if (pages != null) {
            holder.tv_date.setText(pages.get(position).getCreateTime()+"");
        }
    }

    @Override
    public int getItemCount() {
        return  pages != null && pages.size() > 0 ? pages.size() : 0;

    }

    public class TrainingViewHolder extends RecyclerView.ViewHolder {
        TextView tv_date;
        private View itemView;

        public TrainingViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            tv_date = itemView.findViewById(R.id.tv_date);
        }
    }

    public void setPages(List<CheliangByBean.DataBean> data) {
        this.pages = data;
        notifyDataSetChanged();
    }
}
