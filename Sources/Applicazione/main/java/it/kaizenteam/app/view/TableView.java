package it.kaizenteam.app.view;

import it.kaizenteam.app.model.NorrisChart.ChartData;

/**
 * Created by Moro on 23/05/15.
 */
public interface TableView extends View {
    /**
     *
     * @param data
     */
    void renderChart(ChartData data);

    /**
     *
     * @param riga
     * @param colonna
     * @param colorRGB
     */
    void setCellTextColor(int riga, int colonna, String colorRGB);

    /**
     *
     * @param riga
     * @param colonna
     * @param colorRGB
     */
    void setCellBackgroundColor(int riga, int colonna, String colorRGB);

    /**
     *
     * @param title
     */
    void setTitle(String title);

    /**
     *
     * @param border
     */
    void showCellBorderLine(boolean border);
}
