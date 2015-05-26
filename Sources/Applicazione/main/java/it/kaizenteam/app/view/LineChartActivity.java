/*
* Name: LineChartActivity.java
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

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

import it.kaizenteam.app.R;
import it.kaizenteam.app.model.NorrisChart.ChartData;
import it.kaizenteam.app.presenter.LineChartPresenter;
import it.kaizenteam.app.presenter.PresenterImpl;

/**
 * LineChartActivity specializes ChartActivity and constitutes an Activity for line charts. It provides static constants that represent the possible values to pass to methods to change the view.
 */
public class LineChartActivity extends ChartActivity implements LineChartView {
    //TODO Barchart dei dati
    private LineChart chart;
    ArrayList<Entry> entries;
    LineDataSet dataset;
    ArrayList<String> labels;
    LineData data;

    /**
     * This method is performed by android at the creation of the Activity. It will be tasked to initializing its presenter.
     * @param savedInstanceState instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chart);
        presenter= PresenterImpl.create(PresenterImpl.LINECHART_TYPE, this);

        //TODO rimuovi
        ((LineChartPresenter)presenter).update(null,null);
    }


    /**
     * This method will display correctly the chart passed as a parameter.
     * @param data chart
     */
    @Override
    public void renderChart(ChartData data) {
        //TODO use data
        entries = new ArrayList<>();
        entries.add(new Entry(4f, 0));
        entries.add(new Entry(8f, 1));
        entries.add(new Entry(6f, 2));
        entries.add(new Entry(12f, 3));
        entries.add(new Entry(18f, 4));
        entries.add(new Entry(9f, 5));

        dataset = new LineDataSet(entries, "# of Calls");

        labels = new ArrayList<>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");

        chart = new LineChart(this.getBaseContext());
        setContentView(chart);

        this.data = new LineData(labels, dataset);
        chart.setData(this.data);
    }

    /**
     * This method provides the ability to display in the view the name of axes of the chart.
     * @param x name of x-axis
     * @param y name of y-axis
     */
    @Override
    public void setAxisName(String x, String y) {
//TODO
    }

    /**
     * This method provides the ability to view or not the grid in the chart. If the parameter is true appears and hidden otherwise.
     * @param show boolean show / hidden the chart grid
     */
    @Override
    public void showGrid(boolean show) {
//TODO
    }

    /**
     * This method provides the ability to set the position of the legend. The positions available are eligible as static variables of the class.
     * @param position position of the legend
     */
    @Override
    public void setLegendPosition(int position) {
//TODO
    }

    /**
     * This method provides the ability to change the color of various series Data chart.
     * @param colors color to change
     */
    @Override
    public void setSeriesColor(String[] colors) {
//TODO
    }

    /**
     * This method allows the display in the correct way the title of the chart.
     * @param title title of the chart
     */
    @Override
    public void setTitle(String title) {
//TODO
    }

    /**
     * This method allows to display the lines of the line chart with points or not (depending on the boolean parameter).
     * @param dotted disply / not display the lines of the line chart with points or not
     */
    @Override
    public void setDottedLines(boolean dotted) {
//TODO
    }
}
