package com.jpr.router;

import android.app.Activity;
import android.content.ActivityNotFoundException;

/**
 * 类描述:
 * 创建日期:2018/3/20 on 11:48
 * 作者:JiaoPeiRong
 */

public class ActivityRule extends BaseIntentRule<Activity> {
    public static final String ACTIVITY_SCHEME = "activity://";

    @Override
    public void throwException(String pattern) {
        throw new ActivityNotFoundException(pattern);
    }
}
