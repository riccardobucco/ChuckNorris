package it.kaizenteam.app.presenter;

import java.util.Observable;

import it.kaizenteam.app.model.NorrisChart.ChartSettings;

/**
 * Created by Moro on 19/05/15.
 */
public class TablePresenterImpl extends ChartPresenterImpl implements TablePresenter{
    static {
        //registro il tipo di grafico (DI)
        registerFactory(TABLE_TYPE, TablePresenterFactory.getInstance());
    }

    @Override
    public void update(Observable observable, Object data) {
        //TODO
    }

    @Override
    protected void applySettings(ChartSettings settings) {
        //TODO
    }

    private TablePresenterImpl(){}

    protected static class TablePresenterFactory implements PresenterImpl.PresenterFactory {

        private static PresenterFactory instance;

        private static PresenterFactory getInstance(){
            if(instance!=null)
                return instance;
            return new TablePresenterFactory();
        }

        private TablePresenterFactory(){
            instance=this;
        }

        @Override
        public PresenterImpl createPresenter() {
            return new TablePresenterImpl();
        }
    }
}