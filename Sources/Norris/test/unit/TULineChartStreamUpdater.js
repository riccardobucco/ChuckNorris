/*
 * Name: TULineChartStreamUpdater.js
 * Module: 
 * Location: Norris/test/unit
 * Date: 2015-05-26
 * Version: v0.01
 *
 * History:
 *
 * ================================================================================
 * Version Date Programmer Changes
 * ================================================================================
 * v0.01 2015-05-26 Bucco Riccardo Creation
 * ================================================================================
 */

var LineChartStreamUpdater = require('../../main/DataModel/NorrisChart/LineChartStreamUpdater.js');
var assert = require("assert");

describe('LineChartStreamUpdater', function(){

	describe('update(chart: ChartImpl, updateData: ChartUpdate): void', function(){
		it('should not accept a chart without data',function(){
			var chart = {
				data: {},
				settings: {
					maxPoints: 10
				}
			};
			chart.getData = function() {return this.data;};
			chart.setData = function(data) {this.data = data;};
			chart.getSettings = function() {return this.settings;};
			var newData = [
			    {label: 'foo', data: [1,2,3,4,5]},
    			{label: 'bar', data: [1,2,3,4,5]}
			];
			assert.throws(function () {(new LineChartStreamUpdater()).update(chart, newData)});
		});
		it('should reject an update whose data length is different from datasets length of the chart',function(){
			var chart = {
				data: {
    				labels: ['2010','2011','2012','2013'],
    				datasets: [
        				{name: 'pippo', color : {r: 255, g: 255, b: 255}, values: [1,2,3,4]},
        				{name: 'pluto', color : {r: 255, g: 255, b: 255}, values: [1,2,3,4]},
        				{name: 'paperino', color : {r: 255, g: 255, b: 255}, values: [1,2,3,4]}
    				]
 				},
 				settings: {
					maxPoints: 10
				}
			};
			chart.getData = function() {return this.data;};
			chart.setData = function(par) {this.data = par;};
			chart.getSettings = function() {return this.settings;};
			var newData = { stream:[
			    {label: 'foo', data: [1,2,3,4,5]},
			    {label: 'bar', data: [1,2,3,4,5]}
			]};
			assert.throws(function () {(new LineChartStreamUpdater()).update(chart, newData)});
		});
		it('should update a given chart with the stream method', function(){
			var chart = {
				data: {
    				labels: ['2010','2011','2012','2013'],
    				datasets: [
        				{values: [1,2,3,4]},
        				{values: [1,2,3,4]},
        				{values: [1,2,3,4]}
    				]
 				},
 				settings: {
					maxPoints: 10
				}
			};
			chart.getData = function() {return this.data;};
			chart.setData = function(par) {this.data = par;};
			chart.getSettings = function() {return this.settings;};
			var newData = { stream: [
			    {label: 'foo', data: [777,888,999]},
			    {label: 'bar', data: [111,222,333]}
			]};
			var updatedData = {
				labels: ['2010','2011','2012','2013', 'foo', 'bar'],
				datasets: [
    				{values: [1,2,3,4,777,111]},
    				{values: [1,2,3,4,888,222]},
    				{values: [1,2,3,4,999,333]}
				]
 			};
			(new LineChartStreamUpdater()).update(chart, newData);
			assert.deepEqual(updatedData, chart.data);
		});
	});
	
});