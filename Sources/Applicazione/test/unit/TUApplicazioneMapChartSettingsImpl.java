/*
* Name: TUApplicazioneMapChartSettingsImpl.java
* Package: it.kaizenteam.app.model
* Location: Sources/Applicazione/test/unit
* Date: 2015-05-19
* Version: v0.02
*
* History:
* =================================================================
* Version   Date    Programmer  Changes
* =================================================================
* v0.02 2015-05-22  Davide Dal Bianco   Verify
* =================================================================
* v0.01 2015-05-19  Moretto Alessandro  Creation
* =================================================================
*
*/
package test.unit;

import junit.framework.TestCase;

import org.json.JSONObject;

import it.kaizenteam.app.model.NorrisChart.MapChartSettingsImpl;

public class TUApplicazioneMapChartSettingsImpl extends TestCase {


    public void testGetXCameraCoordinate() throws Exception {
        MapChartSettingsImpl a = new MapChartSettingsImpl(new JSONObject("{centerCoordinates:{x:23.5}}"));
        assertEquals(23.5,a.getXCameraCoordinate());
    }

    public void testGetYCameraCoordinate() throws Exception {
        MapChartSettingsImpl a = new MapChartSettingsImpl(new JSONObject("{centerCoordinates:{y:23.5}}"));
        assertEquals(23.5,a.getYCameraCoordinate());
    }

    public void testGetCameraZoomHeight() throws Exception {
        MapChartSettingsImpl a = new MapChartSettingsImpl(new JSONObject("{area:3}"));
        assertEquals(3,a.getCameraZoomHeight());
    }
}