package it.kaizenteam.app.model.NorrisChart;

/**
 * Created by Moro on 19/05/15.
 */
public class LineChartInPlaceUpdater implements Updater {
    private static LineChartInPlaceUpdater instance;

    /**
     *
     * @return
     */
    public static Updater getInstance(){
        return instance;
    }

    /**
     *
     */
    private LineChartInPlaceUpdater(){}

    /**
     *
     * @param chart
     * @param updateData
     */
    @Override
    public void update(ChartImpl chart, ChartUpdate updateData) {
//TODO
    }
}
