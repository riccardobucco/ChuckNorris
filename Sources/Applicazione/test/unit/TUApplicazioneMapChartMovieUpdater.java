/*
* Name: TUApplicazioneMapChartMovieUpdater.java
* Package: test.unit
* Location: Sources/Applicazione/test/unit
* Date: 2015-05-22
* Version: v1.00
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v1.00 2015-06-15 Carlon Chiara Approved
* =================================================================
* v0.02 2015-06-02 Moretto Alessandro Verify
* =================================================================
* v0.01 2015-05-23  Dal Bianco Davide  Creation
* =================================================================
*
*/
package test.unit;

import junit.framework.TestCase;

import it.kaizenteam.app.model.NorrisChart.ChartUpdater;
import it.kaizenteam.app.model.NorrisChart.MapChartMovieUpdater;

public class TUApplicazioneMapChartMovieUpdater extends TestCase {

    public void testGetInstance() throws Exception {
        ChartUpdater a = MapChartMovieUpdater.getInstance();
        ChartUpdater b = MapChartMovieUpdater.getInstance();
        assertEquals(a,b);
    }
}