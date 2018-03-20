package com.jpr.modulerouter;

import android.app.Application;

import com.jpr.alib.AActivity;
import com.jpr.blib.BActivity;
import com.jpr.router.ActivityRule;
import com.jpr.router.Router;

/**
 * 类描述:
 * 创建日期:2018/3/20 on 10:05
 * 作者:JiaoPeiRong
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initRouter();
    }

    private void initRouter() {
        Router.router(ActivityRule.ACTIVITY_SCHEME + "aActivity", AActivity.class);
        Router.router(ActivityRule.ACTIVITY_SCHEME + "bActivity", BActivity.class);
    }
}
