/*
* Name: LineChartDataImpl.java
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

import com.github.mikephil.charting.charts.LineChart;

/**
 * Tale classe rappresenta i dati di un line chart.
 */
public class LineChartDataImpl implements ChartData{
    /**
     * Tale attributo rappresenta i valori del chart.
     */
    private LineChart values;

    /**
     * Tale metodo è il costruttore di LineChartDataImpl. Esso ha come parametro i valori dei dati del chart.
     * @param values valori dei dati del chart
     */
    public LineChartDataImpl(LineChart values){
        this.values=values;
    }

    /**
     * Tale metodo ha il compito di ritornare i dati del chart.
     * @return LineChart ritorna i dati del chart
     */
    public LineChart getData(){
        return values;
    }

    /**
     * Tale metodo ha il compito di impostare i dati del chart.
     * @param data dati del chart
     */
    public void setData(LineChart data){
        this.values=data;
    }
}
