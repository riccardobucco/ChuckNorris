package it.kaizenteam.app.model.NorrisChart;

import java.util.ArrayList;

/**
 * Created by Moro on 24/05/15.
 */
public class TableRow {
    private ArrayList<TableCell> values;

    /**
     *
     * @param values
     */
    public TableRow(ArrayList<TableCell> values){
        this.values=values;
    }

    /**
     *
     * @return
     */
    public ArrayList<TableCell> getData(){
        return values;
    }
}
