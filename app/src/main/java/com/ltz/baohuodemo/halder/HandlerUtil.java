package com.ltz.baohuodemo.halder;

import android.content.Context;
import android.os.Handler;

import java.lang.ref.WeakReference;

/**
 * Handler工具类
 * Created by 1 on 2017/10/31.
 */
public class HandlerUtil extends Handler {

    private static HandlerUtil instance = null;
    WeakReference<Context> mActivityReference;

    public static HandlerUtil getInstance(Context context) {
        if (instance == null) {
            instance = new HandlerUtil(context.getApplicationContext());
        }
        return instance;
    }

    HandlerUtil(Context context) {
        mActivityReference = new WeakReference<>(context);
    }
}