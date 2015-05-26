/*
* Name: TableCellInPlaceUpdate.java
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
 * This class represents an element of the in place update package of a table.
 */
public class TableCellInPlaceUpdate {
    /**
     * This attribute represents the abscissa of the data to replace.
     */
    private double xpos;

    /**
     * This attribute represents the ordinate of the data to replace.
     */
    private double ypos;

    /**
     * This attribute stores the new value to be included in the chart.
     */
    private String value;

    /**
     * Constructor
     * @param xpos
     * @param ypos
     * @param value
     */
    public TableCellInPlaceUpdate(double xpos, double ypos, String value){
        this.xpos=xpos;
        this.ypos=ypos;
        this.value=value;
    }

    /**
     * This method has the task of returning the abscissa of the data to be modified.
     * @return the abscissa of the data to be modified
     */
    public double getX(){
        return xpos;
    }

    /**
     * This method has the task of returning the ordinate of data to be modified.
     * @return the ordinate of data to be modified
     */
    public double getY(){
        return ypos;
    }

    /**
     * This method is responsible for returning the new data of the update package.
     * @return the new data of the update package
     */
    public String getData(){
        return value;
    }
}
