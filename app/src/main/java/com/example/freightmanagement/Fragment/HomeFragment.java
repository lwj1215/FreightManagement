package com.example.freightmanagement.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freightmanagement.Adapter.HomeFragmentAdapter;
import com.example.freightmanagement.Base.BaseFragment;
import com.example.freightmanagement.R;
import com.example.freightmanagement.Utils.OnItemClickListener;
import com.example.freightmanagement.Utils.ToastUtils;

import java.util.Arrays;


public class HomeFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private String[] mName=new String[]{"驾驶员信息","车辆信息","岗前培训","聘用合同","签订承诺书","签订责任书","公司例会","修改密码","关于"};
    private HomeFragmentAdapter jp_adapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.home_fragment;
    }

    @Override
    protected void onInitView(Bundle savedInstanceState) {
        recyclerView = (RecyclerView) bindView(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 3, GridLayoutManager.VERTICAL, false);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        jp_adapter = new HomeFragmentAdapter(mContext);
        recyclerView.setAdapter(jp_adapter);

    }

    @Override
    protected void onLoadData2Remote() {
        jp_adapter.setData(Arrays.asList(mName));
        jp_adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                ToastUtils.popUpToast(mName[position].toString());
            }
        });
    }
}
