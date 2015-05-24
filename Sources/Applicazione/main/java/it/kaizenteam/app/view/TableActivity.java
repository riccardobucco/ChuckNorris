/*
* Name: {TableActivity.java}
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
import android.view.Menu;
import android.view.MenuItem;

import it.kaizenteam.app.R;
import it.kaizenteam.app.model.NorrisChart.ChartData;


public class TableActivity extends ChartActivity implements TableView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
    }

    @Override
    public void renderChart(ChartData data) {
        //TODO
    }

    @Override
    public void setCellTextColor(int riga, int colonna, String colorRGB) {
        //TODO
    }

    @Override
    public void setCellBackgroundColor(int riga, int colonna, String colorRGB) {
        //TODO
    }

    @Override
    public void setTitle(String title) {
        //TODO
    }

    @Override
    public void showCellBorderLine(boolean border) {
        //TODO
    }
}
