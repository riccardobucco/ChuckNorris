package it.kaizenteam.app.model.NorrisChart;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Created by Moro on 27/05/15.
 */
public class TUTableInPlaceUpdate extends TestCase {

    public void testGetData() throws Exception {
        ArrayList<TableCellInPlaceUpdate> arr = new ArrayList<>();
        TableInPlaceUpdate a = new TableInPlaceUpdate(arr);
        assertEquals(arr, a.getData());
    }
}