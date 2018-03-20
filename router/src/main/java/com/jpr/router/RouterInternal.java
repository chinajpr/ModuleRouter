package com.jpr.router;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * 类描述:
 * 创建日期:2018/3/20 on 10:36
 * 作者:JiaoPeiRong
 */

public class RouterInternal {
    private static volatile RouterInternal instance;
    private HashMap<String, Rule> mRules;

    /**
     * 单例获取
     *
     * @return
     */
    public static RouterInternal getInstance() {
        if (null == instance) {
            synchronized (RouterInternal.class) {
                if (null == instance) {
                    instance = new RouterInternal();
                }
            }
        }
        return instance;
    }

    /**
     * 私有构造
     */
    private RouterInternal() {
        mRules = new HashMap<>();
        initDefaultRouter();
    }

    /**
     * 添加默认的路由
     */
    private void initDefaultRouter() {
        addRule(ActivityRule.ACTIVITY_SCHEME, new ActivityRule());
    }

    /**
     * 添加router
     *
     * @param key
     * @param rule
     */
    public final void addRule(String key, Rule rule) {
        mRules.put(key, rule);
    }

    /**
     * 获取rule
     *
     * @param key
     * @return
     */
    private Rule getRule(String key) {
        Set<String> set = mRules.keySet();
        Rule rule = null;
        for (String s : set) {
            if (key.startsWith(s)) {
                rule = mRules.get(s);
                break;
            }
        }
        return rule;
    }

    /**
     * 添加路由
     * @param pattern
     * @param mClass
     * @param <T>
     */
    public final <T> void router(String pattern, Class<T> mClass) {
        Rule<T, ?> rule = getRule(pattern);
        if (rule == null) {
            throw new RuntimeException("unknown---" + pattern);
        }
        rule.addRouter(pattern, mClass);
    }

    /**
     * 获取路由
     * @param ctx
     * @param pattern
     * @param <V>
     * @return
     */
    public final <V> V invoke(Context ctx, String pattern) {
        Rule<?, V> rule = getRule(pattern);
        if (rule == null) {
            throw new RuntimeException("unknown---" + pattern);
        }
        return rule.getRouter(ctx, pattern);
    }

}
