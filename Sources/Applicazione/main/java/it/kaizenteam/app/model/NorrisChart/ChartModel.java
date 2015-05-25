package it.kaizenteam.app.model.NorrisChart;


/**
 * Created by Moro on 23/05/15.
 */
public interface ChartModel {
    /**
     *
     * @param object
     */
    public void setSettings(ChartSettings object);

    /**
     *
     * @param object
     */
    public void setData(ChartData object);

    /**
     *
     * @return
     */
    public ChartSettings getSettings();

    /**
     *
     * @return
     */
    public ChartData getData();

    /**
     *
     * @param type
     * @param object
     */
    public void update(String type, ChartUpdate object);

    /**
     *
     * @return
     */
    public String getType();
}
