package com.example.elephanttrackapp;

public class ElephantData {
    String EleID;
    String DevID;

    public String getEleID() {
        return EleID;
    }

    public void setEleID(String eleID) {
        EleID = eleID;
    }

    public String getDevID() {
        return DevID;
    }

    public void setDevID(String devID) {
        DevID = devID;
    }

    public ElephantData(){

    }

    public ElephantData(String eleID, String devID) {
        EleID = eleID;
        DevID = devID;
    }
}
