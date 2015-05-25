package it.kaizenteam.app.presenter;

import org.json.JSONObject;

import it.kaizenteam.app.model.NorrisChart.ChartData;
import it.kaizenteam.app.model.NorrisChart.ChartSettings;
import it.kaizenteam.app.model.NorrisChart.ChartUpdate;

/**
 * Created by Moro on 19/05/15.
 */
public class JSONParser {
    private static JSONParser instance;

    /**
     *
     * @return
     */
    public static JSONParser getInstance(){
        if(instance!=null)
            return instance;
        return new JSONParser();
    }

    /**
     *
     */
    private JSONParser(){
        instance=this;
    }

    /**
     *
     * @param updateData
     * @return
     */
    public ChartUpdate parseUpdate(JSONObject updateData){
        //todo
        return null;
    }

    /**
     *
     * @param chartData
     * @return
     */
    public ChartData parseChart(JSONObject chartData){
        //todo
        return null;
    }

    /**
     *
     * @param settingsData
     * @return
     */
    public ChartSettings parseSettings(JSONObject  settingsData){
        //todo
        return null;
    }
}
