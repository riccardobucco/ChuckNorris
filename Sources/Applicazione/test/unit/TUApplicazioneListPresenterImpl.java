package test.unit;

import junit.framework.TestCase;

import it.kaizenteam.app.presenter.ListPresenter;
import it.kaizenteam.app.presenter.Presenter;
import it.kaizenteam.app.presenter.PresenterImpl;

/**
 * Created by Moro on 11/06/15.
 */
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