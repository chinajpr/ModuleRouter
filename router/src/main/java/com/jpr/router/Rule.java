package com.jpr.router;

import android.content.Context;

/**
 * 类描述:路由接口
 * 创建日期:2018/3/20 on 10:20
 * 作者:JiaoPeiRong
 */

public interface Rule<T, V> {
    /**
     * 添加router
     *
     * @param key
     * @param mClass
     */
    void addRouter(String key, Class<T> mClass);

    /**
     * 获取router
     *
     * @param context
     * @param key
     * @return
     */
    V getRouter(Context context, String key);
}
