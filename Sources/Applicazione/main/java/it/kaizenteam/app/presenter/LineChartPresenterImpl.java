/*
* Name: LineChartPresenterImpl.java
* Package: it.kaizenteam.app.presenter
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/presenter
* Date: 2015-05-22
* Version: 0.01
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.02 2015-05-26  Moretto Alessandro   Verify
* =================================================================
* v0.01 2015-05-23  Davide Dal Bianco  Creazione file
* =================================================================
*
*/

package it.kaizenteam.app.presenter;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Observable;
import it.kaizenteam.app.model.NorrisChart.ChartData;
import it.kaizenteam.app.model.NorrisChart.ChartImpl;
import it.kaizenteam.app.model.NorrisChart.ChartSettings;
import it.kaizenteam.app.model.NorrisChart.ChartUpdate;
import it.kaizenteam.app.model.NorrisChart.LineChartSettingsImpl;
import it.kaizenteam.app.model.Service.ChartReceiverImpl;
import it.kaizenteam.app.view.LineChartActivity;
import it.kaizenteam.app.view.LineChartView;

/**
 * This class is the implementation of a presenter for line chart.
 */
public class LineChartPresenterImpl extends ChartPresenterImpl implements LineChartPresenter{

    static {
        //registro il tipo di grafico (DI)
        registerFactory(LINECHART_TYPE, LineChartPresenterFactory.getInstance());
    }

    /**
     * This method is the constructor. It is private because it can not be created an instance except from a request of his inner class factory.
     */
    private LineChartPresenterImpl() {
    }

    /**
     * This method has the task of updating the data model if it receives an update of these ones and finally show in view these updated data.
     * @param observable
     * @param data
     */
    @Override
    public void update(Observable observable, Object data) {
        if(((String[])data)[0].toString().equals("linechart")) {
            try {
                ChartData lineChartData = JSONParser.getInstance().parseLineChart(new JSONObject(((String[])data)[2].toString()));
                ChartSettings lineChartSettings = JSONParser.getInstance().parseLineChartSettings(new JSONObject(((String[])data)[1].toString()));
                chart= ChartImpl.create("linechart", id);
                chart.setData(lineChartData);
                chart.setSettings(lineChartSettings);
                ((LineChartActivity)view).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ((LineChartView) view).renderChart(chart.getData());
                        applySettings(chart.getSettings());
                    }
                });
            } catch (JSONException e) {}
        }
        else{
            try {
                if(((String[])data)[0].toString().equals("inplace")) {
                    ChartUpdate update;
                    update = JSONParser.getInstance().parseLineChartInPlaceUpdate(new JSONObject(((String[])data)[1].toString()));
                    chart.update("linechart:inplace", update);
                    ((LineChartActivity)view).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ((LineChartView) view).renderChart(chart.getData());
                        }
                    });
                }
                else
                    if(((String[])data)[0].toString().equals("stream")) {
                        ChartUpdate update;
                        update = JSONParser.getInstance().parseLineChartStreamUpdate(new JSONObject(((String[])data)[1].toString()));
                        chart.update("linechart:stream", update);
                        ((LineChartActivity)view).runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                ((LineChartView) view).renderChart(chart.getData());
                            }
                        });
                    }
            } catch (JSONException e) {}
        }
    }

    @Override
    public void setChart(String id) {
        ((Observable) ChartReceiverImpl.getInstance()).addObserver(this);
        this.id=id;
        ChartReceiverImpl.getInstance().getChart(id);
    }

    /**
     * This method has the task to change the view according to the settings of the chart.
     * @param settings
     */
    @Override
    protected void applySettings(ChartSettings settings) {
        if(((LineChartSettingsImpl) settings).getLegendPosition().equals("right"))
            ((LineChartActivity) view).setLegendPosition(2);
        //TODO more
        ((LineChartActivity) view).setCubicLines(((LineChartSettingsImpl) settings).getCubicCurves());
        //TODO ((LineChartActivity) view).setDottedLines(((LineChartSettingsImpl) settings).getDotted());
        ((LineChartActivity) view).setDotRadius(((LineChartSettingsImpl) settings).getDotRadius());
        ((LineChartActivity) view).showGrid(((LineChartSettingsImpl) settings).getGridVisibility());
        ((LineChartActivity) view).setAxisName(((LineChartSettingsImpl) settings).getXAxisName(), ((LineChartSettingsImpl) settings).getYAxisName());
        ((LineChartActivity) view).showGrid(((LineChartSettingsImpl) settings).getGridVisibility());
        ((LineChartActivity) view).setDescription(((LineChartSettingsImpl) settings).getDescription());
        ((LineChartActivity) view).setTitle(((LineChartSettingsImpl) settings).getTitle());
    }

    /**
     *  This class deals with the creation of a LineChartPresenterImpl presenter.
     */
    protected static class LineChartPresenterFactory implements PresenterImpl.PresenterFactory {
        /**
          * The static attribute is the unique instance of that class.
          */
        private static PresenterFactory instance;

	/**
         * This method has the task of returning the unique instance of the class, and creating it if it not exists.
         * @return the unique instance of the class
         */
        private static PresenterFactory getInstance(){
            if(instance!=null)
                return instance;
            return new LineChartPresenterFactory();
        }

        /**
         * This method is the constructor of the class. It is private because only getInstance() method can create an instance.
         */
        private LineChartPresenterFactory(){
            instance=this;
        }

        /**
         * This method has the task of creating the relative presenter. It can access its constructor because this factory class is inner to the related presenter class.
         * @return presenter
         */
        @Override
        public PresenterImpl createPresenter() {
            return new LineChartPresenterImpl();
        }
    }
}
