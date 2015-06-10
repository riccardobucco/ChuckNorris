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


/**
 * TablePresenter is the interface TablePresenterImpl.
 */
public interface TablePresenter extends Presenter {

    void setChart(String id);

    /**
     * execute the code when the activity go to pause state
     */
    void onPause();
}
