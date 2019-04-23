package com.resmenu.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.resmenu.Database.Entity.MyCart;
import com.resmenu.Database.RestaurentMenuDatabase;
import com.resmenu.R;
import com.resmenu.adapters.MyCartAdapter;
import com.resmenu.customViews.CustomButton;

import java.util.ArrayList;
import java.util.List;

public class MyCartActivity extends AppCompatActivity {

    RecyclerView mRecyclerViewCart;
    MyCartAdapter myCartAdapter;
    List<MyCart> myCartArrayList;

    CustomButton mBtnPproceedtopay;
    CustomButton mBtnContinueorde;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);

        mBtnPproceedtopay = findViewById(R.id.btn_proceedtopay);
        mBtnContinueorde = findViewById(R.id.btn_continueorder);

        mRecyclerViewCart = findViewById(R.id.recycler_virw_cart);
        myCartArrayList = new ArrayList<>();

        getDatabaseList();

//
    }

    private void getDatabaseList() {

        RestaurentMenuDatabase restaurentMenuDatabase = RestaurentMenuDatabase.getInstance(this);
        myCartArrayList = restaurentMenuDatabase.myCartDao().getAll();

        myCartAdapter = new MyCartAdapter(this ,myCartArrayList);
        mRecyclerViewCart.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerViewCart.setAdapter(myCartAdapter);
    }
}
