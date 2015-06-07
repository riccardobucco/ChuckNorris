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
* v0.02 2015-05-26  Moretto Alessandro   Verify
* =================================================================
* v0.01 2015-05-23  Davide Dal Bianco  Creazione file
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
     * This method provides the ability to view or not border lines of the cells of the table.
     * @param border view / hide border lines of the cells of the table
     */
    void showCellBorderLine(boolean border);

    /**
     * This method will display properly the description of the chart.
     * @param description description of the chart
     */
    public void setDescription(String description);
}
