package it.kaizenteam.app.model.NorrisChart;

/**
 * Created by Moro on 19/05/15.
 */
public class BarChartInPlaceUpdater implements Updater {
    private static BarChartInPlaceUpdater instance;

    public static Updater getInstance(){
        return instance;
    }

    private BarChartInPlaceUpdater(){}

    @Override
    public void update(ChartImpl chart, ChartUpdate updateData) {
//TODO
    }
}
