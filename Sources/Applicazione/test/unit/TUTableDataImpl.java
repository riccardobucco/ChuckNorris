package it.kaizenteam.app.model.NorrisChart;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Created by Moro on 27/05/15.
 */
public class TUTableDataImpl extends TestCase {

    public void testGetData() throws Exception {
        ArrayList<String> label = new ArrayList<>();
        label.add("label");
        ArrayList<TableRow> data= new ArrayList<>();
        TableDataImpl a = new TableDataImpl(data,label);
        assertEquals(data,a.getData());
    }

    public void testGetLabels() throws Exception {
        ArrayList<String> label = new ArrayList<>();
        label.add("label");
        ArrayList<TableRow> data= new ArrayList<>();
        TableDataImpl a = new TableDataImpl(data,label);
        assertEquals(label.get(0),a.getLabels().get(0));
    }
}