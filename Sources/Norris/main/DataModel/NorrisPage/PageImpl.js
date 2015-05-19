/*
 * Name: {PageImpl.js}
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
 * @param settings - a JSON object containing the page's settings you wish to add.
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
 * @return 	the page's settings.
 */
PageImpl.prototype.getSettings = function() {
	return this.settings;
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
