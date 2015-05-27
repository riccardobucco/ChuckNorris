/*
* Name: TUApplicazioneBarChartElementInPlaceUpdate.java
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