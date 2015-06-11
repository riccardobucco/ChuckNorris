/*
* Name: TIApplicazionePresenter.java
* Package: test.integration
* Location: Sources/Applicazione/test/integration
* Date: 2015-05-25
* Version: v0.01
*
* History:
* =================================================================
* Version   Date    Programmer  Changes
* =================================================================
* v0.01 2015-05-25  Dal Bianco Davide  Creation
* =================================================================
*
*/
package test.integration;

import junit.framework.TestCase;

import it.kaizenteam.app.presenter.BarChartPresenter;
import it.kaizenteam.app.presenter.LineChartPresenter;
import it.kaizenteam.app.presenter.ListPresenter;
import it.kaizenteam.app.presenter.LoginPresenter;
import it.kaizenteam.app.presenter.MapChartPresenter;
import it.kaizenteam.app.presenter.Presenter;
import it.kaizenteam.app.presenter.PresenterImpl;
import it.kaizenteam.app.presenter.TablePresenter;

/**
 * Created by Moro on 11/06/15.
 */
public class TIApplicazionePresenter extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
        Presenter p = null;
        p=PresenterImpl.create(PresenterImpl.ChartType.LOGIN_TYPE,null);
        ((LoginPresenter)p).onLoginClick("http://192.168.1.2:9000", "Kaizen", "Team");
        p=PresenterImpl.create(PresenterImpl.ChartType.LIST_TYPE,null);
        ((ListPresenter)p).onItemClicked("barchart","bc");
        ((ListPresenter)p).onItemClicked("linechart","lc");
        ((ListPresenter)p).onItemClicked("mapchart","mc");
        ((ListPresenter) p).onItemClicked("table", "t");
        p=PresenterImpl.create(PresenterImpl.ChartType.BARCHART_TYPE, null);
        ((BarChartPresenter)p).setChart("bc");
        p=PresenterImpl.create(PresenterImpl.ChartType.LINECHART_TYPE, null);
        ((LineChartPresenter)p).setChart("lc");
        p=PresenterImpl.create(PresenterImpl.ChartType.MAPCHART_TYPE,null);
        ((MapChartPresenter)p).setChart("mc");
        p=PresenterImpl.create(PresenterImpl.ChartType.TABLE_TYPE, null);
        ((TablePresenter)p).setChart("t");
    }
}