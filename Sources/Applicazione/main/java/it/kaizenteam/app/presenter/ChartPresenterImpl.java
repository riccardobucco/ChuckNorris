package it.kaizenteam.app.presenter;

import java.util.Observable;
import java.util.Observer;

import it.kaizenteam.app.model.NorrisChart.ChartSettings;

/**
 * Created by Moro on 19/05/15.
 */
public abstract class ChartPresenterImpl extends PresenterImpl implements Observer {

    protected ChartPresenterImpl(){}

    @Override
    public abstract void update(Observable observable, Object data);

    protected abstract void applySettings(ChartSettings settings);

}