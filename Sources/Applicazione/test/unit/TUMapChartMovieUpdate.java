package it.kaizenteam.app.model.NorrisChart;

import junit.framework.TestCase;

/**
 * Created by Moro on 27/05/15.
 */
public class TUMapChartMovieUpdate extends TestCase {

    public void testGetInPlaceData() throws Exception {
        MapChartInPlaceUpdate u=new MapChartInPlaceUpdate(null);
        MapChartStreamUpdate v=new MapChartStreamUpdate(null);
        MapChartDeleteUpdate z=new MapChartDeleteUpdate(null);
        MapChartMovieUpdate a = new MapChartMovieUpdate(u,v,z);
        assertEquals(u,a.getInPlaceData());
    }

    public void testGetStreamData() throws Exception {
        MapChartInPlaceUpdate u=new MapChartInPlaceUpdate(null);
        MapChartStreamUpdate v=new MapChartStreamUpdate(null);
        MapChartDeleteUpdate z=new MapChartDeleteUpdate(null);
        MapChartMovieUpdate a = new MapChartMovieUpdate(u,v,z);
        assertEquals(v,a.getStreamData());
    }

    public void testGetDeleteData() throws Exception {
        MapChartInPlaceUpdate u=new MapChartInPlaceUpdate(null);
        MapChartStreamUpdate v=new MapChartStreamUpdate(null);
        MapChartDeleteUpdate z=new MapChartDeleteUpdate(null);
        MapChartMovieUpdate a = new MapChartMovieUpdate(u,v,z);
        assertEquals(z,a.getDeleteData());
    }
}