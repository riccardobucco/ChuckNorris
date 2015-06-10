/*
* Name: TUApplicazioneMapChartMovieUpdate.java
* Package: it.kaizenteam.app.model
* Location: Sources/Applicazione/test/unit
* Date: 2015-05-19
* Version: v0.02
*
* History:
* =================================================================
* Version   Date    Programmer  Changes
* =================================================================
* v0.02 2015-05-26  Moretto Alessandro   Verify
* =================================================================
* v0.01 2015-05-23  Davide Dal Bianco  Creation
* =================================================================
*
*/
package test.unit;

import junit.framework.TestCase;

import it.kaizenteam.app.model.NorrisChart.MapChartDeleteUpdate;
import it.kaizenteam.app.model.NorrisChart.MapChartInPlaceUpdate;
import it.kaizenteam.app.model.NorrisChart.MapChartMovieUpdate;
import it.kaizenteam.app.model.NorrisChart.MapChartStreamUpdate;

public class TUApplicazioneMapChartMovieUpdate extends TestCase {

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