/*
* Name: LineChartActivity.java
* Package: it.kaizenteam.app.view
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/view
* Date: 2015-05-24
* Version: 0.01
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.01	2015-05-19	Davide Dal Bianco   Verify
* =================================================================
* v0.01 2015-05-19  Moretto Alessandro  Creazione file
* =================================================================
*
*/

package it.kaizenteam.app.view;

import android.os.Bundle;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

import it.kaizenteam.app.R;
import it.kaizenteam.app.model.NorrisChart.ChartData;
import it.kaizenteam.app.model.NorrisChart.LineChartDataImpl;
import it.kaizenteam.app.presenter.LineChartPresenter;
import it.kaizenteam.app.presenter.PresenterImpl;

/**
 * LineChartActivity specializes ChartActivity and constitutes an Activity for line charts. It provides static constants that represent the possible values to pass to methods to change the view.
 */
public class LineChartActivity extends ChartActivity implements LineChartView {
    //TODO Barchart dei dati
    private LineChart chart;

    /**
     * This method is performed by android at the creation of the Activity. It will be tasked to initializing its presenter.
     * @param savedInstanceState instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chart);
        chart=(LineChart)findViewById(R.id.chart);
        presenter= PresenterImpl.create(PresenterImpl.LINECHART_TYPE, this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ((LineChartPresenter)presenter).setChart("lc");// TODO getIntent().getStringExtra("id"));
        chart.setDescription("");
        chart.invalidate();
    }

    @Override
    protected void onPause() {
        super.onPause();
        ((LineChartPresenter)presenter).onPause();
        chart.setDescription("");
        chart.invalidate();
    }

    /**
     * This method will display correctly the chart passed as a parameter.
     * @param data chart
     */
    @Override
    public void renderChart(ChartData data) {
        chart.clear();
        chart.getXAxis().setValues(((LineChartDataImpl) data).getData().getXVals());
        chart.setData(((LineChartDataImpl) data).getData());

        float max=0;
        for(int i =0;i<chart.getData().getDataSets().size();i++)
            for(int j =0;j<chart.getData().getDataSets().get(i).getYVals().size();j++){
                if(chart.getData().getDataSets().get(i).getYVals().get(j).getVal()>max)
                    max=chart.getData().getDataSets().get(i).getYVals().get(j).getVal();
            }

        chart.getAxisLeft().setAxisMaxValue(max + 1);
        chart.getAxisRight().setAxisMaxValue(max + 1);
        chart.invalidate();
        //TODO: controllare se c'è qualcosa di piu efficiente senza farlo nel model
    }

    /**
     * This method provides the ability to display in the view the name of axes of the chart.
     * @param x name of x-axis
     * @param y name of y-axis
     */
    @Override
    public void setAxisName(String x, String y) {
        ((TextView) findViewById(R.id.xlabelline)).setText(x);
        ((TextView) findViewById(R.id.ylabelline)).setText(y.replace("", "\n"));
    }

    /**
     * This method provides the ability to view or not the grid in the chart. If the parameter is true appears and hidden otherwise.
     * @param show boolean show / hidden the chart grid
     */
    @Override
    public void showGrid(boolean show) {
        chart.getXAxis().setDrawGridLines(show);
        chart.getAxisRight().setDrawGridLines(show);
        chart.getAxisLeft().setDrawGridLines(show);
        chart.invalidate();
    }

    /**
     * This method provides the ability to set the position of the legend. The positions available are eligible as static variables of the class.
     * @param position position of the legend
     */
    @Override
    public void setLegendPosition(int position) {
        if(position==0){
            chart.getLegend().setPosition(Legend.LegendPosition.BELOW_CHART_LEFT);
            return;
        }
        if(position==1){
            chart.getLegend().setPosition(Legend.LegendPosition.BELOW_CHART_RIGHT);
            return;
        }
        if(position==2){
            chart.getLegend().setPosition(Legend.LegendPosition.RIGHT_OF_CHART);
            return;
        }
        if(position==3){
            chart.getLegend().setPosition(Legend.LegendPosition.RIGHT_OF_CHART_CENTER);
            return;
        }
        chart.invalidate();
    }

    /**
     * This method allows to display the lines of the line chart with points or not (depending on the boolean parameter).
     * @param dotted disply / not display the lines of the line chart with points or not
     */
    @Override
    public void setDottedLines(boolean dotted) {
        ArrayList<LineDataSet> sets = chart.getData().getDataSets();
        for (LineDataSet set : sets){
            if (dotted)
                set.enableDashedLine(5, 5, 5);
            else
                set.disableDashedLine();
          }
        chart.invalidate();
    }

    /**
     * This method allows to display the lines of the line chart cubic or not (depending on the boolean parameter).
     * @param dotted disply / not display the lines of the line chart cubic
     */
    //TODO @Override
    public void setCubicLines(boolean dotted) {
        ArrayList<LineDataSet> sets = chart.getData().getDataSets();
        for (LineDataSet set : sets)
            set.setDrawCubic(dotted);
        chart.invalidate();
    }

    public void setDotRadius(int dotRadius) {
        ArrayList<LineDataSet> sets = chart.getData().getDataSets();
        for (LineDataSet set : sets) {
            if(dotRadius==0)
                set.setDrawCircles(false);
            else {
                set.setDrawCircles(true);
                set.setCircleSize(dotRadius);
            }

        }
        chart.invalidate();
    }
}
