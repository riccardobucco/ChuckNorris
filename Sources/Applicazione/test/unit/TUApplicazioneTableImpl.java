package test.unit;

import junit.framework.TestCase;

import it.kaizenteam.app.model.NorrisChart.ChartImpl;
import it.kaizenteam.app.model.NorrisChart.ChartModel;

/**
 * Created by Moro on 11/06/15.
 */
public class TUApplicazioneTableImpl extends TestCase {
    public void setUp() throws Exception {
        super.setUp();
        ChartModel b= ChartImpl.create("table", "id fgerg");
        assertNotSame(null,b);
    }
}