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

// module.exports = TableImpl;

ChartImpl.registerFactory('table' , new TableFactory());

var defaults = {
	title : '' ,
	description : 'This is a table.',
	showLegend : true,
	legendPosition : 'top-right',
	maxPoints : 5
};

function TableImpl (uid) {
	if (!(this instanceof TableImpl)) return new TableImpl(uid);
	ChartImpl.call(this, uid);
	this.setSettings(defaults);
	this.setType('table');
}

TableImpl.prototype.__proto__ = ChartImpl.prototype;

/* TableFactory ------------------------------------------------------- */

function TableFactory() {
	if(!(this instanceof TableFactory)) return new TableFactory();
}

TableFactory.prototype.create = function (uid) {
	return new TableImpl(uid);
};