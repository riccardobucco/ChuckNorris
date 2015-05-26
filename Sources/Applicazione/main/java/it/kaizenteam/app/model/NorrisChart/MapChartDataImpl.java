/*
* Name: MapChartDataImpl.java
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
 * This class represents the data of a map chart.
 */
public class MapChartDataImpl implements ChartData {
    /**
     * This attribute represents the values of the chart.
     */
    private ArrayList<MapSet> values;

    /**
     * This method is the constructor of MapChartDataImpl. It has values of chart as parameter.
     * @param values of chart
     */
    public MapChartDataImpl(ArrayList<MapSet> values){
        this.values=values;
    }

    /**
     * This method has the task of returning the data of the chart.
     * @return data of the chart
     */
    public ArrayList<MapSet> getData(){
        return values;
    }

    //TODO rimuovere...viene modificato per riferimento

    /**
     * This method has the task to set the data of the chart.
     * @param values data of the chart to set
     */
    public void setData(ArrayList<MapSet> values){
        this.values=values;
    }
}
