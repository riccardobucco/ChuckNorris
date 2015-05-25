/*
 * Name: {TUMapChartImpl.js}
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

var MapChartImpl = require('../../main/DataModel/NorrisChart/MapChartImpl.js');
var assert = require("assert");

describe('MapChartImpl(id: String)', function(){
	describe('MapChartImpl()', function(){
		it('should memorize the right type of the chart',function(){
			var mapchart = new MapChartImpl('randomID');
			assert.equal('mapchart', mapchart.type);
		});
		it('should memorize the right id of the chart',function(){
			var mapchart = new MapChartImpl('randomID');
			assert.equal('randomID', mapchart.uid);
		});
		it('should memorize some default values for the keys of the settings',function(){
			var mapchart = new MapChartImpl('randomID');
			var defaults = {
				title: '',
				description: 'This is a map chart',
				showLegend : true,
				legendPosition : 'top-right',
				maxPoints : 5
			};
			assert.deepEqual(defaults,mapchart.settings);
		});
	})
});