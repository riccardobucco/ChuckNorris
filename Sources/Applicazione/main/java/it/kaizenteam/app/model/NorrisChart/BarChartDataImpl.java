package it.kaizenteam.app.model.NorrisChart;

import com.github.mikephil.charting.charts.BarChart;

/**
 * Created by Moro on 24/05/15.
 */
public class BarChartDataImpl implements ChartData {
    private BarChart values;

    public BarChartDataImpl(BarChart values){
        this.values=values;
    }

    public BarChart getData(){
        return values;
    }

    //TODO rimuovere...viene modificato per riferimento
    public void setData(BarChart values){
        this.values=values;
    }
}
