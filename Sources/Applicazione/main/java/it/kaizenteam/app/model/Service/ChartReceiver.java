/*
* Name: ChartReceiver.java
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

/* ChartReceiver è l’interfaccia di ChartReceiverImpl */
public interface ChartReceiver {
    /*
    * Tale metodo ha il compito di attivare gli aggiornamenti attraverso il canale socket per il chart con id idchart.
    * @param String - Id del chart
    */
    void startUpdateEvent(String chartId);

    /*
    * Tale metodo ha il compito di terminare la ricezione degli aggiornamenti attraverso il canale socket per il chart con id idchart.
    * @param String - Id del chart
    */
    void stopUpdateEvent(String chartId);

    /*
    * Tale metodo ha il compito di reperire dati e impostazioni di un chart il cui id è chartId. Tale metodo ritorna un HashMap nel quale sono salvati tali dati con le chiavi "data" e "settings".
    * @param String - Id del chart
    */
    void getChart(String chartId);
}
