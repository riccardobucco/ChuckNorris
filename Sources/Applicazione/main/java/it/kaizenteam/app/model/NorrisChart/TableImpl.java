/*
* Name: TableImpl.java
* Package: it.kaizenteam.app.model.NorrisChart
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/model/NorrisChart
* Date: 2015-05-19
* Version: v0.02
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.02 2015-05-24  Davide Dal Bianco   Verify
* =================================================================
* v0.01 2015-05-18  Moretto Alessandro  Creazione file
* =================================================================
*
*/

package it.kaizenteam.app.model.NorrisChart;


/**
 * This class represents a table. It contains within it the data (TableDataObject) and settings (TableSettingsObject) relative to the chart. It contains also the 
 * classes TableInPlaceUpdater and TableStreamUpdater, which respectively implement the in place and stream update. TableImpl instance of the class is created by the 
 * class factory TableFactory
 */
class TableImpl extends ChartImpl{

    static {
        //registro il tipo di grafico (DI)
        registerFactory("table", TableFactory.getInstance());
    }

    /**
     * This method is the constructor. It is private because it can not be created except from a request of his inner class factory.
     * @param chartId
     */
    private TableImpl(String chartId) {
        super("table", chartId);
    }

    /**
     * factory class for a Table
     * This class is responsible for creating a TableImpl. In particular it configures the data and the settings of the chart.
     */
    protected static class TableFactory implements ChartFactory{
        /**
          * The static attribute is the unique instance of that class.
          */
        private static TableFactory instance;

        /**
         * This method has the task of returning the unique instance of that class, and creating it if not exists.
         * @return the unique instance of class
         */
        public static ChartFactory getInstance(){
            if(instance!=null)
                return instance;
            return new TableFactory();
        }

        /**
         * This method is the constructor of the class. It is private because only using the getInstance() method it is allowed to create an instance.
         */
        private TableFactory(){
            instance=this;
        }

        /**
         * This method has the task of creating the specialization of ChartImpl.
         * It can access to its constructor because this factory class is internal to the related class TableImpl
         * @param chartId
         * @return specialization of ChartImpl
         */
        @Override
        public ChartImpl createChart(String chartId) {
            return new TableImpl(chartId);
        }

    }
}
