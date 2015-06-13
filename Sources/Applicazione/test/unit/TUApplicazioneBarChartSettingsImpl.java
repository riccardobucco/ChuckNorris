/*
* Name: TUApplicazioneBarChartSettingsImpl.java
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
* v0.02 2015-06-02 Bucco Riccardo Verify
* =================================================================
* v0.01 2015-05-23  Dal Bianco Davide  Creation
* =================================================================
*
*/
package test.unit;

import junit.framework.TestCase;

import org.json.JSONObject;

import it.kaizenteam.app.model.NorrisChart.BarChartSettingsImpl;

public class TUApplicazioneBarChartSettingsImpl extends TestCase {

    public void testGetXAxisName() throws Exception {
        BarChartSettingsImpl a = new BarChartSettingsImpl(new JSONObject("{xLabel: 'xxx'}"));
        assertEquals("xxx", a.getXAxisName());
    }

    public void testGetYAxisName() throws Exception {
        BarChartSettingsImpl a = new BarChartSettingsImpl(new JSONObject("{yLabel: 'yyy'}"));
        assertEquals("yyy", a.getYAxisName());
    }

    public void testGetGridVisibility() throws Exception {
        BarChartSettingsImpl a = new BarChartSettingsImpl(new JSONObject("{style: {showGrid:true}}"));
        assertEquals(true, a.getGridVisibility());
    }

    public void testGetLegendPosition() throws Exception {
        BarChartSettingsImpl a = new BarChartSettingsImpl(new JSONObject("{legendPosition: left}"));
        assertEquals("left", a.getLegendPosition());
    }

    public void testGetOrientation() throws Exception {
        BarChartSettingsImpl a = new BarChartSettingsImpl(new JSONObject("{orientation: horizontal}"));
        assertEquals("horizontal", a.getOrientation());
    }
}