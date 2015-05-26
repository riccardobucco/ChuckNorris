/*
 * Name: {TUBarChartImpl.js}
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

var BarChartImpl = require('../../main/DataModel/NorrisChart/BarChartImpl.js');
var assert = require("assert");

describe('BarChartImpl', function(){
	describe('BarChartImpl(id:String)', function(){
		it('should memorize the right type of the chart',function(){
			var barchart = new BarChartImpl('randomID');
			assert.equal('barchart', barchart.type);
		});
		it('should memorize the right id of the chart',function(){
			var barchart = new BarChartImpl('randomID');
			assert.equal('randomID', barchart.uid);
		});
		it('should memorize some default values for the keys of the settings',function(){
			var barchart = new BarChartImpl('randomID');
			var defaults = {
				title : '',
				description : 'This is a bar chart.',
				xlabel : '',
				ylabel : '',
				showGrid : false,
				legendPosition : 'top-right',
				orientation : 'vertical',
				maxBars: 10,
				format : {
					barValueSpacing : 1,
					barDatasetSpacing : 5
				}
			};
			assert.deepEqual(defaults,barchart.settings);
		});
	})
});