package it.kaizenteam.app.presenter;

import java.util.Observable;

/**
 * Created by Moro on 19/05/15.
 */
public interface LineChartPresenter extends Presenter {
    void update(Observable observable, Object data);
}