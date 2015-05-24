package it.kaizenteam.app.model.NorrisChart;

/**
 * Created by Moro on 19/05/15.
 */
public class LineChartInPlaceUpdater implements Updater {
    private static LineChartInPlaceUpdater instance;

    public static Updater getInstance(){
        return instance;
    }

    private LineChartInPlaceUpdater(){}

    @Override
    public void update(ChartImpl chart, ChartUpdate updateData) {
//TODO
    }
}
