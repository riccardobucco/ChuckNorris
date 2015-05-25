package it.kaizenteam.app.model.NorrisChart;

import org.json.JSONObject;

/**
 * Created by Moro on 24/05/15.
 */
public class LineChartSettingsImpl implements ChartSettings{
    private JSONObject settings;

    /**
     *
     * @param settings
     */
    public LineChartSettingsImpl(JSONObject settings){
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
}
