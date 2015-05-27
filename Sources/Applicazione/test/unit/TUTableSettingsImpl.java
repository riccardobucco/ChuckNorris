package it.kaizenteam.app.model.NorrisChart;

import junit.framework.TestCase;

import org.json.JSONObject;

/**
 * Created by Moro on 27/05/15.
 */
public class TUTableSettingsImpl extends TestCase {

    public void testGetBorderLineVisibility() throws Exception {
        TableSettingsImpl a = new TableSettingsImpl(new JSONObject("{border:true}"));
        assertEquals(true, a.getBorderLineVisibility());
    }
}