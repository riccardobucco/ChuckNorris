/*
* Name: TUApplicazioneChartActivity.java
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
* v0.01 2015-05-23  Dal Bianco Davide  Creation
* =================================================================
*
*/
package test.unit;

import android.app.Activity;
import android.content.Intent;

import junit.framework.TestCase;

import it.kaizenteam.app.view.ChartActivity;


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