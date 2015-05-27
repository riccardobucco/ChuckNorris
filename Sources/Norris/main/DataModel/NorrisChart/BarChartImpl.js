/*
 * Name: {BarChartImpl.js}
 * Module: {DataModel/NorrisChart}
 * Location: {Norris/Main/DataModel/NorrisChart}
 * Date: {2015-04-12}
 * Version: {v0.6}
 *
 * History:
 *
 * ================================================================================
 * Version Date Programmer Changes
 * ================================================================================
 * 0.06 2015-05-24 Carlon Chiara   Verify
 * ================================================================================
 * 0.05 2015-05-21 Pavanello Fabio Matteo   Edit
 * ================================================================================
 * 0.04 2015-04-27 Carlon Chiara   Verify
 * ================================================================================
 * 0.03 2015-04-25 Chiara Bigarella   Edit
 * ================================================================================
 * 0.02 2015-04-14 Bigarella Chiara   Verify
 * ================================================================================
 * 0.01 2015-04-12 Bucco Riccardo   Creation
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
