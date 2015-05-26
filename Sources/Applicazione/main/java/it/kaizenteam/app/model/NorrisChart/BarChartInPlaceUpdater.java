/*
 * Name: BarChartInPlaceUpdater
 * Package: it.kaizenteam.app.model.NorrisChart
 * Location: Sources/Applicazione/main/java/it/kaizenteam/app/model/NorrisChart
 * Date: 24/05/2015
 * Version: 0.01
 *
 * History:
 * =================================================================
 * Version	Date	Programmer	Changes
 *  =================================================================
 * v0.01	2015-05-24	Alessandro Moretto	Creazione file
 * =================================================================
 *
 */


package it.kaizenteam.app.model.NorrisChart;

/**
 * This class is responsible for defining the in place update method for a bar chart. It can access to the BarChartImpl private data fields because it is an inner class of BarChartImpl. In particular, it can access to DataObject contained in  BarChartImpl and change its values.
 */
public class BarChartInPlaceUpdater implements Updater {
    /*
     * The static attribute is the unique instance of that class.
     */
    private static BarChartInPlaceUpdater instance;

    /**
     * This method is responsible for returning the unique instance of this class and creating it if it not exists.
     * @return the unique instance of the class
     */
    public static Updater getInstance(){
        return instance;
    }

    /**
     * Constructor
     */
    private BarChartInPlaceUpdater(){}

    /**
     * This method has the task of updating the chart as a parameter (chart) by using the update package (UpdateData).
     * @param chart
     * @param updateData update package
     */
    @Override
    public void update(ChartImpl chart, ChartUpdate updateData) {
//TODO
    }
}
