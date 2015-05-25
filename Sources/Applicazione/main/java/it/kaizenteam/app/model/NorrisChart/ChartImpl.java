/*
* Name: ChartImpl.java
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

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/**
 * Questa classe rappresenta un grafico generico e per questo motivo è una classe
 * astratta. Essa contiene al suo interno i dati (DatObject) e le impostazioni (SettingsObject)
 * relativi ad un grafico. Contiene, inoltre, l’interfaccia ChartFactory e due hashmap: la prima
 * si occupa della corrispondenza tra le tipologie di grafico e le rispettive classi factory, la
 * seconda invece si occupa della corrispondenza tra le varie tipologie di aggiornamento e la
 * classe che implementa tale aggiornamento per un tipo specifico di grafico. ChartImpl ha una
 * dipendenza verso l’interfaccia UpdateObject, in quanto deve conoscere il tipo del pacchetto
 * degli aggiornamenti.
 */
public abstract class ChartImpl extends Observable implements ChartModel{
    /**
     * Tale hashmap contiene le associazioni di tutti i tipi di chart possibilli con la relativa factory del chart.
     */
    private static Map<String,ChartFactory> factories = new HashMap<>();

    /**
     * Tale hashmap contiene le associazioni di tutti gli aggiornamenti possibilli con l’oggetto ChartUpdater.
     */
    private static HashMap<String,Updater> updaters = new HashMap<>();

    /**
     * Tale attributo rappresenta l’id del chart.
     */
    final String id;

    /**
     * Tale attributo rappresenta il tipo del chart.
     */
    final String type;

    /**
     * Tale attributo rappresenta i valori del chart.
     */
    ChartData data;

    /**
     * Tale attributo rappresenta le impostazioni del chart.
     */
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
     * Tale metodo non fa altro che creare il chart associato al parametro type e ritornare l’interfaccia ChartModel di tale istanza creata.
     * @param type tipo di chart
     * @param id id del chart
     * @return ChartModel ritorna l'interfaccia dell'instanza creata
     */
    public static ChartModel create(String type, String id) {//todo throws Exception {
        ChartFactory factory = factories.get(type);

        if(factory != null)
            return factory.createChart(id);
        else
            return null; //TODO throw new Exception();
    }

    /**
     * Tale metodo serve per registrare una certa factory al relativo chart nell’hashmap della classe (factories).
     * @param chartType tipo di chart
     * @param factory hashmap della classe
     */
    protected static void registerFactory(String chartType, ChartFactory factory) {
        factories.put(chartType, factory);
    }

    /**
     * Tale metodo serve per registrare un certo updater al relativo tipo di update nell’hashmap della classe (updaters).
     * @param updatetype tipo di update
     * @param updater hashmap della classe
     */
    protected void registerUpdater(String updatetype, Updater updater) {
        updaters.put(updatetype, updater);
    }

    /**
     * Tale metodo è il costuttore della classe. Esso è accessibile solamente alle sottoclassi nella creazione del sottoggetto.
     * @param chartType tipo di chart
     * @param chartId id del chart
     */
    protected ChartImpl(String chartType, String chartId) {
        this.id = chartId;
        this.type=chartType;
    }

    /**
     * Tale metodo ha il compito di ritornare i dati del chart.
     * @return ChartData ritorna i dati del chart
     */
    public ChartData getData(){
        return data;
    }

    /**
     * Tale metodo ha il compito di ritornare l’id del chart.
     * @return String ritorna l'id del chart
     */
    public String getId(){
        return id;
    }

    /**
     * Tale metodo ha il compito di ritornare le impostazioni del chart.
     * @return ChartSettings ritorna le impostazioni del chart
     */
    public ChartSettings getSettings(){
        return settings;
    }

    /**
     * Tale metodo ha il compito di ritornare il tipo del chart.
     * @return String ritorna il tipo di chart
     */
    public String getType(){
        return type;
    }

    /**
     * Tale metodo ha il compito di impostare i dati del chart.
     * @param data dati del chart da impostare
     */
    public void setData(ChartData data){
        this.data=data;

    }

    /**
     * Tale metodo ha il compito di assegnare le impostazioni del chart.
     * @param settings impostazioni da assegnare
     */
    public void setSettings(ChartSettings settings){
        this.settings=settings;
    }

    /**
     * Tale metodo ha il compito di aggiornare i chart utilizzando la tipologia di aggiornamento presente in updateType e il pacchetto di aggiornamento updateData.
     * @param updateType tipologia di aggiornamento
     * @param updateData pacchetto di aggiornamento
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
     * ChartFactory è l’interfaccia delle classi factory che si occupano della creazione dei vari tipi di grafici. È interna alla classe ChartImpl.
     */
    protected interface ChartFactory {
        ChartModel createChart(String chartId);
    }
}
