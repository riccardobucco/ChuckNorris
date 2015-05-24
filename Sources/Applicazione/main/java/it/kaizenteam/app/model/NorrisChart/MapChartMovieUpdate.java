package it.kaizenteam.app.model.NorrisChart;

/**
 * Created by Moro on 24/05/15.
 */
public class MapChartMovieUpdate implements ChartUpdate {
    private MapChartInPlaceUpdate inPlace;
    private MapChartStreamUpdate stream;
    private MapChartDeleteUpdate delete;

    public MapChartMovieUpdate(MapChartInPlaceUpdate inPlace, MapChartStreamUpdate stream, MapChartDeleteUpdate delete){
        this.inPlace=inPlace;
        this.stream=stream;
        this.delete=delete;
    }

    public MapChartInPlaceUpdate getInPlaceData(){
        return inPlace;
    }

    public MapChartStreamUpdate getStreamData(){
        return stream;
    }

    public MapChartDeleteUpdate getDeleteData(){
        return delete;
    }
}
