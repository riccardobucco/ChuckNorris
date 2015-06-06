/*
 * Name: TINorrisDataModel.js
 * Module: 
 * Location: Norris/test/integration
 * Date: 2015-05-25
 * Version: v0.01
 *
 * History:
 *
 * ================================================================================
 * Version Date Programmer Changes
 * ================================================================================
 * v0.01 2015-05-25 Bucco Riccardo Creation
 * ================================================================================
 */
var NorrisImpl = require('../../main/DataModel/NorrisImpl.js');

var assert = require("assert");

describe('Norris::DataModel',function(){
	var nrr = new NorrisImpl();

	var data1 = {
		labels: ['2010','2011','2012','2013'],
		datasets: [
	        {name: 'pippo', color : {r: 26, g: 254, b: 22}, values: [1,2,3,4]},
	        {name: 'pluto', color : {r: 253, g: 255, b: 21}, values: [5,6,7,8]},
	        {name: 'paperino', color : {r: 255, g: 24, b: 255}, values: [9,10,11,12]},
		]
	};
	var data2 = {
		labels: ['2010','2011','2012','2013'],
	    datasets: [
	        {name: 'milan', color : {r: 2, g: 251, b: 252}, values: [1,2,3,4]},
	        {name: 'inter', color : {r: 5, g: 250, b: 28}, values: [3,4,5,6]},
	        {name: 'juve', color : {r: 25, g: 7, b: 50}, values: [7,8,9,10]},
	    ]
	};

	var barchart1 = nrr.createChart('barchart','bar1');
	var linechart1 = nrr.createChart('linechart','line1');
	var linechart2 = nrr.createChart('linechart','line2');

	barchart1.setData(data1);
	linechart1.setData(data1);
	linechart2.setData(data2);

	var page1 = nrr.createPage('p1');
	var page2 = nrr.createPage('p2');

	page1.add(barchart1);
	page1.add(linechart2);
	page2.add(linechart1);
	page2.add(linechart2);
	page2.add(barchart1);

	it('should properly memorize charts',function(){
		assert.deepEqual(data1,barchart1.getData());
		assert.deepEqual(data1,linechart1.getData());
		assert.deepEqual(data2,linechart2.getData());
	});
	it('should properly memorize pages',function(){
		assert.deepEqual([barchart1,linechart2],page1.getCharts());
		assert.deepEqual([linechart1,linechart2,barchart1],page2.getCharts());
	});
	it('should return charts previously memorized without loosing data',function(){
		assert.deepEqual({'bar1':barchart1, 'line1': linechart1, 'line2': linechart2},nrr.charts);
	});
	it('should return pagess previously memorized without loosing data',function(){
		assert.deepEqual({'p1':page1, 'p2': page2},nrr.pages);
	});
});