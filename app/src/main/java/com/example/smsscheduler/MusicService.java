package com.example.smsscheduler;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class MusicService extends Service {
    public  static String TAG = MusicService.class.getSimpleName();

    public MusicService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG,"service created");

    }

    private void playMusic() {
        Log.i(TAG,"playMusic service ");

        MediaPlayer player = MediaPlayer.create(this,R.raw.music);
        player.start();
       // stopSelf();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
         super.onStartCommand(intent, flags, startId);
         String url = intent.getStringExtra(MainActivity.MYKEY);
        Log.i(TAG,"onStartCommand url = "+url);

        playMusic();
        return START_STICKY;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy service ");

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
