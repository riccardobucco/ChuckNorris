package it.kaizenteam.app.model.NorrisChart;

import org.json.JSONObject;

/**
 * Created by Moro on 24/05/15.
 */
public class MapChartSettingsImpl implements ChartSettings {
    private JSONObject settings;

    /**
     *
     * @param settings
     */
    public MapChartSettingsImpl(JSONObject settings){
        this.settings=settings;
    }

    /**
     *
     * @return
     */
    public String getMarkerType(){
        //TODO
        return "circle";
    }

    /**
     *
     * @return
     */
    public double getXCameraCoordinate(){
        //TODO
        return 153;
    }

    /**
     *
     * @return
     */
    public double getYCameraCoordinate(){
        //TODO
        return 153;
    }

    /**
     *
     * @return
     */
    public int getCameraZoomHeight(){
        //TODO
        return 15;
    }

}
