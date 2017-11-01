package com.ltz.baohuodemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by 1 on 2017/10/31.
 */
public class MyApplication extends Application{

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        initCatchException();
    }

    //捕获全局Exception 重启界面
    public void initCatchException() {
        //设置该CrashHandler为程序的默认处理器
//        UnceHandler catchExcep = new UnceHandler(this);
//        Thread.setDefaultUncaughtExceptionHandler(catchExcep);
    }
}
