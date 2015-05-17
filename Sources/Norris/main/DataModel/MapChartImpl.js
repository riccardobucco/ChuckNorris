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
var MapChartInPlaceUpdater = require('./MapChartInPlaceUpdater.js');
var MapChartMovieUpdater = require('./MapChartMovieUpdater.js');

//module.exports = MapChartImpl;

var defaults = {
	title : '' ,
	description : 'This is a map chart.',
	showLegend : true,
	legendPosition : 'top-right',
	maxPoints : 5
};

function MapChartImpl (uid) {
	if (!(this instanceof MapChartImpl)) return new MapChartImpl(uid);
	ChartImpl.call(this, 'mapchart', uid);
	this.setSettings(defaults);
}

MapChartImpl.prototype.__proto__ = ChartImpl.prototype;

/* MapChartFactory ------------------------------------------------------- */

function MapChartFactory() {
	if(!(this instanceof MapChartFactory)) return new MapChartFactory();
}

MapChartFactory.prototype.instance=new MapChartFactory(); // static

MapChartFactory.getInstance = function() { // static
	return MapChartFactory.prototype.instance;
};

MapChartFactory.prototype.createChart = function (id) {
	return new MapChartImpl(id);
};

// Dependency injection:
ChartImpl.registerFactory('mapchart' , MapChartFactory.getInstance());
ChartImpl.registerUpdater('mapchart:inplace', MapChartInPlaceUpdater.getInstance() );
ChartImpl.registerUpdater('mapchart:movie', MapChartMovieUpdater.getInstance() );

