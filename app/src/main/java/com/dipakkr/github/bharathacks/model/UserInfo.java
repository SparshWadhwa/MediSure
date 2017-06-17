package com.dipakkr.github.bharathacks.model;

/**
 * Created by root on 6/18/17.
 */

public class UserInfo {
    public String latitude;
    public String longitude;

    public UserInfo(String latitude, String longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
