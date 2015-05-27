package it.kaizenteam.app.model.NorrisChart;

import junit.framework.TestCase;

/**
 * Created by Moro on 27/05/15.
 */
public class TUMapChartElementInPlaceUpdate extends TestCase {

    public void testGetData() throws Exception {
        MapPoint p = new MapPoint(23,23,233030);
        MapChartElementInPlaceUpdate a = new MapChartElementInPlaceUpdate(p,"id");
        assertEquals(p,a.getData());
    }

    public void testGetX() throws Exception {
        MapPoint p = new MapPoint(23,23,233030);
        MapChartElementInPlaceUpdate a = new MapChartElementInPlaceUpdate(p,"id");
        assertEquals(23,a.getY());
    }

    public void testGetY() throws Exception {
        MapPoint p = new MapPoint(23,23,233030);
        MapChartElementInPlaceUpdate a = new MapChartElementInPlaceUpdate(p,"id");
        assertEquals(23,a.getY());
    }

    public void testGetId() throws Exception {
        MapPoint p = new MapPoint(23,23,233030);
        MapChartElementInPlaceUpdate a = new MapChartElementInPlaceUpdate(p,"id");
        assertEquals(233030,a.getId());
    }
}