/*
* Name: LineChartStreamUpdate.java
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
public class LineChartStreamUpdate implements ChartUpdate  {
    private ArrayList<LineChartElementStreamUpdate> values;

    /**
     *
     * @param values
     */
    public LineChartStreamUpdate(ArrayList<LineChartElementStreamUpdate> values){
        this.values=values;
    }

    /**
     *
     * @return
     */
    public ArrayList<LineChartElementStreamUpdate> getData(){
        return values;
    }
}
