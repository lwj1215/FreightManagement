package com.example.freightmanagement.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freightmanagement.Bean.SelectCarBean;
import com.example.freightmanagement.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by songdechuan on 2020/8/6.
 */

public class CarListAdapter extends RecyclerView.Adapter<CarListAdapter.ViewHolder> {
    private final LayoutInflater layoutInflater;
    private Context context;
    private List<SelectCarBean.DataBean> data;
    private static int TAG_VIEW = 0;
    private String TAG = "GiftAdapter";
    private HashMap<Integer, Boolean> states = new HashMap<>();
    private boolean isBind;

    // 利用接口 -> 给RecyclerView设置点击事件
    private ItemClickListener mItemClickListener ;
    public interface ItemClickListener{
        void onItemClick(int position) ;
    }
    public void setOnItemClickListener(ItemClickListener itemClickListener){
        this.mItemClickListener = itemClickListener ;

    }
    // 昌电机
    private ItemLongClickListener mItemLongClickListener ;
    public interface ItemLongClickListener{
        void onItemLongClick(int position) ;
    }
    public void setOnItemLongClickListener(ItemLongClickListener itemLongClickListener){
        this.mItemLongClickListener = itemLongClickListener ;

    }
    public CarListAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         return new CarListAdapter.ViewHolder(layoutInflater.inflate(R.layout.item_car_info, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.tv_name.setText(data.get(position).getCertificateDrivingBo().getOwner());
        holder.tv_brand.setText(data.get(position).getCertificateRegistrationBo().getCarBrand());
        holder.tv_brand.setText(data.get(position).getCertificateRegistrationBo().getGrantNo());
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(mItemLongClickListener != null){
                    mItemLongClickListener.onItemLongClick(position);
                }
                return false;
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mItemClickListener != null){
                    mItemClickListener.onItemClick(position);
                }
            }
        });
    }


    private void setCheckedState(int position) {
        states.put(position, true);
    }

    @Override
    public int getItemCount() {
        return  data != null && data.size() > 0 ? data.size() : 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name;
        TextView tv_number;
        TextView tv_brand;

        private View itemView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_number = itemView.findViewById(R.id.tv_number);
            tv_brand = itemView.findViewById(R.id.tv_brand);
        }
    }

    public void setData(List<SelectCarBean.DataBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }
}
