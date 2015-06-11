/*
* Name: TUApplicazioneLineChartPresenterImpl.java
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

import it.kaizenteam.app.presenter.LineChartPresenter;
import it.kaizenteam.app.presenter.Presenter;
import it.kaizenteam.app.presenter.PresenterImpl;


public class TUApplicazioneLineChartPresenterImpl extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
        Presenter p = PresenterImpl.create(PresenterImpl.ChartType.LINECHART_TYPE,null);
        assertNotNull(p);
        ((LineChartPresenter)p).setChart("id");
    }
}