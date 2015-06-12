/*
* Name: TUApplicazioneLineChartElementInPlaceUpdate.java
* Package: test.unit
* Location: Sources/Applicazione/test/unit
* Date: 2015-05-23
* Version: v0.01
*
* History:
* =================================================================
* Version   Date    Programmer  Changes
* =================================================================
* v0.01 2015-05-23  Dal Bianco Davide  Creation
* =================================================================
*
*/
package test.unit;

import junit.framework.TestCase;

import it.kaizenteam.app.model.NorrisChart.LineChartElementInPlaceUpdate;

public class TUApplicazioneLineChartElementInPlaceUpdate extends TestCase {

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