package com.example.freightmanagement.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.recyclerview.widget.RecyclerView;

import com.example.freightmanagement.Bean.VehicleDetectionBean;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.OnItemClickListener;

import java.util.List;

/**
 * Created by songdechuan on 2020/8/6.
 */

public class VehicleFetectionXx2Adapter extends RecyclerView.Adapter<VehicleFetectionXx2Adapter.TrainingViewHolder> {
    private final LayoutInflater layoutInflater;
    private Context context;
    private List<String> dataList;
    private List<VehicleDetectionBean.DataBean.Type2Bean> pages;
    private OnItemClickListener listener;

    public VehicleFetectionXx2Adapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public TrainingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VehicleFetectionXx2Adapter.TrainingViewHolder(layoutInflater.inflate(R.layout.vehicle_xx_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(TrainingViewHolder holder, final int position) {
        if (pages != null) {
            holder.tv_date.setText(pages.get(position).getItem());
            holder.tv_date.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onItemClick(v, position);
                    }
                }
            });
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

    public void setPages(List<VehicleDetectionBean.DataBean.Type2Bean> type2) {
        this.pages = type2;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

}
