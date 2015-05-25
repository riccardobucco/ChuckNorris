package it.kaizenteam.app.presenter;

/**
 * Created by Moro on 19/05/15.
 */
public interface LoginPresenter extends Presenter{
    /**
     *
     * @param addressNorris
     * @param login
     * @param password
     */
    void onLoginClick(String addressNorris, String login, String password);
}
