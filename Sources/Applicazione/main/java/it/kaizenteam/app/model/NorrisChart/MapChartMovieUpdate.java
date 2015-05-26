/*
* Name: MapChartMovieUpdate.java
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
public class MapChartMovieUpdate implements ChartUpdate {
    /**
     * This attribute stores the update package InPlace on chart.
     */
    private MapChartInPlaceUpdate inPlace;

    /**
     * This attribute stores the update package Stream on chart.
     */
    private MapChartStreamUpdate stream;

    /**
     * This attribute stores the package with the data to be deleted from the chart.
     */
    private MapChartDeleteUpdate delete;

    /**
     * This method is the constructor to create the update package.
     * @param inPlace
     * @param stream
     * @param delete
     */
    public MapChartMovieUpdate(MapChartInPlaceUpdate inPlace, MapChartStreamUpdate stream, MapChartDeleteUpdate delete){
        this.inPlace=inPlace;
        this.stream=stream;
        this.delete=delete;
    }

    /**
     * This method is responsible for returning the update package InPlace on the chart.
     * @return the package update InPlace on the chart
     */
    public MapChartInPlaceUpdate getInPlaceData(){
        return inPlace;
    }

    /**
     * This method is responsible for returning the update package Stream on chart.
     * @return the package update Stream on chart
     */
    public MapChartStreamUpdate getStreamData(){
        return stream;
    }

    /**
     * This method is responsible for returning the package with the data to be deleted from the chart.
     * @return the package with the data to be deleted from the chart
     */
    public MapChartDeleteUpdate getDeleteData(){
        return delete;
    }
}
