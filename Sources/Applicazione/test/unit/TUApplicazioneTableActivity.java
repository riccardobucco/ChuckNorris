/*
* Name: TUApplicazioneTableActivity.java
* Package: test.unit
* Location: Sources/Applicazione/test/unit
* Date: 2015-05-24
* Version: v1.00
*
* History:
* =================================================================
* Version Date Programmer Changes
* =================================================================
* v1.00 2015-06-15 Carlon Chiara Approved
* =================================================================
* v0.02 2015-06-02 Pavanello Fabio Matteo Verify
* =================================================================
* v0.01 2015-05-24  Moretto Alessandro  Creation
* =================================================================
*
*/
package test.unit;

import android.app.Activity;
import android.content.Intent;

import junit.framework.TestCase;

import it.kaizenteam.app.view.TableActivity;


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