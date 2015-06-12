/*
* Name: TUApplicazioneTablePresenterImpl.java
* Package: test.unit
* Location: Sources/Applicazione/test/unit
* Date: 2015-05-24
* Version: v0.01
*
* History:
* =================================================================
* Version   Date    Programmer  Changes
* =================================================================
* v0.01 2015-05-24  Dal Bianco Davide  Creation
* =================================================================
*
*/
package test.unit;

import junit.framework.TestCase;

import it.kaizenteam.app.presenter.Presenter;
import it.kaizenteam.app.presenter.PresenterImpl;
import it.kaizenteam.app.presenter.TablePresenter;


public class TUApplicazioneTablePresenterImpl extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
        Presenter p = PresenterImpl.create(PresenterImpl.ChartType.TABLE_TYPE,null);
        assertNotNull(p);
        ((TablePresenter)p).setChart("id");
    }
}