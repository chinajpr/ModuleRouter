package com.jpr.router;

import android.content.Context;

/**
 * 类描述:
 * 创建日期:2018/3/20 on 10:23
 * 作者:JiaoPeiRong
 */

public class Router {
    /**
     * 添加路由
     * @param key
     * @param mClass
     * @param <T>
     */
    public static <T> void router(String key, Class<T> mClass) {
        RouterInternal.getInstance().router(key , mClass);
    }

    /**
     * 获取路由
     * @param context
     * @param key
     * @param <V>
     * @return
     */
    public static <V> V invoke(Context context , String key){
        return RouterInternal.getInstance().invoke(context,key);
    }
}
