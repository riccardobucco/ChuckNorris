/*
 * Name: {BarChartImpl.js}
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
var BarChartInPlaceUpdater = require('./BarChartInPlaceUpdater.js');

//module.exports = BarChartImpl;

var defaults = {
	title : '' ,
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

function BarChartImpl (uid) {
	if (!(this instanceof BarChartImpl)) return new BarChartImpl(uid);
	ChartImpl.call(this, uid);
	this.setSettings(defaults);
	this.setType('barchart');
}

BarChartImpl.prototype.__proto__ = ChartImpl.prototype;

/* BarChartFactory ------------------------------------------------------- */

function BarChartFactory() {
	if(!(this instanceof BarChartFactory)) {
		return new BarChartFactory();
	}
}

BarChartFactory.prototype.instance=new BarChartFactory(); // static

BarChartFactory.getInstance = function() { // static
	return BarChartFactory.prototype.instance;
};

BarChartFactory.prototype.create = function (uid) {
	return new BarChartImpl(uid);
};

// Dependency injection:
ChartImpl.registerFactory('barchart' , BarChartFactory.getInstance());
ChartImpl.registerUpdater('inplace', BarChartInPlaceUpdater.getInstance() );
