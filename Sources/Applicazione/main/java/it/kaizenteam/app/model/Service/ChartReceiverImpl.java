/*
* Name: ChartReceiverImpl.java
* Package: it.kaizenteam.app.model.service
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/model/Service
* Date: 2015-05-19
* Version: 0.01
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.01	2015-05-19	Kaizen Team	Creazione file
* =================================================================
*
*/

package it.kaizenteam.app.model.Service;

import android.util.Log;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.Socket;

import java.util.Observable;

import it.kaizenteam.app.model.NorrisSessionInfoImpl;

/**
 * 
This class has a responsibility to communicate and receive events through the socket channel between app and server. Updates can be started or stopped out or it can be made the request for a full chart by external api of Norris.
 */
public class ChartReceiverImpl extends Observable implements ChartReceiver {
    private static ChartReceiverImpl instance;
    private Socket socket;

    /**
     * This method has the task of returning the unique instance of that class, and creating it if it not exists
     * @return the unique instance of that class
     */
    public static ChartReceiver getInstance(){
        if(instance!=null)
            return instance;
        return new ChartReceiverImpl();
    }

    /**
     * This method is the constructor of the class. It is private because only getInstance() method is allowed to create an instance.
     */
    private ChartReceiverImpl(){
        instance=this;
    }

    /**
     * This method has the task to enable updates through the socket channel for the chart with id idchart.
     * @param chartId id of the chart
     */
    @Override
    public void startUpdateEvent(String chartId) {
        //TODO controlla eventi
        socket.on("update:" + chartId, new Emitter.Listener() {
            @Override
            public void call(Object... args) {

            }
        });
        socket.connect();
    }

    /**
     * This method has the task of finishing the receipt of the updates through the socket channel for the chart with id idchart.
     * @param chartId id of the chart
     */
    @Override
    public void stopUpdateEvent(String chartId) {
        //TODO controlla eventi
        socket.off("update:" + chartId);
        socket.disconnect();
    }

    /**
     * This method has the task of finding data and settings of a chart whose id is chartId. This method returns a HashMap in which are stored data with the keys "data" and "settings".
     * @param chartId id of the chart
     */
    @Override
    public void getChart(String chartId) {
        //inizializzo il socket con l'indirizzo di norris
        try {
            //TODO salvare address per non instanziarlo ad ogni chart per es.
            socket = IO.socket(NorrisSessionInfoImpl.getInstance().getAddress());
        }
        catch (Exception e){
        }
        //TODO controlla eventi
        socket.on("getChart:" + chartId, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                //TODO controllare args
                ChartReceiverImpl.this.notifyObservers(args[0]);
                socket.disconnect();
            }
        });
        socket.connect();
    }
}
