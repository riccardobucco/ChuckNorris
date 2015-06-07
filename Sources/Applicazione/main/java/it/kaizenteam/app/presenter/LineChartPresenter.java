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


import it.kaizenteam.app.Utils.Observable;

/**
 * LineChartPresenter is the interface LineChartPresenterImpl
 */
public interface LineChartPresenter extends Presenter {
    /**
     * This method has the task of updating the data model in case of update and finally show in view these updated data.
     * @param observable
     * @param data
     */
    void update(Observable observable, Object... data);
    void setChart(String id);
}
