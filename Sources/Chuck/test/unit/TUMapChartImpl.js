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
 * 0.01 2015-05-25 Bigarella Chiara {creation}
 * ================================================================================
 */

describe('MapChartImpl', function() {
    beforeEach(module('chuck-chart'));
    beforeEach(module('norris-chartupdater'));
    
    var MapChartImpl;
    var mapchart;
    
    beforeEach(inject(function($injector) {
        MapChartImpl = $injector.get( 'MapChartImpl');
        mapchart= new MapChartImpl('randomID');
    }));
    
	describe('MapChartImpl(id:String)', function(){
		it('should memorize the right type of the chart',function(){
			expect(mapchart.type).toEqual('mapchart');
		});
		
		it('should memorize the right id of the chart',function(){
			expect(mapchart.uid).toEqual('randomID');
		});
		
		it('should memorize some default values for the keys of the settings',function(){
			var defaults = {
				title: '',
				description: 'This is a map chart',
				legendPosition : 'top-right',
				maxPoints : 5
			};
		    expect(mapchart.settings).toEqual(defaults);
		});
		
    });
		
});
