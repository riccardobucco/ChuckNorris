/*
* Name: TUApplicazioneLineChartInPlaceUpdater.java
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

import it.kaizenteam.app.model.NorrisChart.ChartUpdater;
import it.kaizenteam.app.model.NorrisChart.LineChartInPlaceUpdater;

public class TUApplicazioneLineChartInPlaceUpdater extends TestCase {

    public void testGetInstance() throws Exception {
        ChartUpdater a = LineChartInPlaceUpdater.getInstance();
        ChartUpdater b = LineChartInPlaceUpdater.getInstance();
        assertEquals(a,b);
    }
}