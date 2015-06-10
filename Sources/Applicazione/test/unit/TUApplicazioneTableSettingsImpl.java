/*
* Name: TUApplicazioneTableSettingsImpl.java
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

import org.json.JSONObject;

import it.kaizenteam.app.model.NorrisChart.TableSettingsImpl;

public class TUApplicazioneTableSettingsImpl extends TestCase {

    public void testGetBorderLineVisibility() throws Exception {
        TableSettingsImpl a = new TableSettingsImpl(new JSONObject("{border:true}"));
        assertEquals(true, a.getBorderLineVisibility());
    }
}