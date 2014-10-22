package com.naughtyserver.toob;

import android.app.Activity;
import android.content.SharedPreferences;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Set;


public class Main extends Activity {

    private WifiSniffer wifiSniffer;


    private Set<Wifi> currentWifis;
    private WifiStorage storageManager;
    private WifiService wifiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wifiSniffer = new WifiSniffer((WifiManager) getSystemService(WIFI_SERVICE));

        storageManager = new WifiStorage((SharedPreferences) getSharedPreferences("locations",0));

        wifiService = new WifiService(wifiSniffer,storageManager);
        final TubeInfo tubeInfo = new TubeInfo();
        ((TextView) findViewById(R.id.displaySection)).setText(tubeInfo.getLines());

    }

    public void displayWifis(final View v) {
        String wifis = wifiService.getWifis();
        ((TextView) findViewById(R.id.displaySection)).setText(wifis);

    }

    public void storeWifi(final View v) {
        final String location = wifiService.storeCurrentWifis();
        ((TextView) findViewById(R.id.displaySection)).setText("Location:" + location);

    }

    public void displayAllStorage(final View v) {
        String text = wifiService.getAllStorage();
        ((TextView) findViewById(R.id.displaySection)).setText(text);
    }

    public void determineLocation(final View v) {

        final String location = wifiService.determineLocation();
        ((TextView) findViewById(R.id.displaySection)).setText("Location:" + location);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
