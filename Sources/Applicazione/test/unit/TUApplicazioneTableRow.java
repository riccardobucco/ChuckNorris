/*
* Name: TUApplicazioneTableRow.java
* Package: it.kaizenteam.app.model
* Location: Sources/Applicazione/test/unit
* Date: 2015-05-19
* Version: v0.02
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.02 2015-05-22  Davide Dal Bianco   Verify
* =================================================================
* v0.01 2015-05-19  Moretto Alessandro  Creation
* =================================================================
*
*/
package it.kaizenteam.app.model.NorrisChart;

import junit.framework.TestCase;

import java.util.ArrayList;

public class TUApplicazioneTableRow extends TestCase {

    public void testGetData() throws Exception {
        ArrayList<TableCell> val = new ArrayList<>();
        TableRow tr= new TableRow(val);
        assertEquals(val,tr.getData());
    }
}