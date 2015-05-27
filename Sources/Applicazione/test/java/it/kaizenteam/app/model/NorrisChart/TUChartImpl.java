package it.kaizenteam.app.model.NorrisChart;

import android.test.InstrumentationTestCase;

/**
 * Created by Moro on 27/05/15.
 */
public class TUChartImpl extends InstrumentationTestCase {

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