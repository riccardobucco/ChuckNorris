package test.integration;

import android.app.Application;
import android.content.Intent;

import junit.framework.TestCase;

import it.kaizenteam.app.view.BarChartActivity;
import it.kaizenteam.app.view.LineChartActivity;
import it.kaizenteam.app.view.ListActivity;
import it.kaizenteam.app.view.LoginActivity;
import it.kaizenteam.app.view.MapChartActivity;
import it.kaizenteam.app.view.TableActivity;

/**
 * Created by Moro on 11/06/15.
 */
public class TIApplicazione extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
        Application a = new Application();
        Intent i = new Intent(a.getBaseContext(), LoginActivity.class);
        a.getBaseContext().startActivity(i);

        Intent i2 = new Intent(a.getBaseContext(), ListActivity.class);
        a.getBaseContext().startActivity(i2);

        Intent i3 = new Intent(a.getBaseContext(), MapChartActivity.class);
        i.putExtra("id","mc");
        a.getBaseContext().startActivity(i3);

        Intent i4 = new Intent(a.getBaseContext(), BarChartActivity.class);
        i.putExtra("id","bc");
        a.getBaseContext().startActivity(i4);

        Intent i5 = new Intent(a.getBaseContext(), LineChartActivity.class);
        i.putExtra("id","lc");
        a.getBaseContext().startActivity(i5);

        Intent i6 = new Intent(a.getBaseContext(), TableActivity.class);
        i.putExtra("id","t");
        a.getBaseContext().startActivity(i6);
    }
}