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

/**
 * Creates a new map chart.
 * @constructor
 * @param {String} id - the map chart's id.
 */
function MapChartImpl (id) {
	if (!(this instanceof MapChartImpl)) return new MapChartImpl(id);
	ChartImpl.call(this, 'mapchart', id);
	this.settings=defaults;
}

MapChartImpl.prototype.__proto__ = ChartImpl.prototype;

/* MapChartFactory ------------------------------------------------------- */

/**
 * Creates a new map chart factory.
 * @constructor
 */
function MapChartFactory() {
	if(!(this instanceof MapChartFactory)) return new MapChartFactory();
}

MapChartFactory.prototype.instance=new MapChartFactory(); // static

/**
 * Gets the MapChartFactory's instance.
 * @returns {MapChartFactory} the factory's instance.
 */
MapChartFactory.getInstance = function() { // static
	return MapChartFactory.prototype.instance;
};

/**
 * Creates a new map chart.
 * @param {String} id - the map chart's id;
 * @returns {MapChartImpl} - the created map chart.
 */
MapChartFactory.prototype.createChart = function (id) {
	return new MapChartImpl(id);
};

// Dependency injection:
ChartImpl.registerFactory('mapchart' , MapChartFactory.getInstance());
ChartImpl.registerUpdater('mapchart:inplace', MapChartInPlaceUpdater.getInstance() );
ChartImpl.registerUpdater('mapchart:movie', MapChartMovieUpdater.getInstance() );

