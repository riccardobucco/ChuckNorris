/*
* Name: TUApplicazioneTableSettingsImpl.java
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
* v0.02 2015-06-02 Bucco Riccardo Verify
* =================================================================
* v0.01 2015-05-24  Moretto Alessandro  Creation
* =================================================================
*
*/
package test.unit;

import junit.framework.TestCase;

import org.json.JSONObject;

import it.kaizenteam.app.model.NorrisChart.TableSettingsImpl;

public class TUApplicazioneTableSettingsImpl extends TestCase {

    public void testGetBorderLineVisibility() throws Exception {
        TableSettingsImpl a = new TableSettingsImpl(new JSONObject("{border:true}"));
        assertEquals(true, a.getBorderLineVisibility());
    }
}