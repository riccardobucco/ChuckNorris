/*
* Name: LineChartElementStreamUpdate.java
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
 * Tale classe rappresenta un elemento di pacchetto di aggiornamento stream di un line chart.
 */
public class LineChartElementStreamUpdate {
    /**
     * Tale attributo rappresenta il valore del dato aggiornato.
    */
    private double value;

    /**
     * Tale attributo rappresenta il valore della nuova etichetta da inserire nel chart.
    */
    private String label;

    /**
     * Tale metodo è il costruttore per create tale pacchetto di aggiornamento.
     * @param label valore del dato aggiornato
     * @param value valore etichetta chart
     */
    public LineChartElementStreamUpdate(String label, double value){
        this.label=label;
        this.value=value;
    }

    /**
     * Tale metodo ha il compito di ritornare il nuovo dato del pacchetto di aggiornamento.
     * @return double ritorna il nuovo dato del pacchetto di aggiornamento
     */
    public double getData(){
        return value;
    }

    /**
     * Tale metodo ha il compito di ritornare il valore nella nuova etichetta.
     * @return String ritorna il valore della nuova etichetta
     */
    public String getLabel(){
        return label;
    }
}
