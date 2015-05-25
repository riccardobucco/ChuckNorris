/*
* Name: {ChartImpl.java}
* Package: {it.kaizenteam.app.model}
* Location: {src.main.java.it.kaizenteam.model}
* Date: {data di creazione del file}
* Version: {0.01}
*
* History:
*
* =================================================================
* Version Date Programmer Changes
* =================================================================
* 0.01 GG-MM-AAAA Aessandro Moretto {creation}
* =================================================================
*
*/
package it.kaizenteam.app.model.NorrisChart;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/**
 * This class rapresent an abstract Chart. It contains data and settings.
 */
public abstract class ChartImpl extends Observable implements ChartModel{

    private static Map<String,ChartFactory> factories = new HashMap<>();
    private static HashMap<String,Updater> updaters = new HashMap<>();
    final String id;
    final String type;
    ChartData data;
    ChartSettings settings;

    static {
        //carico le classi per formare gli hashmap statici
        String[] classi=new String[]{
                "it.kaizenteam.app.model.NorrisChart.LineChartImpl",
                "it.kaizenteam.app.model.NorrisChart.BarChartImpl",
                "it.kaizenteam.app.model.NorrisChart.MapChartImpl",
                "it.kaizenteam.app.model.NorrisChart.TableImpl"
        };

        new ClassLoader() {
            public void load(String[] classi){
                for (int i=0;i<classi.length;i++){
                    try {
                        Class.forName(classi[i]);
                    }catch (Exception e){}
                }
            }
        }.load(classi);
    }

    /**
     *
     * @param type
     * @param id
     * @return
     */
    public static ChartModel create(String type, String id) {//todo throws Exception {
        ChartFactory factory = factories.get(type);

        if(factory != null)
            return factory.createChart(id);
        else
            return null; //TODO throw new Exception();
    }

    /**
     *
     * @param chartType
     * @param factory
     */
    protected static void registerFactory(String chartType, ChartFactory factory) {
        factories.put(chartType, factory);
    }

    /**
     *
     * @param updatetype
     * @param updater
     */
    protected void registerUpdater(String updatetype, Updater updater) {
        updaters.put(updatetype, updater);
    }

    /**
     *
     * @param chartType
     * @param chartId
     */
    protected ChartImpl(String chartType, String chartId) {
        this.id = chartId;
        this.type=chartType;
    }

    /**
     *
     * @return
     */
    public ChartData getData(){
        return data;
    }

    /**
     *
     * @return
     */
    public String getId(){
        return id;
    }

    /**
     *
     * @return
     */
    public ChartSettings getSettings(){
        return settings;
    }

    /**
     *
     * @return
     */
    public String getType(){
        return type;
    }

    /**
     *
     * @param data
     */
    public void setData(ChartData data){
        this.data=data;

    }

    /**
     *
     * @param settings
     */
    public void setSettings(ChartSettings settings){
        this.settings=settings;
    }

    /**
     *
     * @param updateType
     * @param updateData
     */
    public void update(String updateType, ChartUpdate updateData) {
        Updater updater = updaters.get(type);

        if (updater != null)
            updater.update(this,updateData);
        /*TODO else
            throw new Exception();
        */
    }

    /**
     *
     */
    protected interface ChartFactory {
        ChartModel createChart(String chartId);
    }
}