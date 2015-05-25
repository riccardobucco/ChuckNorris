/*
* Name: ChartModel.java
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
 * Chart è l’interfaccia che rappresenta un grafico generico e viene implementata da ChartImpl. Essa contiene i metodi set e get relativi alle impostazioni e ai dati ed i metodi relativi agli aggiornamenti dei grafici.
 */
public interface ChartModel {
    /**
     * Tale metodo ha il compito di assegnare le impostazioni del chart.
     * @param object impostazioni del chart da assegnare
     */
    public void setSettings(ChartSettings object);

    /**
     * Tale metodo ha il compito di impostare i dati del chart.
     * @param object dati del chart da impostare
     */
    public void setData(ChartData object);

    /**
     * Tale metodo ha il compito di ritornare le impostazioni del chart.
     * @return ChartSettings ritorna le impostazioni del chart
     */
    public ChartSettings getSettings();

    /**
     * Tale metodo ha il compito di ritornare i dati del chart.
     * @return ChartData ritorna i dati del chart
     */
    public ChartData getData();

    /**
     * Tale metodo ha il compito di ritornare l’id del chart.
     * @return String ritorna l'id del chart
     */
    public String getId();

    /**
     * Tale metodo ha il compito di aggiornare i chart utilizzando la tipologia di aggiornamento presente in updateType e il pacchetto di aggiornamento updateData.
     * @param type tipo dell'aggiornamento
     * @param object pacchetto di aggiornamento
     */
    public void update(String type, ChartUpdate object);

    /**
     * Tale metodo ha il compito di ritornare il tipo del chart.
     * @return String ritorna il tipo di chart
     */
    public String getType();
}
