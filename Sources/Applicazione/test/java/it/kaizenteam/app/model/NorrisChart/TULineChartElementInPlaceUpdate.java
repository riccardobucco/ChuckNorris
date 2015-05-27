package it.kaizenteam.app.model.NorrisChart;

import junit.framework.TestCase;

/**
 * Created by Moro on 27/05/15.
 */
public class TULineChartElementInPlaceUpdate extends TestCase {

    public void testGetData() throws Exception {
        LineChartElementInPlaceUpdate a = new LineChartElementInPlaceUpdate(23,23,23);
        assertEquals(23,a.getData());
    }

    public void testGetX() throws Exception {
        LineChartElementInPlaceUpdate a = new LineChartElementInPlaceUpdate(23,23,23);
        assertEquals(23,a.getData());
    }

    public void testGetY() throws Exception {
        LineChartElementInPlaceUpdate a = new LineChartElementInPlaceUpdate(23,23,23);
        assertEquals(23,a.getData());
    }
}