package it.kaizenteam.app.model.NorrisChart;

import java.util.ArrayList;

/**
 * Created by Moro on 24/05/15.
 */
public class MapChartStreamUpdate {
    private ArrayList<MapSet> values;

    /**
     *
     * @param values
     */
    public MapChartStreamUpdate(ArrayList<MapSet> values){
        this.values=values;
    }

    /**
     *
     * @return
     */
    public ArrayList<MapSet> getData(){
        return values;
    }
}
