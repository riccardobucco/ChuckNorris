package it.kaizenteam.app.model.NorrisChart;

import junit.framework.TestCase;

/**
 * Created by Moro on 27/05/15.
 */
public class TUMapChartInPlaceUpdate extends TestCase {

    public void testGetData() throws Exception {
        MapChartInPlaceUpdate a = new MapChartInPlaceUpdate(null);
        assertEquals(null, a.getData());
    }
}