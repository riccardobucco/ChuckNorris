/*
* Name: MapChartView.java
* Package: it.kaizenteam.app.view
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/view
* Date: 2015-05-24
* Version: v0.02
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.02 2015-05-26  Moretto Alessandro   Verify
* =================================================================
* v0.01 2015-05-23  Davide Dal Bianco  Creation
* =================================================================
*
*/

package it.kaizenteam.app.view;

import it.kaizenteam.app.model.NorrisChart.ChartData;

/**
 * This interface has the task of allowing the use of methods to change the view to represent a map chart from outside of the package View (therefore from a MapChartPresenterImpl).
 */
public interface MapChartView extends View {
    /**
     * This method will display correctly the chart passed as a parameter.
     * @param data chart
     */
    void renderChart(ChartData data);

    /**
     * This method provides the ability to change the display position of the map chart, or the coordinates of the central point.
     * @param latitude latitude coordinate of the central point
     * @param longitude longitude coordinate of the central point
     */
    void setCameraCoordinate(int latitude, int longitude);

    /**
     * This method provides the ability to change the display height of the map chart. The permitted heights are available in static constants of class (X_ZOOM_LEVEL) or intermediate values to them.
     * @param zoomLevel level of display height
     */
    void setCameraZoom(int zoomLevel);

    /**
     * This method provides the ability to change the map markers chart. The markers permits are available in static constants of class (X_SHAPE).
     * @param shape map marker to change
     */
    void setMarkerShape(String shape);

    /**
     * This method provides the ability to change the color of various series Data chart.
     * @param colors colour to change
     */
    void setSeriesColor(String[] colors);

    /**
     * This method allows the display in the correct way the title of the chart.
     * @param title title of the chart
     */
    void setTitle(String title);
}
