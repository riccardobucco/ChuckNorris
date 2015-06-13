/*
* Name: TUApplicazioneBaseActivity.java
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
* v0.02 2015-06-01 Pavanello Fabio Matteo Verify
* =================================================================
* v0.01 2015-05-23  Dal Bianco Davide  Creation
* =================================================================
*
*/
package test.unit;

import android.app.Activity;
import android.content.Intent;

import junit.framework.TestCase;

import it.kaizenteam.app.view.BaseActivity;


public class TUApplicazioneBaseActivity extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
        Activity b=new Activity();
        b.getBaseContext().startActivity(new Intent(b.getBaseContext(), BaseActivity.class));
    }
}