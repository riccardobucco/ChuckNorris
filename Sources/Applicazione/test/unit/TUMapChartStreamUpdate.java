package it.kaizenteam.app.model.NorrisChart;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Created by Moro on 27/05/15.
 */
public class TUMapChartStreamUpdate extends TestCase {

    public void testGetData() throws Exception {
        ArrayList<MapSet> data=new ArrayList<MapSet>();
        MapChartStreamUpdate a = new MapChartStreamUpdate(data);
        assertEquals(data, a.getData());
    }
}