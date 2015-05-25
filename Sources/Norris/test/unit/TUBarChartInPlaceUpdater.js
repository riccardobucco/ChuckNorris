/*
 * Name: {TUBarChartInPlaceUpdater.js}
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

var BarChartInPlaceUpdater = require('../../main/DataModel/NorrisChart/BarChartInPlaceUpdater.js');
var assert = require("assert");

describe('BarChartInPlaceUpdater(id: String)', function(){

	/*describe('getInstance(): BarChartInPlaceUpdater', function(){
		it('should return the static instance attribute', function(){
			assert.equal(BarChartInPlaceUpdater.getInstance(), BarChartInPlaceUpdater.instance);
		});
	});*/
	describe('update(chart: ChartImpl, updateData: ChartUpdate): void', function(){
		it('should reject chart without data',function(){
			var chart = {data: {}};
			chart.getData = function() {return this.data;};
			chart.setData = function(data) {this.data = data;};
			var newData = [
			    { position: {x:0, y:0}, value: 'foo' },
			    { position: {x:0, y:1}, value: 'foo' }
			]
			assert.throws(function () {(new BarChartInPlaceUpdater()).update(chart, newData)});
		});
		it('should update a given barchart with the inplace method',function(){
			var chart = {
				data: {
				    datasets: [
				        {values: [1,2,3,4]},
				        {values: [1,2,3,4]},
				        {values: [1,2,3,4]}
				    ]
				}
			};
			chart.getData = function() {return this.data;};
			chart.setData = function(par) {this.data = par;};
			var newData = [
			    { position: {x:0, y:0}, value: 'foo' },
			    { position: {x:0, y:1}, value: 'foo' }
			];
			var updatedData = {
				datasets: [
			        {values: ['foo','foo',3,4]},
			        {values: [1,2,3,4]},
			        {values: [1,2,3,4]}
				]
			};
			(new BarChartInPlaceUpdater()).update(chart, newData);
			assert.deepEqual(updatedData, chart.data);
		});
	});
});