package com.naughtyserver.toob;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jrae on 19/06/2014.
 */
public class WifiService {
    private final WifiSniffer wifiSniffer;
    private final WifiStorage storageManager;
    private Set<Wifi> currentWifis=new HashSet<Wifi>();

    public WifiService(final WifiSniffer wifiSniffer, final WifiStorage storageManager) {


        this.wifiSniffer = wifiSniffer;
        this.storageManager = storageManager;
    }


    public String getWifis() {
        currentWifis = wifiSniffer.getCurrentWifis();
        StringBuilder builder = new StringBuilder();
        for (Wifi currentWifi : currentWifis) {
            builder.append("bssid:").append(currentWifi.bssid).append(" ssid:").append(currentWifi.ssid).append("\n");
        }
        return builder.toString();
    }

    public String storeCurrentWifis() {
        return storageManager.store(wifiSniffer.getCurrentWifis());
    }

    public String getAllStorage() {
        Set<String> locations = storageManager.getAllLocations();
        StringBuilder text = new StringBuilder("Locations:\n");
        for (String location : locations) {
            text.append("Loc:").append(location).append("\n");
            final Set<String> wifiAtLocation = storageManager.getWifiAtLocation(location);
            for (String wifi : wifiAtLocation) {
                text.append(wifi).append("\n");
            }

        }
        return text.toString();
    }

    public String determineLocation() {
        return storageManager.getLocation(wifiSniffer.getCurrentWifis()).toString();
    }
}
