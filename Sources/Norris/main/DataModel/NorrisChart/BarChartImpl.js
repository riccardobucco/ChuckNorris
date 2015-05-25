/*
 * Name: {BarChartImpl.js}
 * Module: {}
 * Location: {Norris/Main/DataModel/NorrisChart}
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
var BarChartInPlaceUpdater = require('./BarChartInPlaceUpdater.js');

module.exports = BarChartImpl;

var defaults = {
	description : 'This is a bar chart.',
	xlabel : '',
	ylabel : '',
	showGrid : false,
	showLegend : true,
	legendPosition : 'top-right',
	orientation : 'vertical',
	maxBars: 10,
	format : {
		barValueSpacing : 1 , //Number - Spacing between each of the X value sets
		barDatasetSpacing : 5 //Number - Spacing between data sets within X values
	}
};

/**
 * Creates a new bar chart.
 * @constructor
 * @param {String} id - the bar chart's id.
 */

function BarChartImpl (uid) {
	if (!(this instanceof BarChartImpl)) return new BarChartImpl(uid);
	ChartImpl.call(this, 'barchart', uid);
	for(var key in defaults) {
		this.settings[key] = defaults[key];
	}
}

BarChartImpl.prototype.__proto__ = ChartImpl.prototype;

/* BarChartFactory ------------------------------------------------------- */

/**
 * Creates a new bar chart factory.
 * @constructor
 */
function BarChartFactory() {
	if(!(this instanceof BarChartFactory)) {
		return new BarChartFactory();
	}
}

BarChartFactory.prototype.instance=new BarChartFactory(); // static

/**
 * Gets the BarChartFactory's instance.
 * @returns {BarChartFactory} the factory's instance.
 */
BarChartFactory.getInstance = function() { // static
	return BarChartFactory.prototype.instance;
};

/**
 * Creates a new bar chart.
 * @param {String} id - the bar chart's id;
 * @returns {BarChartImpl} - the created bar chart.
 */
BarChartFactory.prototype.createChart = function (id) {
	return new BarChartImpl(id);
};

// Dependency injection:
ChartImpl.registerFactory('barchart' , BarChartFactory.getInstance());
ChartImpl.registerUpdater('barchart:inplace', BarChartInPlaceUpdater.getInstance() );
