/*
* Name: TableActivity.java
* Package: it.kaizenteam.app.view
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/view
* Date: 19/05/2015
* Version: 0.01
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.01	2015-05-23	Alessandro Moretto	Creazione file
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
 * TableActivity specializes ChartActivity and constitutes an Activity for table charts. It provides static constants that represent the possible values to be passed to methods to change the view.
 */
public class TableActivity extends ChartActivity implements TableView{

    /**
     * This method is performed by android at the creation of the Activity. It will be tasked to initializing its presenter.
     * @param savedInstanceState instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        presenter= PresenterImpl.create(PresenterImpl.TABLE_TYPE, this);
    }

    /**
     * This method will display correctly the chart passed as a parameter.
     * @param data chart
     */
    @Override
    public void renderChart(ChartData data) {
        TableLayout table = (TableLayout)findViewById(R.id.table);
        table.removeAllViews();
        //for ogni dato in data...
    }

    /**
     * This method provides the ability to change the text color of a particular cell of the table.
     * @param riga row of the cell table to change
     * @param colonna col of the cell table to change
     * @param colorRGB color to set
     */
    @Override
    public void setCellTextColor(int riga, int colonna, String colorRGB) {
        //TODO
    }

    /**
     * This method provides the ability to change the background color of a particular cell of the table.
     * @param riga row of the cell table to change
     * @param colonna col of the cell table to change
     * @param colorRGB color to set
     */
    @Override
    public void setCellBackgroundColor(int riga, int colonna, String colorRGB) {
        //TODO
    }

    /**
     * This method allows the display in the correct way the title of the chart.
     * @param title title of the chart
     */
    @Override
    public void setTitle(String title) {
        ((TextView)findViewById(R.id.tableTitle)).setText(title);
    }

    /**
     * This method provides the ability to view or not border lines of the cells of the table.
     * @param border view / hide border lines of the cells of the table
     */
    @Override
    public void showCellBorderLine(boolean border) {
    }
}
