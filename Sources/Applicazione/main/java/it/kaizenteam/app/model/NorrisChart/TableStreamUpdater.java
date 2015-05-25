package it.kaizenteam.app.model.NorrisChart;

/**
 * Created by Moro on 19/05/15.
 */

/**
 *
 */
public class TableStreamUpdater implements Updater {
    private static TableStreamUpdater instance;

    /**
     *
     *
     * @return
     */
    public static Updater getInstance(){
        return instance;
    }

    /**
     *
     */
    private TableStreamUpdater(){}

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
