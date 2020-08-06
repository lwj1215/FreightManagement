package com.example.freightmanagement.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.freightmanagement.R;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by songdechuan on 2020/8/6.
 */

public class TrainingAdapter  extends RecyclerView.Adapter<TrainingAdapter.TrainingViewHolder> {
    private final LayoutInflater layoutInflater;
    private Context context;

    public TrainingAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }
    @Override
    public TrainingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TrainingAdapter.TrainingViewHolder(layoutInflater.inflate(R.layout.home_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(TrainingViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class TrainingViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tv_name;
        private View itemView;

        public TrainingViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            tv_name = itemView.findViewById(R.id.tv_name);
            img = itemView.findViewById(R.id.home_jp_img);
        }
    }
}
