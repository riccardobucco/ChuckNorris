package it.kaizenteam.app.model.NorrisChart;

import junit.framework.TestCase;

/**
 * Created by Moro on 27/05/15.
 */
public class TUMapChartDeleteUpdate extends TestCase {

    public void testGetData() throws Exception {
        MapChartDeleteUpdate a =new MapChartDeleteUpdate(null);
        assertEquals(null,a.getData());
    }
}