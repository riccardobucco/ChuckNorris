/*
 * Name: {TINorrisDataModelNorrisChart.js}
 * Module: {}
 * Location: {Norris/test/integration}
 * Date: {2015-05-25}
 * Version: {v0.1}
 *
 * History:
 *
 * ================================================================================
 * Version Date Programmer Changes
 * ================================================================================
 * 0.01 2015-05-25 Riccardo Bucco {creation}
 * ================================================================================
 */

var BarChartImpl = require('../../main/DataModel/NorrisChart/BarChartImpl.js');
var LineChartImpl = require('../../main/DataModel/NorrisChart/LineChartImpl.js');
var MapChartImpl = require('../../main/DataModel/NorrisChart/MapChartImpl.js');
var TableImpl = require('../../main/DataModel/NorrisChart/TableImpl.js');

var assert = require("assert");

describe('Norris::DataModel::NorrisChart',function(){
	var barData = {
		labels: ['2010','2011','2012','2013'],
		datasets: [
	        {name: 'pippo', color : {r: 26, g: 254, b: 22}, values: [1,2,3,4]},
	        {name: 'pluto', color : {r: 253, g: 255, b: 21}, values: [5,6,7,8]},
	        {name: 'paperino', color : {r: 255, g: 24, b: 255}, values: [9,10,11,12]},
		]
	};
	var lineData = {
		labels: ['2010','2011','2012','2013'],
	    datasets: [
	        {name: 'milan', color : {r: 2, g: 251, b: 252}, values: [1,2,3,4]},
	        {name: 'inter', color : {r: 5, g: 250, b: 28}, values: [3,4,5,6]},
	        {name: 'juve', color : {r: 25, g: 7, b: 50}, values: [7,8,9,10]},
	    ]
	};
	var mapData = [
	    {name: 'uno', color : {r: 25, g: 255, b: 4}, values: [{x:1, y:1}, {x:2, y:2}, {x:6, y:7}, {x:10, y:1}]},
	    {name: 'due', color : {r: 205, g: 55, b: 60}, values: [{x:19, y:18}, {x:13, y:121}, {x:13, y:12}]},
	    {name: 'tre', color : {r: 105, g: 225, b: 27}, values: [{x:13, y:1}, {x:13, y:14}, {x:7, y:8}, {x:1, y:0}]}
	]
	var tabData = {
	    headers: ['anno','mese','giorno','ora'],
	    datasets: [
	        [ {color : {r: 25, g: 26, b: 27}, background : {r: 255, g: 255, b: 255}, value: 'due'},
	          {color : {r: 230, g: 29, b: 28}, background : {r: 255, g: 255, b: 255}, value: 'sette'},
	          {color : {r: 31, g: 25, b: 59}, background : {r: 255, g: 255, b: 255}, value: 'random'}
	        ],
	        [ {color : {r: 255, g: 255, b: 255}, background : {r: 255, g: 255, b: 255}, value: '12'},
	          {color : {r: 255, g: 255, b: 255}, background : {r: 255, g: 255, b: 255}, value: 'tre'},
	          {color : {r: 255, g: 255, b: 255}, background : {r: 255, g: 255, b: 255}, value: 'dieci'}
	        ]
	    ]
	};

	it('should properly memorize data and settings for a specified chart of a given type',function(){
		var barchart = new BarChartImpl('bar1');
		var linechart = new LineChartImpl('line1');
		var mapchart = new MapChartImpl('map1');
		var table = new TableImpl('tab1');
		
		barchart.setData(barData);
		linechart.setData(lineData);
		mapchart.setData(mapData);
		table.setData(tabData);

		assert.deepEqual(barData, barchart.getData());
		assert.deepEqual(lineData, linechart.getData());
		assert.deepEqual(mapData, mapchart.getData());
		assert.deepEqual(tabData, table.getData());
	});
	it('should properly update a specified chart with a given method',function(){
		var barchart = new BarChartImpl('bar1');
		var linechart = new LineChartImpl('line1');
		var mapchart = new MapChartImpl('map1');
		
		barchart.setData(barData);
		linechart.setData(lineData);
		mapchart.setData(mapData);

		barNewDataInPlace = [
 		   { position: {x:0, y:0}, value: 'foo1' },
 		   { position: {x:0, y:1}, value: 'foo2' }
 		];
		lineNewDataStream = [
		    {label: 'foo', data: [88,88,88]},
    		{label: 'bar', data: [99,99,99]}
 		];
		mapNewDataMovie = {
		    inplace : [
		        { position: {series:0, index:0}, data: {x:99, y:99} },
		        { position: {series:0, index:1}, data: {x:88, y:88} }
		    ],
		    stream: [
		        {name: 'pippo', color : {r: 255, g: 255, b: 255}, values: [{x:1, y:1}, {x:1, y:1}, {x:1, y:1}, {x:1, y:1}]},
		    ],
		    delete: [
		        {series:1, index:0},
		        {series:2, index:0},
		        {series:2, index:1}
		    ]
		};

		var barDataUpdatedInPlace = {
			labels: ['2010','2011','2012','2013'],
			datasets: [
		        {name: 'pippo', color : {r: 26, g: 254, b: 22}, values: ['foo1','foo2',3,4]},
		        {name: 'pluto', color : {r: 253, g: 255, b: 21}, values: [5,6,7,8]},
		        {name: 'paperino', color : {r: 255, g: 24, b: 255}, values: [9,10,11,12]},
			]
		};

		var lineDataUpdatedStream = {
			labels: ['2010','2011','2012','2013','foo','bar'],
		    datasets: [
		        {name: 'milan', color : {r: 2, g: 251, b: 252}, values: [1,2,3,4,88,99]},
		        {name: 'inter', color : {r: 5, g: 250, b: 28}, values: [3,4,5,6,88,99]},
		        {name: 'juve', color : {r: 25, g: 7, b: 50}, values: [7,8,9,10,88,99]},
		    ]
		};

		var mapDataUpdatedMovie = [
		    {name: 'uno', color : {r: 25, g: 255, b: 4}, values: [{x:99, y:99}, {x:88, y:88}, {x:6, y:7}, {x:10, y:1}]},
		    {name: 'due', color : {r: 205, g: 55, b: 60}, values: [{x:13, y:121}, {x:13, y:12}]},
		    {name: 'tre', color : {r: 105, g: 225, b: 27}, values: [{x:13, y:14}, {x:1, y:0}]},
		    {name: 'pippo', color : {r: 255, g: 255, b: 255}, values: [{x:1, y:1}, {x:1, y:1}, {x:1, y:1}, {x:1, y:1}]}
		];

		barchart.update('inplace', barNewDataInPlace);
		linechart.update('stream', lineNewDataStream);
		mapchart.update('movie', mapNewDataMovie);

		assert.deepEqual(barDataUpdatedInPlace, barchart.getData());
		assert.deepEqual(lineDataUpdatedStream, linechart.getData());
		assert.deepEqual(mapDataUpdatedMovie, mapchart.getData());
	});
});