/*
* Name: TUApplicazioneMapChartStreamUpdate.java
* Package: test.unit
* Location: Sources/Applicazione/test/unit
* Date: 2015-05-24
* Version: v1.00
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v1.00 2015-06-15 Carlon Chiara Approved
* =================================================================
* v0.02 2015-06-02 Rubin Marco Verify
* =================================================================
* v0.01 2015-05-24  Moretto Alessandro  Creation
* =================================================================
*
*/
package test.unit;

import junit.framework.TestCase;

import java.util.ArrayList;

import it.kaizenteam.app.model.NorrisChart.MapChartElementStreamUpdate;
import it.kaizenteam.app.model.NorrisChart.MapChartStreamUpdate;

public class TUApplicazioneMapChartStreamUpdate extends TestCase {

    public void testGetData() throws Exception {
        ArrayList<MapChartElementStreamUpdate> data=new ArrayList<>();
        MapChartStreamUpdate a = new MapChartStreamUpdate(data);
        assertEquals(data, a.getData());
    }
}