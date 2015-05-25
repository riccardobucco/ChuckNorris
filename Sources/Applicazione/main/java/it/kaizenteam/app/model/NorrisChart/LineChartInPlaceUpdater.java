/*
* Name: LineChartInPlaceUpdater.java
* Package: it.kaizenteam.app.model.NorrisChart
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/model/NorrisChart
* Date: 24/05/2015
* Version: 0.01
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.01	2015-05-24	Alessandro Moretto	Creazione file
* =================================================================
*
*/

package it.kaizenteam.app.model.NorrisChart;

/**
 * Questa classe si occupa di definire il metodo di aggiornamento in place per
 * un grafico di tipo line chart. Essendo una classe interna di LineChartImpl, ha acceso ai
 * campi dati privati di questa classe. In particolare può accedere al DataObject contenuto in
 * LineChartImpl e modificarne i valori.
 */
public class LineChartInPlaceUpdater implements Updater {
    /**
     * Tale attributo statico rappresenta l’istanza univoca di tale classe.
     */
    private static LineChartInPlaceUpdater instance;

    /**
     * Tale metodo ha il compito di ritornare l’istanza unica di tale classe e se non esiste la crea.
     * @return ChartUpdater ritorna l'istanza di classe
     */
    public static ChartUpdater getInstance(){
        return instance;
    }

    /**
     * Costruttore della classe
     */
    private LineChartInPlaceUpdater(){}

    /**
     * Tale metodo ha il compito di aggiornare il chart passato come parametro (chart) utilizzando il pacchetto di aggiornamento (updatedata).
     * @param chart chart da aggiornare
     * @param updateData pacchetto di aggiornamento
     */
    @Override
    public void update(ChartImpl chart, ChartUpdate updateData) {
//TODO
    }
}
