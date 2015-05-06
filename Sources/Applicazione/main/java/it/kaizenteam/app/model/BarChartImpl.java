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
package it.kaizenteam.app.model;

/**
 * This class rapresent a
 */
class BarChartImpl extends ChartImpl{

    static {
        //registro il tipo di grafico (DI)
        registerFactory("barchart", new BarChartFactory());
    }

    private BarChartImpl(String id) {
        super(id);
        //registro gli aggiornamenti (DI)
        registerUpdater("inplace", new BarChartInPlaceUpdater());
    }

    /**
     * sets the settings to the BarChartImpl
     * @param object settings for a BarChartImpl
     */
    @Override
    public void setSettings(SettingsObject object) /*throws Exception*/{
        //TODO controllo che il tipo si quello corretto
        settings=object;
    }

    /**
     * sets the data to the BarChartImpl
     * @param object data for a BarChartImpl
     */
    @Override
    public void setData(DataObject object) /*throws Exception*/{
        //TODO controllo che il tipo si quello corretto
        data=object;
    }

    /**
     * factory class for a BarChart
     */
    protected static class BarChartFactory implements ChartFactory{
        /**
         * create a BarChartImpl
         * @param id identification for the BarChartImpl
         * @return an instance of BarChartImplImpl
         */
        @Override
        public ChartImpl create(String id) {
            return new BarChartImpl(id);
        }
    }

    /**
     * this class permits to update the data of the instance of a BarChartImpl
     */
    protected class BarChartInPlaceUpdater implements Updater{
        /**
         * Update the data of the BatChartImpl
         * @param object the update object for a BarChart
         */
        @Override
        public void update(UpdateObject object) {
            //TODO
        }
    }
}
