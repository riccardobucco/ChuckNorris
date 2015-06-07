/*
* Name: ChartUpdater.java
* Package: it.kaizenteam.app.model.NorrisChart
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/model/NorrisChart
* Date: 2015-05-19
* Version: 0.01
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.02 2015-05-24  Davide Dal Bianco   Verify
* =================================================================
* v0.01 2015-05-18  Moretto Alessandro  Creazione file
* =================================================================
*
*/

package it.kaizenteam.app.model.NorrisChart;

/**
 * ChartUpdater is the interface of classes that deal with implementation of various types of update for each type of chart.
 */
public interface ChartUpdater {
    /**
     * This method has the task of updating the chart as a parameter (chart) using the update package (UpdateData).
     * @param chart
     * @param updateData
     */
    void update(ChartImpl chart, ChartUpdate updateData);
}