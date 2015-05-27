/*
* Name: TUTableInPlaceUpdate.java
* Package: it.kaizenteam.app.model
* Location: Sources/Applicazione/test/unit
* Date: 2015-05-19
* Version: 0.02
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.02 2015-05-22  Davide Dal Bianco   Verify
* =================================================================
* v0.01 2015-05-19  Moretto Alessandro  Creazione file
* =================================================================
*
*/
package it.kaizenteam.app.model.NorrisChart;

import junit.framework.TestCase;

import java.util.ArrayList;

public class TUTableInPlaceUpdate extends TestCase {

    public void testGetData() throws Exception {
        ArrayList<TableCellInPlaceUpdate> arr = new ArrayList<>();
        TableInPlaceUpdate a = new TableInPlaceUpdate(arr);
        assertEquals(arr, a.getData());
    }
}