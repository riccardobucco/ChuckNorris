/*
* Name: TUApplicazioneJSONParser.java
* Package: test.unit
* Location: Sources/Applicazione/test/unit
* Date: 2015-05-23
* Version: v0.01
*
* History:
* =================================================================
* Version   Date    Programmer  Changes
* =================================================================
* v0.01 2015-05-23  Moretto Alessandro  Creation
* =================================================================
*
*/
package test.unit;

import junit.framework.TestCase;

import org.json.JSONObject;

import it.kaizenteam.app.model.NorrisChart.ChartData;
import it.kaizenteam.app.model.NorrisChart.ChartSettings;
import it.kaizenteam.app.model.NorrisChart.ChartUpdate;
import it.kaizenteam.app.presenter.JSONParser;


public class TUApplicazioneJSONParser extends TestCase {
    JSONParser j=null;
    public void testGetInstance() throws Exception {
        j=JSONParser.getInstance();
        assertNotNull(j);
    }

    public void testParseBarChart() throws Exception {
        ChartData c=j.parseBarChart(new JSONObject("{\n" +
                "    labels: ['2010','2011','2012','2013'], // asse indipendente\n" +
                "    datasets: [\n" +
                "        {name: 'pippo', color : '#aaaaaa', values: [1,2,3,4]}, // serie1\n" +
                "        {name: 'pluto', color : '#bbbbbb' , values: [1,2,3,4]}, // serie2\n" +
                "        {name: 'paperino', color : '#cccccc' , values: [1,2,3,4]}, // serie3\n" +
                "    ]\n" +
                "}"));
        assertNotNull(c);
    }

    public void testParseLineChart() throws Exception {

        ChartData c=j.parseLineChart(new JSONObject("{\n" +
                "    labels: ['2010','2011','2012','2013'], // asse indipendente\n" +
                "    datasets: [\n" +
                "        {name: 'pippo', color : {r: 255, g: 255, b: 255}, values: [1,2,3,4]}, // linea1\n" +
                "        {name: 'pluto', color : {r: 255, g: 255, b: 255}, values: [1,2,3,4]}, // linea2\n" +
                "        {name: 'paperino', color : {r: 255, g: 255, b: 255}, values: [1,2,3,4]}, // linea3\n" +
                "    ]\n" +
                " }"));
        assertNotNull(c);
    }

    public void testParseMapChart() throws Exception {

        ChartData c=j.parseMapChart(new JSONObject("{datasets: [\n" +
                "    {name: 'pippo', marker: '', color : '#FF00FF', values: [{x:1, y:1}, {x:1, y:1}, {x:1, y:1}, {x:1, y:1}]}, // serie1\n" +
                "    {name: 'pluto', marker: '', color : '#FF0000', values: [{x:1, y:1}, {x:1, y:1}, {x:1, y:1}, {x:1, y:1}]}, // serie2\n" +
                "    {name: 'paperino', marker: '', color : '#0000FF', values: [{x:1, y:1}, {x:1, y:1}, {x:1, y:1}, {x:1, y:1}]} // serie3\n" +
                " ]}"));
        assertNotNull(c);
    }

    public void testParseTable() throws Exception {

        ChartData c=j.parseTable(new JSONObject("{\n" +
                "    headers: ['anno','mese','giorno'], // intestazioni colonne\n" +
                "    datasets: [\n" +
                "        { row: [ \n" +
                "            {color : '#000000', background : '#fffffff', value: '1'},\n" +
                "            {color : '#000000', background : '#fffffff', value: '1'},\n" +
                "            {color : '#000000', background : '#fffffff', value: '1'}\n" +
                "        ]}, // riga1\n" +
                "        { row: [ \n" +
                "            {color : '#000000', background : '#fffffff', value: '1'},\n" +
                "            {color : '#000000', background : '#fffffff', value: '1'},\n" +
                "            {color : '#000000', background : '#fffffff', value: '1'}\n" +
                "        ]} // riga2\n" +
                "    ]\n" +
                " }"));
        assertNotNull(c);
    }

    public void testParseTableSettings() throws Exception {
        ChartSettings s=j.parseTableSettings(new JSONObject("{}"));
        assertNotNull(s);
    }

    public void testParseLineChartSettings() throws Exception {
        ChartSettings s=j.parseLineChartSettings(new JSONObject("{}"));
        assertNotNull(s);
    }

    public void testParseBarChartSettings() throws Exception {
        ChartSettings s=j.parseBarChartSettings(new JSONObject("{}"));
        assertNotNull(s);
    }

    public void testParseMapChartSettings() throws Exception {
        ChartSettings s=j.parseMapChartSettings(new JSONObject("{}"));
        assertNotNull(s);
    }

    public void testParseTableStreamUpdate() throws Exception {
        ChartUpdate u=j.parseTableStreamUpdate(new JSONObject("{\n" +
                "    stream: [\n" +
                "        { row: [ \n" +
                "            {color : '#000000', background : '#fffffff', value: '1'},\n" +
                "            {color : '#000000', background : '#fffffff', value: '1'},\n" +
                "            {color : '#000000', background : '#fffffff', value: '1'}\n" +
                "        ]}, // riga1\n" +
                "        { row: [ \n" +
                "            {color : '#000000', background : '#fffffff', value: '1'},\n" +
                "            {color : '#000000', background : '#fffffff', value: '1'},\n" +
                "            {color : '#000000', background : '#fffffff', value: '1'}\n" +
                "        ]} // riga2\n" +
                "    ] // aggiungo 2 righe nella posizione indicata nelle impostazioni (in testa o in coda)\n" +
                "}"));
        assertNotNull(u);
    }

    public void testParseTableInPlaceUpdate() throws Exception {
        ChartUpdate u=j.parseTableInPlaceUpdate(new JSONObject("{\n" +
                "    inplace: [\n" +
                "        { position: {x:0, y:0}, data: {color: '#000000', background: '#fffffff', value:'1'} },\n" +
                "        { position: {x:0, y:1}, data: {color: '#000000', background: '#fffffff', value:'1'} }\n" +
                "    ] // modifico 2 valori già esistenti\n" +
                " }"));
        assertNotNull(u);
    }

    public void testParseMapChartInPlaceUpdate() throws Exception {
        ChartUpdate u=j.parseTableInPlaceUpdate(new JSONObject("{\n" +
                "    inplace = [\n" +
                "        { position: {series:0, index:0}, data: {x:1, y:1} },\n" +
                "        { position: {series:0, index:1}, data: {x:1, y:1} }\n" +
                "    ] // modifico 2 valori già esistenti\n" +
                " }"));
        assertNotNull(u);
    }

    public void testParseMapChartMovieUpdate() throws Exception {
        ChartUpdate u=j.parseMapChartMovieUpdate(new JSONObject("{\n" +
                "    inplace : [\n" +
                "        { position: {series:0, index:0}, data: {x:1, y:1} },\n" +
                "        { position: {series:0, index:1}, data: {x:2, y:2} }\n" +
                "    ], // modifico 2 valori già esistenti\n" +
                "    stream: [\n" +
                "        {series : 1, data : {x: 1, y: 2} },\n" +
                "        {series : 3, data: {x: 1, y: 3} }\n" +
                "    ],\n" +
                "    delete: [\n" +
                "        {series:0, index:0},\n" +
                "        {series:0, index:1},\n" +
                "        {series:0, index:3}\n" +
                "    ] // elimino 3 punti\n" +
                " }"));
        assertNotNull(u);
    }

    public void testParseLineChartStreamUpdate() throws Exception {
        ChartUpdate u=j.parseLineChartStreamUpdate(new JSONObject("{\n" +
                "    stream: [\n" +
                "        {label: 'foo', data: [1,2,3,4,5]},\n" +
                "        {label: 'bar', data: [1,2,3,4,5]}\n" +
                "    ] // aggiungo 2 valori indipendenti con i rispettivi valori dipendenti per ogni linea\n" +
                " }"));
        assertNotNull(u);
    }

    public void testParseLineChartInPlaceUpdate() throws Exception {
        ChartUpdate u=j.parseLineChartInPlaceUpdate(new JSONObject("{\n" +
                "    inplace = [\n" +
                "        { position: {x:0, y:0}, data='0' },\n" +
                "        { position: {x:0, y:1}, data='1' }\n" +
                "    ] // modifico 2 valori già esistenti\n" +
                " }"));
        assertNotNull(u);
    }

    public void testParseBarChartInPlaceUpdate() throws Exception {
        ChartUpdate u=j.parseBarChartInPlaceUpdate(new JSONObject("{\n" +
                "    inplace: [\n" +
                "        { position: {x:0, y:0}, data='0' },\n" +
                "        { position: {x:0, y:1}, data='1' }\n" +
                "    ] // modifico 2 valori già esistenti\n" +
                "}"));
        assertNotNull(u);
    }
}