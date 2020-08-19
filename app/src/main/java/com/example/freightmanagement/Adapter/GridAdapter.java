package com.example.freightmanagement.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.example.freightmanagement.R;
import com.example.freightmanagement.listener.OnPicturesClickListener;

import java.util.List;

import androidx.appcompat.view.menu.MenuBuilder;
import androidx.recyclerview.widget.RecyclerView;
import me.kareluo.ui.OptionMenu;
import me.kareluo.ui.OptionMenuView;
import me.kareluo.ui.PopupMenuView;
import me.kareluo.ui.PopupView;

/**
 * Created by songdechuan on 2020/8/19.
 */

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder>{
    private final LayoutInflater layoutInflater;
    private Context context;
    private List<String> pathList;
    /**
     * 删除小弹窗
     */
    PopupMenuView menuView;

    /**
     * 设置点击添加按钮的监听
     */
    public void setOnAddPicturesListener(OnPicturesClickListener listener) {
        this.listener = listener;
    }

    OnPicturesClickListener listener;

    private int deletePosition;
    public GridAdapter(Context context,List<String> pathList) {
        this.context = context;
        this.pathList = pathList;
        pathList.add("");
        layoutInflater = LayoutInflater.from(context);
        initDeleteMenu();
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.item_image_select, parent, false));

    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        ImageView ivThum = viewHolder.iv_thum;
        ImageView ivAdd = viewHolder.iv_add;
        String item = pathList.get(position);
        if (item.equals("")) {
            //item为添加按钮
            ivThum.setVisibility(View.GONE);
            ivAdd.setVisibility(View.VISIBLE);
        } else {
            //item为普通图片
            ivThum.setVisibility(View.VISIBLE);
            ivAdd.setVisibility(View.GONE);
        }
//        Glide.with(mContext).load(item).into(ivThum);
        ivThum.setOnClickListener(new PicturesClickListener(position));
        ivAdd.setOnClickListener(new PicturesClickListener(position));

        ivThum.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                deletePosition = position;
                //最上面的三个删除按钮是往下的  其他的都是往上的
                if (position < 3) {
                    menuView.setSites(PopupView.SITE_BOTTOM);
                } else {
                    menuView.setSites(PopupView.SITE_TOP);
                }
                menuView.show(view);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return null == pathList || pathList.size() == 0 ? 0 : pathList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_thum;
        ImageView iv_add;
        private View itemView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            iv_thum = itemView.findViewById(R.id.iv_thum);
            iv_add = itemView.findViewById(R.id.iv_add);
        }
    }

    /**
     * 图片点击事件
     */
    private class PicturesClickListener implements View.OnClickListener {

        int position;

        public PicturesClickListener(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View view) {
            if (listener == null)
                return;
            switch (view.getId()) {
                case R.id.iv_thum:
                    //点击图片
                    listener.onClick(position);
                    break;
                case R.id.iv_add:
                    //点击添加按钮
                    listener.onAdd();
                    break;
            }
        }
    }
    /**
     * 初始化图片删除小弹窗
     */
    private void initDeleteMenu() {
        menuView = new PopupMenuView(context, R.menu.menu_pop, new MenuBuilder(context));
        menuView.setSites(PopupView.SITE_TOP);
        menuView.setOnMenuClickListener(new OptionMenuView.OnOptionMenuClickListener() {
            @Override
            public boolean onOptionMenuClick(int position, OptionMenu menu) {
                pathList.remove(deletePosition);
                if (!pathList.get(pathList.size() - 1).equals("")) {
                    //列表最后一张不是添加按钮时，加入添加按钮
                    pathList.add("");
                }
                notifyDataSetChanged();
                return true;
            }
        });
    }
}
