package com.example.jpmorgan.wihm_223;

import android.*;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Toestemming om locatie voor BLE te mogen gebruiken
        ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 0);

        setContentView(R.layout.activity_main);
    }
    public void ClickOnRegister(View v){
        Intent i_register = new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(i_register);
    }
    public void ClickOnFindUser(View v){
        Intent i_finduser = new Intent(getApplicationContext(), FindUserActivity.class);
        startActivity(i_finduser);
    }
    public void ClickOnRetrieval(View v){
        Intent i_retrieval = new Intent(getApplicationContext(), RetrieveActivity.class);
        startActivity(i_retrieval);
    }
}
