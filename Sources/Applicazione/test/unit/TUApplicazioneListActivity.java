package test.unit;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import junit.framework.TestCase;

import java.util.ArrayList;

import it.kaizenteam.app.R;
import it.kaizenteam.app.view.ListActivity;

/**
 * Created by Moro on 11/06/15.
 */
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