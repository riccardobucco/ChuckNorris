package it.kaizenteam.app.model.NorrisChart;

import com.github.mikephil.charting.charts.BarChart;

/**
 * Created by Moro on 24/05/15.
 */

/**
 *
 */
public class BarChartDataImpl implements ChartData {
    private BarChart values;

    /**
     *
     * @param values
     */
    public BarChartDataImpl(BarChart values){
        this.values=values;
    }

    /**
     *
     * @return
     */
    public BarChart getData(){
        return values;
    }
}
