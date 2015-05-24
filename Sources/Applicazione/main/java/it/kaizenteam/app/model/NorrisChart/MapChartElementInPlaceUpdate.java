package it.kaizenteam.app.model.NorrisChart;

/**
 * Created by Moro on 24/05/15.
 */
public class MapChartElementInPlaceUpdate {
    private MapPoint value;
    private double x;
    private double y;
    private String id;
    private boolean useId;

    public MapChartElementInPlaceUpdate(MapPoint value, String id){
        this.value=value;
        this.id=id;
        useId=true;
    }

    public MapChartElementInPlaceUpdate(MapPoint value, double x, double y){
        this.value=value;
        this.x=x;
        this.y=y;
        useId=false;
    }

    public MapPoint getData(){
        return value;
    }

    public double getX() throws Exception {
        if(!useId)
            return x;
        throw new Exception("Impossible to use. Use getId().");
    }

    public double getY() throws Exception {
        if(!useId)
            return y;
        throw new Exception("Impossible to use. Use getId().");
    }

    public String getId() throws Exception {
        if(useId)
            return id;
        throw new Exception("Impossible to use. Use getX() and getY().");
    }
}
