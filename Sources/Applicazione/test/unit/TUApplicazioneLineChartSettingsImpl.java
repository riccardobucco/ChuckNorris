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
package it.kaizenteam.app.model.NorrisChart;

import junit.framework.TestCase;

import org.json.JSONObject;

public class TUApplicazioneLineChartSettingsImpl extends TestCase {

    public void testGetXAxisName() throws Exception {
        LineChartSettingsImpl a = new LineChartSettingsImpl(new JSONObject("{x: xx}"));
        assertEquals("xx", a.getXAxisName());
    }

    public void testGetYAxisName() throws Exception {
        LineChartSettingsImpl a = new LineChartSettingsImpl(new JSONObject("{y: yy}"));
        assertEquals("yy", a.getYAxisName());
    }

    public void testGetGridVisibility() throws Exception {
        LineChartSettingsImpl a = new LineChartSettingsImpl(new JSONObject("{visibility: vis}"));
        assertEquals("vis", a.getGridVisibility());
    }

    public void testGetLegendPosition() throws Exception {
        LineChartSettingsImpl a = new LineChartSettingsImpl(new JSONObject("{legendposition: left}"));
        assertEquals("left", a.getLegendPosition());
    }
}