/*
* Name: TUApplicazioneTableCellInPlaceUpdate.java
* Package: it.kaizenteam.app.model
* Location: Sources/Applicazione/test/unit
* Date: 2015-05-19
* Version: v0.02
*
* History:
* =================================================================
* Version   Date    Programmer  Changes
* =================================================================
* v0.02 2015-05-22  Davide Dal Bianco   Verify
* =================================================================
* v0.01 2015-05-19  Moretto Alessandro  Creation
* =================================================================
*
*/
package test.unit;

import junit.framework.TestCase;

import it.kaizenteam.app.model.NorrisChart.TableCell;
import it.kaizenteam.app.model.NorrisChart.TableCellInPlaceUpdate;

public class TUApplicazioneTableCellInPlaceUpdate extends TestCase {

    public void testGetX() throws Exception {
        TableCell tc=new TableCell("val","#000000","#000000");
        TableCellInPlaceUpdate a = new TableCellInPlaceUpdate(23,23,tc);
        assertEquals(23,a.getX());
    }

    public void testGetY() throws Exception {
        TableCell tc=new TableCell("val","#000000","#000000");
        TableCellInPlaceUpdate a = new TableCellInPlaceUpdate(23,23,tc);
        assertEquals(23,a.getY());
    }

    public void testGetData() throws Exception {
        TableCell tc=new TableCell("val","#000000","#000000");
        TableCellInPlaceUpdate a = new TableCellInPlaceUpdate(23,23,tc);
        assertEquals(tc,a.getData());
    }
}