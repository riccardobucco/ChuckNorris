/*
* Name: TUApplicazioneMapChartDeleteUpdate.java
* Package: test.unit
* Location: Sources/Applicazione/test/unit
* Date: 2015-05-22
* Version: v0.01
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.01 2015-05-22  Moretto Alessandro  Creation
* =================================================================
*
*/
package test.unit;

import junit.framework.TestCase;

import it.kaizenteam.app.model.NorrisChart.MapChartDeleteUpdate;

public class TUApplicazioneMapChartDeleteUpdate extends TestCase {

    public void testGetData() throws Exception {
        MapChartDeleteUpdate a =new MapChartDeleteUpdate(null);
        assertEquals(null,a.getData());
    }
}