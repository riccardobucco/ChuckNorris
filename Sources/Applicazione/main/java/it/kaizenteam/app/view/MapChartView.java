package it.kaizenteam.app.view;

import it.kaizenteam.app.model.NorrisChart.ChartData;

/**
 * Created by Moro on 23/05/15.
 */
public interface MapChartView extends View {
    /**
     *
     * @param data
     */
    void renderChart(ChartData data);

    /**
     *
     * @param latitude
     * @param longitude
     */
    void setCameraCoordinate(int latitude, int longitude);

    /**
     *
     * @param zoomLevel
     */
    void setCameraZoom(int zoomLevel);

    /**
     *
     * @param shape
     */
    void setMarkerShape(String shape);

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
