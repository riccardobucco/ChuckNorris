/*
* Name: BarChartDataImpl.java
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

import com.github.mikephil.charting.charts.BarChart;

/**
* Tale classe rappresenta i dati di un bar chart
*/
public class BarChartDataImpl implements ChartData {
    /**
    * Tale attributo rappresenta i valori del chart.
    */
    private BarChart values;

    /**
    * Tale metodo è il costruttore di BarChartDataImpl. Esso ha come parametro i valori dei dati del chart.
    * @param values valori dei dati del chart
    */
    public BarChartDataImpl(BarChart values){
        this.values=values;
    }

    /**
    * Tale metodo ha il compito di ritornare i dati del chart.
    * @return BarChart dati del chart
    */
    public BarChart getData(){
        return values;
    }

    /** TODO rimuovere...viene modificato per riferimento
    * Tale metodo ha il compito di impostare i dati del chart.
    * @param values dati del chart 
    */
    public void setData(BarChart values){
        this.values=values;
    }
}
