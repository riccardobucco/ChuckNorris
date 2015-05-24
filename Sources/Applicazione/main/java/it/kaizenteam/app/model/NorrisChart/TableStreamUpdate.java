package it.kaizenteam.app.model.NorrisChart;

import java.util.ArrayList;

/**
 * Created by Moro on 24/05/15.
 */
public class TableStreamUpdate implements ChartUpdate {
    private ArrayList<TableRow> values;

    public TableStreamUpdate(ArrayList<TableRow> values){
        this.values=values;
    }

    public ArrayList<TableRow> getData(){
        return values;
    }
}
