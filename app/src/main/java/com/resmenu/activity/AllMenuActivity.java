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
import com.resmenu.POJO.MenuItem;
import com.resmenu.R;
import com.resmenu.adapters.AdapterHorizontal;
import com.resmenu.adapters.AdapterSubCat;
import com.resmenu.constants.ApiUrls;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AllMenuActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView mRecyclerMenuList;
    private RequestQueue mRequestQueue;
    ArrayList<String> arrayListMenus;
    private AdapterHorizontal adapterHorizontal;
    private AdapterSubCat adapterSubCat;
    public static final String TAG = AllMenuActivity.class.getSimpleName();
    String menu_type;
    ArrayList<MenuItem> menuItemArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_menu);

        Bundle bundle = getIntent().getExtras();
        menu_type = bundle.getString("menu_id");
        Log.e(TAG, "Menu_type  :- " + menu_type);
        arrayListMenus = bundle.getStringArrayList("menu_list");

        init();
    }

    private void init() {
        mRecyclerView = findViewById(R.id.recycler_menu_tital);
        mRecyclerMenuList = findViewById(R.id.recycler_menu_List);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mRecyclerMenuList.setLayoutManager(new LinearLayoutManager(this));

        adapterHorizontal = new AdapterHorizontal(this, arrayListMenus);
        mRecyclerView.setAdapter(adapterHorizontal);

       getMenuItem(0, Integer.parseInt(menu_type));

    }
    public void getMenuItem(int hotelID,int menuID){
        mRequestQueue = Volley.newRequestQueue(this);
        final StringRequest request = new StringRequest(Request.Method.GET, ApiUrls.mUrlSubCategories, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

                Log.e("sadddsasasa",""+s.toString());

                try {

                    JSONObject object = new JSONObject(s);
                    int sucess_code=object.getInt("success");
                    if (sucess_code==1){
                        menuItemArrayList=new ArrayList<>();
                        JSONArray array =object.getJSONArray("result");
                        Log.e("dddddddddd",""+array.toString());
                        for (int i = 0 ; i<array.length();i++){
                            JSONObject jsonObject=array.getJSONObject(i);
                            int id=jsonObject.getInt("ItemId");
                            int ItemRating=jsonObject.getInt("ItemRating");
                            String ItemName=jsonObject.getString("ItemName");
                            String ItemPic=jsonObject.getString("ItemPic");
                            String ItemDescription=jsonObject.getString("ItemDescription");
                            String ItemPrize=jsonObject.getString("ItemPrize");

                            MenuItem menuItem=new MenuItem(id,ItemRating,ItemName,ItemPic,ItemDescription,ItemPrize);
                            menuItemArrayList.add(menuItem);

                        }
                        adapterSubCat =new AdapterSubCat(AllMenuActivity.this,menuItemArrayList);
                        mRecyclerMenuList.setAdapter(adapterSubCat);
                    }

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
