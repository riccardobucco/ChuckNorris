package it.kaizenteam.app.view;

import it.kaizenteam.app.model.NorrisChart.ChartData;

/**
 * Created by Moro on 23/05/15.
 */
public interface MapChartView extends View {
    void renderChart(ChartData data);
    void setCameraCoordinate(int latitude, int longitude);
    void setCameraZoom(int zoomLevel);
    void setMarkerShape(String shape);
    void setSeriesColor(String[] colors);
    void setTitle(String title);
}
