/*
* Name: TUApplicazioneLineChartSettingsImpl.java
* Package: it.kaizenteam.app.model
* Location: Sources/Applicazione/test/unit
* Date: 2015-05-19
* Version: v0.02
*
* History:
* =================================================================
* Version   Date    Programmer  Changes
* =================================================================
* v0.02 2015-05-26  Moretto Alessandro   Verify
* =================================================================
* v0.01 2015-05-23  Davide Dal Bianco  Creation
* =================================================================
*
*/
package test.unit;

import junit.framework.TestCase;

import org.json.JSONObject;

import it.kaizenteam.app.model.NorrisChart.LineChartSettingsImpl;

public class TUApplicazioneLineChartSettingsImpl extends TestCase {

    public void testGetXAxisName() throws Exception {
        LineChartSettingsImpl a = new LineChartSettingsImpl(new JSONObject("{xLabel: 'xxx'}"));
        assertEquals("xxx", a.getXAxisName());
    }

    public void testGetYAxisName() throws Exception {
        LineChartSettingsImpl a = new LineChartSettingsImpl(new JSONObject("{yLabel: 'yyy'}"));
        assertEquals("yyy", a.getYAxisName());
    }

    public void testGetGridVisibility() throws Exception {
        LineChartSettingsImpl a = new LineChartSettingsImpl(new JSONObject("{style: {showGrid:true}}"));
        assertEquals(true, a.getGridVisibility());
    }

    public void testGetLegendPosition() throws Exception {
        LineChartSettingsImpl a = new LineChartSettingsImpl(new JSONObject("{legendPosition: left}"));
        assertEquals("left", a.getLegendPosition());
    }
}