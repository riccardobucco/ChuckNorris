/*
 * Name: {TUTableImpl.js}
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

var TableImpl = require('../../main/DataModel/NorrisChart/TableImpl.js');
var assert = require("assert");

describe('TableImpl', function(){
	describe('TableImpl(id: String)', function(){
		it('should memorize the right type of the chart',function(){
			var table = new TableImpl('randomID');
			assert.equal('table', table.type);
		});
		it('should memorize the right id of the chart',function(){
			var table = new TableImpl('randomID');
			assert.equal('randomID', table.uid);
		});
		it('should memorize some default values for the keys of the settings',function(){
			var table = new TableImpl('randomID');
			var defaults = {
				title: '',
				description : 'This is a table.',
				maxRows : 10 ,
				showTableGrid : true ,
				newLinePosition : 'bottom'
			};
			assert.deepEqual(defaults,table.settings);
		});
	})
});