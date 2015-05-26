/*
* Name: LineChartStreamUpdate.java
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
 * This class represents a update stream package of a line chart.
 */
public class LineChartStreamUpdate implements ChartUpdate  {
    /**
     * This attribute represents the values of the given date.
     */
    private ArrayList<LineChartElementStreamUpdate> values;

    /**
     * This method is the constructor to create the update package.
     * @param values elements of the update package
     */
    public LineChartStreamUpdate(ArrayList<LineChartElementStreamUpdate> values){
        this.values=values;
    }

    /**
     * This method is responsible for returning the data of the update package.
     * @return data of the update package
     */
    public ArrayList<LineChartElementStreamUpdate> getData(){
        return values;
    }
}
