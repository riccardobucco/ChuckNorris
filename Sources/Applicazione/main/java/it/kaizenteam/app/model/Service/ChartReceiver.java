package it.kaizenteam.app.model.Service;

/**
 * Created by Moro on 23/05/15.
 */
public interface ChartReceiver {
    void startUpdateEvent(String chartId);
    void stopUpdateEvent(String chartId);
    void getChart(String chartId);
}
