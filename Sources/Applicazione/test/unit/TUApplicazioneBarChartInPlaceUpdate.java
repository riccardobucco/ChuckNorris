/*
* Name: TUApplicazioneBarChartInPlaceUpdate.java
* Package: test.unit
* Location: Sources/Applicazione/test/unit
* Date: 2015-05-23
* Version: v0.01
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.01 2015-05-23  Dal Bianco Davide  Creation
* =================================================================
*
*/
package test.unit;

import junit.framework.TestCase;

import it.kaizenteam.app.model.NorrisChart.BarChartInPlaceUpdate;

public class TUApplicazioneBarChartInPlaceUpdate extends TestCase {

    public void testGetData() throws Exception {
        BarChartInPlaceUpdate a = new BarChartInPlaceUpdate(null);
        assertEquals(null,a.getData());
    }
}