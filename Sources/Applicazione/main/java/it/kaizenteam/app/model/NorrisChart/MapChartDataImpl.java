/*
* Name: MapChartDataImpl.java
* Package: it.kaizenteam.app.model.NorrisChart
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/model/NorrisChart
* Date: 24/05/2015
* Version: 0.01
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.01	2015-05-24	Alessandro Moretto	Creazione file
* =================================================================
*
*/

package it.kaizenteam.app.model.NorrisChart;

import java.util.ArrayList;

/**
 * Created by Moro on 24/05/15.
 */
public class MapChartDataImpl implements ChartData {
    private ArrayList<MapSet> values;

    /**
     *
     * @param values
     */
    public MapChartDataImpl(ArrayList<MapSet> values){
        this.values=values;
    }

    /**
     *
     * @return
     */
    public ArrayList<MapSet> getData(){
        return values;
    }

    //TODO rimuovere...viene modificato per riferimento

    /**
     *
     * @param values
     */
    public void setData(ArrayList<MapSet> values){
        this.values=values;
    }
}
