package it.kaizenteam.app.model.NorrisChart;

import java.util.ArrayList;

/**
 * Created by Moro on 24/05/15.
 */
public class LineChartInPlaceUpdate implements ChartUpdate {
    private ArrayList<LineChartElementInPlaceUpdate> values;

    /**
     *
     * @param values
     */
    public LineChartInPlaceUpdate(ArrayList<LineChartElementInPlaceUpdate> values){
        this.values=values;
    }

    /**
     *
     * @return
     */
    public ArrayList<LineChartElementInPlaceUpdate> getData(){
        return values;
    }
}
