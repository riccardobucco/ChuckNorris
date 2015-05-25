package it.kaizenteam.app.presenter;

import java.util.Observable;

import it.kaizenteam.app.model.NorrisChart.ChartSettings;
import it.kaizenteam.app.view.BarChartView;

/**
 * Created by Moro on 19/05/15.
 */
public class BarChartPresenterImpl extends ChartPresenterImpl implements BarChartPresenter{
    static {
        //registro il tipo di grafico (DI)
        registerFactory(BARCHART_TYPE, BarChartPresenterFactory.getInstance());
    }

    /**
     *
     */
    private BarChartPresenterImpl(){
        //TODO richiesta socket e add observer e update start
    }

    /**
     *
     * @param observable
     * @param data
     */
    @Override
    public void update(Observable observable, Object data) {
        //TODO jsonparser mod model e renderchart e settings
        ((BarChartView)view).renderChart(null);
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
    protected static class BarChartPresenterFactory implements PresenterImpl.PresenterFactory {

        private static PresenterFactory instance;

        /**
         *
         * @return
         */
        private static PresenterFactory getInstance(){
            if(instance!=null)
                return instance;
            return new BarChartPresenterFactory();
        }

        /**
         *
         */
        private BarChartPresenterFactory(){
            instance=this;
        }

        /**
         *
         * @return
         */
        @Override
        public PresenterImpl createPresenter() {
            return new BarChartPresenterImpl();
        }
    }
}