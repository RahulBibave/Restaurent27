package com.resmenu.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.resmenu.R;
import com.resmenu.adapters.AdapterKitchen;

public class ActivityKitchen extends AppCompatActivity {

    private RecyclerView mRecyclerViewKitchen;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen);
        init();
    }

    private void init() {
        mRecyclerViewKitchen=findViewById(R.id.recycler_kitchen);
        mRecyclerViewKitchen.setLayoutManager(new LinearLayoutManager(this));
        AdapterKitchen adapterKitchen=new AdapterKitchen(this);
        mRecyclerViewKitchen.setAdapter(adapterKitchen);
    }
}
