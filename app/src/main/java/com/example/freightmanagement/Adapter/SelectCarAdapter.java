package com.example.freightmanagement.Adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freightmanagement.Bean.CheliangJcBean;
import com.example.freightmanagement.Bean.SelectCarBean;
import com.example.freightmanagement.R;
import com.google.gson.internal.$Gson$Preconditions;

import java.util.HashMap;
import java.util.List;

/**
 * Created by songdechuan on 2020/8/6.
 */

public class SelectCarAdapter extends RecyclerView.Adapter<SelectCarAdapter.ViewHolder> {
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

    public SelectCarAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         return new SelectCarAdapter.ViewHolder(layoutInflater.inflate(R.layout.item_select_car, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        if (data==null||data.get(position)==null||data.get(position).getCertificateRegistrationBo()==null){
            return;
        }
        if (!TextUtils.isEmpty(data.get(position).getCertificateRegistrationBo().getOwner())){
            holder.tv_name.setText(data.get(position).getCertificateRegistrationBo().getOwner());
        }if (!TextUtils.isEmpty(data.get(position).getCertificateRegistrationBo().getCarBrand())){
            holder.tv_brand.setText(data.get(position).getCertificateRegistrationBo().getCarBrand());
        }

        holder.tv_brand.setText(data.get(position).getCertificateRegistrationBo().getGrantNo());
        holder.rb_check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    clearState();
                    setCheckedState(position);
                    mItemClickListener.onItemClick(position);
                    if(!isBind){ //标识位
                        notifyDataSetChanged();
                    }
                }
            }
        });
        //注意setChecked与setOnCheckedChangeListener的顺序，同样会导致错乱
        holder.rb_check.setChecked(states.get(position));
        isBind = false;

    }


    private void clearState() {
        for (int i = 0; i < getItemCount(); i++) {
            states.put(i, false);
        }
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
        RadioButton rb_check;

        private View itemView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_number = itemView.findViewById(R.id.tv_number);
            tv_brand = itemView.findViewById(R.id.tv_brand);
            rb_check = itemView.findViewById(R.id.rb_check);

        }
    }

    public void setData(List<SelectCarBean.DataBean> data) {
        this.data = data;
        clearState();
        notifyDataSetChanged();
    }
}
