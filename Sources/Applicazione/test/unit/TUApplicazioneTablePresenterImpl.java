package test.unit;

import junit.framework.TestCase;

import it.kaizenteam.app.presenter.Presenter;
import it.kaizenteam.app.presenter.PresenterImpl;
import it.kaizenteam.app.presenter.TablePresenter;

/**
 * Created by Moro on 11/06/15.
 */
public class TUApplicazioneTablePresenterImpl extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
        Presenter p = PresenterImpl.create(PresenterImpl.ChartType.TABLE_TYPE,null);
        assertNotNull(p);
        ((TablePresenter)p).setChart("id");
    }
}