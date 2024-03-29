/*
* Name: TUApplicazioneMapChartDataImpl.java
* Package: test.unit
* Location: Sources/Applicazione/test/unit
* Date: 2015-05-22
* Version: v1.00
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v1.00 2015-06-15 Carlon Chiara Approved
* =================================================================
* v0.02 2015-06-02 Dal Bianco Davide Verify
* =================================================================
* v0.01 2015-05-22  Moretto Alessandro  Creation
* =================================================================
*
*/
package test.unit;

import junit.framework.TestCase;

import it.kaizenteam.app.model.NorrisChart.MapChartDataImpl;

public class TUApplicazioneMapChartDataImpl extends TestCase {

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