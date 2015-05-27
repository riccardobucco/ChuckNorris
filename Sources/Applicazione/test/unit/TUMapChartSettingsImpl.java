package it.kaizenteam.app.model.NorrisChart;

import junit.framework.TestCase;

import org.json.JSONObject;

/**
 * Created by Moro on 27/05/15.
 */
public class TUMapChartSettingsImpl extends TestCase {

    public void testGetMarkerType() throws Exception {
        MapChartSettingsImpl a = new MapChartSettingsImpl(new JSONObject("marker:bus"));
        assertEquals("bus",a.getMarkerType());
    }

    public void testGetXCameraCoordinate() throws Exception {
        MapChartSettingsImpl a = new MapChartSettingsImpl(new JSONObject("xcamera:xcamera"));
        assertEquals("xcamera",a.getXCameraCoordinate());
    }

    public void testGetYCameraCoordinate() throws Exception {
        MapChartSettingsImpl a = new MapChartSettingsImpl(new JSONObject("ycamera:ycamera"));
        assertEquals("ycamera",a.getYCameraCoordinate());
    }

    public void testGetCameraZoomHeight() throws Exception {
        MapChartSettingsImpl a = new MapChartSettingsImpl(new JSONObject("camerazoom:camerazoom"));
        assertEquals("camerazoom",a.getCameraZoomHeight());
    }
}