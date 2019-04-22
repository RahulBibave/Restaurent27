package com.resmenu.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.resmenu.R;
import com.resmenu.adapters.AdapterHorizontal;
import com.resmenu.adapters.AdapterSubCat;
import com.resmenu.constants.ApiUrls;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AllMenuActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView mRecyclerMenuList;
    private RequestQueue mRequestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_menu);
        init();
    }

    private void init() {
        mRecyclerView=findViewById(R.id.recycler_menu_tital);
        mRecyclerMenuList=findViewById(R.id.recycler_menu_List);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        mRecyclerMenuList.setLayoutManager(new LinearLayoutManager(this));

        AdapterHorizontal adapterHorizontal=new AdapterHorizontal(this);
        mRecyclerView.setAdapter(adapterHorizontal);


        AdapterSubCat adapterSubCat=new AdapterSubCat(this);
        mRecyclerMenuList.setAdapter(adapterSubCat);


    }





}
