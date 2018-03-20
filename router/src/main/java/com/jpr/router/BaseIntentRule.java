package com.jpr.router;

import android.content.Context;
import android.content.Intent;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;

/**
 * 类描述:
 * 创建日期:2018/3/20 on 11:39
 * 作者:JiaoPeiRong
 */

public abstract class BaseIntentRule<T> implements Rule<T, Intent> {
    private HashMap<String, Class<T>> mIntentRules;

    public BaseIntentRule() {
        mIntentRules = new HashMap<>();
    }

    @Override
    public void addRouter(String key, Class<T> mClass) {
        mIntentRules.put(key , mClass);
    }

    @Override
    public Intent getRouter(Context context, String key) {
        Class<T> tClass = mIntentRules.get(key);
        if (tClass == null) {
            throwException(key);
        }
        return new Intent(context, tClass);
    }

    public abstract void throwException(String pattern);
}
