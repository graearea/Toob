package com.naughtyserver.toob;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by jrae on 16/06/2014.
 */
public class WifiSniffer {

    private WifiManager wifiManager;

    public WifiSniffer(WifiManager wifiManager) {
        this.wifiManager = wifiManager;
    }

    public Set<Wifi> getCurrentWifis() {
        Set<Wifi> wifis = new HashSet<Wifi>();

        final List<ScanResult> scanResults = wifiManager.getScanResults();
        for (ScanResult scanResult : scanResults) {
            wifis.add(new Wifi(scanResult.SSID, scanResult.BSSID));
        }
        return wifis;
    }

}
