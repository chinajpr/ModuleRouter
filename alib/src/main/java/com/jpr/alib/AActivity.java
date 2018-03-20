package com.jpr.alib;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jpr.router.ActivityRule;
import com.jpr.router.Router;

/**
 * 类描述:
 * 创建日期:2018/3/20 on 10:12
 * 作者:JiaoPeiRong
 */

public class AActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void startB(View view) {
        Intent i = Router.invoke(AActivity.this, ActivityRule.ACTIVITY_SCHEME + "bActivity");
        startActivity(i);
    }
}
