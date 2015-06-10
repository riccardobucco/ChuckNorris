/*
* Name: TUApplicazioneTableInPlaceUpdater.java
* Package: it.kaizenteam.app.model
* Location: Sources/Applicazione/test/unit
* Date: 2015-05-19
* Version: v0.02
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.02 2015-05-22  Davide Dal Bianco   Verify
* =================================================================
* v0.01 2015-05-19  Moretto Alessandro  Creation
* =================================================================
*
*/
package test.unit;

import junit.framework.TestCase;

import it.kaizenteam.app.model.NorrisChart.ChartUpdater;
import it.kaizenteam.app.model.NorrisChart.TableInPlaceUpdater;

public class TUApplicazioneTableInPlaceUpdater extends TestCase {

    public void testGetInstance() throws Exception {
        ChartUpdater a = TableInPlaceUpdater.getInstance();
        ChartUpdater b = TableInPlaceUpdater.getInstance();
        assertEquals(a,b);
    }
}