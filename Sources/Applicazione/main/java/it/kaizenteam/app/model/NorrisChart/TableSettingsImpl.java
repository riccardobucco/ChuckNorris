package it.kaizenteam.app.model.NorrisChart;

import org.json.JSONObject;

/**
 * Created by Moro on 24/05/15.
 */

/**
 *
 */
public class TableSettingsImpl implements ChartSettings {
    private JSONObject settings;

    /**
     *
     * @param settings
     */
    public TableSettingsImpl(JSONObject settings){
        this.settings=settings;
    }

    /**
     *
     * @return
     */
    public boolean getBorderLineVisibility(){
        //TODO
        return true;
    }
}
