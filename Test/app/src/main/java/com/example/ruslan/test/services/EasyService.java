package com.example.ruslan.test.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Ruslan on 03.12.2016.
 */

public class EasyService extends Service {

    final String LOG_TAG = "MY_LOG";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(LOG_TAG, "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(LOG_TAG, "onStartCommand");
        someHardWork();
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(LOG_TAG, "onBind");
        return null;
    }

    private void someHardWork(){
        int result = 1;
        for(int i = 0;i < 10000;i++){
            result = result * i;
        }
    }
}
