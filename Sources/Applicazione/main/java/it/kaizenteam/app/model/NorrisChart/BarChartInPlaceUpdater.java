/*
 * Name: BarChartInPlaceUpdater
 * Package: it.kaizenteam.app.model.NorrisChart
 * Location: Sources/Applicazione/main/java/it/kaizenteam/app/model/NorrisChart
 * Date: 24/05/2015
 * Version: 0.01
 *
 * History:
 * =================================================================
 * Version	Date	Programmer	Changes
 *  =================================================================
 * v0.01	2015-05-24	Alessandro Moretto	Creazione file
 * =================================================================
 *
 */


package it.kaizenteam.app.model.NorrisChart;

/**
 * Questa classe si occupa di definire il metodo di aggiornamento in place per
 * un grafico di tipo bar chart. Essendo una classe interna di BarChartImpl, ha acceso ai
 * campi dati privati di questa classe. In particolare può accedere al DataObject contenuto in
 * BarChartImpl e modificarne i valori.
 */
public class BarChartInPlaceUpdater implements Updater {
    /*
     * Tale attributo statico rappresenta l’istanza univoca di tale classe.
     */
    private static BarChartInPlaceUpdater instance;

    /**
     * Tale metodo ha il compito di ritornare l’istanza unica di tale classe e se non esiste lacrea.
     * @return Updater ritorna l'istanza unica della classe
     */
    public static Updater getInstance(){
        return instance;
    }

    /**
     * 
     */
    private BarChartInPlaceUpdater(){}

    /**
     * Tale metodo ha il compito di aggiornare il chart passato come parametro (chart) utilizzando il pacchetto di aggiornamento (updatedata).
     * @param chart
     * @param updateData pacchetto di aggiornamento
     */
    @Override
    public void update(ChartImpl chart, ChartUpdate updateData) {
//TODO
    }
}
