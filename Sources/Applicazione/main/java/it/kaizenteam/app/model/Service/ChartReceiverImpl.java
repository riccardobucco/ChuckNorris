/*
* Name: ChartReceiverImpl.java
* Package: it.kaizenteam.app.model.Service
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/model/Service
* Date: 23/05/2015
* Version: 0.01
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.01	2015-05-23	Alessandro Moretto	Creazione file
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

/* Tale classe ha il compito di comunicare e ricevere eventi attraverso il canale socket tra app e server. Possono essere avviati o stoppati gli aggiornamenti oppure può esser fatta la richiesta di un intero chart attraverso le api esterne di Norris. */
public class ChartReceiverImpl extends Observable implements ChartReceiver {
    /*
    * Tale attributo statico rappresenta l’istanza univoca di tale classe.
    */
    private static ChartReceiverImpl instance;

    /*
    * Tale attributo rappresenta l’istanza del socket connesso con il server dell’istanza di Norris.
    */
    private Socket socket;

    /*
    * Tale metodo ha il compito di ritornare l’istanza unica di tale classe e se non esiste la crea.
    * @return ChartReveiver - Instanza unica della classe
    */
    public static ChartReceiver getInstance(){
        if(instance!=null)
            return instance;
        return new ChartReceiverImpl();
    }

    /*
    * Tale metodo è il costruttore della classe. Esso è privato perchè non si vuole permettere a nessuno di poter creare un’istanza se non utilizzando il metodo getInstance().
    */
    private ChartReceiverImpl(){
        instance=this;
    }

    /*
    * Tale metodo ha il compito di attivare gli aggiornamenti attraverso il canale socket per il chart con id idchart.
    * @param chartId - id del chart
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

    /*
    * Tale metodo ha il compito di terminare la ricezione degli aggiornamenti attraverso il canale socket per il chart con id idchart.
    * @param chartId - id del chart
    */
    @Override
    public void stopUpdateEvent(String chartId) {
        //TODO controlla eventi
        socket.off("update:" + chartId);
        socket.disconnect();
    }

    /*
    * Tale metodo ha il compito di reperire dati e impostazioni di un chart il cui id è chartId. Tale metodo ritorna un HashMap nel quale sono salvati tali dati con le chiavi "data" e "settings".
    * @param chartId - id del chart
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
