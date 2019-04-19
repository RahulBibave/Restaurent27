package com.resmenu.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;

import com.resmenu.POJO.PagerList;
import com.resmenu.fragment.Breakfast;

import java.util.List;

public class MenuAdapterViewPager extends FragmentPagerAdapter {

    List<PagerList> mPagerList;
    Context mContext;
    private LayoutInflater inflater=null;
    public static final int NUMBERS = 1;



    public MenuAdapterViewPager(FragmentManager fm) {
        super(fm);
    }


    @Override
    public int getCount() {
        return NUMBERS;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:// Fragment # 0 - This will show FirstFragment

                return Breakfast.newInstance(0, "Page # 1");
            default:
                return null;
        }
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }
}
