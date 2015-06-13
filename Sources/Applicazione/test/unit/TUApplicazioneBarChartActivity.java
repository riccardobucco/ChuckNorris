/*
* Name: TUApplicazioneBarChartActivity.java
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
* v0.02 2015-06-03 Moretto Alessandro Verify
* =================================================================
* v0.01 2015-05-23  Dal Bianco Davide  Creation
* =================================================================
*
*/
package test.unit;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import junit.framework.TestCase;

import it.kaizenteam.app.R;
import it.kaizenteam.app.view.BarChartActivity;


public class TUApplicazioneBarChartActivity extends TestCase {
    Activity a=null;
    public void setUp() throws Exception {
        super.setUp();
        a=new Activity();
        a.getBaseContext().startActivity(new Intent(a.getBaseContext(), BarChartActivity.class));
    }

    public void testRenderChart() throws Exception {
        ((BarChartActivity)a).renderChart(null);
    }

    public void testSetAxisName() throws Exception {
        ((BarChartActivity)a).setAxisName("x","y");
        assertEquals("x", ((TextView) a.findViewById(R.id.xlabelbar)).getText());
        assertEquals("y",((TextView)a.findViewById(R.id.ylabelbar)).getText());
    }

    public void testShowGrid() throws Exception {
        ((BarChartActivity)a).showGrid(true);
        ((BarChartActivity)a).showGrid(false);
    }

    public void testSetLegendPosition() throws Exception {
        ((BarChartActivity)a).setLegendPosition(0);
        ((BarChartActivity)a).setLegendPosition(1);
        ((BarChartActivity)a).setLegendPosition(2);
        ((BarChartActivity)a).setLegendPosition(3);
        ((BarChartActivity)a).setLegendPosition(4);
        ((BarChartActivity)a).setLegendPosition(5);
    }

    public void testSetOrientation() throws Exception {
        ((BarChartActivity)a).setOrientation("horizontal");
        assertEquals(View.INVISIBLE, (a.findViewById(R.id.chartv)).getVisibility());
        assertEquals(View.VISIBLE, (a.findViewById(R.id.charth)).getVisibility());
        ((BarChartActivity)a).setOrientation("veritical");
        assertEquals(View.VISIBLE, (a.findViewById(R.id.chartv)).getVisibility());
        assertEquals(View.INVISIBLE, (a.findViewById(R.id.charth)).getVisibility());
    }
}