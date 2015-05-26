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
 * 0.01 2015-05-25 Bigarella Chiara {creation}
 * ================================================================================
 */

describe('BarChartImpl', function() {
    beforeEach(module('chuck-chart'));
    beforeEach(module('norris-chartupdater'));
    
    
    var barchart;
    var BarChartImpl;
    
    beforeEach(inject(function($injector) {
        BarChartImpl = $injector.get( 'BarChartImpl');
        barchart= new BarChartImpl('randomID');
    }));
    
	describe('BarChartImpl(id:String)', function(){
	
		it('should memorize the right type of the chart',function(){
			expect(barchart.type).toEqual('barchart');
		});
		
		it('should memorize the right id of the chart',function(){
			expect(barchart.uid).toEqual('randomID');
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
			expect(barchart.settings).toEqual(defaults);
		});
    });		
});
