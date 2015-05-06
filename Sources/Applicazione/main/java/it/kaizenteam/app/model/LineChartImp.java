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
package it.kaizenteam.app.model;


class LineChartImp extends ChartImpl {

    static {
        //registro il tipo di grafico (DI)
        registerFactory("linechart", new LineChartFactory());
    }

    private LineChartImp(String id) {
        super(id);
        //registro gli aggiornamenti (DI)
        registerUpdater("inplace", new LineChartInPlaceUpdater());
        registerUpdater("stream", new LineChartStreamUpdater());
    }

    /**
     * sets the settings to the LineChartImp
     * @param object settings for a LineChart
     */
    @Override
    public void setSettings(SettingsObject object) /*throws Exception*/{
        //TODO controllo che il tipo si quello corretto
        settings=object;
    }

    /**
     * sets the data to the LineChartImp
     * @param object data for a LineChart
     */
    @Override
    public void setData(DataObject object) /*throws Exception*/{
        //TODO controllo che il tipo si quello corretto
        data=object;
    }

    /**
     * factory class for a LineChartImp
     */
    protected static class LineChartFactory implements ChartFactory{
        /**
         * create a LineChartImp
         * @param id identification for the LineChartImp
         * @return an instance of LineChartImp
         */
        @Override
        public ChartImpl create(String id) {
            return new LineChartImp(id);
        }
    }

    /**
     * this class permits to update the data of the instance of a LineChartImp
     */
    protected class LineChartInPlaceUpdater implements Updater{
        /**
         * Update the data of the LineChartImp
         * @param object the update object for a LineChart
         */
        @Override
        public void update(UpdateObject object) {
            //TODO
        }
    }

    /**
     * this class permits to update the data of the instance of a LineChartImp
     */
    protected class LineChartStreamUpdater implements Updater{
        /**
         * Update the data of the LineChartImp
         * @param object the update object for a LineChart
         */
        @Override
        public void update(UpdateObject object) {
            //TODO
        }
    }
}
