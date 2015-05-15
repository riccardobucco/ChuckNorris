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

// module.exports = LineChartImpl;

ChartImpl.registerFactory('linechart' , new LineChartFactory());

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
	ChartImpl.call(this, uid);
	this.setSettings(defaults);
	this.setType('linechart');

}

LineChartImpl.prototype.__proto__ = ChartImpl.prototype;

/* LineChartFactory ------------------------------------------------------- */

function LineChartFactory() {
	if(!(this instanceof LineChartFactory)) return new LineChartFactory();
}
LineChartFactory.prototype.create = function (uid) {
	return new LineChartImpl(uid);
};