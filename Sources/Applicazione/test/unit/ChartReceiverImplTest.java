package test.unit;

import junit.framework.TestCase;

import it.kaizenteam.app.model.Service.ChartReceiver;
import it.kaizenteam.app.model.Service.ChartReceiverImpl;

/**
 * Created by Moro on 11/06/15.
 */
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