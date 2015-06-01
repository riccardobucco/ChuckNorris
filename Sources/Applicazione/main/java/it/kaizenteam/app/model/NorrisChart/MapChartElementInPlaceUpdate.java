/*
* Name: MapChartElementInPlaceUpdate.java
* Package: it.kaizenteam.app.model.NorrisChart
* Location: Sources/Applicazione/main/java/it/kaizenteam/app/model/NorrisChart
* Date: 2015-05-16
* Version: v0.02
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.02 2015-05-26  Moretto Alessandro   Verify
* =================================================================
* v0.01 2015-05-22  Davide Dal Bianco  Creazione file
* =================================================================
*
*/

package it.kaizenteam.app.model.NorrisChart;

/**
 * This class represents an element of the update package in place of a map chart.
 */
public class MapChartElementInPlaceUpdate {
    /**
     * This attribute represents the values of the given date.
     */
    private MapPoint value;

    /**
     * This attribute is the abscissa in the map of the data to be replaced.
     */
    private double x;

    /**
     * This attribute is the ordinate in the map of the data to be replaced.
     */
    private double y;

    /**
     * This attribute is the id of the data to be replaced.
     */
    private String id;

    /**
     * 
     */
    private boolean useId;

    /**
     * This method is a constructor to create the update package.
     * @param value new data of update package
     * @param id of the point to be modified
     */
    public MapChartElementInPlaceUpdate(MapPoint value, String id){
        this.value=value;
        this.id=id;
        useId=true;
    }

    /**
     * This method is a constructor to create the update package.
     * @param value new data of update package
     * @param x position of point
     * @param y position of point
     */
    public MapChartElementInPlaceUpdate(MapPoint value, double x, double y){
        this.value=value;
        this.x=x;
        this.y=y;
        useId=false;
    }

    /**
     * This method is responsible for returning the new data of the update package.
     * @return new data of the update package
     */
    public MapPoint getData(){
        return value;
    }

    /**
     * This method is responsible for returning the position in mapchart of the point to edit.
     * @return x-coordinate of point to edit
     * @throws Exception
     */
    public double getX() throws Exception {
        if(!useId)
            return x;
        throw new Exception("Impossible to use. Use getId().");
    }

    /**
     * This method is responsible for returning the position in mapchart of the point to edit.
     * @return y-coordinate of point to edit
     * @throws Exception
     */
    public double getY() throws Exception {
        if(!useId)
            return y;
        throw new Exception("Impossible to use. Use getId().");
    }

    /**
     * This method is responsible for returning the id of the point to edit.
     * @return id of the point to be point to edit
     * @throws Exception
     */
    public String getId() throws Exception {
        if(useId)
            return id;
        throw new Exception("Impossible to use. Use getX() and getY().");
    }
}
