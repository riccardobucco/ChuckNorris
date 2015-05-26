/*
* Name: LineChartDataImpl.java
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

import com.github.mikephil.charting.charts.LineChart;

/**
 * This class represents the data in a line chart.
 */
public class LineChartDataImpl implements ChartData{
    private LineChart values;

    /**
     * This method is the constructor of LineChartDataImpl. It has as a parameter data values in the chart.
     * @param values data values of the chart
     */
    public LineChartDataImpl(LineChart values){
        this.values=values;
    }

    /**
     * This method has the task of returning the data of the chart.
     * @return the data of the chart
     */
    public LineChart getData(){
        return values;
    }

    /**
     * This method has the task to set the data of the chart.
     * @param data data of the chart
     */
    public void setData(LineChart data){
        this.values=data;
    }
}
