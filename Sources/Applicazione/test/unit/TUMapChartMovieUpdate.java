package it.kaizenteam.app.model.NorrisChart;

import junit.framework.TestCase;

/*
* Name: NorrisSessionInfoImpl.java
* Package: it.kaizenteam.app.model
* Location: Sources/Applicazione/test/unit
* Date: 2015-05-19
* Version: 0.02
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.02 2015-05-26  Moretto Alessandro   Verify
* =================================================================
* v0.01 2015-05-23  Davide Dal Bianco  Creazione file
* =================================================================
*
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