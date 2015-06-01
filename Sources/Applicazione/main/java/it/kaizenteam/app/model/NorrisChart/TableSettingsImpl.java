/*
* Name: TableSettingsImpl.java
* Package: it.kaizenteam.app.model.NorrisChart
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/model/NorrisChart
* Date: 2015-05-19
* Version: v0.02
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.02 2015-05-24  Davide Dal Bianco   Verify
* =================================================================
* v0.01 2015-05-18  Moretto Alessandro  Creation
* =================================================================
*
*/

package it.kaizenteam.app.model.NorrisChart;

import org.json.JSONObject;

/**
 * This class represents the settings for a table.
 */
public class TableSettingsImpl implements ChartSettings {
    /**
     * This attribute stores the JSON object with the settings of the chart.
     */
    private JSONObject settings;

    /**
     * Constructor
     * @param settings
     */
    public TableSettingsImpl(JSONObject settings){
        this.settings=settings;
    }

    /**
     * This method has the task to returning a boolean that says if the border lines of the cells must be visible or not.
     * @return boolean that says if the border lines of the cells must be visible or not
     */
    public boolean getBorderLineVisibility(){
        //TODO
        return true;
    }
}
