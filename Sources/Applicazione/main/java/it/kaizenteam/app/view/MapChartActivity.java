/*
* Name: {MapChartActivity.java}
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

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import it.kaizenteam.app.R;
import it.kaizenteam.app.model.NorrisChart.ChartData;


public class MapChartActivity extends ChartActivity implements MapChartView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_chart);
    }


    @Override
    public void renderChart(ChartData data) {
        //TODO
    }

    @Override
    public void setCameraCoordinate(int latitude, int longitude) {
//TODO
    }

    @Override
    public void setCameraZoom(int zoomLevel) {
//TODO
    }

    @Override
    public void setMarkerShape(String shape) {
//TODO
    }

    @Override
    public void setSeriesColor(String[] colors) {
//TODO
    }

    @Override
    public void setTitle(String title) {
//TODO
    }
}
