/*
* Name: TUApplicazioneChartImpl.java
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
* v0.02 2015-06-01 Bucco Riccardo Verify
* =================================================================
* v0.01 2015-05-23  Dal Bianco Davide  Creation
* =================================================================
*
*/
package test.unit;

import android.test.InstrumentationTestCase;

import it.kaizenteam.app.model.NorrisChart.ChartImpl;
import it.kaizenteam.app.model.NorrisChart.ChartModel;

public class TUApplicazioneChartImpl extends InstrumentationTestCase {

    public void testRegisterFactory() throws Exception {
        ChartImpl a;
        ChartImpl.create("barchart", "id");
        //if it's possible che register it's done
    }

    public void testRegisterUpdater() throws Exception {
        ChartModel a = ChartImpl.create("barchart","aaa");
        a.update("barchart", null);
        //if it's possible it's done
    }

    public void testGetData() throws Exception {
        ChartModel a = ChartImpl.create("barchart","aaa");
        assertEquals(null, a.getData());
    }

    public void testGetId() throws Exception {
        ChartModel a = ChartImpl.create("barchart","aaa");
        assertEquals("aaa",a.getId());
    }

    public void testGetSettings() throws Exception {
        ChartModel a = ChartImpl.create("barchart","aaa");
        assertEquals(null,a.getSettings());
    }

    public void testGetType() throws Exception {
        ChartModel a = ChartImpl.create("barchart","aaa");
        assertEquals("barchart",a.getType());
    }

    public void testSetData() throws Exception {
        ChartModel a = ChartImpl.create("barchart","idfwevwevw");
        a.setData(null);
        assertEquals(null, a.getData());
    }

    public void testSetSettings() throws Exception {
        ChartModel a = ChartImpl.create("barchart","idfwevwevw");
        a.setSettings(null);
        assertEquals(null, a.getSettings());
    }

}