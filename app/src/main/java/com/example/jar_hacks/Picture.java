package com.example.jar_hacks;

import android.graphics.Bitmap;

import java.net.URL;

public class Picture {
    double lat, lon;
    String desc, imageB64;

    public Picture(double lat, double lon, String desc, String imageB64){
        this.lat = lat;
        this.lon = lon;
        this.desc = desc;
        this.imageB64 = imageB64;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImageB64() {
        return imageB64;
    }

    public void setImageB64(String imageB64) {
        this.imageB64 = imageB64;
    }
}
