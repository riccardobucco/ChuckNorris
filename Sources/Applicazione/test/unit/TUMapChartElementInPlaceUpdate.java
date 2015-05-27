/*
* Name: TUMapChartElementInPlaceUpdate.java
* Package: it.kaizenteam.app.model
* Location: Sources/Applicazione/test/unit
* Date: 2015-05-19
* Version: 0.02
*
* History:
* =================================================================
* Version   Date    Programmer  Changes
* =================================================================
* v0.02 2015-05-26  Moretto Alessandro   Verify
* =================================================================
* v0.01 2015-05-23  Davide Dal Bianco  Creazione file
* =================================================================
*
*/
package it.kaizenteam.app.model.NorrisChart;

import junit.framework.TestCase;

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