package it.kaizenteam.app.presenter;

/**
 * Created by Moro on 19/05/15.
 */
public interface ListPresenter extends Presenter{
    void onItemClicked(String type,String id);
    void onLogoutClick();
    void onResume();
}
