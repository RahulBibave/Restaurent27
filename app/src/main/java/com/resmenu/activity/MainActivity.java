package com.resmenu.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.resmenu.R;
import com.resmenu.constants.ApiUrls;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
      private Button button_login;
      private RequestQueue mRequestQueue;
      private EditText mEdtID,mEdtPass;
      String userid="gan1234",userPass="leo_123";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        String hotel_id = SharedPreferenceManager.get(AppConstants.SHaredPrefKeys.LoginKey,"0");
//        int role = SharedPreferenceManager.getInt(AppConstants.SHaredPrefKeys.RoleKey);
//
//        if (hotel_id != null ) {
//            Intent intentRole = new Intent(MainActivity.this,TablesActivity.class);
//            intentRole.putExtra("role",role);
//            startActivity(intentRole);
//            finish();
//        }
        init();
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Login();
            }
        });

        // all views will be initialize here


    }

    private void init() {
        button_login=findViewById(R.id.button_login);
        mEdtID=findViewById(R.id.et_restaurent_id);
        mEdtPass=findViewById(R.id.et_restaurent_password);
        mEdtID.setText(userid);
        mEdtPass.setText(userPass);
    }

    public void showAlertDialogButtonClicked() {

        // setup the alert builder
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose Role");

        // add a list
        String[] roles = {"Kitchen", "Waiter"};
        builder.setItems(roles, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:{
                        // 1 for kitchen
                        Intent intent=new Intent(MainActivity.this,TablesActivity.class);
                        intent.putExtra("role","1");
//                        SharedPreferenceManager.storeInt(AppConstants.SHaredPrefKeys.RoleKey,1);
                        startActivity(intent);
                        break;
                    }
                    case 1: {
                        // 2 for waiter

                        Intent intent=new Intent(MainActivity.this,TablesActivity.class);
                        intent.putExtra("role","2");
//                        SharedPreferenceManager.storeInt(AppConstants.SHaredPrefKeys.RoleKey,2);
                        startActivity(intent);
                        break;
                    }

                }
            }
        });

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    public void showAlertDialogWaiter() {

        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose Waiter");

        // add a list
        String[] animals = {"Waiter 1", "Waiter 2","Waiter 3","Waiter 4","Waiter 5","Waiter 6"};
        builder.setItems(animals, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:{
                        Intent intent=new Intent(MainActivity.this,TablesActivity.class);
                        startActivity(intent);
                        break;

                    }
                    case 1: {

                    }

                }
            }
        });

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    public void Login(){
        mRequestQueue = Volley.newRequestQueue(this);
        final StringRequest request = new StringRequest(Request.Method.GET, ApiUrls.mUrlLogin+"UserName="+mEdtID.getText().toString()+"&Password="+mEdtPass.getText().toString(), new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

                Log.e("sadddsasasa",""+s.toString());

                try {

                    JSONObject object = new JSONObject(s);
                    int sucess_code=object.getInt("success");
                    if (sucess_code==0){
                        final AlertDialog.Builder aleartDialod=new AlertDialog.Builder(MainActivity.this);
                        aleartDialod.setTitle("Login Failed");
                        aleartDialod.setMessage("Try with valid Restaurent ID and Password");
                        aleartDialod.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        aleartDialod.create().show();
                    }else if(sucess_code==1){
                        showAlertDialogButtonClicked();
                        JSONArray array =object.getJSONArray("result");
                        Log.e("dddddddddd",""+array.toString());
                        for (int i = 0 ; i<array.length();i++){
                            JSONObject jsonObject=array.getJSONObject(i);
                            int hotel_id = jsonObject.getInt("HotelId");
                            Log.e("Hotel_id",""+hotel_id);
//                            SharedPreferenceManager.storeInt(AppConstants.SHaredPrefKeys.LoginKey,hotel_id);
                        }
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
