/*
 * Name: {TableImpl.js}
 * Module: {}
 * Location: {Norris/Main/DataModel}
 * Date: {2015-05-04}
 * Version: {v0.1}
 *
 * History:
 *
 * ================================================================================
 * 0.06 2015-05-21 Bigarella Chiara   Verify
 * ================================================================================
 * 0.05 2015-04-25 Dal Bianco Davide   Edit
 * ================================================================================
 * Version Date Programmer Changes
 * ================================================================================
 * 0.04 2015-04-27 Bigarella Chiara   Verify
 * ================================================================================
 * 0.03 2015-04-25 Bucco Riccardo   Edit
 * ================================================================================
 * 0.02 2015-04-14 Carlon Chiara   Verify
 * ================================================================================
 * 0.01 2015-04-10 Pavanello Fabio Matteo   Creation
 * ================================================================================
 */

var ChartImpl = require('./ChartImpl.js');
var TableInPlaceUpdater = require('./TableInPlaceUpdater.js');
var TableStreamUpdater = require('./TableStreamUpdater.js');

// module.exports = TableImpl;

var defaults = {
	description : 'This is a table.',
	maxRows : 10 ,
	showTableGrid : true ,
	newLinePosition : 'bottom'
};

/**
 * Creates a new table.
 * @constructor
 * @param {String} id - the table's id.
 */
function TableImpl (id) {
	if (!(this instanceof TableImpl)) return new TableImpl(uid);
	ChartImpl.call(this, 'table',id);
	for(var key in defaults) {
		this.settings[key] = defaults[key];
	}
}

TableImpl.prototype.__proto__ = ChartImpl.prototype;

/* TableFactory ------------------------------------------------------- */

/**
 * Creates a new table factory.
 * @constructor
 */
function TableFactory() {
	if(!(this instanceof TableFactory)) return new TableFactory();
}

TableFactory.prototype.instance=new TableFactory(); // static

/**
 * Gets the TableFactory's instance.
 * @returns {TableFactory} the factory's instance.
 */
TableFactory.getInstance = function() { // static
	return TableFactory.prototype.instance;
};

/**
 * Creates a new table.
 * @param {String} id - the table's id;
 * @returns {BarChartImpl} - the created table.
 */
TableFactory.prototype.createChart = function (id) {
	return new TableImpl(id);
};

//Dependency injection:
ChartImpl.registerFactory('table' , TableFactory.getInstance());
ChartImpl.registerUpdater('table:inplace', TableInPlaceUpdater.getInstance() );
ChartImpl.registerUpdater('table:stream', TableStreamUpdater.getInstance() );

