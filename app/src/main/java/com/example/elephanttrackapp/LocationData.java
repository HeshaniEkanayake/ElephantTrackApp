package com.example.elephanttrackapp;

public class LocationData {
    String EleId,longitude,latitude,address,DAT;

    public LocationData(String eleId, String longitude, String latitude, String address, String DAT) {
        EleId = eleId;
        this.longitude = longitude;
        this.latitude = latitude;
        this.address = address;
        this.DAT = DAT;
    }

    public String getDAT() {
        return DAT;
    }

    public void setDAT(String DAT) {
        this.DAT = DAT;
    }

    public LocationData(){

    }

    public String getEleId() {
        return EleId;
    }

    public void setEleId(String eleId) {
        EleId = eleId;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
