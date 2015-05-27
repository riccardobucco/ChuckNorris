package it.kaizenteam.app.model.NorrisChart;

import junit.framework.TestCase;

/**
 * Created by Moro on 27/05/15.
 */
public class TUMapChartMovieUpdater extends TestCase {

    public void testGetInstance() throws Exception {
        Updater a = MapChartMovieUpdater.getInstance();
        Updater b = MapChartMovieUpdater.getInstance();
        assertEquals(a,b);
    }
}