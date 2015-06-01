/*
* Name: LineChartSettingsImpl.java
* Package: it.kaizenteam.app.model.NorrisChart
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/model/NorrisChart
* Date: 2015-05-16
* Version: v0.02
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.02 2015-05-26  Moretto Alessandro   Verify
* =================================================================
* v0.01 2015-05-22  Davide Dal Bianco  Creation
* =================================================================
*
*/

package it.kaizenteam.app.model.NorrisChart;

import org.json.JSONObject;

/**
 * This class represents the settings for a line chart
 */
public class LineChartSettingsImpl implements ChartSettings{
    /**
     * This attribute stores the JSON object with the settings of the chart.
     */
    private JSONObject settings;

    /**
     * This method is the constructor to create the settings for a line chart
     * @param settings chart settings
     */
    public LineChartSettingsImpl(JSONObject settings){
        this.settings=settings;
    }

    /**
     * This method has the task of returning the name of the abscissa axis.
     * @return the name of the abscissa axis
     */
    public String getXAxisName(){
        //TODO
        return "XAXIX";
    }

    /**
     * This method has the task of returning the name of the ordinate axis.
     * @return the name of the ordinate axis
     */
    public String getYAxisName(){
        //TODO
        return "YAXIX";
    }

    /**
     * This method has the task to return a boolean that says if the grid is displayed or not.
     * @return display / hide grid
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
}
