/*
* Name: BarChartPresenter.java
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
* v0.01 2015-05-25  Davide Dal Bianco  Creazione file
* =================================================================
*
*/

package it.kaizenteam.app.presenter;

import org.json.JSONException;
import org.json.JSONObject;

import it.kaizenteam.app.Utils.Observable;
import it.kaizenteam.app.model.NorrisChart.BarChartSettingsImpl;
import it.kaizenteam.app.model.NorrisChart.ChartData;
import it.kaizenteam.app.model.NorrisChart.ChartImpl;
import it.kaizenteam.app.model.NorrisChart.ChartSettings;
import it.kaizenteam.app.model.NorrisChart.ChartUpdate;
import it.kaizenteam.app.model.Service.ChartReceiverImpl;
import it.kaizenteam.app.view.BarChartActivity;
import it.kaizenteam.app.view.BarChartView;

/**
 * This class is the implementation of a presenter for bar chart.
 */
public class BarChartPresenterImpl extends ChartPresenterImpl implements BarChartPresenter{
    static {
        // register the type of graph (DI)
        registerFactory(BARCHART_TYPE, BarChartPresenterFactory.getInstance());
    }
    /**
     * This method is the constructor. It is private because it can not be created an instance except from a request of his inner class factory.
     */
    private BarChartPresenterImpl(){

    }

    /**
     * This method has the task of updating the data model if it receives an update of these ones and finally show in view these updated data.
     * @param observable
     * @param data
     */
    @Override
    public void update(Observable observable, Object... data) {
        if(data[0].toString().equals("barchart")) {
            try {
                ChartData barChartData = JSONParser.getInstance().parseBarChart(new JSONObject(data[2].toString()));
                ChartSettings barChartSettings = JSONParser.getInstance().parseBarChartSettings(new JSONObject(data[1].toString()));
                chart= ChartImpl.create("barchart", id);
                chart.setData(barChartData);
                chart.setSettings(barChartSettings);
                ((BarChartActivity)view).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ((BarChartView) view).renderChart(chart.getData());
                        applySettings(chart.getSettings());
                    }
                });
            } catch (JSONException e) {}
        }
        else{
            try {
                if(data[0].toString().equals("inplace")) {
                    ChartUpdate update;
                    update = JSONParser.getInstance().parseBarChartInPlaceUpdate(new JSONObject(data[1].toString()));
                    chart.update("barchart:inplace", update);
                    ((BarChartActivity)view).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ((BarChartView) view).renderChart(chart.getData());
                        }
                    });
                }
            } catch (JSONException e) {}
        }
    }

    @Override
    public void setChart(String id) {
        ((Observable)ChartReceiverImpl.getInstance()).attach(this);
        this.id=id;
        ChartReceiverImpl.getInstance().getChart(id);
    }

    /**
     * This method has the task to change the view according to the settings of the chart.
     * @param settings
     */
    @Override
    protected void applySettings(ChartSettings settings) {
        ((BarChartActivity) view).setDescription(((BarChartSettingsImpl) settings).getDescription());
        ((BarChartActivity) view).setAxisName(((BarChartSettingsImpl) settings).getXAxisName(), ((BarChartSettingsImpl) settings).getYAxisName());
        ((BarChartActivity) view).setBarDataSetSpacing(((BarChartSettingsImpl) settings).getBarDataSetSpacing());
        ((BarChartActivity) view).setBarValueSpacing(((BarChartSettingsImpl) settings).getBarValueSpacing());
        ((BarChartActivity) view).showGrid(((BarChartSettingsImpl) settings).getGridVisibility());
        if(((BarChartSettingsImpl) settings).getLegendPosition().equals("left"))
            ((BarChartActivity) view).setLegendPosition(0);
        //TODO more ...
        ((BarChartActivity) view).setOrientation(((BarChartSettingsImpl) settings).getOrientation());
        ((BarChartActivity) view).setTitle(((BarChartSettingsImpl) settings).getTitle());
    }

    /**
     *  This class deals with the creation of a BarChartPresenterImpl presenter.
     */
    protected static class BarChartPresenterFactory implements PresenterImpl.PresenterFactory {

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
            return new BarChartPresenterFactory();
        }

        /**
         * This method is the constructor of the class. It is private because only getInstance() method can create an instance.
         */
        private BarChartPresenterFactory(){
            instance=this;
        }

        /**
         * This method has the task of creating the relative presenter. It can access its constructor because this factory class is inner to the related presenter class.
         * @return presenter
         */
        @Override
        public PresenterImpl createPresenter() {
            return new BarChartPresenterImpl();
        }
    }
}
