package com.naughtyserver.toob;

import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jrae on 17/06/2014.
 */
public class WifiStorage {
    private SharedPreferences sharedPreferences;

    public WifiStorage(final SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;

    }

    public String store(final Set<Wifi> currentWifis) {


        Set<String> bssids = toBssids(currentWifis);

        final String location = getLocation(currentWifis);

        final SharedPreferences.Editor edit = sharedPreferences.edit();
        if(location==null) {
            final Set<String> locations = sharedPreferences.getStringSet("locations", new HashSet<String>());
            final String newLocation = Integer.toString(locations.size() + 1);
            locations.add(newLocation);
            edit.putStringSet("locations", locations);
            edit.putStringSet(newLocation, bssids);
            boolean result= edit.commit();

            return newLocation;

        }else{
            final Set<String> idsForLocation = sharedPreferences.getStringSet(location,new HashSet<String>());
            idsForLocation.addAll(bssids);
            edit.putStringSet(location, idsForLocation);
            edit.commit();
            return location;
        }

    }

    private Set<String> toBssids(final Set<Wifi> currentWifis) {
        Set<String> bssids = new HashSet<String>(currentWifis.size());


        for (Wifi currentWifi : currentWifis) {
            bssids.add(currentWifi.ssid+"_"+currentWifi.bssid);
        }
        return bssids;
    }

    public String getLocation(final Set<Wifi> currentWifis) {
        Set<String> bssids = toBssids(currentWifis);
        final Set<String> locations = sharedPreferences.getStringSet("locations",new HashSet<String>());
        final HashSet<String> defValues = new HashSet<String>();
        for (String location : locations) {
            final Set<String> loadedBssids = sharedPreferences.getStringSet(location, defValues);
            for (String bssid : bssids) {
                if(loadedBssids.contains(bssid)){
                    return location;
                }
            }
        }
        return null;
    }

    public Set<String> getAllLocations() {
        return sharedPreferences.getStringSet("locations",new HashSet<String>());
    }

    public Set<String> getWifiAtLocation(final String location) {
        return sharedPreferences.getStringSet(location, new HashSet<String>());
    }
}
