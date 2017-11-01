package com.ltz.baohuodemo.base;

import android.content.ComponentName;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import com.ltz.baohuodemo.IMyAidlInterface;

/**
 * Created by 1 on 2017/10/31.
 */
public class BaseActivity extends AppCompatActivity implements ServiceConnection {

    public static IMyAidlInterface mService = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mToken = MusicPlayer.bindToService(this, this);
//        mPlaybackStatus = new PlaybackStatus(this);
//        IntentFilter f = new IntentFilter();
//        f.addAction(MediaService.PLAYSTATE_CHANGED);
//        f.addAction(MediaService.META_CHANGED);
//        f.addAction(MediaService.QUEUE_CHANGED);
//        f.addAction(IConstants.MUSIC_COUNT_CHANGED);
//        f.addAction(MediaService.TRACK_PREPARED);
//        f.addAction(MediaService.BUFFER_UP);
//        f.addAction(IConstants.EMPTY_LIST);
//        f.addAction(MediaService.MUSIC_CHANGED);
//        f.addAction(MediaService.LRC_UPDATED);
//        f.addAction(IConstants.PLAYLIST_COUNT_CHANGED);
//        f.addAction(MediaService.MUSIC_LODING);
//        registerReceiver(mPlaybackStatus, new IntentFilter(f));
    }


    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        mService = IMyAidlInterface.Stub.asInterface(iBinder);
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        mService = null;
    }

}
