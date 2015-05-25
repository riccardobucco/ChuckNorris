package it.kaizenteam.app.model.NorrisChart;

import org.json.JSONObject;


/**
 *
 */
public class BarChartSettingsImpl implements ChartSettings {
    private JSONObject settings;

    /**
     *
     * @param settings
     */
    public BarChartSettingsImpl(JSONObject settings){
        this.settings=settings;
    }

    /**
     *
     * @return
     */
    public String getXAxisName(){
        //TODO
        return "XAXIX";
    }

    /**
     *
     * @return
     */
    public String getYAxisName(){
        //TODO
        return "YAXIX";
    }

    /**
     *
     * @return
     */
    public boolean getGridVisibility(){
        //TODO
        return true;
    }

    /**
     *
     * @return
     */
    public String getLegendPosition(){
        //TODO
        return "left";
    }

    /**
     *
     * @return
     */
    public String getOrientation(){
        //TODO
        return "horizontal";
    }
}
