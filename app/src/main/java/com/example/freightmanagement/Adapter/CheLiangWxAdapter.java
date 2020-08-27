package com.example.freightmanagement.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.freightmanagement.Bean.CheliangJcBean;
import com.example.freightmanagement.Bean.CheliangWeiXiuBean;
import com.example.freightmanagement.R;

import java.util.List;

/**
 * Created by songdechuan on 2020/8/6.
 */

public class CheLiangWxAdapter extends RecyclerView.Adapter<CheLiangWxAdapter.TrainingViewHolder> {
    private final LayoutInflater layoutInflater;
    private Context context;
    private List<CheliangWeiXiuBean.DataBean> pages;

    public CheLiangWxAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public TrainingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CheLiangWxAdapter.TrainingViewHolder(layoutInflater.inflate(R.layout.wei_xiu_ji_lu, parent, false));
    }

    @Override
    public void onBindViewHolder(TrainingViewHolder holder, int position) {
        if (pages != null) {
            holder.et_xing_shi_li_cheng.setText(pages.get(position).getPartMaker()+"");
            holder.et_wei_xiu_dan_wei.setText(pages.get(position).getServicer()+"");
            holder.et_wei_xiu_nei_rong.setText(pages.get(position).getContent()+"");
            holder.et_bu_jian_chang_jia.setText(pages.get(position).getBillPicUrl()+"");
            holder.tv_wei_xiu_shi_jian.setText(pages.get(position).getTime()+"");
        }
    }

    @Override
    public int getItemCount() {
        return  pages != null && pages.size() > 0 ? pages.size() : 0;

    }

    public class TrainingViewHolder extends RecyclerView.ViewHolder {
        TextView et_xing_shi_li_cheng,et_wei_xiu_dan_wei,et_wei_xiu_nei_rong,et_bu_jian_chang_jia,tv_wei_xiu_shi_jian;
        private View itemView;

        public TrainingViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            et_xing_shi_li_cheng = itemView.findViewById(R.id.et_xing_shi_li_cheng);
            et_wei_xiu_dan_wei = itemView.findViewById(R.id.et_wei_xiu_dan_wei);
            et_wei_xiu_nei_rong = itemView.findViewById(R.id.et_wei_xiu_nei_rong);
            et_bu_jian_chang_jia = itemView.findViewById(R.id.et_bu_jian_chang_jia);
            tv_wei_xiu_shi_jian = itemView.findViewById(R.id.tv_wei_xiu_shi_jian);
        }
    }

    public void setPages(List<CheliangWeiXiuBean.DataBean> data) {
        this.pages = data;
        notifyDataSetChanged();
    }
}
