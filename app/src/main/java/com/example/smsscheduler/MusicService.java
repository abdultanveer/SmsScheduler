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
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
         super.onStartCommand(intent, flags, startId);
        Log.i(TAG,"onStartCommand service ");

        playMusic();
        return START_STICKY;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
