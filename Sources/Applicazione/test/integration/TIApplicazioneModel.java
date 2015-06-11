/*
* Name: TIApplicazioneModel.java
* Package: test.integration
* Location: Sources/Applicazione/test/integration
* Date: 2015-05-25
* Version: v0.01
*
* History:
* =================================================================
* Version   Date    Programmer  Changes
* =================================================================
* v0.01 2015-05-25  Moretto Alessandro  Creation
* =================================================================
*
*/
package test.integration;

import junit.framework.TestCase;

import it.kaizenteam.app.model.NorrisSessionInfoImpl;

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