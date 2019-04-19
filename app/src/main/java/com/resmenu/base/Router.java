package com.resmenu.base;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

public class Router {
    private AppCompatActivity mParentActivity;

    public Router(AppCompatActivity mParentActivity) {
        this.mParentActivity = mParentActivity;
    }


    // start activity will start new activity
    public void startActivity(Class nextActivityName){
        mParentActivity.startActivity(new Intent(mParentActivity , nextActivityName).setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP));
    }


}
