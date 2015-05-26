/*
* Name: TableDataImpl.java
* Package: it.kaizenteam.app.model.NorrisChart
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/model/NorrisChart
* Date: 2015-05-19
* Version: 0.01
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.01	2015-05-19	Kaizen Team	Creazione file
* =================================================================
*
*/

package it.kaizenteam.app.model.NorrisChart;

import java.util.ArrayList;

/**
 * Created by Moro on 24/05/15.
 */
public class TableDataImpl implements ChartData {
    /**
     * This attribute represents the values of the chart.
     */
    private ArrayList<TableRow> values;

    /**
     * This attribute is the label names of the values of the chart.
     */
    private ArrayList<String> labels;

    /**
     * This method is the constructor of TableDataImpl. It has as parameter values data chart and labels.
     * @param values
     * @param labels
     */
    public TableDataImpl(ArrayList<TableRow> values, ArrayList<String> labels){
        this.values=values;
        this.labels=labels;
    }

    /**
     * This method has the task of returning the data of the chart.
     * @return data of the chart
     */
    public ArrayList<TableRow> getData(){
        return values;
    }

    /**
     * This method has the task of returning the label names of the chart.
     * @return label names of the chart
     */
    public ArrayList<String> getLabels(){
        return labels;
    }

    /**
     * This method has the task to set the data of the chart.
     * @param values
     */
    public void setData(ArrayList<TableRow> values){
        this.values = values;
    }
}
