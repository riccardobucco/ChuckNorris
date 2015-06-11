/*
* Name: TIApplicazioneModelService.java
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