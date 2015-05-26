/*
* Name: LineChartInPlaceUpdate.java
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
 * This class represents an in place update package of a line chart.
 */
public class LineChartInPlaceUpdate implements ChartUpdate {
    /**
     * This attribute represents the values of the updated date.
     */    
    private ArrayList<LineChartElementInPlaceUpdate> values;

    /**
     * This method is the constructor to create the update package.
     * @param values udpate package
     */
    public LineChartInPlaceUpdate(ArrayList<LineChartElementInPlaceUpdate> values){
        this.values=values;
    }

    /**
     * This method is responsible for returning the data of the update package.
     * @return the data of the update package
     */
    public ArrayList<LineChartElementInPlaceUpdate> getData(){
        return values;
    }
}
