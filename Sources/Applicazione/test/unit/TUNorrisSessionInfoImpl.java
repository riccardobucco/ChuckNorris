package it.kaizenteam.app.model;

import junit.framework.TestCase;

/*
* Name: NorrisSessionInfo.java
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