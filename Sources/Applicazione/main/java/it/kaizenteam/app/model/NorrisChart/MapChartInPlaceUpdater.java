/*
* Name: MapChartInPlaceUpdater.java
* Package: it.kaizenteam.app.model.NorrisChart
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/model/NorrisChart
* Date: 24/05/2015
* Version: 0.01
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.01	2015-05-24	Alessandro Moretto	Creazione file
* =================================================================
*
*/

package it.kaizenteam.app.model.NorrisChart;

/**
 * That class is responsible for defining in place updating method for a map chart. It can access to the private data fields of MapChartImpl because it is an inner class. In particular it can access to DataObject contained in MapChartImpl and change its values.
 */
public class MapChartInPlaceUpdater implements Updater {
    /**
      * The static attribute represent the unique instance of the class. 
      */
    private static MapChartInPlaceUpdater instance;

    /**
     * This method has the task of returning the unique instance of class, and creating it if it not exists.
     * @return instance of the class
     */
    public static Updater getInstance(){
        return instance;
    }

    /**
     * Constructor of the class
     */
    private MapChartInPlaceUpdater(){}


    /**
     * This method has the task of updating the chart passed as a parameter (chart) by using the update package (UpdateData).
     * @param chart the chart to be update
     * @param updateData the update package
     */
    @Override
    public void update(ChartImpl chart, ChartUpdate updateData) {
//TODO
    }
}
