package com.example.freightmanagement.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freightmanagement.Bean.VehicleDetectionBean;
import com.example.freightmanagement.Bean.VerAddBean;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by songdechuan on 2020/8/6.
 */

public class VehicleFetectionAdapter extends RecyclerView.Adapter<VehicleFetectionAdapter.TrainingViewHolder> {
    private final LayoutInflater layoutInflater;
    private Context context;
    private List<String> dataList;
    private VehicleDetectionBean.DataBean pages;
    private VerAddBean verAddBean=new VerAddBean();
    private VerAddBean.CompleteBosBean completeBosBean=new VerAddBean.CompleteBosBean();
    private List<VerAddBean.CompleteBosBean>     lisBean=new ArrayList<>();
    private OnHdListener listener;

    public VehicleFetectionAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public TrainingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VehicleFetectionAdapter.TrainingViewHolder(layoutInflater.inflate(R.layout.vehicle_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(TrainingViewHolder holder, int position) {
        if (pages != null) {
            if (position==0) {
                holder.tv_date.setText("(1) 行车前");
                for (int i = 0; i <pages.getType1().size() ; i++) {
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 4, GridLayoutManager.VERTICAL, false);
                    gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    holder.recyclerView1.setLayoutManager(gridLayoutManager);
                    VehicleFetectionXxAdapter vehicleFetectionAdapter = new VehicleFetectionXxAdapter(context);
                    holder.recyclerView1.setAdapter(vehicleFetectionAdapter);
                    vehicleFetectionAdapter.setPages(pages.getType1());
                    vehicleFetectionAdapter.setOnItemClickListener(new OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {

                            completeBosBean.setChechDataId(pages.getType1().get(position).getId());
                            completeBosBean.setState(1);
                            completeBosBean.setReslut("");
                            lisBean.add(completeBosBean);
                            verAddBean.setCompleteBos(lisBean);

                            if (listener != null) {
                                listener.onItemClick(verAddBean);
                            }
                        }
                    });
                }
            }else if (position==1) {
                holder.tv_date.setText("(2) 行车中");
                for (int i = 0; i <pages.getType2().size() ; i++) {
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 4, GridLayoutManager.VERTICAL, false);
                    gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    holder.recyclerView1.setLayoutManager(gridLayoutManager);
                    VehicleFetectionXx2Adapter vehicleFetectionAdapter = new VehicleFetectionXx2Adapter(context);
                    holder.recyclerView1.setAdapter(vehicleFetectionAdapter);
                    vehicleFetectionAdapter.setPages(pages.getType2());
                    vehicleFetectionAdapter.setOnItemClickListener(new OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {

                            completeBosBean.setChechDataId(pages.getType2().get(position).getId());
                            completeBosBean.setState(1);
                            completeBosBean.setReslut("");
                            lisBean.add(completeBosBean);
                            verAddBean.setCompleteBos(lisBean);
                            if (listener != null) {
                                listener.onItemClick(verAddBean);
                            }
                        }
                    });
                }
            } else {
                holder.tv_date.setText("(3) 行车后");
                GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 4, GridLayoutManager.VERTICAL, false);
                gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                holder.recyclerView1.setLayoutManager(gridLayoutManager);
                VehicleFetectionXx3Adapter vehicleFetectionAdapter = new VehicleFetectionXx3Adapter(context);
                holder.recyclerView1.setAdapter(vehicleFetectionAdapter);
                vehicleFetectionAdapter.setPages(pages.getType3());
                vehicleFetectionAdapter.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                        completeBosBean.setChechDataId(pages.getType3().get(position).getId());
                        completeBosBean.setState(1);
                        completeBosBean.setReslut("");
                        lisBean.add(completeBosBean);
                        verAddBean.setCompleteBos(lisBean);
                        if (listener != null) {
                            listener.onItemClick(verAddBean);
                        }
                    }
                });
                }
            }
    }

    @Override
    public int getItemCount() {
        return 3;

    }

    public class TrainingViewHolder extends RecyclerView.ViewHolder {
        TextView tv_date;
        RecyclerView recyclerView1;
        private View itemView;

        public TrainingViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            tv_date = itemView.findViewById(R.id.tv_date);
            recyclerView1 = itemView.findViewById(R.id.llayout);
        }
    }

    public void setPages(VehicleDetectionBean.DataBean data) {
        this.pages = data;
        notifyDataSetChanged();
    }

    public void setOnHdListener(OnHdListener listener) {
        this.listener = listener;
    }

    public interface OnHdListener {
        void onItemClick(VerAddBean verAddBean);
    }
}
