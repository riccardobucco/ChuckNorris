package test.unit;

import junit.framework.TestCase;

import it.kaizenteam.app.presenter.LoginPresenter;
import it.kaizenteam.app.presenter.Presenter;
import it.kaizenteam.app.presenter.PresenterImpl;

/**
 * Created by Moro on 11/06/15.
 */
public class TUApplicazioneLoginPresenterImpl extends TestCase {

    public void testOnLoginClick() throws Exception {
        Presenter p= PresenterImpl.create(PresenterImpl.ChartType.LOGIN_TYPE,null);
        ((LoginPresenter) p).onLoginClick("http://192.168.1.2:9000","Kaizen","Team");
    }
}