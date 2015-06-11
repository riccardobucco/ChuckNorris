package test.integration;

import junit.framework.TestCase;

import java.util.ArrayList;

import it.kaizenteam.app.model.NorrisChart.BarChartElementInPlaceUpdate;
import it.kaizenteam.app.model.NorrisChart.BarChartInPlaceUpdate;
import it.kaizenteam.app.model.NorrisChart.ChartImpl;
import it.kaizenteam.app.model.NorrisChart.ChartModel;
import it.kaizenteam.app.model.NorrisChart.LineChartElementInPlaceUpdate;
import it.kaizenteam.app.model.NorrisChart.LineChartElementStreamUpdate;
import it.kaizenteam.app.model.NorrisChart.LineChartInPlaceUpdate;
import it.kaizenteam.app.model.NorrisChart.LineChartStreamUpdate;
import it.kaizenteam.app.model.NorrisChart.MapChartDeleteUpdate;
import it.kaizenteam.app.model.NorrisChart.MapChartElementInPlaceUpdate;
import it.kaizenteam.app.model.NorrisChart.MapChartInPlaceUpdate;
import it.kaizenteam.app.model.NorrisChart.MapChartMovieUpdate;
import it.kaizenteam.app.model.NorrisChart.MapChartStreamUpdate;
import it.kaizenteam.app.model.NorrisChart.TableCellInPlaceUpdate;
import it.kaizenteam.app.model.NorrisChart.TableInPlaceUpdate;
import it.kaizenteam.app.model.NorrisChart.TableRow;
import it.kaizenteam.app.model.NorrisChart.TableStreamUpdate;

/**
 * Created by Moro on 11/06/15.
 */
public class TIApplicazioneModelNorrisChart extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
        ChartModel chartModel=null;
        chartModel= ChartImpl.create("barchart", "bc");
        chartModel.setData(null);
        assertNotNull(chartModel);
        chartModel.update("inplace", new BarChartInPlaceUpdate(new ArrayList<BarChartElementInPlaceUpdate>()));
        assertEquals(null, chartModel.getData());
        chartModel= ChartImpl.create("linechart","lc");
        assertNotNull(chartModel);
        chartModel.setData(null);
        chartModel.update("inplace", new LineChartInPlaceUpdate(new ArrayList<LineChartElementInPlaceUpdate>()));
        assertEquals(null, chartModel.getData());
        chartModel.update("stream", new LineChartStreamUpdate(new ArrayList<LineChartElementStreamUpdate>()));
        assertEquals(null, chartModel.getData());
        chartModel= ChartImpl.create("mapchart","mc");
        assertNotNull(chartModel);
        chartModel.setData(null);
        chartModel.update("inplace", new MapChartInPlaceUpdate(new ArrayList<MapChartElementInPlaceUpdate>()));
        assertEquals(null, chartModel.getData());
        chartModel.update("movie", new MapChartMovieUpdate(new MapChartInPlaceUpdate(null),new MapChartStreamUpdate(null),new MapChartDeleteUpdate(null)));
        assertEquals(null, chartModel.getData());
        chartModel= ChartImpl.create("table","t");
        assertNotNull(chartModel);
        chartModel.setData(null);
        chartModel.update("inplace", new TableInPlaceUpdate(new ArrayList<TableCellInPlaceUpdate>()));
        assertEquals(null, chartModel.getData());
        chartModel.update("stream",new TableStreamUpdate(new ArrayList<TableRow>()));
        assertEquals(null, chartModel.getData());



    }
}