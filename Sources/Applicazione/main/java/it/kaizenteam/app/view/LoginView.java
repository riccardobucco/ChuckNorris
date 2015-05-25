package it.kaizenteam.app.view;

/**
 * Created by Moro on 23/05/15.
 */
public interface LoginView extends View {
    /**
     *
     */
    void showAuthenticationError();

    /**
     *
     */
    void showListView();

    /**
     *
     * @param show
     */
    void showProgress(boolean show);

    /**
     *
     * @param view
     */
    void onLoginClick(android.view.View view);
}
