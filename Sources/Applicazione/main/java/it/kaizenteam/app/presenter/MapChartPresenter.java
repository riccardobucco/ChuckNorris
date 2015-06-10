/*
* Name: MapChartPresenter.java
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
* v0.01 2015-05-25  Davide Dal Bianco  Creazione file
* =================================================================
*
*/

package it.kaizenteam.app.presenter;


/**
 * This class create a LoginPresenterImpl presenter.
 */
public interface MapChartPresenter extends Presenter{

    /**
     * This methods ask to Norris the chart data, start the updates events and ask the renderization to the view
     * @param id id of the chart
     */
    void setChart(String id);

    /**
     * execute the code when the activity go to pause state
     */
    void onPause();
}
