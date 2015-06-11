package test.unit;

import android.app.Activity;
import android.content.Intent;

import junit.framework.TestCase;

import it.kaizenteam.app.view.TableActivity;

/**
 * Created by Moro on 11/06/15.
 */
public class TUApplicazioneTableActivity extends TestCase {
    Activity a=null;
    public void setUp() throws Exception {
        super.setUp();
        a=new Activity();
        a.getBaseContext().startActivity(new Intent(a.getBaseContext(), TableActivity.class));
    }

    public void testRenderChart() throws Exception {
        ((TableActivity)a).renderChart(null);
    }

    public void testShowCellBorderLine() throws Exception {
        ((TableActivity)a).showCellBorderLine(true);
        ((TableActivity)a).showCellBorderLine(false);
    }
}