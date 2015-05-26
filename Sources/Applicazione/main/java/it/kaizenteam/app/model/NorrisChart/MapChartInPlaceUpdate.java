/*
* Name: MapChartInPlaceUpdate.java
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
 * This class represents an in place update package of a map chart.
 */
public class MapChartInPlaceUpdate implements ChartUpdate {
    /**
      * This attribute represents the values of the given date.
      */
    private ArrayList<MapChartElementInPlaceUpdate> values;

    /**
     * This method is a constructor to create the update package.
     * @param values of the update package
     */
    public MapChartInPlaceUpdate(ArrayList<MapChartElementInPlaceUpdate> values){
        this.values=values;
    }

    /**
     * This method is responsible for returning the new data of the update package.
     * @return new data of the update package
     */
    public ArrayList<MapChartElementInPlaceUpdate> getData(){
        return values;
    }
}
