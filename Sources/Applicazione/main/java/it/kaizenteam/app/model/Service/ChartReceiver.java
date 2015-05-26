/*
* Name: ChartReceiver.java
* Package: it.kaizenteam.app.model.service
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/model/Service
* Date: 23/05/2015
* Version: 0.01
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.01	2015-05-23	Alessandro Moretto	Creazione file
* =================================================================
*
*/

package it.kaizenteam.app.model.Service;

/**
 * ChartReceiver is the interface ChartReceiverImpl.
 */
public interface ChartReceiver {
    /**
     * This method has the task to enable updates through the socket channel for the chart with id idchart.
     * @param chartId id of the chart
     */
    void startUpdateEvent(String chartId);

    /**
     * This method has the task of finishing the receipt of the updates through the socket channel for the chart with id idchart.
     * @param chartId id of the chart
     */
    void stopUpdateEvent(String chartId);

    /**
     * This method has the task of finding data and settings of a chart whose id is chartId. This method returns a HashMap in which are stored data with the keys "data" and "settings".
     * @param chartId id of the chart
     */
    void getChart(String chartId);
}
