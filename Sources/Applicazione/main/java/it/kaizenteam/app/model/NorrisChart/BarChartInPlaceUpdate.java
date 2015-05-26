/*
 * Name: BarChartInPlaceUpdate
 * Package: it.kaizenteam.app.model.NorrisChart
 * Location: Sources/Applicazione/main/java/it/kaizenteam/app/model/NorrisChart
 * Date: 24/05/2015
 * Version: 0.01
 *
 * History:
 * =================================================================
 * Version	Date	Programmer	Changes
 *  =================================================================
 * v0.01	2015-05-24	Alessandro Moretto	Creazione file
 * =================================================================
 *
 */

package it.kaizenteam.app.model.NorrisChart;

import java.util.ArrayList;

/**
 * This class represents an in place update package of a bar chart.
 */
public class BarChartInPlaceUpdate implements ChartUpdate {
    private ArrayList<BarChartElementInPlaceUpdate> values;

    /**
     * This method is the constructor to create the update package.
     * @param values BarChart elements
     */
    public BarChartInPlaceUpdate(ArrayList<BarChartElementInPlaceUpdate> values){
        this.values=values;
    }

    /**
     * This method has the task of returning the data of the update package
     * @return data of the update package
     */
    public ArrayList<BarChartElementInPlaceUpdate> getData(){
        return values;
    }
}
