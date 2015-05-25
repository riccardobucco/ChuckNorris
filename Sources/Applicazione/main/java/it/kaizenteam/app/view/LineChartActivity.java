/*
* Name: {LineChartActivity.java}
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
 *
 *
 */
public class LineChartActivity extends ChartActivity implements LineChartView {
    //TODO Barchart dei dati
    private LineChart chart;
    ArrayList<Entry> entries;
    LineDataSet dataset;
    ArrayList<String> labels;
    LineData data;

    /**
     *
     * @param savedInstanceState
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
     *
     * @param data
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
     *
     * @param x
     * @param y
     */
    @Override
    public void setAxisName(String x, String y) {
//TODO
    }

    /**
     *
     * @param show
     */
    @Override
    public void showGrid(boolean show) {
//TODO
    }

    /**
     *
     * @param position
     */
    @Override
    public void setLegendPosition(int position) {
//TODO
    }

    /**
     *
     * @param colors
     */
    @Override
    public void setSeriesColor(String[] colors) {
//TODO
    }

    /**
     *
     * @param title
     */
    @Override
    public void setTitle(String title) {
//TODO
    }

    /**
     *
     * @param dotted
     */
    @Override
    public void setDottedLines(boolean dotted) {
//TODO
    }
}
