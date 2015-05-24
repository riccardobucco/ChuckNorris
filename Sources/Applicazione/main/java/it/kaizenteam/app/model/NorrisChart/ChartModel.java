package it.kaizenteam.app.model.NorrisChart;


/**
 * Created by Moro on 23/05/15.
 */
public interface ChartModel {
    public void setSettings(ChartSettings object);
    public void setData(ChartData object);
    public ChartSettings getSettings();
    public ChartData getData();
    public void update(String type, ChartUpdate object);
    public String getType();
}
