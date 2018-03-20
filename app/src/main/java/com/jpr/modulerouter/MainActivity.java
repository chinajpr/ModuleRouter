package com.jpr.modulerouter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jpr.alib.AActivity;
import com.jpr.blib.BActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startA(View v){
        Intent i = new Intent(this , AActivity.class);
        startActivity(i);
    }

    public void startB(View v){
        Intent i = new Intent(this , BActivity.class);
        startActivity(i);
    }
}
