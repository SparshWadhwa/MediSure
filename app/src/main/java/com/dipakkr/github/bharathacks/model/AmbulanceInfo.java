package com.dipakkr.github.bharathacks.model;

/**
 * Created by root on 6/18/17.
 */

public class AmbulanceInfo {
    public String mName;
    public String latitude;
    public String longitude;

    public AmbulanceInfo(String mName,String latitude, String longitude) {
        this.mName = mName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getmName() {
        return mName;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
