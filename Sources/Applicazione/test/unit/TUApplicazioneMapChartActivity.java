package test.unit;

import android.app.Activity;
import android.content.Intent;

import junit.framework.TestCase;

import it.kaizenteam.app.model.NorrisChart.MapChartDataImpl;
import it.kaizenteam.app.view.MapChartActivity;

/**
 * Created by Moro on 11/06/15.
 */
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