package it.kaizenteam.app.model.NorrisChart;

import java.util.ArrayList;

/**
 * Created by Moro on 24/05/15.
 */
public class MapChartInPlaceUpdate implements ChartUpdate {
    private ArrayList<MapChartElementInPlaceUpdate> values;

    public MapChartInPlaceUpdate(ArrayList<MapChartElementInPlaceUpdate> values){
        this.values=values;
    }

    public ArrayList<MapChartElementInPlaceUpdate> getData(){
        return values;
    }
}
