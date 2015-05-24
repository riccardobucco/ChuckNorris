package it.kaizenteam.app.model.NorrisChart;

/**
 * Created by Moro on 24/05/15.
 */
public class LineChartElementInPlaceUpdate {
    private double value;
    private double xpos;
    private double ypos;

    public LineChartElementInPlaceUpdate(double xpos, double ypos, double value){
        this.xpos=xpos;
        this.ypos=ypos;
        this.value=value;
    }

    public double getData(){
        return value;
    }

    public double getX(){
        return xpos;
    }

    public double getY(){
        return ypos;
    }
}
