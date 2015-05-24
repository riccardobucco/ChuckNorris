package it.kaizenteam.app.model.NorrisChart;

/**
 * Created by Moro on 19/05/15.
 */
public class TableInPlaceUpdater implements Updater {
    private static TableInPlaceUpdater instance;

    public static Updater getInstance(){
        return instance;
    }

    private TableInPlaceUpdater(){}

    @Override
    public void update(ChartImpl chart, ChartUpdate updateData) {
//TODO
    }
}
