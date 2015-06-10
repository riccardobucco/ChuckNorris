/*
* Name: ChartActivity.java
* Package: it.kaizenteam.app.view
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/view
* Date: 2015-05-24
* Version: 0.01
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.01	2015-05-19	Davide Dal Bianco   Verify
* =================================================================
* v0.01 2015-05-19  Moretto Alessandro  Creazione file
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
    public void setTitle(String title){
        getSupportActionBar().setTitle(title);
    }

    /**
     * This method will display properly the description of the chart.
     * @param description description of the chart
     */
    public void setDescription(String description) {
        getSupportActionBar().setSubtitle(description);
    }

    /**
     * This method returns the id of the graph shown.
     * @return id of the graph shown.
     */
    public String getId(){
        return idChart;
    }
}
