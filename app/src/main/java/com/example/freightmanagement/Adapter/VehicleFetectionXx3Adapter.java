package com.example.freightmanagement.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.recyclerview.widget.RecyclerView;

import com.example.freightmanagement.Bean.VehicleDetectionBean;
import com.example.freightmanagement.R;

import java.util.List;

/**
 * Created by songdechuan on 2020/8/6.
 */

public class VehicleFetectionXx3Adapter extends RecyclerView.Adapter<VehicleFetectionXx3Adapter.TrainingViewHolder> {
    private final LayoutInflater layoutInflater;
    private Context context;
    private List<String> dataList;
    private List<VehicleDetectionBean.DataBean.Type3Bean> pages;

    public VehicleFetectionXx3Adapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public TrainingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VehicleFetectionXx3Adapter.TrainingViewHolder(layoutInflater.inflate(R.layout.vehicle_xx_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(TrainingViewHolder holder, int position) {
        if (pages != null) {
            holder.tv_date.setText(pages.get(position).getItem());
        }
    }

    @Override
    public int getItemCount() {
        return null == pages || pages.size() == 0 ? 0 : pages.size();

    }

    public class TrainingViewHolder extends RecyclerView.ViewHolder {
        CheckBox tv_date;
        private View itemView;

        public TrainingViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            tv_date = itemView.findViewById(R.id.tv_date);
        }
    }

    public void setPages(List<VehicleDetectionBean.DataBean.Type3Bean> type3) {
        this.pages = type3;
        notifyDataSetChanged();
    }

}
