/*
* Name: TUApplicazioneListPresenterImpl.java
* Package: test.unit
* Location: Sources/Applicazione/test/unit
* Date: 2015-05-23
* Version: v0.01
*
* History:
* =================================================================
* Version   Date    Programmer  Changes
* =================================================================
* v0.01 2015-05-23  Dal Bianco Davide  Creation
* =================================================================
*
*/
package test.unit;

import junit.framework.TestCase;

import it.kaizenteam.app.presenter.ListPresenter;
import it.kaizenteam.app.presenter.Presenter;
import it.kaizenteam.app.presenter.PresenterImpl;


public class TUApplicazioneListPresenterImpl extends TestCase {
    Presenter p= PresenterImpl.create(PresenterImpl.ChartType.LIST_TYPE,null);
    public void testOnItemClicked() throws Exception {
        ((ListPresenter)p).onItemClicked("barchart","id");
        ((ListPresenter)p).onItemClicked("linechart","id");
        ((ListPresenter)p).onItemClicked("mapchart","id");
        ((ListPresenter)p).onItemClicked("table","id");
    }

    public void testOnLogoutClick() throws Exception {
        ((ListPresenter)p).onLogoutClick();
    }

    public void testOnResume() throws Exception {
        ((ListPresenter)p).onResume();
    }
}