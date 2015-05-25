/*
* Name: BarChartImpl.java
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
 * Questa classe rappresenta un grafico di tipo bar chart. Essa contiene al suo
 * interno i dati (BarChartDataObject) e le impostazioni (BarChartSettingsObject) relativi al
 * grafico. Inoltre contiene la classe BarChartInPlaceUpdater, la quale implementa l’aggiornamento
 * di tipo in place per il grafico in questione. Un’istanza della classe BarChartImpl viene
 * creata dalla classe factory BarChartFactory.
 */
class BarChartImpl extends ChartImpl{
    static {
        //registro il tipo di grafico (DI)
        registerFactory("barchart", BarChartFactory.getInstance());
    }

    /**
    * Questo metodo è il costruttore della classe.
    * @param chartId
    */
    private BarChartImpl(String chartId) {
        super("barchart", chartId);
    }


    /**
    * Questa classe si occupa della creazione di un grafico di tipo BarChartImpl. In
    * particolare si occupa di configurare i dati e le impostazioni del grafico.
    */
    protected static class BarChartFactory implements ChartFactory{
    	/**
    	 * Questo attributo è il riferimento all’unica istanza della classe.
    	 */
        private static BarChartFactory instance;

        /**
         * Questo metodo permette di ottenere l’unica istanza esistente della classe.
         * @return ChartFactory instanza della classe
         */
        public static ChartFactory getInstance(){
            if(instance!=null)
                return instance;
            return new BarChartFactory();
        }

        /**
         * Questo metodo è il costruttore della classe.
         */
        private BarChartFactory(){
            instance=this;
        }

        /**
         * Questo metodo permette di costruire un’istanza di BarChartImpl.
         * @param chartId Id del chart
         * @return ChartModel istanza di BarChartImpl
         */
        @Override
        public ChartModel createChart(String chartId) {
            return new BarChartImpl(chartId);
        }
    }
}
