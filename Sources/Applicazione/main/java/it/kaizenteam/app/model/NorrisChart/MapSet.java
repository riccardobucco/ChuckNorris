/*
* Name: MapSet.java
* Package: it.kaizenteam.app.model.NorrisChart
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/model/NorrisChart
* Date: 2015-05-19
* Version: 0.01
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.02 2015-05-24  Davide Dal Bianco   Verify
* =================================================================
* v0.01 2015-05-18  Moretto Alessandro  Creazione file
* =================================================================
*
*/

package it.kaizenteam.app.model.NorrisChart;

import java.util.ArrayList;

/**
 * This class represents the data of a set of a map chart.
 */
public class MapSet {
    /**
     * This attribute represents the values of a series of map chart.
     */
    private ArrayList<MapPoint> values;
    private String color;
    private String name;
    private String marker;

    /**
     * This method is the constructor of MapSet. It has as a parameter data values of a series of mapchart.
     * @param values
     */
    public MapSet(ArrayList<MapPoint> values){
        this.values=values;
    }

    /**
     * This method has the task of returning the data of the series.
     * @return the data of the series
     */
    public ArrayList<MapPoint> getData(){
        return values;
    }

    /**
     * This method has the task to set the data of the series.
     * @param 
     */
    public void setData(ArrayList<MapPoint> values){
        this.values= values;
    }

    public void setColor(String color){
        this.color=color;
    }

    public String getColor(){
        return color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public String getMarker() {
        return marker;
    }
}
