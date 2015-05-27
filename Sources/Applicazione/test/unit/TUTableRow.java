package it.kaizenteam.app.model.NorrisChart;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Created by Moro on 27/05/15.
 */
public class TUTableRow extends TestCase {

    public void testGetData() throws Exception {
        ArrayList<TableCell> val = new ArrayList<>();
        TableRow tr= new TableRow(val);
        assertEquals(val,tr.getData());
    }
}