package com.example.freightmanagement.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.recyclerview.widget.RecyclerView;

import com.example.freightmanagement.Bean.VehicleDetectionBean;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.OnItemClickListener;
import com.example.freightmanagement.Utils.OnItemClickListener2;

import java.util.List;

/**
 * Created by songdechuan on 2020/8/6.
 */

public class VehicleFetectionXx3Adapter extends RecyclerView.Adapter<VehicleFetectionXx3Adapter.TrainingViewHolder> {
    private final LayoutInflater layoutInflater;
    private Context context;
    private List<String> dataList;
    private List<VehicleDetectionBean.DataBean.Type3Bean> pages;
    private OnItemClickListener2 listener;

    public VehicleFetectionXx3Adapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public TrainingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VehicleFetectionXx3Adapter.TrainingViewHolder(layoutInflater.inflate(R.layout.vehicle_xx_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(final TrainingViewHolder holder, final int position) {
        if (pages != null) {
            holder.tv_date.setText(pages.get(position).getItem());
            if (position == pages.size() - 1) {
                holder.edy_text.setVisibility(View.VISIBLE);
            } else {
                holder.edy_text.setVisibility(View.GONE);
            }
            holder.tv_date.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onItemClick(v, position,holder.edy_text.getText().toString());
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
        private EditText edy_text;
        public TrainingViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            tv_date = itemView.findViewById(R.id.tv_date);
            edy_text = itemView.findViewById(R.id.edy_text);
        }
    }

    public void setPages(List<VehicleDetectionBean.DataBean.Type3Bean> type3) {
        this.pages = type3;
        notifyDataSetChanged();
    }
    public void setOnItemClickListener(OnItemClickListener2 listener) {
        this.listener = listener;
    }
}
