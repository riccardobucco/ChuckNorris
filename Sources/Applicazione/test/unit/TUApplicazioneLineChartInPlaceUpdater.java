/*
* Name: TUApplicazioneLineChartInPlaceUpdater.java
* Package: test.unit
* Location: Sources/Applicazione/test/unit
* Date: 2015-05-23
* Version: v0.01
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.01 2015-05-23  Moretto Alessandro  Creation
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