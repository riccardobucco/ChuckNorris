/*
 * Name: PageImpl.js
 * Module: DataModel
 * Location: Norris/Main/DataModel
 * Date: 2015-04-12
 * Version: v0.06
 *
 * History:
 *
 * ================================================================================
 * Version Date Programmer Changes
 * ================================================================================
 * v0.06 2015-05-24 Carlon Chiara   Verify
 * ================================================================================
 * v0.05 2015-05-21 Pavanello Fabio Matteo   Edit
 * ================================================================================
 * v0.04 2015-04-27 Carlon Chiara   Verify
 * ================================================================================
 * v0.03 2015-04-25 Chiara Bigarella   Edit
 * ================================================================================
 * v0.02 2015-04-14 Pavanello Fabio Matteo   Verify
 * ================================================================================
 * v0.01 2015-04-12 Moretto Alessandro   Creation
 * ================================================================================
 */

var NorrisChart = require('../NorrisChart');

module.exports = PageImpl;

var defaults = {
	title: 'Norris\'s page',
	maxChartsRow: 2, // maximum number of charts per row
	maxChartsCol: 3 // maximum number of charts per column
};

/**
 * Creates a new page.
 * @constructor
 * @param {String} PageId - the page's id.
 */
function PageImpl (PageId) {
	if (!(this instanceof PageImpl)) return new PageImpl(PageId);
	this.uid = PageId;
	this.settings = {};
	this.charts = [];
	this.setSettings(defaults);
}

/**
 * Adds a chart to the page.
 *
 * @param {ChartImpl} chart - the chart you wish to add to the page;
 * @return {PageImpl} the page to which you've added the chart.
 */
PageImpl.prototype.add = function (chart) {
	if (this.charts.length < (this.settings['maxChartsCol']*this.settings['maxChartsRow']) ) {
		if ((chart instanceof NorrisChart)) {
			this.charts.push(chart);
			return this;
		}
		else {
			console.log("ERROR: wrong type. A NorrisChart widget is required.");
			return null;
		}
	}
	else {
		console.log("ERROR: maximum number of charts is reached. You cannot add other charts to the page.");
		return null;
	}

};

/**
 * Gets the page's ID.
 *
 * @return {String} the page's ID.
 */
PageImpl.prototype.getId = function() {
	return this.uid;
};

/**
 * Sets the page's settings. You're allowed to change value to the default properties, but you cannot add
 * new properties to the page's settings.
 *
 * @param {PageSettings} settings - a JSON object containing the page's settings you wish to add.
 */
PageImpl.prototype.setSettings = function(settings) {
	if(typeof settings == 'object') {
		for(var key in settings) {
			if(settings.hasOwnProperty(key)) {
				this.settings[key] = settings[key];
			}
		}
	}
};

/**
 * Gets the page's settings.
 *
 * @return {PageSettings} the page's settings.
 */
PageImpl.prototype.getSettings = function() {
	return this.settings;
};

/**
 * Gets the page's charts.
 *
 * @return {ChartImpl[]} the page's charts.
 */
PageImpl.prototype.getCharts = function() {
	return this.charts;
};

/**
 * Removes all the charts in the page.
 */
PageImpl.prototype.clearCharts = function() {
	this.charts=[];
};
/*
/* Modifica le impostazioni * /
PageImpl.prototype.set = function (param, info) {
	if(typeof param == 'object') {
		for(var key in param) {
			if(param.hasOwnProperty(key)) {
				this.settings[key] = param[key];
			}
		}
	} else {
		this.settings[param] = info;
	}
}

*/
