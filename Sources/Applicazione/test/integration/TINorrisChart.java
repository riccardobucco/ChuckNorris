package it.kaizenteam.app.model.NorrisChart;

import junit.framework.TestCase;

import java.util.ArrayList;

/*
* Name: TINorrisChart.java
* Package: it.kaizenteam.app.model
* Location: Sources/Applicazione/test/unit
* Date: 2015-05-19
* Version: 0.02
*
* History:
* =================================================================
* Version	Date	Programmer	Changes
* =================================================================
* v0.02 2015-05-26  Moretto Alessandro   Verify
* =================================================================
* v0.01 2015-05-23  Davide Dal Bianco  Creazione file
* =================================================================
*
*/
public class TINorrisChart extends TestCase {
    public void testCreation(){
        ChartModel chart= ChartImpl.create("barchart","idchart");
        chart.setData(null);
        chart.update("inplace",new BarChartInPlaceUpdate(new ArrayList<BarChartElementInPlaceUpdate>()));
        assertEquals(null,chart.getData());
    }
}