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

/**
 * PageImpl represents a web page which contains one or more charts.
 * @type {PageImpl}
 */

var ChartImpl = require('./ChartImpl.js');

module.exports = PageImpl;

var defaults = {
	title: 'Norris\'s page',
	maxChartsRow: 2, // maximum number of charts per row
	maxChartsCol: 3 // maximum number of charts per column
};

function PageImpl (PageId) {
	if (!(this instanceof PageImpl)) return new PageImpl(PageId);
	this.uid = PageId;
	this.settings = {};
	this.charts = [];
	this.setSettings(defaults);
}

/**
 * PageImpl.add allows you to add a chart to the page.
 *
 * @param chart is the chart you want to add to the page;
 * @return PageImpl
 */
PageImpl.prototype.add = function (chart) {
	if ((chart instanceof ChartImpl)) {
		this.charts.push(chart);
		return this;
	}
	else {
		console.log("ERROR: wrong type. A ChartImpl widget is required.");
		return null;
	}
};

PageImpl.prototype.getId = function() {
	return this.uid;
};

PageImpl.prototype.setSettings = function(settings) {
	if(typeof settings == 'object') {
		for(var key in settings) {
			if(settings.hasOwnProperty(key)) {
				this.settings[key] = settings[key];
			}
		}
	}
};

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
