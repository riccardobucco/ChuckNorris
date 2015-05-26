/*
 * Name: {TUTableImpl.js}
 * Module: {}
 * Location: {Norris/test/unit}
 * Date: {2015-05-26}
 * Version: {v0.1}
 *
 * History:
 *
 * ================================================================================
 * Version Date Programmer Changes
 * ================================================================================
 * 0.01 2015-05-26 Bigarella Chiara {creation}
 * ================================================================================
 */

describe('TableImpl', function() {
    beforeEach(module('chuck-chart'));
    beforeEach(module('norris-chartupdater'));
    
    var TableImpl;
    var table;
    
    beforeEach(inject(function($injector) {
        TableImpl = $injector.get( 'TableImpl');
        table= new TableImpl('randomID');
    }));
    
	describe('TableImpl(id:String)', function(){
		it('should memorize the right type of the chart',function(){
			expect(table.type).toEqual('table');
		});
		
		it('should memorize the right id of the chart',function(){
			expect(table.uid).toEqual('randomID');
		});
		
		it('should memorize some default values for the keys of the settings',function(){
			var defaults = {
				title: '',
				description: 'This is a table.',
				maxRows : 10 ,
				showTableGrid : true ,
				newLinePosition : 'bottom'
			};
		    expect(table.settings).toEqual(defaults);
		});
		
    });
		
});
