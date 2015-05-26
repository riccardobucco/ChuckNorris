/*
* Name: LineChartElementStreamUpdate.java
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

/**
 * This class represents an element of stream update package of a line chart.
 */
public class LineChartElementStreamUpdate {
    /**
     * This attribute is the value of the updated data.
    */
    private double value;

    /**
     * This attribute is the value of the new label to be included in the chart.
    */
    private String label;

    /**
     * This method is the constructor to create update package.
     * @param label value of chart label
     * @param value updated value
     */
    public LineChartElementStreamUpdate(String label, double value){
        this.label=label;
        this.value=value;
    }

    /**
     * This method is responsible for returning the new data of the update package.
     * @return the new data of the update package
     */
    public double getData(){
        return value;
    }

    /**
     * This method has the task to return the value of new label.
     * @return the value of new label
     */
    public String getLabel(){
        return label;
    }
}
