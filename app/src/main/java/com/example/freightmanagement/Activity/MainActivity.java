package com.example.freightmanagement.Activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.freightmanagement.Adapter.FragmentIndexAdapter;
import com.example.freightmanagement.Base.BaseActivity;
import com.example.freightmanagement.Fragment.AccountFragment;
import com.example.freightmanagement.Fragment.HomeFragment;
import com.example.freightmanagement.Fragment.MeetingFragment;
import com.example.freightmanagement.R;
import com.example.freightmanagement.View.MyViewPager;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private MyViewPager index_vp_fragment_list_top;
    private LinearLayout index_bottom_bar_home, index_bottom_bar_dynamic_state, index_bottom_bar_me;
    private ImageView index_bottom_bar_home_image, index_bottom_bar_dynamic_state_image, index_bottom_bar_me_image;
    private ArrayList<Fragment> mFragments;
    private FragmentIndexAdapter mFragmentIndexAdapter;

    @Override
    public int setLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    protected void onInitView() {
        index_vp_fragment_list_top = (MyViewPager) bindView(R.id.index_vp_fragment_list_top);
        index_bottom_bar_home = (LinearLayout) bindView(R.id.index_bottom_bar_home);//首页
        index_bottom_bar_dynamic_state = (LinearLayout) bindView(R.id.index_bottom_bar_dynamic_state);//会议
        index_bottom_bar_me = (LinearLayout) bindView(R.id.index_bottom_bar_me);//账户
        index_bottom_bar_home_image = (ImageView) bindView(R.id.index_bottom_bar_home_image);
        index_bottom_bar_dynamic_state_image = (ImageView) bindView(R.id.index_bottom_bar_dynamic_state_image);
        index_bottom_bar_me_image = (ImageView) bindView(R.id.index_bottom_bar_me_image);

    }

    @Override
    protected void onLoadData2Remote() {
        initData();
        initEvent();
    }

    private void initData() {
        mFragments = new ArrayList<Fragment>();
        mFragments.add(new HomeFragment());//首页
        mFragments.add(new MeetingFragment());//会议
        mFragments.add(new AccountFragment());//我的
        initIndexFragmentAdapter();
    }

    private void initEvent() {
        index_bottom_bar_home.setOnClickListener(new TabOnClickListener(0));
        index_bottom_bar_dynamic_state.setOnClickListener(new TabOnClickListener(1));
        index_bottom_bar_me.setOnClickListener(new TabOnClickListener(2));
    }

    private void initIndexFragmentAdapter() {
        mFragmentIndexAdapter = new FragmentIndexAdapter(this.getSupportFragmentManager(), mFragments);
        index_vp_fragment_list_top.setAdapter(mFragmentIndexAdapter);
        index_bottom_bar_home.setSelected(true);
        index_vp_fragment_list_top.setCurrentItem(0);
        index_vp_fragment_list_top.setOffscreenPageLimit(3);
        index_vp_fragment_list_top.addOnPageChangeListener(new TabOnPageChangeListener());
    }

    /**
     * Bottom_Bar的点击事件
     */
    public class TabOnClickListener implements View.OnClickListener {

        private int index = 0;

        public TabOnClickListener(int i) {
            index = i;
        }

        public void onClick(View v) {
            //选择某一页
            index_vp_fragment_list_top.setCurrentItem(index, false);

        }

    }
    public class TabOnPageChangeListener implements ViewPager.OnPageChangeListener {

        //当滑动状态改变时调用
        public void onPageScrollStateChanged(int state) {
        }

        //当前页面被滑动时调用
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        //当新的页面被选中时调用
        public void onPageSelected(int position) {
            resetTextView();
            switch (position) {
                case 0:
                    index_bottom_bar_home.setSelected(true);
                    break;
                case 1:
                    index_bottom_bar_dynamic_state.setSelected(true);
                    break;
                case 2:
                    index_bottom_bar_me.setSelected(true);
                    break;
            }
        }
    }

    /**
     * 重置所有TextView的字体颜色
     */
    private void resetTextView() {
        index_bottom_bar_home.setSelected(false);
        index_bottom_bar_dynamic_state.setSelected(false);
        index_bottom_bar_me.setSelected(false);
    }

    @Override
    protected boolean getFitsSystemWindows() {
        return false;
    }

}
