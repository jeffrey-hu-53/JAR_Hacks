package com.example.jar_hacks;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import java.net.URL;

public class Picture {
    double lat, lon;
    String desc;
    int imDrawable;

    public Picture(double lat, double lon, String desc, int imDrawable){
        this.lat = lat;
        this.lon = lon;
        this.desc = desc;
        this.imDrawable = imDrawable;
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

    public int getImDrawable() {
        return imDrawable;
    }

    public void setImDrawable(int imDrawable) {
        this.imDrawable = imDrawable;
    }
}
