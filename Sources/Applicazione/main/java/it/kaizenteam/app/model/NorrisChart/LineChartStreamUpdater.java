package it.kaizenteam.app.model.NorrisChart;

/**
 * Created by Moro on 19/05/15.
 */
public class LineChartStreamUpdater implements Updater {
    private static LineChartStreamUpdater instance;

    public static Updater getInstance(){
        return instance;
    }

    private LineChartStreamUpdater(){}

    @Override
    public void update(ChartImpl chart, ChartUpdate updateData) {
//TODO
    }
}
