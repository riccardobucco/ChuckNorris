/*
* Name: TableView.java
* Package: it.kaizenteam.app.view
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/view
* Date: 2015-05-24
* Version: 0.01
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.01	2015-05-24	Kaizen Team	Creazione file
* =================================================================
*
*/

package it.kaizenteam.app.view;

import it.kaizenteam.app.model.NorrisChart.ChartData;

/**
 * This interface has the task of allowing the use of methods to change the view to represent a table from the outside of the package View (therefore from a TablePresenterImpl).
 */
public interface TableView extends View {
    /**
     * This method will display correctly the chart passed as a parameter.
     * @param data chart
     */
    void renderChart(ChartData data);

    /**
     * This method provides the ability to change the text color of a particular cell of the table.
     * @param riga row of the cell table to change
     * @param colonna col of the cell table to change
     * @param colorRGB color to set
     */
    void setCellTextColor(int riga, int colonna, String colorRGB);

    /**
     * This method provides the ability to change the background color of a particular cell of the table.
     * @param riga row of the cell table to change
     * @param colonna col of the cell table to change
     * @param colorRGB color to set
     */
    void setCellBackgroundColor(int riga, int colonna, String colorRGB);

    /**
     * This method allows the display in the correct way the title of the chart.
     * @param title title of the chart
     */
    void setTitle(String title);

    /**
     * This method provides the ability to view or not border lines of the cells of the table.
     * @param border view / hide border lines of the cells of the table
     */
    void showCellBorderLine(boolean border);
}
