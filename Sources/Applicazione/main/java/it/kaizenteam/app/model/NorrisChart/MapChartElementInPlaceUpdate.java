/*
* Name: MapChartElementInPlaceUpdate.java
* Package: it.kaizenteam.app.model.NorrisChart
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/model/NorrisChart
* Date: 24/05/2015
* Version: 0.01
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.01	2015-05-24	Alessandro Moretto	Creazione file
* =================================================================
*
*/

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

    /**
     *
     * @param value
     * @param id
     */
    public MapChartElementInPlaceUpdate(MapPoint value, String id){
        this.value=value;
        this.id=id;
        useId=true;
    }

    /**
     *
     * @param value
     * @param x
     * @param y
     */
    public MapChartElementInPlaceUpdate(MapPoint value, double x, double y){
        this.value=value;
        this.x=x;
        this.y=y;
        useId=false;
    }

    /**
     *
     * @return
     */
    public MapPoint getData(){
        return value;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public double getX() throws Exception {
        if(!useId)
            return x;
        throw new Exception("Impossible to use. Use getId().");
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public double getY() throws Exception {
        if(!useId)
            return y;
        throw new Exception("Impossible to use. Use getId().");
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public String getId() throws Exception {
        if(useId)
            return id;
        throw new Exception("Impossible to use. Use getX() and getY().");
    }
}
