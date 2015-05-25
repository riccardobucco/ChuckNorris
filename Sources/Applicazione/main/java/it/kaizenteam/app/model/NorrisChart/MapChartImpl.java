/*
* Name: {MapChartImpl.java}
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


class MapChartImpl extends ChartImpl {

    static {
        //registro il tipo di grafico (DI)
        registerFactory("mapchart", MapChartFactory.getInstance());
    }

    /**
     *
     * @param chartId
     */
    private MapChartImpl(String chartId) {
        super("mapchart", chartId);
    }

    /**
     * factory class for a BarChart
     */
    protected static class MapChartFactory implements ChartFactory{
        private static MapChartFactory instance;

        /**
         *
         * @return
         */
        public static ChartFactory getInstance(){
            if(instance!=null)
                return instance;
            return new MapChartFactory();
        }

        /**
         *
         */
        private MapChartFactory(){
            instance=this;
        }

        /**
         *
         * @param chartId
         * @return
         */
        @Override
        public ChartModel createChart(String chartId) {
            return new MapChartImpl(chartId);
        }
    }
}
