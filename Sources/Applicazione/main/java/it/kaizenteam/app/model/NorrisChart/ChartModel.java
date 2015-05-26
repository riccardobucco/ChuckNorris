/*
* Name: ChartModel.java
* Package: it.kaizenteam.app.model.NorrisChart
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/model/NorrisChart
* Date: 2015-05-16
* Version: 0.01
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.01	2015-05-16	Kaizen Team	Creazione file
* =================================================================
*
*/

package it.kaizenteam.app.model.NorrisChart;


/**
 * Chart is a graphical interface that is generic and is implemented by ChartImpl. It contains the set and get methods related to the settings and data and methods related to updates of the charts.
 */
public interface ChartModel {
    /**
     * This method has the task of setting the settings of the chart.
     * @param object chart settings to set
     */
    public void setSettings(ChartSettings object);

    /**
     * This method has the task of setting the data of the chart.
     * @param object chart data to set
     */
    public void setData(ChartData object);

    /**
     * This method has the task to return the settings of the chart.
     * @return the settings of the chart
     */
    public ChartSettings getSettings();

    /**
     * This method has the task of returning the data of the chart.
     * @return the data of the chart
     */
    public ChartData getData();

    /**
     * This method has the task to return the id of the chart.
     * @return id of the chart
     */
    public String getId();

    /**
     * This method has the task of updating the chart using type of update in UpdateType and the update package UpdateData.
     * @param type update type
     * @param object update package
     */
    public void update(String type, ChartUpdate object);

    /**
     * This method has the task to return the type of the chart.
     * @return type of the chart
     */
    public String getType();
}
