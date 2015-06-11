package test.unit;

import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;

import junit.framework.TestCase;

import it.kaizenteam.app.R;
import it.kaizenteam.app.view.LoginActivity;

/**
 * Created by Moro on 11/06/15.
 */
public class TUApplicazioneLoginActivity extends TestCase {
    Activity a=null;
    public void setUp() throws Exception {
        super.setUp();
        a=new Activity();
        a.getBaseContext().startActivity(new Intent(a.getBaseContext(), LoginActivity.class));
    }

    public void testShowAuthenticationError() throws Exception {
        ((LoginActivity)a).showAuthenticationError("ciao");
        assertEquals("ciao",((TextView)a.findViewById(R.id.errorloginlbl)).getText());
    }

    public void testShowListView() throws Exception {
        ((LoginActivity)a).showListView();
    }

    public void testShowProgress() throws Exception {
        ((LoginActivity)a).showProgress(true);
        assertEquals(true,a.findViewById(R.id.progressimage).getVisibility());
        ((LoginActivity)a).showProgress(false);
        assertEquals(false,a.findViewById(R.id.progressimage).getVisibility());
    }

    public void testOnLoginClick() throws Exception {
        ((LoginActivity)a).onLoginClick(null);
    }
}