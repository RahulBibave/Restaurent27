package com.resmenu.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.resmenu.POJO.Staff;
import com.resmenu.R;
import com.resmenu.constants.ApiUrls;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.resmenu.activity.MainActivity.ACCESS_TOKEN;
import static com.resmenu.activity.MainActivity.PREF_NAME;

public class Activity_WaiterLanding extends AppCompatActivity {


    private LinearLayout mMenu, mFeedBack;
    private RequestQueue mRequestQueue;
    private TextView txtWaiter;
    ArrayList<String> arrayListStaff;
    private LinearLayout myOrders;
    private String accesstoken;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiter_landing);
        SharedPreferences prefs = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        accesstoken = prefs.getString(ACCESS_TOKEN, null);
        getStaff();
        init();
        mMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_WaiterLanding.this, Activity_Menu.class);
                startActivity(intent);
            }
        });

        mFeedBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_WaiterLanding.this, Activity_Feedback.class);
                startActivity(intent);

            }
        });

        myOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_WaiterLanding.this, MyCartActivity.class);
                startActivity(intent);
            }
        });

    }

    private void init() {
        mMenu = findViewById(R.id.lin_menu);
        mFeedBack = findViewById(R.id.lin_feedback);
        txtWaiter = findViewById(R.id.txt_waiter);
        myOrders = findViewById(R.id.my_orders);
        txtWaiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               displayList();
            }
        });
    }

    public void getStaff() {
        mRequestQueue = Volley.newRequestQueue(Activity_WaiterLanding.this);
        final StringRequest request = new StringRequest(Request.Method.GET, ApiUrls.mUrlStaff, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

                Log.e("sadddsasasa", "" + s.toString());
                arrayListStaff = new ArrayList<>();
                try {

                    JSONObject object = new JSONObject(s);
                    int sucess_code = object.getInt("success");
                    if (sucess_code == 1) {
                        JSONArray array = object.getJSONArray("result");
                        Log.e("dddddddddd", "" + array.toString());
                        for (int i = 0; i < array.length(); i++) {
                            JSONObject jsonObject = array.getJSONObject(i);
                            int id = jsonObject.getInt("Staffid");
                            String name = jsonObject.getString("StaffName");
                            Staff staff = new Staff(name, id);
                            arrayListStaff.add(id+"");

                        }
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("saddd", volleyError.toString());

            }
        }){


            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                // Removed this line if you dont need it or Use application/json
                params.put("Authorization","Bearer "+ accesstoken);
                return params;
            }


        };
        mRequestQueue.add(request);
    }

    public void displayList() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose an animal");

// add a list
        final String[] animals = {"1", "2", "3", "4"};

        builder.setItems(animals, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                txtWaiter.setText(animals[which]);
                /*switch (which) {
                    case 0: // horse
                    case 1: // cow
                    case 2: // camel
                    case 3: // sheep
                    case 4: // goat
                }*/
            }
        });

// create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
