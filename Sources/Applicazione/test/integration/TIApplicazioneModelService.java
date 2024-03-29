/*
* Name: TIApplicazioneModelService.java
* Package: test.integration
* Location: Sources/Applicazione/test/integration
* Date: 2015-05-25
* Version: v1.00
*
* History:
* =================================================================
* Version   Date    Programmer  Changes
* =================================================================
* v1.00 2015-06-15  Carlon Chiara  Approved
* =================================================================
* v0.02 2015-06-02  Rubin Marco  Verify
* =================================================================
* v0.01 2015-05-25  Dal Bianco Davide  Creation
* =================================================================
*
*/
package test.integration;

import junit.framework.TestCase;

import java.util.Observable;
import java.util.Observer;

import it.kaizenteam.app.model.Service.ChartReceiver;
import it.kaizenteam.app.model.Service.ChartReceiverImpl;


public class TIApplicazioneModelService extends TestCase implements Observer {
    boolean done=false;
    public void testCreation(){
        ChartReceiver receiver = ChartReceiverImpl.getInstance();
        ((ChartReceiverImpl)receiver).addObserver(this);
        receiver.getChart("idchart");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(true,done);
    }

    @Override
    public void update(Observable observable, Object data) {
        done=true;
    }
}