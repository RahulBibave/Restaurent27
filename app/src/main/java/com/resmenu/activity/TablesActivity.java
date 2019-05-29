package com.resmenu.activity;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.resmenu.R;
import com.resmenu.constants.ApiUrls;
import com.resmenu.adapters.LiveTableAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.resmenu.activity.MainActivity.ACCESS_TOKEN;
import static com.resmenu.activity.MainActivity.PREF_NAME;

public class TablesActivity extends AppCompatActivity {
    private RecyclerView mRecyclerViewTable;
    public static String role;
    private RequestQueue mRequestQueue;
    private String accesstoken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables);
        SharedPreferences prefs = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        accesstoken = prefs.getString(ACCESS_TOKEN, null);
        getTable();
        role=getIntent().getStringExtra("role");

        init();
    }

    private void init() {

        mRecyclerViewTable=findViewById(R.id.recycler_view_live_tables);
        mRecyclerViewTable.setLayoutManager(new GridLayoutManager(this,4));
        LiveTableAdapter liveTableAdapter=new LiveTableAdapter(this);
        mRecyclerViewTable.setAdapter(liveTableAdapter);
    }

    public void getTable() {
        mRequestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, ApiUrls.mUrlTableList, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONObject object = null;
                try {
                    object = new JSONObject(response);
                    Boolean sucess_code = object.getBoolean("Status");
                    if (sucess_code.equals(true)){


                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                // Removed this line if you dont need it or Use application/json
                params.put("Authorization", "Bearer " + accesstoken);
                return params;
            }


        };
    }
}
