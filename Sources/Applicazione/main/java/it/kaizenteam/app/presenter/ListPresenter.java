/*
* Name: ListPresenter.java
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

/**
 * ListPresenter is the interface of ListPresenterImpl.
 */
public interface ListPresenter extends Presenter{
    /**
     * This method is invoked by pressing a list item. It will ask the display of chartActivity specification of the chart represented in the item.
     * @param type
     * @param id
     */
    void onItemClicked(String type,String id);

    /**
     * This method is invoked when you press the button to logout in view. It will carry out of the session (through HttpRequesterWithCookie).
     */
    void onLogoutClick();

    /**
     * This method is invoked in response to an event in the view, or the display of Activity with the list of chart. Its task is to get the list (through
HttpRequesterWithCookie) and change the view with those values.
     */
    void onResume();
}
