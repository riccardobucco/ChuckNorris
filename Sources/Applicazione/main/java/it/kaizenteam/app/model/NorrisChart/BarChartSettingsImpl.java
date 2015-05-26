/*
 * Name: BarChartSettingsImpl
 * Package: it.kaizenteam.app.model.NorrisChart
 * Location: Sources/Applicazione/main/java/it/kaizenteam/app/model/NorrisChart
 * Date: 2015-05-16
 * Version: 0.01
 *
 * History:
 * =================================================================
 * Version	Date	Programmer	Changes
 *  =================================================================
 * v0.01	2015-05-16	Kaizen Team	Creazione file
 * =================================================================
 *
 */

package it.kaizenteam.app.model.NorrisChart;

import org.json.JSONObject;


/**
 * This class represents the settings for a bar chart.
 */
public class BarChartSettingsImpl implements ChartSettings {
    /*
     * This attribute stores the JSON object with the settings of the chart.
     */
    private JSONObject settings;

    /**
     * Constructor
     * @param settings
     */
    public BarChartSettingsImpl(JSONObject settings){
        this.settings=settings;
    }

    /**
     * This method has the task of returning the title of the abscissa axis.
     * @return the title of the abscissa axis
     */
    public String getXAxisName(){
        //TODO
        return "XAXIX";
    }

    /**
     * This method has the task of returning the title of the ordinates axis.
     * @return the title of the ordinates axis
     */
    public String getYAxisName(){
        //TODO
        return "YAXIX";
    }

    /**
     * This method has the task to return a boolean that says if the grid is displayed or not.
     * @return display / hide the grid
     */
    public boolean getGridVisibility(){
        //TODO
        return true;
    }

    /**
     * This method has the task of returning the position of the legend.
     * @return the position of the legend
     */
    public String getLegendPosition(){
        //TODO
        return "left";
    }

    /**
     * This method has the task of returning the orientation of the chart.
     * @return the chart orientation
     */
    public String getOrientation(){
        //TODO
        return "horizontal";
    }
}
