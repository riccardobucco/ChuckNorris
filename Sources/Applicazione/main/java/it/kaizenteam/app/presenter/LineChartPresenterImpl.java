package it.kaizenteam.app.presenter;

import java.util.Observable;

import it.kaizenteam.app.model.NorrisChart.ChartSettings;
import it.kaizenteam.app.view.LineChartView;

/**
 * Created by Moro on 19/05/15.
 */
public class LineChartPresenterImpl extends ChartPresenterImpl implements LineChartPresenter{

    static {
        //registro il tipo di grafico (DI)
        registerFactory(LINECHART_TYPE, LineChartPresenterFactory.getInstance());
    }

    private LineChartPresenterImpl() {
    //TODO richiesta socket e add observer e update start
    }

    @Override
    public void update(Observable observable, Object data) {
        //TODO jsonparser mod model e renderchart e settings


        ((LineChartView)view).renderChart(null);
    }

    @Override
    protected void applySettings(ChartSettings settings) {
        //TODO
    }

    protected static class LineChartPresenterFactory implements PresenterImpl.PresenterFactory {

        private static PresenterFactory instance;

        private static PresenterFactory getInstance(){
            if(instance!=null)
                return instance;
            return new LineChartPresenterFactory();
        }

        private LineChartPresenterFactory(){
            instance=this;
        }

        @Override
        public PresenterImpl createPresenter() {
            return new LineChartPresenterImpl();
        }
    }
}