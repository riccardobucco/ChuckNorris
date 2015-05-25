/*
* Name: {LineChartImp.java}
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


class LineChartImpl extends ChartImpl {

    static {
        //registro il tipo di grafico (DI)
        registerFactory("linechart", LineChartFactory.getInstance());
    }

    /**
     *
     * @param chartId
     */
    private LineChartImpl(String chartId) {
        super("linechart", chartId);
    }


    /**
     * factory class for a LineChartImp
     */
    protected static class LineChartFactory implements ChartFactory{
        private static LineChartFactory instance;

        /**
         *
         * @return
         */
        public static ChartFactory getInstance(){
            if(instance!=null)
                return instance;
            return new LineChartFactory();
        }

        /**
         *
         */
        private LineChartFactory(){
            instance=this;
        }

        /**
         *
         * @param chartId
         * @return
         */
        @Override
        public ChartModel createChart(String chartId) {
            return new LineChartImpl(chartId);
        }
    }
}
