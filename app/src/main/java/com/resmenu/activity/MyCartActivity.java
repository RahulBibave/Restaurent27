package com.resmenu.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.resmenu.Database.Entity.MyCart;
import com.resmenu.Database.RestaurentMenuDatabase;
import com.resmenu.R;
import com.resmenu.adapters.MyCartAdapter;
import com.resmenu.customViews.CustomButton;
import com.resmenu.customViews.CustomTextView;
import com.resmenu.interfaces.DataTransfer;

import java.util.ArrayList;
import java.util.List;

public class MyCartActivity extends AppCompatActivity implements DataTransfer {


    private RecyclerView mRecyclerViewCart;
    private MyCartAdapter myCartAdapter;
    private List<MyCart> myCartArrayList;
    RestaurentMenuDatabase restaurentMenuDatabase;

    private CustomButton mBtnPproceedtopay;
    private CustomButton mBtnContinueorde;
    private CustomTextView mTvNoItems , mTvTotalAMount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);

        mBtnPproceedtopay = findViewById(R.id.btn_proceedtopay);
        mBtnContinueorde = findViewById(R.id.btn_continueorder);
        mTvTotalAMount = findViewById(R.id.tv_amount);

        mTvNoItems = findViewById(R.id.tv_no_items);

        mRecyclerViewCart = findViewById(R.id.recycler_virw_cart);
        myCartArrayList = new ArrayList<>();

        getDatabaseList();

        mBtnContinueorde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void getDatabaseList() {

        restaurentMenuDatabase = RestaurentMenuDatabase.getInstance(this);
        myCartArrayList = restaurentMenuDatabase.myCartDao().getAll();

        if (myCartArrayList.size() == 0 && myCartArrayList.isEmpty()) {
            mTvNoItems.setVisibility(View.VISIBLE);
            mBtnPproceedtopay.setEnabled(false);
            mBtnContinueorde.setEnabled(false);
        }else {
            myCartAdapter = new MyCartAdapter(this, myCartArrayList , restaurentMenuDatabase,this);
            mRecyclerViewCart.setLayoutManager(new LinearLayoutManager(this));
            mRecyclerViewCart.setAdapter(myCartAdapter);
        }
    }

    @Override
    public void setValues(double total) {
        mTvTotalAMount.setText(""+total);
    }


/*

    private RecyclerView mRecyclerViewCart;
    private MyCartAdapter myCartAdapter;
    private List<MyCart> myCartArrayList;
    RestaurentMenuDatabase restaurentMenuDatabase;

    private CustomButton mBtnPproceedtopay;
    private CustomButton mBtnContinueorde;
    private CustomTextView mTvNoItems , mTvTotalAMount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);

        mBtnPproceedtopay = findViewById(R.id.btn_proceedtopay);
        mBtnContinueorde = findViewById(R.id.btn_continueorder);
        mTvTotalAMount = findViewById(R.id.tv_amount);

        mTvNoItems = findViewById(R.id.tv_no_items);

        mRecyclerViewCart = findViewById(R.id.recycler_virw_cart);
        myCartArrayList = new ArrayList<>();

        getDatabaseList();

        mBtnContinueorde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void getDatabaseList() {

        restaurentMenuDatabase = RestaurentMenuDatabase.getInstance(this);
        myCartArrayList = restaurentMenuDatabase.myCartDao().getAll();

        if (myCartArrayList.size() == 0 && myCartArrayList.isEmpty()) {
            mTvNoItems.setVisibility(View.VISIBLE);
            mBtnPproceedtopay.setEnabled(false);
            mBtnContinueorde.setEnabled(false);
        }else {
            myCartAdapter = new MyCartAdapter(this, myCartArrayList , restaurentMenuDatabase,this);
            mRecyclerViewCart.setLayoutManager(new LinearLayoutManager(this));
            mRecyclerViewCart.setAdapter(myCartAdapter);
        }
    }

    @Override
    public void setValues(double total) {
            mTvTotalAMount.setText(""+total);
    }


*/
}
