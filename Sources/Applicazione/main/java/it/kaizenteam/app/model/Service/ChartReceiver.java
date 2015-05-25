package it.kaizenteam.app.model.Service;

/**
 * Created by Moro on 23/05/15.
 */
public interface ChartReceiver {
    /**
     *
     * @param chartId
     */
    void startUpdateEvent(String chartId);

    /**
     *
     * @param chartId
     */
    void stopUpdateEvent(String chartId);

    /**
     *
     * @param chartId
     */
    void getChart(String chartId);
}
