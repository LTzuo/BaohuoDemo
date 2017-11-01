package com.ltz.baohuodemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by 1 on 2017/10/31.
 */
public class LiveService extends Service{

    public static final String LOCK_SCREEN = "com.ltz.baohuo.lock";

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }
}
