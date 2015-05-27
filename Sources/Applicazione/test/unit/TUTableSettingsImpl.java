/*
* Name: TUApplicazioneTableSettingsImpl.java
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

import org.json.JSONObject;
public class TUApplicazioneTableSettingsImpl extends TestCase {

    public void testGetBorderLineVisibility() throws Exception {
        TableSettingsImpl a = new TableSettingsImpl(new JSONObject("{border:true}"));
        assertEquals(true, a.getBorderLineVisibility());
    }
}