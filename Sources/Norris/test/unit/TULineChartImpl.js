/*
 * Name: {TULineChartImpl.js}
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

var LineChartImpl = require('../../main/DataModel/NorrisChart/LineChartImpl.js');
var assert = require("assert");

describe('LineChartImpl', function(){
	describe('LineChartImpl(id: String)', function(){
		it('should memorize the right type of the chart',function(){
			var linechart = new LineChartImpl('randomID');
			assert.equal('linechart', linechart.type);
		});
		it('should memorize the right id of the chart',function(){
			var linechart = new LineChartImpl('randomID');
			assert.equal('randomID', linechart.uid);
		});
		it('should memorize some default values for the keys of the settings',function(){
			var linechart = new LineChartImpl('randomID');
			var defaults = {
				title: '',
				description : 'This is a line chart.',
				xlabel : '',
				ylabel : '',
				showGrid : false,
				showLegend : true,
				legendPosition : 'top-right',
				maxPoints : 10,
				format : {
					pointDotRadius : 1 ,
					bezierCurve : true
				}
			};
			assert.deepEqual(defaults,linechart.settings);
		});
	})
});