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

describe('LineChartImpl', function(){

	beforeEach(module('chuck-chart'));
    beforeEach(module('norris-chartupdater'));
    
    var LineChartImpl;
    var linechart;
    
    beforeEach(inject(function($injector) {
        LineChartImpl = $injector.get( 'LineChartImpl');
        linechart = new LineChartImpl('randomID');
    }));
    
	describe('LineChartImpl(id: String)', function(){
	
		it('should memorize the right type of the chart',function(){
			expect(linechart.type).toEqual('linechart');
		});
		
		it('should memorize the right id of the chart',function(){
			expect(linechart.uid).toEqual('randomID');
		});
		
		it('should memorize some default values for the keys of the settings',function(){
			var linechart = new LineChartImpl('randomID');
			var defaults = {
				title: '',
				description : 'This is a line chart.',
				xlabel : '',
				ylabel : '',
				showGrid : false,
				legendPosition : 'top-right',
				maxPoints : 10,
				format : {
					pointDotRadius : 1 ,
					bezierCurve : true
				}
			};
		    expect(linechart.settings).toEqual(defaults);
	    });
	});
});
