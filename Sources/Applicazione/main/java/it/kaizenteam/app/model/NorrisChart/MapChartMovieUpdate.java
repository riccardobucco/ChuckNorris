package it.kaizenteam.app.model.NorrisChart;

/**
 * Created by Moro on 24/05/15.
 */
public class MapChartMovieUpdate implements ChartUpdate {
    private MapChartInPlaceUpdate inPlace;
    private MapChartStreamUpdate stream;
    private MapChartDeleteUpdate delete;

    /**
     *
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
     *
     * @return
     */
    public MapChartInPlaceUpdate getInPlaceData(){
        return inPlace;
    }

    /**
     *
     * @return
     */
    public MapChartStreamUpdate getStreamData(){
        return stream;
    }

    /**
     *
     * @return
     */
    public MapChartDeleteUpdate getDeleteData(){
        return delete;
    }
}
