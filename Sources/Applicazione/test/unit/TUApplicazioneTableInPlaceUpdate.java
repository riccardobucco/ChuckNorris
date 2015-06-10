/*
* Name: TUApplicazioneTableInPlaceUpdate.java
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
package test.unit;

import junit.framework.TestCase;

import java.util.ArrayList;

import it.kaizenteam.app.model.NorrisChart.TableCellInPlaceUpdate;
import it.kaizenteam.app.model.NorrisChart.TableInPlaceUpdate;

public class TUApplicazioneTableInPlaceUpdate extends TestCase {

    public void testGetData() throws Exception {
        ArrayList<TableCellInPlaceUpdate> arr = new ArrayList<>();
        TableInPlaceUpdate a = new TableInPlaceUpdate(arr);
        assertEquals(arr, a.getData());
    }
}