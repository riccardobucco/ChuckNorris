package it.kaizenteam.app.view;

import it.kaizenteam.app.model.NorrisChart.ChartData;

/**
 * Created by Moro on 23/05/15.
 */
public interface LineChartView extends View {
    void renderChart(ChartData data);
    void setAxisName(String x, String y);
    void showGrid(boolean show);
    void setLegendPosition(int position);
    void setSeriesColor(String[] colors);
    void setTitle(String title);
    void setDottedLines(boolean dotted);
}
