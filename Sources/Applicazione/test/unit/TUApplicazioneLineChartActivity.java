/*
* Name: TUApplicazioneLineChartActivity.java
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
* v0.01 2015-05-23  Moretto Alessandro  Creation
* =================================================================
*
*/
package test.unit;

import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;

import junit.framework.TestCase;

import it.kaizenteam.app.R;
import it.kaizenteam.app.view.LineChartActivity;


public class TUApplicazioneLineChartActivity extends TestCase {
    Activity a=null;
    public void setUp() throws Exception {
        super.setUp();
        a=new Activity();
        a.getBaseContext().startActivity(new Intent(a.getBaseContext(), LineChartActivity.class));
    }

    public void testRenderChart() throws Exception {
        ((LineChartActivity)a).renderChart(null);
    }

    public void testSetAxisName() throws Exception {
        ((LineChartActivity)a).setAxisName("x","y");
        assertEquals("x", ((TextView) a.findViewById(R.id.xlabelbar)).getText());
        assertEquals("y", ((TextView) a.findViewById(R.id.ylabelbar)).getText());
    }

    public void testShowGrid() throws Exception {
        ((LineChartActivity)a).showGrid(true);
        ((LineChartActivity)a).showGrid(false);
    }

    public void testSetLegendPosition() throws Exception {
        ((LineChartActivity)a).setLegendPosition(0);
        ((LineChartActivity)a).setLegendPosition(1);
        ((LineChartActivity)a).setLegendPosition(2);
        ((LineChartActivity)a).setLegendPosition(3);
        ((LineChartActivity)a).setLegendPosition(4);
        ((LineChartActivity)a).setLegendPosition(5);
    }

    public void testSetCubicLines() throws Exception {
        ((LineChartActivity)a).setCubicLines(true);
        ((LineChartActivity)a).setCubicLines(false);
    }

    public void testSetDotRadius() throws Exception {
        ((LineChartActivity)a).setDotRadius(2);
    }
}