package it.kaizenteam.app.view;

import it.kaizenteam.app.model.NorrisChart.ChartData;

/**
 * Created by Moro on 23/05/15.
 */
public interface TableView extends View {
    void renderChart(ChartData data);
    void setCellTextColor(int riga, int colonna, String colorRGB);
    void setCellBackgroundColor(int riga, int colonna, String colorRGB);
    void setTitle(String title);
    void showCellBorderLine(boolean border);
}
