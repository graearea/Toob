package com.naughtyserver.toob;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by jrae on 19/06/2014.
 */
public class BackgroundRunner extends Service {
    private WifiService wifiService;

    @Override
    public IBinder onBind(final Intent intent) {
        return null;
    }

    public BackgroundRunner(WifiService wifiService) {
        this.wifiService = wifiService;
        wifiService.storeCurrentWifis();
    }



    @Override
    public int onStartCommand(final Intent intent, final int flags, final int startId) {
        return Service.START_STICKY;
    }
}
