/*
* Name: TableStreamUpdater.java
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
* v0.01 2015-05-18  Moretto Alessandro  Creazione file
* =================================================================
*
*/

package it.kaizenteam.app.model.NorrisChart;

/**
 * This class is responsible for defining the stream update method of a table. It can access it has turned to the TableImpl private data fields because 
 * TableStreamUpdater is an inner class of TableImpl. In particular, it can access to DataObject container in TableImpl and change its values.
 */
public class TableStreamUpdater implements Updater {
    /**
     * The static attribute is the unique instance of that class.
     */
    private static TableStreamUpdater instance;

    /**
     * This method has the task of returning the unique instance of that class, and creating it if it not exists.
     * @return the unique instance of the class
     */
    public static Updater getInstance(){
        return instance;
    }

    /**
     * Constructor
     */
    private TableStreamUpdater(){}

    /**
     * This method has the task of updating the chart as a parameter (chart) by using the update package (UpdateData).
     * @param chart
     * @param updateData
     */
    @Override
    public void update(ChartImpl chart, ChartUpdate updateData) {
//TODO
    }
}
