package com.resmenu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.resmenu.R;

public class Activity_WaiterLanding extends AppCompatActivity {


    private LinearLayout mMenu,mFeedBack;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiter_landing);
        init();
        mMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity_WaiterLanding.this,Activity_Menu.class);
                startActivity(intent);
            }
        });

        mFeedBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity_WaiterLanding.this,Activity_Feedback.class);
                startActivity(intent);

            }
        });

    }

    private void init() {
        mMenu=findViewById(R.id.lin_menu);
        mFeedBack=findViewById(R.id.lin_feedback);
    }
}
