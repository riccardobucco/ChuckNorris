/*
* Name: TUApplicazioneTableRow.java
* Package: test.unit
* Location: Sources/Applicazione/test/unit
* Date: 2015-05-24
* Version: v1.00
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v1.00 2015-06-15 Carlon Chiara Approved
* =================================================================
* v0.02 2015-06-02 Bigarella Chiara Verify
* =================================================================
* v0.01 2015-05-24  Moretto Alessandro  Creation
* =================================================================
*
*/
package test.unit;

import junit.framework.TestCase;

import java.util.ArrayList;

import it.kaizenteam.app.model.NorrisChart.TableCell;
import it.kaizenteam.app.model.NorrisChart.TableRow;

public class TUApplicazioneTableRow extends TestCase {

    public void testGetData() throws Exception {
        ArrayList<TableCell> val = new ArrayList<>();
        TableRow tr= new TableRow(val);
        assertEquals(val,tr.getData());
    }
}