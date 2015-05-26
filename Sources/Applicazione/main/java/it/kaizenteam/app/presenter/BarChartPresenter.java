/*
* Name: BarChartPresenter.java
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

/**
 * BarChartPresenter is the interface of BarChartPresenterImpl.
 */
public interface BarChartPresenter extends Presenter {
    /**
     * This method has the task of updating the data model if it receive a update of these ones and finally show in view these updated data.
     * @param observable
     * @param data
     */
    void update(Observable observable, Object data);
}
