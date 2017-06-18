package com.dipakkr.github.bharathacks.model;

/**
 * Created by anshul on 18/6/17.
 */

public class PatientRequestData {

    public String latitude;
    public String longitude;

    public PatientRequestData(String latitude, String longitude){
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
