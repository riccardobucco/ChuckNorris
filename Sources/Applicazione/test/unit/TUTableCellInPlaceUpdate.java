package it.kaizenteam.app.model.NorrisChart;

import junit.framework.TestCase;

/**
 * Created by Moro on 27/05/15.
 */
public class TUTableCellInPlaceUpdate extends TestCase {

    public void testGetX() throws Exception {
        TableCellInPlaceUpdate a = new TableCellInPlaceUpdate(23,23,"val");
        assertEquals(23,a.getX());
    }

    public void testGetY() throws Exception {
        TableCellInPlaceUpdate a = new TableCellInPlaceUpdate(23,23,"val");
        assertEquals(23,a.getY());
    }

    public void testGetData() throws Exception {
        TableCellInPlaceUpdate a = new TableCellInPlaceUpdate(23,23,"val");
        assertEquals("val",a.getData());
    }
}