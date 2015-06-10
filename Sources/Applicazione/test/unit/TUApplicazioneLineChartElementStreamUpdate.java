/*
* Name: TUApplicazioneLineChartElementStreamUpdate.java
* Package: it.kaizenteam.app.model
* Location: Sources/Applicazione/test/unit
* Date: 2015-05-19
* Version: v0.02
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.02 2015-05-26  Moretto Alessandro   Verify
* =================================================================
* v0.01 2015-05-23  Davide Dal Bianco  Creation
* =================================================================
*
*/
package test.unit;

import junit.framework.TestCase;

import java.util.ArrayList;

import it.kaizenteam.app.model.NorrisChart.LineChartElementStreamUpdate;

public class TUApplicazioneLineChartElementStreamUpdate extends TestCase {

    public void testGetData() throws Exception {
        ArrayList<Integer> r= new ArrayList<>();
        r.add(23);
        LineChartElementStreamUpdate a = new LineChartElementStreamUpdate("lab", r);
        assertEquals(23,a.getData().get(0).intValue());
    }

    public void testGetLabel() throws Exception {
        ArrayList<Integer> r= new ArrayList<>();
        r.add(23);
        LineChartElementStreamUpdate a = new LineChartElementStreamUpdate("lab",r);
        assertEquals(23,a.getData().get(0).intValue());
    }
}