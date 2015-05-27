/*
* Name: MapChartSettingsImpl.java
* Package: it.kaizenteam.app.model.NorrisChart
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/model/NorrisChart
* Date: 2015-05-19
* Version: 0.01
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.02 2015-05-24  Davide Dal Bianco   Verify
* =================================================================
* v0.01 2015-05-18  Moretto Alessandro  Creazione file
* =================================================================
*
*/

package it.kaizenteam.app.model.NorrisChart;

import org.json.JSONObject;

/**
 * This class represents the settings for a map chart.
 */
public class MapChartSettingsImpl implements ChartSettings {
    /**
      * This attribute stores the JSON object with the settings of the chart.
      */
    private JSONObject settings;

    /**
     * Constructor of the class
     * @param settings of the chart
     */
    public MapChartSettingsImpl(JSONObject settings){
        this.settings=settings;
    }

    /**
     * This method has the task to return the type of marker for whatever point of the map chart.
     * @return marker of point
     */
    public String getMarkerType(){
        //TODO
        return "circle";
    }

    /**
     * This method has the task of returning the abscissas of the position of the camera in map chart.
     * @return abscissas of the position of the camera in map chart
     */
    public double getXCameraCoordinate(){
        //TODO
        return 153;
    }

    /**
     * This method has the task of returning the ordinates of the position of the camera in map chart.
     * @return ordinates of the position of the camera in map chart
     */
    public double getYCameraCoordinate(){
        //TODO
        return 153;
    }

    /**
     * This method has the task of returning the height of the camera in the map chart.
     * @return height of the camera in the map chart
     */
    public int getCameraZoomHeight(){
        //TODO
        return 15;
    }

}
