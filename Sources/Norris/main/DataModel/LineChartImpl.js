/*
 * Name: {LineChartImpl.js}
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
var LineChartInPlaceUpdater = require('./LineChartInPlaceUpdater.js');
var LineChartStreamUpdater = require('./LineChartStreamUpdater.js');

// module.exports = LineChartImpl;

var defaults = {
	title : '' ,
	description : 'This is a line chart.',
	xlabel : '',
	ylabel : '',
	showGrid : false,
	showLegend : true,
	legendPosition : 'top-right',
	maxPoints : 10,
	format : {
		pointDotRadius : 1 , // Number - Radius of each point dot in pixels
		bezierCurve : true // Boolean - Whether the line is curved between points
	}
};

function LineChartImpl (uid) {
	if (!(this instanceof LineChartImpl)) return new LineChartImpl(uid);
	ChartImpl.call(this, 'linechart', uid);
	this.setSettings(defaults);
}

LineChartImpl.prototype.__proto__ = ChartImpl.prototype;

/* LineChartFactory ------------------------------------------------------- */

function LineChartFactory() {
	if(!(this instanceof LineChartFactory)) return new LineChartFactory();
}

LineChartFactory.prototype.instance=new LineChartFactory(); // static

LineChartFactory.getInstance = function() { // static
	return LineChartFactory.prototype.instance;
};
LineChartFactory.prototype.createChart = function (uid) {
	return new LineChartImpl(uid);
};

// Dependency injection:
ChartImpl.registerFactory('linechart' , LineChartFactory.getInstance());
ChartImpl.registerUpdater('linechart:inplace', LineChartInPlaceUpdater.getInstance() );
ChartImpl.registerUpdater('linechart:stream', LineChartStreamUpdater.getInstance() );


