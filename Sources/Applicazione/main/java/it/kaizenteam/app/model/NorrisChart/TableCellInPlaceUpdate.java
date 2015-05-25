package it.kaizenteam.app.model.NorrisChart;

/**
 * Created by Moro on 24/05/15.
 */
public class TableCellInPlaceUpdate {
    private double xpos;
    private double ypos;
    private String value;

    /**
     *
     * @param xpos
     * @param ypos
     * @param value
     */
    public TableCellInPlaceUpdate(double xpos, double ypos, String value){
        this.xpos=xpos;
        this.ypos=ypos;
        this.value=value;
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

    /**
     *
     * @return
     */
    public String getData(){
        return value;
    }
}
