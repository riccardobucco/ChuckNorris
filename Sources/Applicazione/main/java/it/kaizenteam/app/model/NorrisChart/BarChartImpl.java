/*
* Name: {BarChartImpl.java}
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

/**
 *
 */
class BarChartImpl extends ChartImpl{

    static {
        //registro il tipo di grafico (DI)
        registerFactory("barchart", BarChartFactory.getInstance());
    }

    /**
     *
     * @param chartId
     */
    private BarChartImpl(String chartId) {
        super("barchart", chartId);
    }


    /**
     * factory class for a BarChart
     */
    protected static class BarChartFactory implements ChartFactory{
        private static BarChartFactory instance;

        /**
         *
         * @return
         */
        public static ChartFactory getInstance(){
            if(instance!=null)
                return instance;
            return new BarChartFactory();
        }

        /**
         *
         */
        private BarChartFactory(){
            instance=this;
        }

        /**
         *
         * @param chartId
         * @return
         */
        @Override
        public ChartModel createChart(String chartId) {
            return new BarChartImpl(chartId);
        }
    }
}
