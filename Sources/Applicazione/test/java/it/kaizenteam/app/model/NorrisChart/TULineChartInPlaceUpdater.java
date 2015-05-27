package it.kaizenteam.app.model.NorrisChart;

import junit.framework.TestCase;

/**
 * Created by Moro on 27/05/15.
 */
public class TULineChartInPlaceUpdater extends TestCase {

    public void testGetInstance() throws Exception {
        Updater a = LineChartInPlaceUpdater.getInstance();
        Updater b = LineChartInPlaceUpdater.getInstance();
        assertEquals(a,b);
    }
}