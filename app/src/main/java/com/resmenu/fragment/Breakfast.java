package com.resmenu.fragment;

import android.os.Bundle;

import com.resmenu.R;
import com.resmenu.base.BaseFragment;
import com.resmenu.customViews.CustomTextView;

import butterknife.BindView;

public class Breakfast extends BaseFragment {

    private String title;
    private int page;

    public static Breakfast newInstance(){
        return new Breakfast();
    }

    @BindView(R.id.tv_breakfastr)
    CustomTextView mTvBrekfast;

    @Override
    protected int getRootView() {
        return R.layout.breakfast_menu;
    }

    @Override
    protected void init() {
      /*  mTvBrekfast.setText("Breakfast");
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");*/
    }

    public static Breakfast newInstance(int page, String title) {
        Breakfast fragmentFirst = new Breakfast();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

}
