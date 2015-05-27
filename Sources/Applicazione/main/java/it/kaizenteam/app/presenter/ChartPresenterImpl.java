/*
* Name: BarChartPresenter.java
* Package: it.kaizenteam.app.presenter
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/presenter
* Date: 2015-05-22
* Version: 0.01
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.02 2015-05-26  Moretto Alessandro   Verify
* =================================================================
* v0.01 2015-05-23  Davide Dal Bianco  Creazione file
* =================================================================
*
*/

package it.kaizenteam.app.presenter;

import java.util.Observable;
import java.util.Observer;

import it.kaizenteam.app.model.NorrisChart.ChartSettings;

/**
 * This class represents a general presenter of a view of a chart. In this class it is saved the reference chart (ChartModel).
 * This class implements Observer with the purpose to receive data from the socket (using the Package Service).
 * It can ask to ChartUpdater the values of a chart or request to receive the various updates of a chart.
 */
public abstract class ChartPresenterImpl extends PresenterImpl implements Observer {

    /**
     * This method is the constructor of the class. It is only accessible to subclasses in the creation of the subobject.
     */
    protected ChartPresenterImpl(){}

    /**
     * This method is abstract and has the task of updating the data model in case of data update and finally show the view this data updated.
     * @param observable
     * @param data
     */
    @Override
    public abstract void update(Observable observable, Object data);

    /**
     * This method is abstract and has the task to change the view by using the settings the chart.
     * @param settings
     */
    protected abstract void applySettings(ChartSettings settings);

}
