package test.unit;

import junit.framework.TestCase;

import it.kaizenteam.app.presenter.LineChartPresenter;
import it.kaizenteam.app.presenter.Presenter;
import it.kaizenteam.app.presenter.PresenterImpl;

/**
 * Created by Moro on 11/06/15.
 */
public class TUApplicazioneLineChartPresenterImpl extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
        Presenter p = PresenterImpl.create(PresenterImpl.ChartType.LINECHART_TYPE,null);
        assertNotNull(p);
        ((LineChartPresenter)p).setChart("id");
    }
}