package it.kaizenteam.app.model.NorrisChart;

import org.json.JSONObject;

/**
 * Created by Moro on 24/05/15.
 */
public class BarChartSettingsImpl implements ChartSettings {
    private JSONObject settings;

    public BarChartSettingsImpl(JSONObject settings){
        this.settings=settings;
    }

    public String getXAxisName(){
        //TODO
        return "XAXIX";
    }

    public String getYAxisName(){
        //TODO
        return "YAXIX";
    }

    public boolean getGridVisibility(){
        //TODO
        return true;
    }

    public String getLegendPosition(){
        //TODO
        return "left";
    }

    public String getOrientation(){
        //TODO
        return "horizontal";
    }
}
