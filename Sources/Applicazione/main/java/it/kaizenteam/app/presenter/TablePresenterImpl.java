/*
* Name: TablePresenterImpl.java
* Package: it.kaizenteam.app.presenter
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/presenter
* Date: 19/05/2015
* Version: 0.01
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.01	2015-05-19	Alessandro Moretto	Creazione file
* =================================================================
*
*/

package it.kaizenteam.app.presenter;

import java.util.Observable;

import it.kaizenteam.app.model.NorrisChart.ChartSettings;

/**
 * This class is the implementation of a presenter for table.
 */
public class TablePresenterImpl extends ChartPresenterImpl implements TablePresenter{
    static {
        //registro il tipo di grafico (DI)
        registerFactory(TABLE_TYPE, TablePresenterFactory.getInstance());
    }

    /**
     * This method has the task of updating the data model if it receives an update of these ones and finally show in view these updated data.
     * @param observable
     * @param data
     */
    @Override
    public void update(Observable observable, Object data) {
        //TODO
    }

    /**
     * This method has the task to change the view according to the settings of the chart.
     * @param settings
     */
    @Override
    protected void applySettings(ChartSettings settings) {
        //TODO
    }

    /**
     * This method is the constructor. It is private because it can not be created an instance except from a request of his inner class factory.
     */
    private TablePresenterImpl(){}

    /**
     * This class deals with the creation of a TablePresenterImpl presenter.
     */
    protected static class TablePresenterFactory implements PresenterImpl.PresenterFactory {
        /**
          * The static attribute is the unique instance of that class.
          */
        private static PresenterFactory instance;

	/**
         * This method has the task of returning the unique instance of the class, and creating it if it not exists.
         * @return the unique instance of the class
         */
        private static PresenterFactory getInstance(){
            if(instance!=null)
                return instance;
            return new TablePresenterFactory();
        }

        /**
         * This method is the constructor of the class. It is private because only getInstance() method can create an instance.
         */
        private TablePresenterFactory(){
            instance=this;
        }

        /**
         * This method has the task of creating the relative presenter. It can access its constructor because this factory class is inner to the related presenter class.
         * @return presenter
         */
        @Override
        public PresenterImpl createPresenter() {
            return new TablePresenterImpl();
        }
    }
}
