/*
* Name: TUApplicazioneChartPresenterImpl.java
* Package: test.unit
* Location: Sources/Applicazione/test/unit
* Date: 2015-05-23
* Version: v1.00
*
* History:
* =================================================================
* Version Date Programmer Changes
* =================================================================
* v1.00 2015-06-15 Carlon Chiara Approved
* =================================================================
* v0.02 2015-06-03 Moretto Alessandro Verify
* =================================================================
* v0.01 2015-05-23  Dal Bianco Davide  Creation
* =================================================================
*
*/
package test.unit;

import junit.framework.TestCase;

import it.kaizenteam.app.presenter.BarChartPresenter;
import it.kaizenteam.app.presenter.Presenter;
import it.kaizenteam.app.presenter.PresenterImpl;


public class TUApplicazioneChartPresenterImpl extends TestCase {

    public void testApplySettings() throws Exception {
        assertNotNull(PresenterImpl.create(PresenterImpl.ChartType.BARCHART_TYPE, null));
        assertNotNull(PresenterImpl.create(PresenterImpl.ChartType.LINECHART_TYPE, null));
        assertNotNull(PresenterImpl.create(PresenterImpl.ChartType.LIST_TYPE,null));
        assertNotNull(PresenterImpl.create(PresenterImpl.ChartType.LOGIN_TYPE,null));
        assertNotNull(PresenterImpl.create(PresenterImpl.ChartType.MAPCHART_TYPE,null));
        assertNotNull(PresenterImpl.create(PresenterImpl.ChartType.TABLE_TYPE,null));
    }

    public void testOnPause() throws Exception {
        Presenter a =PresenterImpl.create(PresenterImpl.ChartType.BARCHART_TYPE, null);
        ((BarChartPresenter)a).onPause();
        Presenter b =PresenterImpl.create(PresenterImpl.ChartType.LINECHART_TYPE, null);
        ((BarChartPresenter)b).onPause();
        Presenter c =PresenterImpl.create(PresenterImpl.ChartType.LIST_TYPE, null);
        ((BarChartPresenter)c).onPause();
        Presenter d =PresenterImpl.create(PresenterImpl.ChartType.LOGIN_TYPE, null);
        ((BarChartPresenter)d).onPause();
        Presenter e =PresenterImpl.create(PresenterImpl.ChartType.MAPCHART_TYPE, null);
        ((BarChartPresenter)e).onPause();
        Presenter f =PresenterImpl.create(PresenterImpl.ChartType.TABLE_TYPE, null);
        ((BarChartPresenter)f).onPause();
    }

    public void testSetChart() throws Exception {
        Presenter a =PresenterImpl.create(PresenterImpl.ChartType.BARCHART_TYPE, null);
        ((BarChartPresenter)a).setChart("dvcwec");
        Presenter b =PresenterImpl.create(PresenterImpl.ChartType.LINECHART_TYPE, null);
        ((BarChartPresenter)b).setChart("dvcwec");
        Presenter c =PresenterImpl.create(PresenterImpl.ChartType.LIST_TYPE, null);
        ((BarChartPresenter)c).setChart("dvcwec");
        Presenter d =PresenterImpl.create(PresenterImpl.ChartType.LOGIN_TYPE, null);
        ((BarChartPresenter)d).setChart("dvcwec");
        Presenter e =PresenterImpl.create(PresenterImpl.ChartType.MAPCHART_TYPE, null);
        ((BarChartPresenter)e).setChart("dvcwec");
        Presenter f =PresenterImpl.create(PresenterImpl.ChartType.TABLE_TYPE, null);
        ((BarChartPresenter)f).setChart("dvcwec");
    }
}