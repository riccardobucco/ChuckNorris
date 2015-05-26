/*
 * Name: {TULineChartInPlaceUpdater.js}
 * Module: {}
 * Location: {Norris/test/unit}
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

var LineChartInPlaceUpdater = require('../../main/DataModel/NorrisChart/LineChartInPlaceUpdater.js');
var assert = require("assert");

describe('LineChartInPlaceUpdater', function(){

	describe('update(chart: ChartImpl, updateData: ChartUpdate): void', function(){
		it('should reject chart without data',function(){
			var chart = {data: {}};
			chart.getData = function() {return this.data;};
			chart.setData = function(data) {this.data = data;};
			var newData = [
			    { position: {x:0, y:0}, value: 'foo' },
			    { position: {x:0, y:1}, value: 'foo' }
			]
			assert.throws(function () {(new LineChartInPlaceUpdater()).update(chart, newData)});
		});
		it('should update a given linechart with the inplace method',function(){
			var chart = {
				data: {
    				headers: ['uno','due','tre'],
    				datasets: [
				        [ {value: '1'}, {value: '2'}, {value: '3'} ],
				        [ {value: '4'}, {value: '5'}, {value: '6'} ]
				    ]
 				}
			};
			chart.getData = function() {return this.data;};
			chart.setData = function(par) {this.data = par;};
			var newData = [
        		[ {value: '9999'}, {value: '8888'}, {value: '7777'} ],
        		[ {value: '6666'}, {value: '5555'}, {value: '4444'} ]
    		];
			var updatedData = {
				headers: ['uno','due','tre'],
				datasets: [
			        [ {value: '1'}, {value: '2'}, {value: '3'} ],
			        [ {value: '4'}, {value: '5'}, {value: '6'} ],
			        [ {value: '9999'}, {value: '8888'}, {value: '7777'} ],
        			[ {value: '6666'}, {value: '5555'}, {value: '4444'} ]
			    ]
			};
			(new LineChartInPlaceUpdater()).update(chart, newData);
			assert.deepEqual(updatedData, chart.data);
		});
	});
});