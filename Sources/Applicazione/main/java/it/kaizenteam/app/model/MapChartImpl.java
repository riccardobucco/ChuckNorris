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
package it.kaizenteam.app.model;


class MapChartImpl extends ChartImpl {


    static {
        //registro il tipo di grafico (DI)
        registerFactory("barchart", new MapChartFactory());
    }

    private MapChartImpl(String id) {
        super(id);
        //registro gli aggiornamenti (DI)
        registerUpdater("inplace", new MapChartInPlaceUpdater());
        registerUpdater("movie", new MapChartMovieUpdater());
    }

    /**
     * sets the settings to the MapChartImpl
     * @param object settings for a MapChart
     */
    @Override
    public void setSettings(SettingsObject object) /*throws Exception*/{
        //TODO controllo che il tipo si quello corretto
        settings=object;
    }

    /**
     * sets the data to the MapChartImpl
     * @param object data for a MapChart
     */
    @Override
    public void setData(DataObject object) /*throws Exception*/{
        //TODO controllo che il tipo si quello corretto
        data=object;
    }

    /**
     * factory class for a BarChart
     */
    protected static class MapChartFactory implements ChartFactory{
        /**
         * create a MapChartImpl
         * @param id identification for the MapChartImpl
         * @return an instance of MapChartImpl
         */
        @Override
        public ChartImpl create(String id) {
            return new MapChartImpl(id);
        }
    }

    /**
     * this class permits to update the data of the instance of a MapChartImpl
     */
    protected class MapChartInPlaceUpdater implements Updater{
        /**
         * Update the data of the MapChartImpl
         * @param object the update object for a MapChart
         */
        @Override
        public void update(UpdateObject object) {
            //TODO
        }
    }

    /**
     * this class permits to update the data of the instance of a MapChartImpl
     */
    protected class MapChartMovieUpdater implements Updater{
        /**
         * Update the data of the MapChartImpl
         * @param object the update object for a MapChart
         */
        @Override
        public void update(UpdateObject object) {
            //TODO
        }
    }
}
