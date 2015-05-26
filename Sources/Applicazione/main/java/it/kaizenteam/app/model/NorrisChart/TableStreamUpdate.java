/*
* Name: TableStreamUpdate.java
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
 * This class is an stream update package for a table.
 */
public class TableStreamUpdate implements ChartUpdate {
    /**
     * This attribute represents the values of the updated data
     */
    private ArrayList<TableRow> values;

    /**
     * This method is the constructor to create the update package.
     * @param values
     */
    public TableStreamUpdate(ArrayList<TableRow> values){
        this.values=values;
    }

    /**
     * This method is responsible for returning the new data of the update package
     * @return
     */
    public ArrayList<TableRow> getData(){
        return values;
    }
}
