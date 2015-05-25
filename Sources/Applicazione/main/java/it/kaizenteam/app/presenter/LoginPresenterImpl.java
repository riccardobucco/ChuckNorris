package it.kaizenteam.app.presenter;


import it.kaizenteam.app.model.NorrisSessionInfoImpl;
import it.kaizenteam.app.view.LoginView;

/**
 * Created by Moro on 19/05/15.
 */
public class LoginPresenterImpl extends PresenterImpl implements LoginPresenter{
    static {
        //registro il tipo di grafico (DI)
        registerFactory(LOGIN_TYPE, LoginPresenterFactory.getInstance());
    }

    /**
     *
     * @param addressNorris
     * @param login
     * @param password
     */
    @Override
    public void onLoginClick(String addressNorris, String login, String password) {
        //TODO use http...
        boolean accesso=true;
        if(accesso) {
            NorrisSessionInfoImpl.getInstance().setAddress(addressNorris);
            NorrisSessionInfoImpl.getInstance().login();
            ((LoginView) view).showListView();
        }
        else
            ((LoginView) view).showAuthenticationError();
    }

    /**
     *
     */
    private LoginPresenterImpl(){}

    /**
     *
     */
    protected static class LoginPresenterFactory implements PresenterImpl.PresenterFactory {

        private static PresenterFactory instance;

        /**
         *
         * @return
         */
        private static PresenterFactory getInstance(){
            if(instance!=null)
                return instance;
            return new LoginPresenterFactory();
        }

        /**
         *
         */
        private LoginPresenterFactory(){
            instance=this;
        }

        /**
         *
         * @return
         */
        @Override
        public PresenterImpl createPresenter() {
            return new LoginPresenterImpl();
        }
    }

}
