package it.kaizenteam.app.model.NorrisChart;

import com.github.mikephil.charting.charts.LineChart;

/**
 * Created by Moro on 24/05/15.
 */
public class LineChartDataImpl implements ChartData{
    private LineChart values;

    /**
     *
     * @param values
     */
    public LineChartDataImpl(LineChart values){
        this.values=values;
    }

    /**
     *
     * @return
     */
    public LineChart getData(){
        return values;
    }
}
