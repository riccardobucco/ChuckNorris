/*
* Name: {BarChartActivity.java}
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

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

import it.kaizenteam.app.R;
import it.kaizenteam.app.model.NorrisChart.ChartData;
import it.kaizenteam.app.presenter.BarChartPresenter;
import it.kaizenteam.app.presenter.PresenterImpl;


/**
 *
 */
public class BarChartActivity extends ChartActivity implements BarChartView{
    //TODO Barchart dei dati
    private BarChart chart;
    ArrayList<BarEntry> entries;
    BarDataSet dataset;
    ArrayList<String> labels;
    BarData data;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);
        presenter= PresenterImpl.create(PresenterImpl.BARCHART_TYPE,this);

        //TODO rimuovi
        ((BarChartPresenter)presenter).update(null,null);
    }


    /**
     *
     * @param data
     */
    @Override
    public void renderChart(ChartData data) {
        //TODO use data
        entries = new ArrayList<>();
        entries.add(new BarEntry(4f, 0));
        entries.add(new BarEntry(8f, 1));
        entries.add(new BarEntry(6f, 2));
        entries.add(new BarEntry(12f, 3));
        entries.add(new BarEntry(18f, 4));
        entries.add(new BarEntry(9f, 5));

        dataset = new BarDataSet(entries, "# of Calls");

        labels = new ArrayList<>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");

        chart = new BarChart(this.getBaseContext());
        setContentView(chart);

        this.data = new BarData(labels, dataset);
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
     * @param orientation
     */
    @Override
    public void setOrientation(int orientation) {
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
}
