package com.resmenu.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.resmenu.R;
import com.resmenu.adapters.LiveTableAdapter;

public class TablesActivity extends AppCompatActivity {
    private RecyclerView mRecyclerViewTable;
    public static String role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables);
        role=getIntent().getStringExtra("role");

        init();
    }

    private void init() {

        mRecyclerViewTable=findViewById(R.id.recycler_view_live_tables);
        mRecyclerViewTable.setLayoutManager(new GridLayoutManager(this,4));
        LiveTableAdapter liveTableAdapter=new LiveTableAdapter(this);
        mRecyclerViewTable.setAdapter(liveTableAdapter);
    }
}
