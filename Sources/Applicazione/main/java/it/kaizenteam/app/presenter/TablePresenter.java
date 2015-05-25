package it.kaizenteam.app.presenter;

import java.util.Observable;

/**
 * Created by Moro on 19/05/15.
 */
public interface TablePresenter extends Presenter {
    /**
     *
     * @param observable
     * @param data
     */
    void update(Observable observable, Object data);
}
