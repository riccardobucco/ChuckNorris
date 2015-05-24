package it.kaizenteam.app.model.NorrisChart;

import android.graphics.Color;

/**
 * Created by Moro on 24/05/15.
 */
public class MapPoint {
    private double latitude;
    private double longitude;
    private int id;

    public MapPoint(double latitude, double longitude, int id){
        this.latitude=latitude;
        this.longitude=longitude;
        this.id=id;
    }

    public int getId(){
        return id;
    }

    public double getLatitude(){
        return latitude;
    }

    public double getLongitude(){
        return longitude;
    }

    public void setLatitude(double latitude){
        this.latitude= latitude;
    }

    public void setLongitude(double longitude){
        this.longitude= longitude;
    }
}
