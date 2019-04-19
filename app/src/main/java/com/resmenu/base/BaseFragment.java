package com.resmenu.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {

    View mRootView;
    protected BaseBackstackManagerActivity mParentActivity;
    protected CommanUtils mCommanUtils;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getRootView(),container,false);
        ButterKnife.bind(this , mRootView);
        init();
        return mRootView;
    }

    protected abstract int getRootView();


    protected abstract void init();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mParentActivity = (BaseBackstackManagerActivity) context;
        mCommanUtils = new CommanUtils(mParentActivity);
    }


}
