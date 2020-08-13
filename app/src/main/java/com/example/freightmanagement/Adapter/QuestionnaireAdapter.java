package com.example.freightmanagement.Adapter;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.freightmanagement.Base.BaseViewPageFragment;

import java.util.List;

/***
 * 问卷中viewpager的adapter
 */
public class QuestionnaireAdapter extends FragmentPagerAdapter {

    public QuestionnaireAdapter(FragmentManager fm, List<BaseViewPageFragment> fragmentlist) {
        super(fm);
        this.fragmentlist = fragmentlist;
    }

    private List<BaseViewPageFragment> fragmentlist;

    @Override
    public Fragment getItem(int position) {
        return fragmentlist.get(position);
    }

    @Override
    public int getCount() {
        return fragmentlist.size();
    }
}
