package it.kaizenteam.app.model.NorrisChart;

import java.util.ArrayList;

/**
 * Created by Moro on 24/05/15.
 */
public class TableInPlaceUpdate implements ChartUpdate {
    private ArrayList<TableCellInPlaceUpdate> values;

    public TableInPlaceUpdate(ArrayList<TableCellInPlaceUpdate> values){
        this.values=values;
    }

    public ArrayList<TableCellInPlaceUpdate> getData(){
        return values;
    }
}
