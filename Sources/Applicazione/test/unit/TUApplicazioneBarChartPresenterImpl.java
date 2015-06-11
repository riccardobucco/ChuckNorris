package test.unit;

import junit.framework.TestCase;

import it.kaizenteam.app.presenter.BarChartPresenter;
import it.kaizenteam.app.presenter.Presenter;
import it.kaizenteam.app.presenter.PresenterImpl;

/**
 * Created by Moro on 11/06/15.
 */
public class TUApplicazioneBarChartPresenterImpl extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
        Presenter p = PresenterImpl.create(PresenterImpl.ChartType.BARCHART_TYPE,null);
        assertNotNull(p);
        ((BarChartPresenter)p).setChart("id");
    }
}