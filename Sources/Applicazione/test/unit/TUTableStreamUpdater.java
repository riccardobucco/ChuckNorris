package it.kaizenteam.app.model.NorrisChart;

import junit.framework.TestCase;

/**
 * Created by Moro on 27/05/15.
 */
public class TUTableStreamUpdater extends TestCase {

    public void testGetInstance() throws Exception {
        Updater a = TableStreamUpdater.getInstance();
        Updater b = TableStreamUpdater.getInstance();
    }
}