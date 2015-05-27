package it.kaizenteam.app.model.NorrisChart;

import junit.framework.TestCase;

/**
 * Created by Moro on 27/05/15.
 */
public class TULineChartDataImpl extends TestCase {

    public void testGetData() throws Exception {
        LineChartDataImpl a=new LineChartDataImpl(null);
        assertEquals(null,a.getData());
    }
}