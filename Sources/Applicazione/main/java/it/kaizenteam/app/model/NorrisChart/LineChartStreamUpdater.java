/*
* Name: LineChartStreamUpdater.java
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
* v0.01 2015-05-22  Davide Dal Bianco  Creation
* =================================================================
*
*/

package it.kaizenteam.app.model.NorrisChart;

/**
 * This class is responsible for defining the updating stream method for a line chart. In particular it change the DataObject contained in LineChartImpl through the appropriate method.
 */
public class LineChartStreamUpdater implements Updater {
    /**
     * This attribute is a reference to the unique instance of the class
     */    
    private static LineChartStreamUpdater instance;

    /**
     * This method allows to get the unique existing instance of the class.
     * @return instance of the class
     */
    public static Updater getInstance(){
        return instance;
    }

    /**
     * This method is the constructor of the class.
     */
    private LineChartStreamUpdater(){}

    @Override
    /**
     * This method allows to update the chart passed as the first parameter using the data passed as the second parameter.
     * @param chart
     * @param updateData
     */
    public void update(ChartImpl chart, ChartUpdate updateData) {
//TODO
    }
}
