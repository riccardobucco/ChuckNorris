/*
* Name: TUApplicazioneLoginPresenterImpl.java
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
* v0.02 2015-06-01 Moretto Alessandro Verify
* =================================================================
* v0.01 2015-05-23  Dal Bianco Davide  Creation
* =================================================================
*
*/
package test.unit;

import junit.framework.TestCase;

import it.kaizenteam.app.presenter.LoginPresenter;
import it.kaizenteam.app.presenter.Presenter;
import it.kaizenteam.app.presenter.PresenterImpl;


public class TUApplicazioneLoginPresenterImpl extends TestCase {

    public void testOnLoginClick() throws Exception {
        Presenter p= PresenterImpl.create(PresenterImpl.ChartType.LOGIN_TYPE,null);
        ((LoginPresenter) p).onLoginClick("http://192.168.1.2:9000","Kaizen","Team");
    }
}