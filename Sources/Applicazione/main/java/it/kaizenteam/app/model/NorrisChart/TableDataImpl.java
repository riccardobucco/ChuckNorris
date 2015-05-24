package it.kaizenteam.app.model.NorrisChart;

import java.util.ArrayList;

/**
 * Created by Moro on 24/05/15.
 */
public class TableDataImpl implements ChartData {
    private ArrayList<TableRow> values;
    private ArrayList<String> labels;

    public TableDataImpl(ArrayList<TableRow> values, ArrayList<String> labels){
        this.values=values;
        this.labels=labels;
    }

    public ArrayList<TableRow> getData(){
        return values;
    }

    public ArrayList<String> getLabels(){
        return labels;
    }

    //TODO rimuovere...viene modificato per riferimento
    public void setData(ArrayList<TableRow> values){
        this.values=values;
    }
}
