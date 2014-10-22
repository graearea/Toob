package com.naughtyserver.toob;

/**
 * Created by jrae on 16/06/2014.
 */
public class Wifi {
    public final String ssid;
    public final String bssid;

    public Wifi(final String ssid, final String bssid) {
        this.ssid = ssid;
        this.bssid = bssid;
    }
    public Wifi(final String token) {
        final String[] split = token.split("_");

        ssid=split[0];
        bssid=split[1];
    }
    @Override
    public String toString() {
        return String.format("%s_%s", ssid, bssid);
    }
}
