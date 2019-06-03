package com.resmenu.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.resmenu.Database.Entity.UserTable;
import com.resmenu.Database.RestaurentMenuDatabase;
import com.resmenu.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityViewBill extends AppCompatActivity {

    RestaurentMenuDatabase restaurentMenuDatabase;
    List<UserTable> userTables = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_bill);
        restaurentMenuDatabase = RestaurentMenuDatabase.getInstance(ActivityViewBill.this);
        getBill();
    }

    public void getBill(){

       userTables = restaurentMenuDatabase.myUserTableDao().getDataByTableNo(1);

       System.out.println("userTables    :--- "+userTables.size());

    }
}
