package com.example.freightmanagement.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.OnItemClickListener;
import com.pili.pldroid.player.widget.PLVideoView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Created by songdechuan on 2020/8/6.
 */

public class TrainingHtmlAdapter extends RecyclerView.Adapter<TrainingHtmlAdapter.TrainingViewHolder> {
    private final LayoutInflater layoutInflater;
    private Context context;
    private List<String> dataList;
    private OnItemClickListener listener;
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
    public void setData(List<String> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }
    public TrainingHtmlAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }
    @Override
    public TrainingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TrainingHtmlAdapter.TrainingViewHolder(layoutInflater.inflate(R.layout.item_html, parent, false));
    }

    @Override
    public void onBindViewHolder(TrainingViewHolder holder, final int position) {
        String s = dataList.get(position);
        if(s.contains(".html")){
            holder.tvHtml.setText(position+1+".文档");
        }else if(s.contains(".mp4")){
            holder.tvHtml.setText(position+1+".视频");
        }else {
            holder.tvHtml.setText(position+1+".其他");
        }
        holder.tvHtml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(v, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return null == dataList || dataList.size() == 0 ? 0 : dataList.size();

    }

    public class TrainingViewHolder extends RecyclerView.ViewHolder {
        TextView tvHtml;
        private View itemView;

        public TrainingViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            tvHtml = itemView.findViewById(R.id.iv_html_txt);
        }
    }
}
