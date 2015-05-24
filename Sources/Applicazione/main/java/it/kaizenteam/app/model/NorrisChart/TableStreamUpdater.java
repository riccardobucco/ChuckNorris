package it.kaizenteam.app.model.NorrisChart;

/**
 * Created by Moro on 19/05/15.
 */
public class TableStreamUpdater implements Updater {
    private static TableStreamUpdater instance;

    public static Updater getInstance(){
        return instance;
    }

    private TableStreamUpdater(){}

    @Override
    public void update(ChartImpl chart, ChartUpdate updateData) {
//TODO
    }
}
