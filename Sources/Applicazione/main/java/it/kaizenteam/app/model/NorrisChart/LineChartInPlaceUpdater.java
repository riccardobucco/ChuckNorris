/*
* Name: LineChartInPlaceUpdater.java
* Package: it.kaizenteam.app.model.NorrisChart
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/model/NorrisChart
* Date: 2015-05-16
* Version: v0.02
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.02 2015-05-26  Moretto Alessandro   Verify
* =================================================================
* v0.01 2015-05-22  Davide Dal Bianco  Creazione file
* =================================================================
*
*/

package it.kaizenteam.app.model.NorrisChart;

/**
 * This class is responsible for defining the in place update method for a line chart. It can access to the LineChartImpl private data fields because it is an inner class of LineChartImpl. In particular, it can access to DataObject contained in LineChartImpl and change its values.
 */
public class LineChartInPlaceUpdater implements Updater {
    /**
     * The static attribute is the unique instance of that class.
     */
    private static LineChartInPlaceUpdater instance;

    /**
     * This method is responsible for returning the unique instance of this class and creating it if it not exists
     * @return the unique instance of the class
     */
    public static ChartUpdater getInstance(){
        return instance;
    }

    /**
     * Constructor
     */
    private LineChartInPlaceUpdater(){}

    /**
     * This method has the task of updating the chart as a parameter (chart) by using the update package (UpdateData).
     * @param chart chart to update
     * @param updateData update package
     */
    @Override
    public void update(ChartImpl chart, ChartUpdate updateData) {
//TODO
    }
}
