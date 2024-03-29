/*
* Name: TUApplicazioneBarChartElementInPlaceUpdate.java
* Package: test.unit
* Location: Sources/Applicazione/test/unit
* Date: 2015-05-23
* Version: v1.00
*
* History:
* =================================================================
* Version Date Programmer Changes
* =================================================================
* v1.00 2015-06-15 Carlon Chiara Approved
* =================================================================
* v0.02 2015-06-03 Bigarella Chiara Verify
* =================================================================
* v0.01 2015-05-23  Moretto Alessandro  Creation
* =================================================================
*
*/
package test.unit;

import junit.framework.TestCase;

import it.kaizenteam.app.model.NorrisChart.BarChartElementInPlaceUpdate;

public class TUApplicazioneBarChartElementInPlaceUpdate extends TestCase {

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