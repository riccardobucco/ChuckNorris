package it.kaizenteam.app.model.NorrisChart;

import junit.framework.TestCase;

import org.json.JSONObject;

/**
 * Created by Moro on 27/05/15.
 */
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