package com.example.jpmorgan.wihm_223;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MonitorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);
    }
    public void ClickOnFindUser(View v){
        Intent i_finduser = new Intent(getApplicationContext(), FindUserActivity.class);
        startActivity(i_finduser);
    }
    public void ClickOnResult(View v){
        Intent i_ClickOnResult= new Intent(getApplicationContext(), ResultActivity.class);
        startActivity(i_ClickOnResult);
    }
}
