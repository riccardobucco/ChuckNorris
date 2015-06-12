/*
* Name: TUApplicazioneLineChartSettingsImpl.java
* Package: test.unit
* Location: Sources/Applicazione/test/unit
* Date: 2015-05-23
* Version: v0.01
*
* History:
* =================================================================
* Version   Date    Programmer  Changes
* =================================================================
* v0.01 2015-05-23  Dal Bianco Davide  Creation
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