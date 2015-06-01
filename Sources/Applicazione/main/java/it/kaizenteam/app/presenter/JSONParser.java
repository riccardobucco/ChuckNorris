/*
* Name: BarChartPresenter.java
* Package: it.kaizenteam.app.presenter
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/presenter
* Date: 2015-05-22
* Version: v0.02
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.02 2015-05-26  Moretto Alessandro   Verify
* =================================================================
* v0.01 2015-05-23  Davide Dal Bianco  Creazione file
* =================================================================
*
*/

package it.kaizenteam.app.presenter;

import org.json.JSONObject;

import it.kaizenteam.app.model.NorrisChart.ChartData;
import it.kaizenteam.app.model.NorrisChart.ChartSettings;
import it.kaizenteam.app.model.NorrisChart.ChartUpdate;

/**
 * This class deals with parsing the update packages or a chart of data coming from the server in JSON format.
 */
public class JSONParser {
    /**
     * The static attribute is the unique instance of that class.
     */
    private static JSONParser instance;

    /**
     * This static method is called to receive the unique instance for the class.
     * @return unique instance for the class
     */
    public static JSONParser getInstance(){
        if(instance!=null)
            return instance;
        return new JSONParser();
    }

    /**
     * It is the manufacturer of JSONParser. It is private to force to use design pattern singleton through the method getInstance().
     */
    private JSONParser(){
        instance=this;
    }

    /**
     * This method allows you to transform an update from the JSON format to ChartUpdate.
     * @param updateData
     * @return ChartUpdate
     */
    public ChartUpdate parseUpdate(JSONObject updateData){
        //todo
        return null;
    }

    /**
     * This method allows you to transform the data of a JSON format to ChartData.
     * @param chartData
     * @return ChartData format
     */
    public ChartData parseChart(JSONObject chartData){
        //todo
        return null;
    }

    /**
     * This method lets you turn the settings of a chart from JSON format to ChartSettings format.
     * @param settingsData
     * @return ChartSettings format
     */
    public ChartSettings parseSettings(JSONObject  settingsData){
        //todo
        return null;
    }
}
