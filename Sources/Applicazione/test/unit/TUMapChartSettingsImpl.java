/*
* Name: TUApplicazioneMapChartSettingsImpl.java
* Package: it.kaizenteam.app.model
* Location: Sources/Applicazione/test/unit
* Date: 2015-05-19
* Version: 0.02
*
* History:
* =================================================================
* Version   Date    Programmer  Changes
* =================================================================
* v0.02 2015-05-22  Davide Dal Bianco   Verify
* =================================================================
* v0.01 2015-05-19  Moretto Alessandro  Creazione file
* =================================================================
*
*/
package it.kaizenteam.app.model.NorrisChart;

import junit.framework.TestCase;

import org.json.JSONObject;

public class TUApplicazioneMapChartSettingsImpl extends TestCase {

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