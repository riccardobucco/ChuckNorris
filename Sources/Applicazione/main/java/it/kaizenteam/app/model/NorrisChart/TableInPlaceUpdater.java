/*
* Name: TableInPlaceUpdater.java
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
 * This class is responsible for defining the in place update method for a table. It can access to the private data fields of his related class TableImpl. In particular, it can access in DataObject container in TableImpl and change its values.
 */
public class TableInPlaceUpdater implements Updater {
    /**
     * This attribute is a reference to the unique instance of the class.
     */
    private static TableInPlaceUpdater instance;

    /**
     * This method allows to get the unique existing instance of the class.
     * @return unique existing instance
     */
    public static Updater getInstance(){
        return instance;
    }

    /**
     * This method is the constructor of the class.
     */
    private TableInPlaceUpdater(){}

    /**
     * This method allows you to update the chart passed as the first parameter using the data passed as the second parameter.
     * @param chart
     * @param updateData
     */
    @Override
    public void update(ChartImpl chart, ChartUpdate updateData) {
//TODO
    }
}
