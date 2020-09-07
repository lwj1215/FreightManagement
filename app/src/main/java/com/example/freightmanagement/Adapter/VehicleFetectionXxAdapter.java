package com.example.freightmanagement.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freightmanagement.Bean.VehicleDetectionBean;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.OnItemClickListener;
import com.example.freightmanagement.Utils.OnItemClickListener2;

import java.util.List;

/**
 * Created by songdechuan on 2020/8/6.
 */

public class VehicleFetectionXxAdapter extends RecyclerView.Adapter<VehicleFetectionXxAdapter.TrainingViewHolder> {
    private final LayoutInflater layoutInflater;
    private Context context;
    private List<String> dataList;
    private List<VehicleDetectionBean.DataBean.Type1Bean> pages;
    private OnItemClickListener2 listener;

    public VehicleFetectionXxAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public TrainingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VehicleFetectionXxAdapter.TrainingViewHolder(layoutInflater.inflate(R.layout.vehicle_xx_layout, parent, false));
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
                    if (position== pages.size() - 1){
                        listener.onItemClick(v, position,holder.edy_text.getText().toString());
                    }else {
                        listener.onItemClick(v, position,"");
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
        private CheckBox tv_date;
        private EditText edy_text;
        private View itemView;

        public TrainingViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            tv_date = itemView.findViewById(R.id.tv_date);
            edy_text = itemView.findViewById(R.id.edy_text);
        }
    }

    public void setPages(List<VehicleDetectionBean.DataBean.Type1Bean> type1) {
        this.pages = type1;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener2 listener) {
        this.listener = listener;
    }
}
