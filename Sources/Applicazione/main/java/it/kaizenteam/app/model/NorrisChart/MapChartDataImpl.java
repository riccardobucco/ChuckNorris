package it.kaizenteam.app.model.NorrisChart;

import java.util.ArrayList;

/**
 * Created by Moro on 24/05/15.
 */
public class MapChartDataImpl implements ChartData {
    private ArrayList<MapSet> values;

    public MapChartDataImpl(ArrayList<MapSet> values){
        this.values=values;
    }

    public ArrayList<MapSet> getData(){
        return values;
    }

    //TODO rimuovere...viene modificato per riferimento
    public void setData(ArrayList<MapSet> values){
        this.values=values;
    }
}
