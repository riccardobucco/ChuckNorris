package it.kaizenteam.app.model.NorrisChart;

/**
 *
 */
public interface Updater {
    /**
     *
     * @param chart
     * @param updateData
     */
    void update(ChartImpl chart, ChartUpdate updateData);
}
