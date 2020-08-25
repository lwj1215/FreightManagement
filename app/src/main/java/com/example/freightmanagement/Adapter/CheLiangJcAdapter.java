package com.example.freightmanagement.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freightmanagement.Bean.CheliangJcBean;
import com.example.freightmanagement.Bean.VehicleDetectionBean;
import com.example.freightmanagement.Bean.VerAddBean;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by songdechuan on 2020/8/6.
 */

public class CheLiangJcAdapter extends RecyclerView.Adapter<CheLiangJcAdapter.TrainingViewHolder> {
    private final LayoutInflater layoutInflater;
    private Context context;
    private List<CheliangJcBean.DataBean> pages;

    public CheLiangJcAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public TrainingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CheLiangJcAdapter.TrainingViewHolder(layoutInflater.inflate(R.layout.cheliang_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(TrainingViewHolder holder, int position) {
        if (pages != null) {
            holder.tv_date.setText(pages.get(position).getCheckDateTime()+"");
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

    public void setPages(List<CheliangJcBean.DataBean> data) {
        this.pages = data;
        notifyDataSetChanged();
    }
}
