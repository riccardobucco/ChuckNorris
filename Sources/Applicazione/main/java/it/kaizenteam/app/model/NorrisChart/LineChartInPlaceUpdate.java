/*
* Name: LineChartInPlaceUpdate.java
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

import java.util.ArrayList;

/**
 * Tale classe rappresenta un pacchetto di aggiornamento in place di un line chart.
 */
public class LineChartInPlaceUpdate implements ChartUpdate {
    /**
     * Tale attributo rappresenta i valori del dato aggiornato.
     */    
    private ArrayList<LineChartElementInPlaceUpdate> values;

    /**
     * Tale metodo è il costruttore per creare tale pacchetto di aggiornamento.
     * @param values dati pacchetto di aggiornamento
     */
    public LineChartInPlaceUpdate(ArrayList<LineChartElementInPlaceUpdate> values){
        this.values=values;
    }

    /**
     * Tale metodo ha il compito di ritornare i dati del pacchetto di aggiornamento.
     * @return ArrayList<LineChartElementInPlaceUpdate> ritorna i dati del pacchetto di aggiornamento
     */
    public ArrayList<LineChartElementInPlaceUpdate> getData(){
        return values;
    }
}
