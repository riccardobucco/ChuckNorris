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
package it.kaizenteam.app.model;


class TableImpl extends ChartImpl{

    static {
        //registro il tipo di grafico (DI)
        registerFactory("table", new TableFactory());
    }

    private TableImpl(String id) {
        super(id);
        //registro gli aggiornamenti (DI)
        registerUpdater("inplace", new TableInPlaceUpdater());
        registerUpdater("stream", new TableStreamUpdater());
    }

    /**
     * sets the settings to the TableImpl
     * @param object settings for a TableImpl
     */
    @Override
    public void setSettings(SettingsObject object) /*throws Exception*/{
        //TODO controllo che il tipo si quello corretto
        settings=object;
    }

    /**
     * sets the data to the TableImpl
     * @param object data for a TableImpl
     */
    @Override
    public void setData(DataObject object) /*throws Exception*/{
        //TODO controllo che il tipo si quello corretto
        data=object;
    }

    /**
     * factory class for a Table
     */
    protected static class TableFactory implements ChartFactory{
        /**
         * create a BarChartImpl
         * @param id identification for the TableImpl
         * @return an instance of TableImpl
         */
        @Override
        public ChartImpl create(String id) {
            return new TableImpl(id);
        }
    }

    /**
     * this class permits to update the data of the instance of a TableImpl
     */
    protected class TableInPlaceUpdater implements Updater{
        /**
         * Update the data of the TableImpl
         * @param object the update object for a Table
         */
        @Override
        public void update(UpdateObject object) {
            //TODO
        }
    }

    /**
     * this class permits to update the data of the instance of a TableImpl
     */
    protected class TableStreamUpdater implements Updater{
        /**
         * Update the data of the TableImpl
         * @param object the update object for a Table
         */
        @Override
        public void update(UpdateObject object) {
            //TODO
        }
    }
}
