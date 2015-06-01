/*
* Name: LineChartElementStreamUpdate.java
* Package: it.kaizenteam.app.model.NorrisChart
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/model/NorrisChart
* Date: 2015-05-16
* Version: v0.02
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
