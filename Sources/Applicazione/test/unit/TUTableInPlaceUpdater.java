package it.kaizenteam.app.model.NorrisChart;

import junit.framework.TestCase;

/**
 * Created by Moro on 27/05/15.
 */
public class TUTableInPlaceUpdater extends TestCase {

    public void testGetInstance() throws Exception {
        Updater a = TableInPlaceUpdater.getInstance();
        Updater b = TableInPlaceUpdater.getInstance();
        assertEquals(a,b);
    }
}