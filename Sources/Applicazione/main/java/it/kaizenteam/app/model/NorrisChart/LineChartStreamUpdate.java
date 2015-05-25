package it.kaizenteam.app.model.NorrisChart;

import java.util.ArrayList;

/**
 * Created by Moro on 24/05/15.
 */
public class LineChartStreamUpdate implements ChartUpdate  {
    private ArrayList<LineChartElementStreamUpdate> values;

    /**
     *
     * @param values
     */
    public LineChartStreamUpdate(ArrayList<LineChartElementStreamUpdate> values){
        this.values=values;
    }

    /**
     *
     * @return
     */
    public ArrayList<LineChartElementStreamUpdate> getData(){
        return values;
    }
}
