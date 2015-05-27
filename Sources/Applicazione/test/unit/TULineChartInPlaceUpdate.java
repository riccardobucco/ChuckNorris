package it.kaizenteam.app.model.NorrisChart;

import junit.framework.TestCase;

/**
 * Created by Moro on 27/05/15.
 */
public class TULineChartInPlaceUpdate extends TestCase {

    public void testGetData() throws Exception {
        LineChartInPlaceUpdate a= new LineChartInPlaceUpdate(null);
        assertEquals(null, a.getData());
    }
}