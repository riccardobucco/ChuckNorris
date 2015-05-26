/*
* Name: TableInPlaceUpdate.java
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
 * This class represents an in place update package of a table.
 */
public class TableInPlaceUpdate implements ChartUpdate {
    /**
     * This attribute represents the values of the updated data.
     */
    private ArrayList<TableCellInPlaceUpdate> values;

    /**
     * This method is the constructor to create the update package.
     * @param values elements of the update package
     */
    public TableInPlaceUpdate(ArrayList<TableCellInPlaceUpdate> values){
        this.values=values;
    }

    /**
     * This method is responsible for returning the new data of the update package.
     * @return new data of the update package
     */
    public ArrayList<TableCellInPlaceUpdate> getData(){
        return values;
    }
}
