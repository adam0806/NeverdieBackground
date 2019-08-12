package com.app.adam.nerverdie;

import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v4.app.JobIntentService;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Lenovo on 2019/8/12.
 */

public class MyJobIntentService extends JobIntentService {
    public String TAG = MyJobIntentService.class.getSimpleName();
    public static MediaPlayer mMediaPlayer;
    private static final int JOB_ID = 1000;
    private static final int TIME = 2*1000;
    private static final int REPEAT = 500;
    Thread thread;
    public static void enqueueWork(Context context, Intent work) {
        mMediaPlayer = MediaPlayer.create(context, R.raw.no_notice);
        mMediaPlayer.setLooping(true);
        enqueueWork(context, MyJobIntentService.class, JOB_ID, work);
    }

    @Override
    protected void onHandleWork(@NonNull final Intent intent) {
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                mMediaPlayer.start();
                for (int i = 0; i < REPEAT; i++) {
                    try {
                        Log.d( TAG, " MyJobIntentService, i: " + i);
                        Thread.sleep(TIME);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        thread.start();
    }
}
