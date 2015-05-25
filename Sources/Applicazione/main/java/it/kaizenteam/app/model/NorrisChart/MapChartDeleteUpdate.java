/*
* Name: MapChartDeleteUpdate.java
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
public class MapChartDeleteUpdate {
    private ArrayList<MapPoint> values;

    /**
     *
     * @param values
     */
    public MapChartDeleteUpdate(ArrayList<MapPoint> values){
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
