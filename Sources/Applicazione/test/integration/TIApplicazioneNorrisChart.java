/*
* Name: TIApplicazioneNorrisChart.java
* Package: it.kaizenteam.app.model
* Location: Sources/Applicazione/test/unit
* Date: 2015-05-19
* Version: v0.02
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.02 2015-05-26  Moretto Alessandro   Verify
* =================================================================
* v0.01 2015-05-23  Davide Dal Bianco  Creation
* =================================================================
*
*/
package test.integration;

import junit.framework.TestCase;

import it.kaizenteam.app.model.NorrisSessionInfo;
import it.kaizenteam.app.model.NorrisSessionInfoImpl;

public class TIApplicazioneNorrisChart extends TestCase {
    public void testCreation(){
        NorrisSessionInfo a = NorrisSessionInfoImpl.getInstance();
        NorrisSessionInfo b = NorrisSessionInfoImpl.getInstance();
        assertEquals(a,b);
        a.setAddress("add1");
        assertEquals("add1",a.getAddress());
        a.login();
        assertEquals(true,a.isLogged());
        a.logout();
        assertEquals(false,a.isLogged());
        a.logout();
        assertEquals(false,a.isLogged());
        a.login();
        assertEquals(true,a.isLogged());
    }
}