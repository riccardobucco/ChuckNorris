/*
* Name: TablePresenter.java
* Package: it.kaizenteam.app.presenter
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/presenter
* Date: 2015-05-22
* Version: 0.01
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.02 2015-05-26  Davide Dal Bianco   Verify
* =================================================================
* v0.01 2015-05-25  Moretto Alessandro  Creazione file
* =================================================================
*
*/

package it.kaizenteam.app.presenter;


import it.kaizenteam.app.Utils.Observable;

/**
 * TablePresenter is the interface TablePresenterImpl.
 */
public interface TablePresenter extends Presenter {
    /**
     * This method has the task of updating the data model if it receives an update of these ones and finally show in view these updated data.
     * @param observable
     * @param data
     */
    void update(Observable observable, Object... data);
    void setChart(String id);
}
