package test.unit;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import junit.framework.TestCase;

import it.kaizenteam.app.R;
import it.kaizenteam.app.view.BarChartActivity;

/**
 * Created by Moro on 11/06/15.
 */
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