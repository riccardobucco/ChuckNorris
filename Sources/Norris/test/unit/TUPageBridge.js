/*
 * Name: {TUPageBridge.js}
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
 * 0.01 2015-05-25 kaizenteam {creation}
 * ================================================================================
 */
var NorrisImpl = require('../../main/DataModel/NorrisImpl.js');
var PageImpl = require('../../main/DataModel/NorrisPage/PageImpl.js');
var PageBridge = require('../../main/InternalAPIManager/PageBridge.js');
var ChartBridge = require('../../main/InternalAPIManager/ChartBridge.js');
var assert = require("assert");

describe('PageBridge', function(){

    describe('add(chart : ChartImpl): PageBridge',function(){
		it('should add a chart to this page',function(){
			
		    var norris = new NorrisImpl();
			var chart = norris.createChart('barchart','randomid');
			var chartBridge = new ChartBridge(chart);
			var pageNorris = new PageImpl('randomid');
			var pageBridge = new PageBridge(pageNorris);
			
			pageBridge.add(chartBridge);
			assert.deepEqual(chart,pageBridge.page.charts[0]);
		});
	});

	describe('setSettings(settings: PageSettings): void',function(){
		it('should set the page settings',function(){
			var settings = {'title':'my page','maxChartsRow':'7','maxChartsCol':'4'};
			var page = new PageImpl('randomid');
			var pageBridge = new PageBridge(page);
			pageBridge.setSettings(settings);
			assert.deepEqual(settings,pageBridge.page.settings);
		});
	});
	
	describe('getId(): String',function(){
		it('should return the id of the page', function(){
			var page = new PageImpl('randomid');
			var pageBridge = new PageBridge(page);
			assert.equal('randomid',pageBridge.page.getId());
		});
	});
	
	describe('getSettings(): PageSettings',function(){
		it('should return the settings of the page', function(){
			var settings = {'title':'my page','maxChartsRow':'7','maxChartsCol':'4'};
			var page = new PageImpl('randomid');
			page.setSettings(settings);
			var pageBridge = new PageBridge(page);
			assert.deepEqual(settings,pageBridge.page.getSettings());
		});
	});
	
	describe('getCharts(): ChartImpl[]',function(){
		it('should return an array of charts in the page', function(){
			var norris = new NorrisImpl();
			var chart1 = norris.createChart('barchart','01');
			var chart2 = norris.createChart('linechart','02')
			var page = new PageImpl('randomid');
			page.add(chart1);
			page.add(chart2);
			var arrayChart = [chart1, chart2];
			var pageBridge = new PageBridge(page);
			assert.deepEqual(arrayChart, pageBridge.page.getCharts());
		});
	});
	
});