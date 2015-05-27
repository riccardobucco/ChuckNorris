package it.kaizenteam.app.model.NorrisChart;

import junit.framework.TestCase;

import org.json.JSONObject;

/**
 * Created by Moro on 27/05/15.
 */
public class TULineChartSettingsImpl extends TestCase {

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