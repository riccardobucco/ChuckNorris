/*
* Name: TUApplicazioneMapChartActivity.java
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
* v0.02 2015-06-02 Moretto Alessandro Verify
* =================================================================
* v0.01 2015-05-23  Moretto Alessandro Creation
* =================================================================
*
*/
package test.unit;

import android.app.Activity;
import android.content.Intent;

import junit.framework.TestCase;

import it.kaizenteam.app.model.NorrisChart.MapChartDataImpl;
import it.kaizenteam.app.view.MapChartActivity;


public class TUApplicazioneMapChartActivity extends TestCase {
    Activity a=null;
    public void setUp() throws Exception {
        super.setUp();
        a=new Activity();
        a.getBaseContext().startActivity(new Intent(a.getBaseContext(), MapChartActivity.class));
    }

    public void testRenderChart() throws Exception {
        ((MapChartActivity)a).renderChart(new MapChartDataImpl(null));
    }

    public void testSetCameraCoordinate() throws Exception {
        ((MapChartActivity)a).setCameraCoordinate(12,12);
    }

    public void testSetCameraZoom() throws Exception {
        ((MapChartActivity)a).setCameraZoom(12);
    }
}