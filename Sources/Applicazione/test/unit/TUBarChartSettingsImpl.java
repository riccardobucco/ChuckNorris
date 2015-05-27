/*
* Name: TUBarChartSettingsImpl.java
* Package: it.kaizenteam.app.model
* Location: Sources/Applicazione/test/unit
* Date: 2015-05-19
* Version: 0.02
*
* History:
* =================================================================
* Version   Date    Programmer  Changes
* =================================================================
* v0.02 2015-05-26  Moretto Alessandro   Verify
* =================================================================
* v0.01 2015-05-23  Davide Dal Bianco  Creazione file
* =================================================================
*
*/
package it.kaizenteam.app.model.NorrisChart;

import junit.framework.TestCase;

import org.json.JSONObject;

public class TUBarChartSettingsImpl extends TestCase {

    public void testGetXAxisName() throws Exception {
        BarChartSettingsImpl a = new BarChartSettingsImpl(new JSONObject("{settings: set}"));
        assertEquals("set", a.getXAxisName());
    }

    public void testGetYAxisName() throws Exception {
        BarChartSettingsImpl a = new BarChartSettingsImpl(new JSONObject("{x: xx}"));
        assertEquals("xx", a.getYAxisName());
    }

    public void testGetGridVisibility() throws Exception {
        BarChartSettingsImpl a = new BarChartSettingsImpl(new JSONObject("{visibility: vis}"));
        assertEquals("vis", a.getGridVisibility());
    }

    public void testGetLegendPosition() throws Exception {
        BarChartSettingsImpl a = new BarChartSettingsImpl(new JSONObject("{legendposition: left}"));
        assertEquals("left", a.getLegendPosition());
    }

    public void testGetOrientation() throws Exception {
        BarChartSettingsImpl a = new BarChartSettingsImpl(new JSONObject("{orientation: horizontal}"));
        assertEquals("horizontal", a.getOrientation());
    }
}