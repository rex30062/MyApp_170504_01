package com.cclz.myapp_170504_01;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.util.Log;

import java.util.Date;

public class MyService extends Service {
    Handler handler=new Handler();
    int count;

    public MyService() {
    }

    Runnable showTime=new Runnable() {
        @Override
        public void run() {
            Log.d("SER1", "Time: " + new java.util.Date());
            if(count <10){
                count ++;
                handler.postDelayed(this, 1000);
            }
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.d("SER1", "This is onBind");
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("SER1", "This is onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("SER1", "This is onStartCommand");
        count = 0;
        handler.post(showTime);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(showTime);
        Log.d("SER1", "This is onDestroy");
    }
}
