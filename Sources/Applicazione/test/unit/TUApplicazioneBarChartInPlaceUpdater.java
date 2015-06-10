/*
* Name: TUApplicazioneBarChartInPlaceUpdater.java
* Package: it.kaizenteam.app.model
* Location: Sources/Applicazione/test/unit
* Date: 2015-05-19
* Version: v0.02
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.02 2015-05-26  Moretto Alessandro   Verify
* =================================================================
* v0.01 2015-05-23  Davide Dal Bianco  Creation
* =================================================================
*
*/
package test.unit;

import junit.framework.TestCase;

import it.kaizenteam.app.model.NorrisChart.BarChartInPlaceUpdater;
import it.kaizenteam.app.model.NorrisChart.ChartUpdater;

public class TUApplicazioneBarChartInPlaceUpdater extends TestCase {

    public void testGetInstance() throws Exception {
        ChartUpdater a = BarChartInPlaceUpdater.getInstance();
        ChartUpdater b = BarChartInPlaceUpdater.getInstance();
        assertEquals(a,b);
    }
}