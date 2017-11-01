package com.ltz.baohuodemo.base;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.ltz.baohuodemo.IMyAidlInterface;

/**
 * 锁屏界面基类
 * Created by 1 on 2017/10/31.
 */
public class LuckBaseActivity extends AppCompatActivity implements ServiceConnection {

    public static IMyAidlInterface mService = null;

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        mService = IMyAidlInterface.Stub.asInterface(iBinder);
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
       mService = null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("lock"," on destroy");
        unbindService();
    }

    public void unbindService() {
//        if (mToken != null) {
//            MusicPlayer.unbindFromService(mToken);
//            mToken = null;
//        }
    }
}
