package it.kaizenteam.app.model;

import junit.framework.TestCase;

/**
 * Created by Moro on 27/05/15.
 */
public class TUNorrisSessionInfoImpl extends TestCase {

    public void testGetInstance() throws Exception {
        NorrisSessionInfo a = NorrisSessionInfoImpl.getInstance();
        NorrisSessionInfo b = NorrisSessionInfoImpl.getInstance();
        assertEquals(a,b);
    }

    public void testGetSetAddress() throws Exception {
        NorrisSessionInfo a = NorrisSessionInfoImpl.getInstance();
        a.setAddress("add1");
        assertEquals("add1",a.getAddress());
    }

    public void testLogin() throws Exception {
        NorrisSessionInfo a = NorrisSessionInfoImpl.getInstance();
        a.login();
        assertEquals(true,a.isLogged());
    }

    public void testLogout() throws Exception {
        NorrisSessionInfo a = NorrisSessionInfoImpl.getInstance();
        a.logout();
        assertEquals(false,a.isLogged());
    }

    public void testIsLogged() throws Exception {
        NorrisSessionInfo a = NorrisSessionInfoImpl.getInstance();
        a.logout();
        assertEquals(false,a.isLogged());
        a.login();
        assertEquals(true,a.isLogged());
    }
}