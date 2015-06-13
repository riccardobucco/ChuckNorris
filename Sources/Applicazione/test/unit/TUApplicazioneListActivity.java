/*
* Name: TUApplicazioneListActivity.java
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
import android.view.View;

import junit.framework.TestCase;

import java.util.ArrayList;

import it.kaizenteam.app.R;
import it.kaizenteam.app.view.ListActivity;


public class TUApplicazioneListActivity extends TestCase {

    Activity a=null;
    public void setUp() throws Exception {
        super.setUp();
        a=new Activity();
        a.getBaseContext().startActivity(new Intent(a.getBaseContext(), ListActivity.class));
    }

    public void testNavigateToLoginView() throws Exception {
        ((ListActivity)a).navigateToLoginView();
    }

    public void testOnLogoutClick() throws Exception {
        ((ListActivity)a).onLogoutClick(null);
    }

    public void testRenderList() throws Exception {
        ((ListActivity)a).renderList(new ArrayList<String[]>());
    }

    public void testShowChartDetailView() throws Exception {
        ((ListActivity)a).showChartDetailView("barchart","id");
    }

    public void testShowWaitMessage() throws Exception {
        ((ListActivity)a).showWaitMessage(true);
        assertEquals(View.VISIBLE, (a.findViewById(R.id.waitimg)).getVisibility());
        ((ListActivity)a).showWaitMessage(false);
        assertEquals(View.INVISIBLE, (a.findViewById(R.id.waitimg)).getVisibility());
    }
}