package com.resmenu.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
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
import com.resmenu.POJO.Menu;
import com.resmenu.R;
import com.resmenu.adapters.AdapterMenu;
import com.resmenu.constants.ApiUrls;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Activity_Menu extends AppCompatActivity {

    private RecyclerView mRecyclerViewMenu;
    RequestQueue mRequestQueue;
    private ArrayList<Menu> arrayList;
    private AdapterMenu adapterMenu;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        init();
    }

    private void init() {
        mRecyclerViewMenu=findViewById(R.id.recycler_menu);
        mRecyclerViewMenu.setLayoutManager(new LinearLayoutManager(this));

        mRequestQueue = Volley.newRequestQueue(Activity_Menu.this);
        final StringRequest request = new StringRequest(Request.Method.GET, ApiUrls.mUrlMenuList, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

                Log.e("saddd",""+s.toString());
                   arrayList=new ArrayList<Menu>();
                try {
                    JSONObject object = new JSONObject(s);
                    JSONArray array =object.getJSONArray("result");
                    Log.e("dddddddddd",""+array.toString());
                    for (int i = 0 ; i<array.length();i++){
                        JSONObject jsonObject=array.getJSONObject(i);
                        String pic=jsonObject.getString("ItemTypePic");
                        int id=jsonObject.getInt("ItemTypeid");
                        String ItemTypeName=jsonObject.getString("ItemTypeName");
                        Menu menu=new Menu(id+"",ItemTypeName,pic);
                        arrayList.add(menu);

                    }
                    adapterMenu=new AdapterMenu(arrayList,Activity_Menu.this);
                    mRecyclerViewMenu.setAdapter(adapterMenu);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("saddd",volleyError.toString());

            }
        });

        mRequestQueue.add(request);


    }
}
