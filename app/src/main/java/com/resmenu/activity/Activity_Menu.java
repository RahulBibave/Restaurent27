package com.resmenu.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.resmenu.R;
import com.resmenu.adapters.AdapterMenu;

public class Activity_Menu extends AppCompatActivity {

    private RecyclerView mRecyclerViewMenu;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        init();
    }

    private void init() {
        mRecyclerViewMenu=findViewById(R.id.recycler_menu);
        mRecyclerViewMenu.setLayoutManager(new LinearLayoutManager(this));
        AdapterMenu adapterMenu=new AdapterMenu(this);
        mRecyclerViewMenu.setAdapter(adapterMenu);
    }
}
