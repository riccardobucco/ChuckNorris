/*
* Name: TUApplicazioneTableStreamUpdate.java
* Package: test.unit
* Location: Sources/Applicazione/test/unit
* Date: 2015-05-24
* Version: v0.01
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.01 2015-05-24  Moretto Alessandro  Creation
* =================================================================
*
*/
package test.unit;

import junit.framework.TestCase;

import java.util.ArrayList;

import it.kaizenteam.app.model.NorrisChart.TableRow;
import it.kaizenteam.app.model.NorrisChart.TableStreamUpdate;

public class TUApplicazioneTableStreamUpdate extends TestCase {

    public void testGetData() throws Exception {
        ArrayList<TableRow> arr = new ArrayList<>();
        TableStreamUpdate a = new TableStreamUpdate(arr);
        assertEquals(arr, a.getData());
    }
}