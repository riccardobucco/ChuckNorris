/*
* Name: BaseActivity.java
* Package: it.kaizenteam.app.view
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/view
* Date: 19/05/2015
* Version: 0.01
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.01	2015-05-22	Alessandro Moretto	Creazione file
* =================================================================
*
*/

package it.kaizenteam.app.view;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;

import it.kaizenteam.app.presenter.Presenter;

/**
 * This class is the abstraction of an Activity. It contains the reference to the generic presenter that will be instantiated by the specializations of this class.
 */
public class BaseActivity extends ActionBarActivity implements View {
    protected Presenter presenter;
}
