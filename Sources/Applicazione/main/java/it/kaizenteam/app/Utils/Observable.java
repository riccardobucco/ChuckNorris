package it.kaizenteam.app.Utils;

import java.util.ArrayList;

/**
 * Created by Moro on 06/06/15.
 */
public class Observable {
    //questa lista ha lo scopo di salvare tutti gli osservatori dell'oggetto
    private ArrayList<Observer> osservatori=new ArrayList<>();

    /*
    tale metodo serve ad un osservatore per registrarsi nella lista degli
    osservatori, ciò implica che verrà avvisato quando l'oggetto osservato
    sarà modificato
    */
    public void attach(Observer osservatore){
        osservatori.add(osservatore);
    }

    /*
    tale metodo serve per annullare l'effetto dell'aggiornamento all'observer
    */
    public void deattach(Observer osservatore){
        osservatori.remove(osservatore);
    }

    /*
    tale metodo dovrà essere chiamato dalla classe che estende
    Observable ongi qualvolta esso verrà modificato.
    Tale metodo notificherà ogni osservatore chiamando il suo metodo update(Observable o)
    */
    public void notifyObservers(Object... o){
        for (Observer osservatore : osservatori) {
            osservatore.update(this,o);
        }
    }
}
