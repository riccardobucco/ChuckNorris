package test.unit;

import android.app.Activity;
import android.content.Intent;

import junit.framework.TestCase;

import it.kaizenteam.app.view.BaseActivity;

/**
 * Created by Moro on 11/06/15.
 */
public class TUApplicazioneBaseActivity extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
        Activity b=new Activity();
        b.getBaseContext().startActivity(new Intent(b.getBaseContext(), BaseActivity.class));
    }
}