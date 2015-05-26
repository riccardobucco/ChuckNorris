/*
* Name: TableRow.java
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
 * This class represents the data of a row of a table.
 */
public class TableRow {
    /**
     * This attribute represents the values of a row of the table.
     */
    private ArrayList<TableCell> values;

    /**
     * This method is the constructor of TableRow. It has as a parameter data values of the cells of the table row.
     * @param values
     */
    public TableRow(ArrayList<TableCell> values){
        this.values=values;
    }

    /**
     * This method has the task of returning the data of the row.
     * @return data of the row
     */
    public ArrayList<TableCell> getData(){
        return values;
    }

    /**
     * This method has the task to set the data of the row.
     * @param value
     */
    public void setData(ArrayList<TableCell> value){
        this.values=values;
    }
}
