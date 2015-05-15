/*
 * Name: {MapChartImpl.js}
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
 * 0.01 2015-05-04 Chiara Bigarella {creation}
 * ================================================================================
 */

var ChartImpl = require('./ChartImpl.js');

//module.exports = MapChartImpl;

ChartImpl.registerFactory('mapchart' , new MapChartFactory());

var defaults = {
	title : '' ,
	description : 'This is a map chart.',
	showLegend : true,
	legendPosition : 'top-right',
	maxPoints : 5
};

function MapChartImpl (uid) {
	if (!(this instanceof MapChartImpl)) return new MapChartImpl(uid);
	ChartImpl.call(this, uid);
	this.setSettings(defaults);
	this.setType('mapchart');

}

MapChartImpl.prototype.__proto__ = ChartImpl.prototype;

/* MapChartFactory ------------------------------------------------------- */

function MapChartFactory() {
	if(!(this instanceof MapChartFactory)) return new MapChartFactory();
}

MapChartFactory.prototype.create = function (uid) {
	return new MapChartImpl(uid);
};