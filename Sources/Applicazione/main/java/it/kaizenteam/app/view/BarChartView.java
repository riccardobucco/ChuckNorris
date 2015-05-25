package it.kaizenteam.app.view;

import it.kaizenteam.app.model.NorrisChart.ChartData;

/**
 * Created by Moro on 23/05/15.
 */
public interface BarChartView extends View {
    /**
     *
     * @param data
     */
    void renderChart(ChartData data);

    /**
     *
     * @param x
     * @param y
     */
    void setAxisName(String x, String y);

    /**
     *
     * @param show
     */
    void showGrid(boolean show);

    /**
     *
     * @param position
     */
    void setLegendPosition(int position);

    /**
     *
     * @param orientation
     */
    void setOrientation(int orientation);

    /**
     *
     * @param colors
     */
    void setSeriesColor(String[] colors);

    /**
     *
     * @param title
     */
    void setTitle(String title);
}
