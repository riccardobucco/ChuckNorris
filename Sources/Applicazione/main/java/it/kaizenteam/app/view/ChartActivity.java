/*
* Name: {ChartActivity.java}
* Package: {it.kaizenteam.app.view}
* Location: {src.main.java.it.kaizenteam.view}
* Date: {data di creazione del file}
* Version: {0.01}
*
* History:
*
* =================================================================
* Version Date Programmer Changes
* =================================================================
* 0.01 GG-MM-AAAA Aessandro Moretto {creation}
* =================================================================
*
*/
package it.kaizenteam.app.view;


import it.kaizenteam.app.model.NorrisChart.ChartData;

/**
 *
 */
public abstract class ChartActivity extends BaseActivity{
    protected String idChart;

    /**
     *
     * @param data
     */
    public abstract void renderChart(ChartData data);

    /**
     *
     * @param title
     */
    public abstract void setTitle(String title);

    /**
     *
     * @return
     */
    public String getId(){
        return idChart;
    }
}
