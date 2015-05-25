package it.kaizenteam.app.model.Service;

import android.util.Log;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.Socket;

import java.util.Observable;

import it.kaizenteam.app.model.NorrisSessionInfoImpl;

/**
 * Created by Moro on 23/05/15.
 */
public class ChartReceiverImpl extends Observable implements ChartReceiver {
    private static ChartReceiverImpl instance;
    private Socket socket;

    public static ChartReceiver getInstance(){
        if(instance!=null)
            return instance;
        return new ChartReceiverImpl();
    }

    private ChartReceiverImpl(){
        instance=this;
    }

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

    @Override
    public void stopUpdateEvent(String chartId) {
        //TODO controlla eventi
        socket.off("update:" + chartId);
        socket.disconnect();
    }

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
