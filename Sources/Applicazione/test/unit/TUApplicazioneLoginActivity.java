/*
* Name: TUApplicazioneLoginActivity.java
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
import android.widget.TextView;

import junit.framework.TestCase;

import it.kaizenteam.app.R;
import it.kaizenteam.app.view.LoginActivity;


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