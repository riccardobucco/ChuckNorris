package it.kaizenteam.app.model.NorrisChart;

import junit.framework.TestCase;

/**
 * Created by Moro on 27/05/15.
 */
public class TULineChartElementStreamUpdate extends TestCase {

    public void testGetData() throws Exception {
        LineChartElementStreamUpdate a = new LineChartElementStreamUpdate("lab",23);
        assertEquals(23,a.getData());
    }

    public void testGetLabel() throws Exception {
        LineChartElementStreamUpdate a = new LineChartElementStreamUpdate("lab",23);
        assertEquals(23,a.getLabel());
    }
}