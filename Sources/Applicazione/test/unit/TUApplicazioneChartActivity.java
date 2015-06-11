package test.unit;

import android.app.Activity;
import android.content.Intent;

import junit.framework.TestCase;

import it.kaizenteam.app.view.ChartActivity;

/**
 * Created by Moro on 11/06/15.
 */
public class TUApplicazioneChartActivity extends TestCase {
    Activity a=null;
    public void setUp() throws Exception {
        super.setUp();
        a=new Activity();
        a.getBaseContext().startActivity(new Intent(a.getBaseContext(), ChartActivity.class));
    }

    public void testSetTitle() throws Exception {
        ((ChartActivity)a).setTitle("titolo");
    }

    public void testSetDescription() throws Exception {
        ((ChartActivity)a).setDescription("descr");
    }
}