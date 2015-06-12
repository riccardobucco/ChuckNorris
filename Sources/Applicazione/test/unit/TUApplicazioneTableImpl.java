/*
* Name: TUApplicazioneBarChartElementInPlaceUpdate.java
* Package: test.unit
* Location: Sources/Applicazione/test/unit
* Date: 2015-05-23
* Version: v0.01
*
* History:
* =================================================================
* Version   Date    Programmer  Changes
* =================================================================
* v0.01 2015-05-23  Dal Bianco Davide  Creation
* =================================================================
*
*/
package test.unit;

import junit.framework.TestCase;

import it.kaizenteam.app.model.NorrisChart.ChartImpl;
import it.kaizenteam.app.model.NorrisChart.ChartModel;

public class TUApplicazioneTableImpl extends TestCase {
    public void setUp() throws Exception {
        super.setUp();
        ChartModel b= ChartImpl.create("table", "id fgerg");
        assertNotSame(null,b);
    }
}