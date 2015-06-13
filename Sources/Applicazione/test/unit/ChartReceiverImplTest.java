/*
* Name: ChartReceiverImplTest.java
* Package: test.unit
* Location: Sources/Applicazione/test/unit
* Date: 2015-05-23
* Version: v1.00
*
* History:
* =================================================================
* Version Date Programmer Changes
* =================================================================
* v1.00 2015-06-15 Carlon Chiara Approved
* =================================================================
* v0.02 2015-06-01 Moretto Alessandro Verify
* =================================================================
* v0.01 2015-05-23  Dal Bianco Davide  Creation
* =================================================================
*
*/
package test.unit;

import junit.framework.TestCase;

import it.kaizenteam.app.model.Service.ChartReceiver;
import it.kaizenteam.app.model.Service.ChartReceiverImpl;


public class ChartReceiverImplTest extends TestCase {

    public void testGetInstance() throws Exception {
        ChartReceiver c=ChartReceiverImpl.getInstance();
        assertNotNull(c);
    }

    public void testStopUpdateEvent() throws Exception {
        ChartReceiver c=ChartReceiverImpl.getInstance();
        c.stopUpdateEvent();
    }

    public void testGetChart() throws Exception {
        ChartReceiver c=ChartReceiverImpl.getInstance();
        c.getChart("id");
    }
}