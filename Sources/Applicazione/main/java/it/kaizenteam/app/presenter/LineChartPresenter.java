/*
* Name: BarChartPresenter.java
* Package: it.kaizenteam.app.presenter
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/presenter
* Date: 2015-05-23
* Version: v0.02
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.02 2015-05-26  Moretto Alessandro   Verify
* =================================================================
* v0.01 2015-05-23  Dal Bianco Davide  Creation
* =================================================================
*
*/

package it.kaizenteam.app.presenter;


/**
 * LineChartPresenter is the interface LineChartPresenterImpl
 */
public interface LineChartPresenter extends Presenter {

    void setChart(String id);

    /**
     * execute the code when the activity go to pause state
     */
    void onPause();
}
