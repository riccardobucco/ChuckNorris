/*
* Name: MapChartStreamUpdate.java
* Package: it.kaizenteam.app.model.NorrisChart
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/model/NorrisChart
* Date: 24/05/2015
* Version: 0.01
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.01	2015-05-24	Alessandro Moretto	Creazione file
* =================================================================
*
*/

package it.kaizenteam.app.model.NorrisChart;

import java.util.ArrayList;

/**
 * This class represents an stream update package a map chart.
 */
public class MapChartStreamUpdate {
    /**
      * This attribute represents the values of the given date.
      */
    private ArrayList<MapSet> values;

    /**
     * This method is the constructor to create the update package.
     * @param values of the update package
     */
    public MapChartStreamUpdate(ArrayList<MapSet> values){
        this.values=values;
    }

    /**
     * This method is responsible for returning the new data of the update package.
     * @return new data of the update package
     */
    public ArrayList<MapSet> getData(){
        return values;
    }
}
