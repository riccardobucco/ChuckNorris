/*
* Name: LoginPresenterImpl.java
* Package: it.kaizenteam.app.presenter
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/presenter
* Date: 2015-05-22
* Version: v0.02
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.02 2015-05-26  Moretto Alessandro   Verify
* =================================================================
* v0.01 2015-05-23  Davide Dal Bianco  Creazione file
* =================================================================
*
*/

package it.kaizenteam.app.presenter;


import it.kaizenteam.app.model.NorrisSessionInfoImpl;
import it.kaizenteam.app.view.LoginView;

/**
 * This class represents the specialization of PresenterImpl.
 * It has the aims to change the view of the home. Its task is to ask HttpRequesterWithCookie the access to an instance of Norris through login.
 */
public class LoginPresenterImpl extends PresenterImpl implements LoginPresenter{
    static {
        //registro il tipo di grafico (DI)
        registerFactory(LOGIN_TYPE, LoginPresenterFactory.getInstance());
    }

    /**
     * This method handles the gesture of a user click on the button in the login view. It will attempt to login by placing the signal waiting on view and if this has success shows the view with the list of chart otherwise appears on view an error message.
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
     * This method is the constructor. It is private because it can not be created an instance except from a request of his inner class factory.
     */
    private LoginPresenterImpl(){}

    /**
     *  This class deals with the creation of a LoginPresenterImpl presenter.
     */
    protected static class LoginPresenterFactory implements PresenterImpl.PresenterFactory {

        /**
          * The static attribute is the unique instance of that class.
          */
        private static PresenterFactory instance;

        /**
         * This method has the task of returning the unique instance of the class, and creating it if it not exists.
         * @return the unique instance of the class
         */
        private static PresenterFactory getInstance(){
            if(instance!=null)
                return instance;
            return new LoginPresenterFactory();
        }

        /**
         * This method is the constructor of the class. It is private because only getInstance() method can create an instance.
         */
        private LoginPresenterFactory(){
            instance=this;
        }

        /**
         * This method has the task of creating the relative presenter. It can access its constructor because this factory class is inner to the related presenter class.
         * @return presenter
         */
        @Override
        public PresenterImpl createPresenter() {
            return new LoginPresenterImpl();
        }
    }

}
