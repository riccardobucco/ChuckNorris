/*
* Name: LineChartStreamUpdater.java
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
 * Created by Moro on 19/05/15.
 */
public class LineChartStreamUpdater implements Updater {
    private static LineChartStreamUpdater instance;

    /**
     *
     * @return
     */
    public static Updater getInstance(){
        return instance;
    }

    /**
     *
     */
    private LineChartStreamUpdater(){}

    @Override
/**
 *
 */
    public void update(ChartImpl chart, ChartUpdate updateData) {
//TODO
    }
}
