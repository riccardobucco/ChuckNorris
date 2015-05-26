/*
* Name: BarChartActivity.java
* Package: it.kaizenteam.app.view
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/view
* Date: 2015-05-24
* Version: 0.01
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.01	2015-05-24	Kaizen Team	Creazione file
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
 * BarChartActivity specializes ChartActivity and constitutes an Activity for bar charts. It provides static constants that represent the possible values to be passed to methods to change the view.
 */
public class BarChartActivity extends ChartActivity implements BarChartView{
    //TODO Barchart dei dati
    private BarChart chart;
    ArrayList<BarEntry> entries;
    BarDataSet dataset;
    ArrayList<String> labels;
    BarData data;

    /**
     * This method is performed by android at the creation of the Activity. It will be tasked to initializing its presenter.
     * @param savedInstanceState instance state
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
     * This method will display correctly the chart passed as a parameter.
     * @param data chart
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
     * This method provides the ability to change the orientation of the chart based on the parameter.
     * The parameters allowed are available in static constants in the class.
     * @param orientation orientation of the chart
     */
    @Override
    public void setOrientation(int orientation) {
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
}
