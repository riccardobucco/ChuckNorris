package test.unit;

import junit.framework.TestCase;

import it.kaizenteam.app.presenter.MapChartPresenter;
import it.kaizenteam.app.presenter.Presenter;
import it.kaizenteam.app.presenter.PresenterImpl;

/**
 * Created by Moro on 11/06/15.
 */
public class TUApplicazioneMapChartPresenterImpl extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
        Presenter p = PresenterImpl.create(PresenterImpl.ChartType.MAPCHART_TYPE, null);
        assertNotNull(p);
        ((MapChartPresenter)p).setChart("id");
    }
}