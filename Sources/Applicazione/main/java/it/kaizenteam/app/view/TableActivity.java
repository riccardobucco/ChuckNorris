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

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.TextView;

import it.kaizenteam.app.R;
import it.kaizenteam.app.model.NorrisChart.ChartData;
import it.kaizenteam.app.presenter.PresenterImpl;


/**
 *
 */
public class TableActivity extends ChartActivity implements TableView{

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        presenter= PresenterImpl.create(PresenterImpl.TABLE_TYPE, this);
    }

    /**
     *
     * @param data
     */
    @Override
    public void renderChart(ChartData data) {
        TableLayout table = (TableLayout)findViewById(R.id.table);
        table.removeAllViews();
        //for ogni dato in data...
    }

    /**
     *
     * @param riga
     * @param colonna
     * @param colorRGB
     */
    @Override
    public void setCellTextColor(int riga, int colonna, String colorRGB) {
        //TODO
    }

    /**
     *
     * @param riga
     * @param colonna
     * @param colorRGB
     */
    @Override
    public void setCellBackgroundColor(int riga, int colonna, String colorRGB) {
        //TODO
    }

    /**
     *
     * @param title
     */
    @Override
    public void setTitle(String title) {
        ((TextView)findViewById(R.id.tableTitle)).setText(title);
    }

    /**
     *
     * @param border
     */
    @Override
    public void showCellBorderLine(boolean border) {
    }
}
