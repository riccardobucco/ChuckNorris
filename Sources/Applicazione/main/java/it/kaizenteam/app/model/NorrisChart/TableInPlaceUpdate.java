/*
* Name: TableInPlaceUpdate.java
* Package: it.kaizenteam.app.model.NorrisChart
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/model/NorrisChart
* Date: 2015-05-24
* Version: v0.02
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.02 2015-05-24  Dal Bianco Davide   Verify
* =================================================================
* v0.01 2015-05-18  Moretto Alessandro  Creation
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
