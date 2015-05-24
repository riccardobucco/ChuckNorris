package it.kaizenteam.app.model.NorrisChart;

import org.json.JSONObject;

/**
 * Created by Moro on 24/05/15.
 */
public class MapChartSettingsImpl implements ChartSettings {
    private JSONObject settings;

    public MapChartSettingsImpl(JSONObject settings){
        this.settings=settings;
    }

    public String getMarkerType(){
        //TODO
        return "circle";
    }

    public double getXCameraCoordinate(){
        //TODO
        return 153;
    }

    public double getYCameraCoordinate(){
        //TODO
        return 153;
    }

    public int getCameraZoomHeight(){
        //TODO
        return 15;
    }

}
