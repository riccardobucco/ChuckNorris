package it.kaizenteam.app.model.NorrisChart;

/**
 * Created by Moro on 24/05/15.
 */
public class BarChartElementInPlaceUpdate {
    private double value;
    private double xpos;
    private double ypos;

    /**
     *
     * @param xpos
     * @param ypos
     * @param value
     */
    public BarChartElementInPlaceUpdate(double xpos, double ypos, double value){
        this.xpos=xpos;
        this.ypos=ypos;
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
    public double getX(){
        return xpos;
    }

    /**
     *
     * @return
     */
    public double getY(){
        return ypos;
    }
}
