/*
* Name: TUApplicazioneBarChartDataImpl.java
* Package: test.unit
* Location: Sources/Applicazione/test/unit
* Date: 2015-05-23
* Version: v1.00
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v1.00 2015-06-15 Carlon Chiara Approved
* =================================================================
* v0.02 2015-06-02 Bucco Riccardo Verify
* =================================================================
* v0.01 2015-05-23  Dal Bianco Davide  Creation
* =================================================================
*
*/
package test.unit;

import android.test.InstrumentationTestCase;

import it.kaizenteam.app.model.NorrisChart.BarChartDataImpl;

public class TUApplicazioneBarChartDataImpl extends InstrumentationTestCase {

    public void testGetData() throws Exception {
        BarChartDataImpl a=new BarChartDataImpl(null);
        assertEquals(null,a.getData());
    }
}