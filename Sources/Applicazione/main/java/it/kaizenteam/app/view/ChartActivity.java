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

abstract class ChartActivity extends BaseActivity{
    protected String idChart;

    public abstract void renderChart(ChartData data);
    public abstract void setTitle(String title);

    public String getId(){
        return idChart;
    }
}
