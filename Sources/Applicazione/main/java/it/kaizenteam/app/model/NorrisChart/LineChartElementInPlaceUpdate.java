/*
* Name: LineChartElementInPlaceUpdate.java
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
 * Tale classe rappresenta un elemento di pacchetto di aggiornamento in place di un line chart.
 */
public class LineChartElementInPlaceUpdate {
    /**
     * Tale attributo rappresenta i valori del dato aggiornato.
     */
    private double value;

    /**
     * Tale attributo rappresenta l’ordinata del dato da sostituire.
     */
    private double xpos;

    /**
     * Tale attributo rappresenta l’ascissa del dato da sostituire.
     */
    private double ypos;

    /**
     * Tale metodo è un costruttore per create tale pacchetto di aggiornamento.
     * @param xpos ascissa del dato da modificare
     * @param ypos ordinata del dato da modificare
     * @param value nuovo dato del pacchetto di aggiornamento
     */
    public LineChartElementInPlaceUpdate(double xpos, double ypos, double value){
        this.xpos=xpos;
        this.ypos=ypos;
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
     * Tale metodo ha il compito di ritornare l’ascissa del dato da modificare.
     * @return double ritorna l'ascissa del dato da modificare
     */
    public double getX(){
        return xpos;
    }

    /**
     * Tale metodo ha il compito di ritornare l’ordinata del dato da modificare.
     * @return double ritorna l'ordinata del dato da modificare
     */
    public double getY(){
        return ypos;
    }
}
