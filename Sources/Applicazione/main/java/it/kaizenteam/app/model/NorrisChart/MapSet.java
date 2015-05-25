package it.kaizenteam.app.model.NorrisChart;

import java.util.ArrayList;

/**
 * Created by Moro on 24/05/15.
 */
public class MapSet {
    private ArrayList<MapPoint> values;

    /**
     *
     * @param values
     */
    public MapSet(ArrayList<MapPoint> values){
        this.values=values;
    }

    /**
     *
     * @return
     */
    public ArrayList<MapPoint> getData(){
        return values;
    }

}
