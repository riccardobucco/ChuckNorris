package it.kaizenteam.app.model.NorrisChart;

/**
 * Created by Moro on 24/05/15.
 */
public class LineChartElementStreamUpdate {
    private double value;
    private String label;

    /**
     *
     * @param label
     * @param value
     */
    public LineChartElementStreamUpdate(String label, double value){
        this.label=label;
        this.value=value;
    }

    /**
     *
     * @return
     */
    public double getData(){
        return value;
    }

    /**
     *
     * @return
     */
    public String getLabel(){
        return label;
    }
}
