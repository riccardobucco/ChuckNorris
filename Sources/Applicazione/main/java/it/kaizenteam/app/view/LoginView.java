/*
* Name: LoginView.java
* Package: it.kaizenteam.app.view
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/view
* Date: 2015-05-24
* Version: 0.01
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.01	2015-05-24	Kaizen Team	Creazione file
* =================================================================
*
*/

package it.kaizenteam.app.view;

/**
 * This interface has the task of allowing the use of methods to change the view from the outside of the package to login View (therefore from a LoginPresenterImpl).
 */
public interface LoginView extends View {
    /**
     * This method shows the view of the message authentication failure.
     */
    void showAuthenticationError();

    /**
     * This method starts the activity in which it will present the list of the instance of the Norris chart.
     */
    void showListView();

    /**
     * This method displays the view of a waiting signal if the parameter is true and hides otherwise.
     * @param show display / hide the view of a waiting signal
     */
    void showProgress(boolean show);

    /**
     * This method is called automatically by Android when the button is clicked login. It will notify its presenter have pressed.
     * @param view
     */
    void onLoginClick(android.view.View view);
}
