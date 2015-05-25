package it.kaizenteam.app.model.NorrisChart;

import android.graphics.Color;

/**
 * Created by Moro on 24/05/15.
 */
public class MapPoint {
    private double latitude;
    private double longitude;
    private int id;

    /**
     *
     * @param latitude
     * @param longitude
     * @param id
     */
    public MapPoint(double latitude, double longitude, int id){
        this.latitude=latitude;
        this.longitude=longitude;
        this.id=id;
    }

    /**
     *
     * @return
     */
    public int getId(){
        return id;
    }

    /**
     *
     * @return
     */
    public double getLatitude(){
        return latitude;
    }

    /**
     *
     * @return
     */
    public double getLongitude(){
        return longitude;
    }

    /**
     *
     * @param latitude
     */
    public void setLatitude(double latitude){
        this.latitude= latitude;
    }

    /**
     *
     * @param longitude
     */
    public void setLongitude(double longitude){
        this.longitude= longitude;
    }
}
