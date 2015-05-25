/*
 * Name: {TUChartImpl.js}
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
var ChartImpl = require('../../main/DataModel/NorrisChart/ChartImpl.js');
var assert = require("assert");
var _ = require('lodash');

describe('ChartImpl', function(){

	describe('registerFactory(chartType: String, factory: ChartFactory): void',function(){

	});

	describe('registerUpdater(updateType: String, updater: ChartUpdater): void',function(){
		
	});

	describe('createChart(chartType: String, chartId: String): ChartImpl',function(){
		
	});

	describe('ChartImpl(chartType: String, chartId: String)', function(){
		it('should memorize the right type of the chart',function(){
			assert.equal('barchart', (new ChartImpl('barchart','randomID')).type);
		});
		it('should memorize the right id of the chart',function(){
			assert.equal('randomID', (new ChartImpl('barchart','randomID')).uid);
		});
		it('should memorize an empty title for the chart',function(){
			assert.equal('', (new ChartImpl('barchart','randomID')).settings.title);
		});
		it('should memorize "This is a chart." as a description for the chart',function(){
			assert.equal('This is a chart.', (new ChartImpl('barchart','randomID')).settings.description);
		});
		it('should memorize no data',function(){
			assert.equal(0, Object.keys(new ChartImpl('barchart','randomID').data).length);
		});
	});

	describe('getId(): String', function(){
		it('should return the ID of the chart', function(){
			assert.equal('randomID', (new ChartImpl('barchart','randomID')).getId());
		});
	});

	describe('getType(): String', function(){
		it('should return the type of the chart', function(){
			assert.equal('linechart', (new ChartImpl('linechart','0123')).getType());
			assert.equal('barchart', (new ChartImpl('barchart','3210')).getType());
			assert.equal('mapchart', (new ChartImpl('mapchart','0132')).getType());
			assert.equal('table', (new ChartImpl('table','2301')).getType());
		});
	});

	describe('setData(data: ChartData): void', function(){
		it('should set "data" parameter as data object in the chart', function(){
			var data = {'randomKey1':'randomValue1', 'randomKey2':'randomValue2'};
			var chart = new ChartImpl('linechart','randomID');
			chart.setData(data);
			assert.equal(true, _.isEqual(data, chart.data));
		});
	});

	describe('getData(): ChartData', function(){
		it('should return the data object of the chart',function(){
			var chart = new ChartImpl('linechart','randomID');
			chart.data = {'randomKey1':'randomValue1', 'randomKey2':'randomValue2'};
			assert.equal(true, _.isEqual(chart.data,chart.getData()));
		});
	});

	describe('setSettings(settings: ChartSettings): void', function(){
		it('should set "settings" parameter as settings object in the chart (keys different from "title" and "description" are ignored)', function(){
			var settings = {'randomKey1':'randomValue1', 'randomKey2':'randomValue2'};
			var chart = new ChartImpl('linechart','randomID');
			chart.setSettings(settings);
			assert.equal(false, _.isEqual(settings, chart.settings));
			settings = {'title':'randomTitle', 'description':'randomDescription'};
			chart.setSettings(settings);
			assert.equal(true, _.isEqual(settings, chart.settings));
		});
	});

	describe('getSettings(): ChartSettings', function(){
		it('should return the settings object of the chart',function(){
			var settings = {'randomKey1':'randomValue1', 'randomKey2':'randomValue2'};
			var chart = new ChartImpl('linechart','randomID');
			chart.settings = settings;
			assert.equal(true, _.isEqual(chart.settings, chart.getSettings()));
		})
	});

	describe('update(updateType: String, updateData: ChartUpdate): void', function(){

	});

});