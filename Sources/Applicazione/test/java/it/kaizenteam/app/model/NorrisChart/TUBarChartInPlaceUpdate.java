package it.kaizenteam.app.model.NorrisChart;

import junit.framework.TestCase;

/**
 * Created by Moro on 27/05/15.
 */
public class TUBarChartInPlaceUpdate extends TestCase {

    public void testGetData() throws Exception {
        BarChartInPlaceUpdate a = new BarChartInPlaceUpdate(null);
        assertEquals(null,a.getData());
    }
}