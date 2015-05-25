/*
* Name: {TableImpl.java}
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
class TableImpl extends ChartImpl{

    static {
        //registro il tipo di grafico (DI)
        registerFactory("table", TableFactory.getInstance());
    }

    /**
     *
     * @param chartId
     */
    private TableImpl(String chartId) {
        super("table", chartId);
    }

    /**
     * factory class for a Table
     */
    protected static class TableFactory implements ChartFactory{

        private static TableFactory instance;

        /**
         *
         * @return
         */
        public static ChartFactory getInstance(){
            if(instance!=null)
                return instance;
            return new TableFactory();
        }

        /**
         *
         */
        private TableFactory(){
            instance=this;
        }

        /**
         *
         * @param chartId
         * @return
         */
        @Override
        public ChartModel createChart(String chartId) {
            return new TableImpl(chartId);
        }

    }
}
