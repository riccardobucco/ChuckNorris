package it.kaizenteam.app.model.NorrisChart;

import java.util.ArrayList;

/**
 * Created by Moro on 24/05/15.
 */
public class BarChartInPlaceUpdate implements ChartUpdate {
    private ArrayList<BarChartElementInPlaceUpdate> values;

    public BarChartInPlaceUpdate(ArrayList<BarChartElementInPlaceUpdate> values){
        this.values=values;
    }

    public ArrayList<BarChartElementInPlaceUpdate> getData(){
        return values;
    }
}
