package com.example.freightmanagement.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.freightmanagement.R;

import java.util.List;

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ViewHolder>{
    private final LayoutInflater layoutInflater;
    private Context context;
    private List<String> data;

    public ImageListAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ImageListAdapter.ViewHolder(layoutInflater.inflate(R.layout.item_image, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(data.get(position)).into(holder.mIv);
    }


    @Override
    public int getItemCount() {
        return  data != null && data.size() > 0 ? data.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mIv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mIv = itemView.findViewById(R.id.iv);
        }
    }
    public void setData(List<String> data) {
        this.data = data;
        notifyDataSetChanged();
    }
}
