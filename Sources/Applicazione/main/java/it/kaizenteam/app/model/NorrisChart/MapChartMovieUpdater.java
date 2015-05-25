package it.kaizenteam.app.model.NorrisChart;

/**
 * Created by Moro on 19/05/15.
 */
public class MapChartMovieUpdater implements Updater {
    private static MapChartMovieUpdater instance;

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
    private MapChartMovieUpdater(){}

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
