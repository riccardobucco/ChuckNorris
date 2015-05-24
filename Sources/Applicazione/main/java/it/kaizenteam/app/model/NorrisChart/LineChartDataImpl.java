package it.kaizenteam.app.model.NorrisChart;

import com.github.mikephil.charting.charts.LineChart;

/**
 * Created by Moro on 24/05/15.
 */
public class LineChartDataImpl implements ChartData{
    private LineChart values;

    public LineChartDataImpl(LineChart values){
        this.values=values;
    }

    public LineChart getData(){
        return values;
    }

    //TODO rimuovere...viene modificato per riferimento
    public void setData(LineChart values){
        this.values=values;
    }
}
