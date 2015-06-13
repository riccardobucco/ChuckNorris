/*
* Name: TUApplicazioneLineChartElementStreamUpdate.java
* Package: test.unit
* Location: Sources/Applicazione/test/unit
* Date: 2015-05-23
* Version: v1.00
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v1.00 2015-06-15 Carlon Chiara Approved
* =================================================================
* v0.02 2015-06-02 Moretto Alessandro Verify
* =================================================================
* v0.01 2015-05-23  Dal Bianco Davide  Creation
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