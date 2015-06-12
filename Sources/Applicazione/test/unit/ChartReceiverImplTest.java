/*
* Name: ChartReceiverImplTest.java
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