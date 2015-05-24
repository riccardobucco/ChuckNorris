package it.kaizenteam.app.model.NorrisChart;

/**
 * Created by Moro on 19/05/15.
 */
public class MapChartInPlaceUpdater implements Updater {
    private static MapChartInPlaceUpdater instance;

    public static Updater getInstance(){
        return instance;
    }

    private MapChartInPlaceUpdater(){}

    @Override
    public void update(ChartImpl chart, ChartUpdate updateData) {
//TODO
    }
}
