package com.example.freightmanagement.Adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.OnItemClickListener;

import java.util.List;

/**
 * 所有分类   Adapter
 */
public class HomeFragmentAdapter extends RecyclerView.Adapter<HomeFragmentAdapter.HomeViewHolder> {


    private Context context;
    private final LayoutInflater layoutInflater;
    private List<String> dataList;
    private OnItemClickListener listener;
    private int selectorPosition;
    private int playcount;

    public void setData(List<String> commendarray) {
        this.dataList = commendarray;
        notifyDataSetChanged();
    }

    public HomeFragmentAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeFragmentAdapter.HomeViewHolder(layoutInflater.inflate(R.layout.home_item_layout, parent, false));

    }

    @Override
    public void onBindViewHolder(final HomeViewHolder holder, final int position) {
        if (dataList != null && dataList.size() > 0) {
            holder.tv_name.setText(dataList.get(position).toString());

        } else {
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
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

    public class HomeViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tv_name;
        private View itemView;

        public HomeViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            tv_name = itemView.findViewById(R.id.tv_name);
            img = itemView.findViewById(R.id.home_jp_img);
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
