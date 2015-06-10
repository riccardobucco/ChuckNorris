/*
* Name: TUApplicazioneMapChartElementInPlaceUpdate.java
* Package: it.kaizenteam.app.model
* Location: Sources/Applicazione/test/unit
* Date: 2015-05-19
* Version: v0.02
*
* History:
* =================================================================
* Version   Date    Programmer  Changes
* =================================================================
* v0.02 2015-05-26  Moretto Alessandro   Verify
* =================================================================
* v0.01 2015-05-23  Davide Dal Bianco  Creation
* =================================================================
*
*/
package test.unit;

import junit.framework.TestCase;

import it.kaizenteam.app.model.NorrisChart.MapChartElementInPlaceUpdate;
import it.kaizenteam.app.model.NorrisChart.MapPoint;

public class TUApplicazioneMapChartElementInPlaceUpdate extends TestCase {

    public void testGetData() throws Exception {
        MapPoint p = new MapPoint(23,23);
        MapChartElementInPlaceUpdate a = new MapChartElementInPlaceUpdate(p,0,0);
        assertEquals(p,a.getData());
    }

    public void testGetX() throws Exception {
        MapPoint p = new MapPoint(23,23);
        MapChartElementInPlaceUpdate a = new MapChartElementInPlaceUpdate(p,0,0);
        assertEquals(0,a.getIndex());
    }

    public void testGetY() throws Exception {
        MapPoint p = new MapPoint(23,23);
        MapChartElementInPlaceUpdate a = new MapChartElementInPlaceUpdate(p,0,0);
        assertEquals(0,a.getSeries());
    }

    public void testGetId() throws Exception {
        MapPoint p = new MapPoint(23,23);
        MapChartElementInPlaceUpdate a = new MapChartElementInPlaceUpdate(p,0,0);
        a.setId("233030");
        assertEquals("233030",a.getId());
    }
}