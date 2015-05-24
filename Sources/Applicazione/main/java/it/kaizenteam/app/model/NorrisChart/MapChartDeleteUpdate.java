package it.kaizenteam.app.model.NorrisChart;

import java.util.ArrayList;

/**
 * Created by Moro on 24/05/15.
 */
public class MapChartDeleteUpdate {
    private ArrayList<MapPoint> values;

    public MapChartDeleteUpdate(ArrayList<MapPoint> values){
        this.values=values;
    }

    public ArrayList<MapPoint> getData(){
        return values;
    }
}
