/*
* Name: Updater.java
* Package: it.kaizenteam.app.model.NorrisChart
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/model/NorrisChart
* Date: 2015-05-19
* Version: 0.01
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.01	2015-05-19	Kaizen Team	Creazione file
* =================================================================
*
*/

package it.kaizenteam.app.model.NorrisChart;

/**
 * Updater is the interface of classes that deal with implementation of various types of update for each type of chart.
 */
public interface Updater {
    /**
     * This method has the task of updating the chart as a parameter (chart) using the update package (UpdateData).
     * @param chart
     * @param updateData
     */
    void update(ChartImpl chart, ChartUpdate updateData);
}
