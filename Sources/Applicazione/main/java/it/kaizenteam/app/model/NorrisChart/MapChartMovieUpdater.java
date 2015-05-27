/*
* Name: MapChartMovieUpdater.java
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
 * This class is responsible for defining the movie update method of a map chart. It can access the MapChartImpl private data fields because it is an inner class.  
 * In particular it can access in DataObject contained in MapChartImpl and change its values.
 */
public class MapChartMovieUpdater implements Updater {
    /**
     * The static attribute is the unique instance of the class.
     */
    private static MapChartMovieUpdater instance;

    /**
     * This method has the task of returning the unique instance of that class, and creating it if not exists.
     * @return the unique instance of the class
     */
    public static Updater getInstance(){
        return instance;
    }

    /**
     * Constructor
     */
    private MapChartMovieUpdater(){}

    /**
     * This method has the task of updating the chart passed as a parameter (chart) by using the update package (UpdateData).
     * @param chart
     * @param updateData
     */
    @Override
    public void update(ChartImpl chart, ChartUpdate updateData) {
//TODO
    }
}
