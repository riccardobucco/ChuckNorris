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
 * Version Date Programmer Changes
 * ================================================================================
 * 0.1 2015-05-04 Chiara Bigarella {creation}
 * ================================================================================
 */

var ChartImpl = require('./ChartImpl.js');
var TableInPlaceUpdater = require('./TableInPlaceUpdater.js');
var TableStreamUpdater = require('./TableStreamUpdater.js');

// module.exports = TableImpl;

var defaults = {
	title : '' ,
	description : 'This is a table.',
	showLegend : true,
	legendPosition : 'top-right',
	maxPoints : 5
};

function TableImpl (uid) {
	if (!(this instanceof TableImpl)) return new TableImpl(uid);
	ChartImpl.call(this, 'table',uid);
	this.setSettings(defaults);
}

TableImpl.prototype.__proto__ = ChartImpl.prototype;

/* TableFactory ------------------------------------------------------- */

function TableFactory() {
	if(!(this instanceof TableFactory)) return new TableFactory();
}

TableFactory.prototype.instance=new TableFactory(); // static

TableFactory.getInstance = function() { // static
	return TableFactory.prototype.instance;
};

TableFactory.prototype.createChart = function (id) {
	return new TableImpl(id);
};

//Dependency injection:
ChartImpl.registerFactory('table' , TableFactory.getInstance());
ChartImpl.registerUpdater('table:inplace', TableInPlaceUpdater.getInstance() );
ChartImpl.registerUpdater('table:stream', TableStreamUpdater.getInstance() );

