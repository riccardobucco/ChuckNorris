package it.kaizenteam.app.model.NorrisChart;

import junit.framework.TestCase;

/**
 * Created by Moro on 27/05/15.
 */
public class TUBarChartInPlaceUpdater extends TestCase {

    public void testGetInstance() throws Exception {
        Updater a = BarChartInPlaceUpdater.getInstance();
        Updater b = BarChartInPlaceUpdater.getInstance();
        assertEquals(a,b);
    }
}