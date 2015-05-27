package it.kaizenteam.app.model.NorrisChart;

import android.test.InstrumentationTestCase;

/**
 * Created by Moro on 27/05/15.
 */
public class TUBarChartDataImpl extends InstrumentationTestCase {

    public void testGetData() throws Exception {
        BarChartDataImpl a=new BarChartDataImpl(null);
        assertEquals(null,a.getData());
    }
}