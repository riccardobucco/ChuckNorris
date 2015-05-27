package it.kaizenteam.app.model.NorrisChart;

import junit.framework.TestCase;

/**
 * Created by Moro on 27/05/15.
 */
public class TUMapChartDataImpl extends TestCase {

    public void testGetData() throws Exception {
        MapChartDataImpl a = new MapChartDataImpl(null);
        assertEquals(null,a.getData());
    }

    public void testSetData() throws Exception {
        MapChartDataImpl a = new MapChartDataImpl(null);
        a.setData(null);
        assertEquals(null,a.getData());
    }
}