/*
* Name: TUApplicazioneNorrisSessionInfoImpl.java
* Package: test.unit
* Location: Sources/Applicazione/test/unit
* Date: 2015-05-24
* Version: v0.01
*
* History:
* =================================================================
* Version   Date    Programmer  Changes
* =================================================================
* v0.01 2015-05-24  Moretto Alessandro  Creation
* =================================================================
*
*/
package test.unit;

import junit.framework.TestCase;

import it.kaizenteam.app.model.NorrisSessionInfo;
import it.kaizenteam.app.model.NorrisSessionInfoImpl;

public class TUApplicazioneNorrisSessionInfoImpl extends TestCase {

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