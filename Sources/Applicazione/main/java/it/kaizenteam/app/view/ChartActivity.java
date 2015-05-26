/*
* Name: ChartActivity.java
* Package: it.kaizenteam.app.view
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/view
* Date: 19/05/2015
* Version: 0.01
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.01	2015-05-19	Alessandro Moretto	Creazione file
* =================================================================
*
*/

package it.kaizenteam.app.view;


import it.kaizenteam.app.model.NorrisChart.ChartData;

/**
 * ChartActivity is an abstract class that represents an Activity for the representation of generic chart.
 */
public abstract class ChartActivity extends BaseActivity{
    protected String idChart;

    /**
     * This method is abstract and all specializations of this class must implement it. It will display properly the chart.
     * @param data the chart to display
     */
    public abstract void renderChart(ChartData data);

    /**
     * This method is abstract and all specializations of this class must implement it. It will display properly the title of the chart.
     * @param title title of the chart
     */
    public abstract void setTitle(String title);

    /**
     * This method returns the id of the graph shown.
     * @return id of the graph shown.
     */
    public String getId(){
        return idChart;
    }
}
