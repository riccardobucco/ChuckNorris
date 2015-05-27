package it.kaizenteam.app.model.NorrisChart;

import junit.framework.TestCase;

/**
 * Created by Moro on 27/05/15.
 */
public class TUBarChartElementInPlaceUpdate extends TestCase {

    public void testGetData() throws Exception {
        BarChartElementInPlaceUpdate a= new BarChartElementInPlaceUpdate(23,23,23);
        assertEquals(23,a.getData());
    }

    public void testGetX() throws Exception {
        BarChartElementInPlaceUpdate a= new BarChartElementInPlaceUpdate(23,23,23);
        assertEquals(23,a.getX());
    }

    public void testGetY() throws Exception {
        BarChartElementInPlaceUpdate a= new BarChartElementInPlaceUpdate(23,23,23);
        assertEquals(23,a.getY());
    }
}