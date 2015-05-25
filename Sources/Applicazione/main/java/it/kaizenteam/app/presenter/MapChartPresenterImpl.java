package it.kaizenteam.app.presenter;

import java.util.Observable;

import it.kaizenteam.app.model.NorrisChart.ChartSettings;

/**
 * Created by Moro on 19/05/15.
 */
public class MapChartPresenterImpl extends ChartPresenterImpl implements MapChartPresenter{
    static {
        //registro il tipo di grafico (DI)
        registerFactory(MAPCHART_TYPE, MapChartPresenterFactory.getInstance());
    }

    /**
     *
     */
    private MapChartPresenterImpl(){}

    /**
     *
     * @param observable
     * @param data
     */
    @Override
    public void update(Observable observable, Object data) {
        //TODO
    }

    /**
     *
     * @param settings
     */
    @Override
    protected void applySettings(ChartSettings settings) {
        //TODO
    }

    /**
     *
     */
    protected static class MapChartPresenterFactory implements PresenterImpl.PresenterFactory {

        private static PresenterFactory instance;

        /**
         *
         * @return
         */
        private static PresenterFactory getInstance(){
            if(instance!=null)
                return instance;
            return new MapChartPresenterFactory();
        }

        /**
         *
         */
        private MapChartPresenterFactory(){
            instance=this;
        }

        /**
         *
         * @return
         */
        @Override
        public PresenterImpl createPresenter() {
            return new MapChartPresenterImpl();
        }
    }
}