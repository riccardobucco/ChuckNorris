/*
 * Name: TSChartRef.js
 * Module: 
 * Location: Norris/test/strength
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

var assert = require("assert");
var ChartRef = require('../../main/ExternalAPIManager/ChartRef.js');

describe('ChartRef',function(){
	describe('ChartRef(chart: ChartImpl): void',function(){
		it('should refuse the creation of a ChartRef because it is not indicated an NorrisChart as parameter',function(){
			
			var chart = { description: 'this object would be a norris chart' };
			
			assert.throws(function(){new ChartRef(chart)});
		});
	});

});
