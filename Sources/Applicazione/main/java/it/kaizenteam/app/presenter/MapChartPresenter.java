/*
* Name: MapChartPresenter.java
* Package: it.kaizenteam.app.presenter
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/presenter
* Date: 2015-05-22
* Version: v0.02
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.02 2015-05-26  Moretto Alessandro   Verify
* =================================================================
* v0.01 2015-05-25  Davide Dal Bianco  Creation
* =================================================================
*
*/

package it.kaizenteam.app.presenter;

import java.util.Observable;

/**
 * This class create a LoginPresenterImpl presenter.
 */
public interface MapChartPresenter extends Presenter{
    /**
     * This method has the task of updating the data model in case of update and finally show in view these updated data.
     * @param observable
     * @param data
     */
    void update(Observable observable, Object data);
}
