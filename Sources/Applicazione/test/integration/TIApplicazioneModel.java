package test.integration;

import junit.framework.TestCase;

import it.kaizenteam.app.model.NorrisSessionInfoImpl;

/**
 * Created by Moro on 11/06/15.
 */
public class TIApplicazioneModel extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
        NorrisSessionInfoImpl.getInstance().setAddress("address");
        NorrisSessionInfoImpl.getInstance().setEndpoint("endpoint");
        NorrisSessionInfoImpl.getInstance().setAuthCookie(null);

        assertEquals(null, NorrisSessionInfoImpl.getInstance().getAuthCookie());
        assertEquals("address", NorrisSessionInfoImpl.getInstance().getAddress());
        assertEquals("endpoint",NorrisSessionInfoImpl.getInstance().getEndpoint());
        NorrisSessionInfoImpl.getInstance().login();
        assertEquals(true, NorrisSessionInfoImpl.getInstance().isLogged());
        NorrisSessionInfoImpl.getInstance().logout();
        assertEquals(false, NorrisSessionInfoImpl.getInstance().isLogged());
    }
}