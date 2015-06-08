/*
 * Name: TUChartRef.js
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
 * v0.01 2015-05-26 Bigarella Chiara Creation
 * ================================================================================
 */
 
var ChartRef = require('../../main/ExternalAPIManager/ChartRef.js');
var BarChartImpl = require('../../main/DataModel/NorrisChart/BarChartImpl.js');
var assert = require("assert");

describe('ChartRef(chart: ChartImpl)', function(){

    describe('getId() : String', function(){
        it('should get the right ID of the chart', function(){
            var barchart = new BarChartImpl('randomID');
            var chart = new ChartRef(barchart);
		    assert.equal('randomID', chart.getId());
        });
    });
    
    describe('getType() : String', function(){
        it('should get the right type of the chart', function(){
            var barchart = new BarChartImpl('randomID');
            var chart = new ChartRef(barchart);
		    assert.equal('barchart', chart.getType());
        });
    });
    
    describe('getData() : ChartData', function(){
        it('should get the right data of the chart', function(){
            var barchart = new BarChartImpl('randomID');
            barchart.setData({labels: ['2010','2011','2012','2013']});
            var chart = new ChartRef(barchart);
		    assert.deepEqual({labels: ['2010','2011','2012','2013']}, chart.getData());
        });
    });
    
    describe('getSettings() : ChartSettings', function(){
         it('should get the right settings of the chart', function(){
            var barchart = new BarChartImpl('randomID');
            var chart = new ChartRef(barchart);
	    var defaults = {
		    title : '',
	            description : 'This is a bar chart.',
	            xLabel : '',
	            yLabel : '',
		    style : {
			animationDuration : 1000,
			barArea : "60%", 
			showGrid : false,
		    },
	            legendPosition : 'right',
	            orientation : 'vertical'
	    };
	    assert.deepEqual(defaults, chart.getSettings() );
        });
    
    });
});
