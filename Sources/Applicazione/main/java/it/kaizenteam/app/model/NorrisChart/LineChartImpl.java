/*
* Name: LineChartImpl.java
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
 * Questa classe rappresenta un grafico di tipo line chart. Essa contiene al suo
 * interno i dati (LineChartDataObject) e le impostazioni (LineChartSettingsObject) relativi
 * al grafico. Inoltre contiene le classi LineChartInPlaceUpdater e LineChartStreamUpdater,
 * le quali implementano rispettivamente l’aggiornamento di tipo in place e stream per il grafico
 * in questione. Un’istanza della classe LineChartImpl viene creata dalla classe factory
 * LineChartFactory.
 */
class LineChartImpl extends ChartImpl {

    static {
        //registro il tipo di grafico (DI)
        registerFactory("linechart", LineChartFactory.getInstance());
    }

    /**
     * Tale metodo è il costruttore. Esso è privato perchè non può esser creata una istanza se non dalla sua classe interna factory.
     * @param chartId id del chart
     */
    private LineChartImpl(String chartId) {
        super("linechart", chartId);
    }


    /**
     * factory class for a LineChartImp
     * Questa classe si occupa della creazione di un grafico di tipo LineChartImpl. In particolare si occupa di configurare i dati e le impostazioni del grafico.
     */
    protected static class LineChartFactory implements ChartFactory{
        /**
         * Tale attributo statico rappresenta l’istanza univoca di tale classe.
         */
        private static LineChartFactory instance;

        /**
         * Tale metodo ha il compito di ritornare l’istanza unica di tale classe e se non esiste la crea.
         * @return ChartFactory ritorna istanza unica della classe
         */
        public static ChartFactory getInstance(){
            if(instance!=null)
                return instance;
            return new LineChartFactory();
        }

        /**
         * Tale metodo è il costruttore della classe. Esso è privato perchè non si vuole permettere a nessuno di poter creare un’istanza se non utilizzando il metodo getInstance().
         */
        private LineChartFactory(){
            instance=this;
        }

        /**
         * Tale metodo ha il compito di creare la relativa specializzazione di ChartImpl. Esso può accedere al suo costruttore perchè questa classe factory è interna alla relativa classe LineChartImpl.
         * @param chartId id del chart
         * @return ChartImpl
         */
        @Override
        public ChartImpl createChart(String chartId) {
            return new LineChartImpl(chartId);
        }
    }
}
