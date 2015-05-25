/*
* Name: MapChartImpl.java
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
