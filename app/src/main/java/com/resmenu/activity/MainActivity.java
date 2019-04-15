package com.resmenu.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.resmenu.R;

public class MainActivity extends AppCompatActivity {
      private Button button_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialogButtonClicked();
            }
        });

        // all views will be initialize here


    }

    private void init() {
        button_login=findViewById(R.id.button_login);
    }

    public void showAlertDialogButtonClicked() {

        // setup the alert builder
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose Role");

        // add a list
        String[] animals = {"Kitchen", "Waiter"};
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
                        showAlertDialogWaiter();
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
}
