/*
 * Name: BarChartSettingsImpl
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

import org.json.JSONObject;


/**
 * Tale classe rappresenta le impostazioni di un bar chart.
 */
public class BarChartSettingsImpl implements ChartSettings {
    /*
     * Tale attributo memorizza l’Oggetto JSON con le impostazioni del chart.
     */
    private JSONObject settings;

    /**
     *
     * @param settings
     */
    public BarChartSettingsImpl(JSONObject settings){
        this.settings=settings;
    }

    /**
     * Tale metodo ha il compito di ritornare il nome del nome dell’asse delle ascisse.
     * @return String ritorna il nome dell'asse delle ascisse.
     */
    public String getXAxisName(){
        //TODO
        return "XAXIX";
    }

    /**
     * Tale metodo ha il compito di ritornare il nome del nome dell’asse delle ordinate.
     * @return String ritorna il nome del nome dell’asse delle ordinate
     */
    public String getYAxisName(){
        //TODO
        return "YAXIX";
    }

    /**
     * Tale metodo ha il compito di ritornare un booleano che dica se la griglia è visualizzata o no.
     * @return booolean ritorna true se la griglia è visualizzata, altrimenti false
     */
    public boolean getGridVisibility(){
        //TODO
        return true;
    }

    /**
     * Tale metodo ha il compito di ritornare la posizione della legenda.
     * @return String ritorna la posizione della legenda
     */
    public String getLegendPosition(){
        //TODO
        return "left";
    }

    /**
     * Tale metodo ha il compito di ritornare l’orientamento del chart.
     * @return String ritorna l'orientamento del chart
     */
    public String getOrientation(){
        //TODO
        return "horizontal";
    }
}
