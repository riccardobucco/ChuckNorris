/*
* Name: BarChartDataImpl.java
* Package: it.kaizenteam.app.model.NorrisChart
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/model/NorrisChart
* Date: 2015-05-16
* Version: 0.01
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.02 2015-05-26  Moretto Alessandro   Verify
* =================================================================
* v0.01 2015-05-22  Davide Dal Bianco  Creazione file
* =================================================================
*
*/

package it.kaizenteam.app.model.NorrisChart;

import com.github.mikephil.charting.charts.BarChart;

/**
* This class represents the data in a bar chart
*/
public class BarChartDataImpl implements ChartData {
    private BarChart values;

    /**
    * This method is the constructor of BarChartDataImpl. It has as a parameter data values in the chart.
    * @param values values of the chart
    */
    public BarChartDataImpl(BarChart values){
        this.values=values;
    }

    /**
    * This method has the task of returning the data of the chart.
    * @return data of the chart
    */
    public BarChart getData(){
        return values;
    }

    /** TODO rimuovere...viene modificato per riferimento
    * This method has the task to set the data of the chart.
    * @param values data of the chart
    */
    public void setData(BarChart values){
        this.values=values;
    }
}
