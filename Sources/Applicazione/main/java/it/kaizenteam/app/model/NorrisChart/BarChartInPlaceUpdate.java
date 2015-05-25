package it.kaizenteam.app.model.NorrisChart;

import java.util.ArrayList;

/**
 *
 */
public class BarChartInPlaceUpdate implements ChartUpdate {
    private ArrayList<BarChartElementInPlaceUpdate> values;

    /**
     *
     * @param values
     */
    public BarChartInPlaceUpdate(ArrayList<BarChartElementInPlaceUpdate> values){
        this.values=values;
    }

    /**
     *
     * @return
     */
    public ArrayList<BarChartElementInPlaceUpdate> getData(){
        return values;
    }
}
