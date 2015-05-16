/*
 * Name: {ChartImpl.js}
 * Module: {DataModel}
 * Location: {Norris/Main/DataModel}
 * Date: {2015-05-04}
 * Version: {v0.01}
 *
 * History:
 *
 * ================================================================================
 * Version Date Programmer Changes
 * ================================================================================
 * 0.01 2015-05-04 Chiara Bigarella {creation}
 * ================================================================================
 */

/**
 * ChartImpl represents a generic chart.
 * @type {ChartImpl}
 */


module.exports = ChartImpl;

function ChartImpl (id) {
	if (!(this instanceof ChartImpl)) return new ChartImpl(id);
	this.uid = id;
	this.type='';
	this.settings = {};
	this.data = {};
}

ChartImpl.prototype.factories = {}; // dependencies is a static variable

ChartImpl.prototype.updaters = {}; // dependencies is a static variable

/**
 * ChartImpl.registerFactory is a static method which registers the correspondence between a chart's
 * type and its factory.
 *
 * @param chartType represents the chart's type, i.e. 'barchart', 'linechart', 'mapchart', 'table';
 * @param factory is the factory instance which corresponds to the chartType type;
 * @return void
 */
ChartImpl.registerFactory = function(chartType, factory) {
	ChartImpl.prototype.factories[chartType] = factory; /* EXPLICITLY assign to prototype property,
	otherwise it won't act as a static variable */
};

/**
 * ChartImpl.create is a static method which allows you to create specific kind of chart.
 *
 * @param chartType represents the chart's type, i.e. 'barchart', 'linechart', 'mapchart', 'table'
 * @param chartId the chart's ID
 * @return ChartImpl
*/
ChartImpl.create = function(chartType, chartId) {
	if (ChartImpl.prototype.factories.hasOwnProperty(chartType)) {
		var dep = ChartImpl.prototype.factories[chartType];
		return dep.create(chartId);
	}
	else
	return null;
};

/**
 * ChartImpl.registerUpdater is a static method which registers the correspondence between an updating
 * type and its updater.
 *
 * @param updateType represents the chart's updating type, i.e. 'stream', 'inplace', 'movie';
 * @param updater is the updater instance which corresponds to the updateType;
 * @return void
 */
ChartImpl.registerUpdater = function(updateType, updater) {
	ChartImpl.prototype.updaters[updateType] = updater; /* EXPLICITLY assign to prototype property,
	 otherwise it won't act as a static variable */
};

ChartImpl.prototype.getId = function() {
	return this.uid;
};

ChartImpl.prototype.getType = function() {
	return this.type;
};

ChartImpl.prototype.setType = function(type) {
	this.type=type;
};

ChartImpl.prototype.setData = function(data) {
	this.data=data;
};

ChartImpl.prototype.getData = function() {
	return this.data;
};

ChartImpl.prototype.setSettings = function(settings) {
	if(typeof settings == 'object') {
		for(var key in settings) {
			if(settings.hasOwnProperty(key)) {
				this.settings[key] = settings[key];
			}
		}
	}
};

ChartImpl.prototype.getSettings = function() {
	return this.settings;
};

ChartImpl.prototype.update = function(updateType, updateData) {
	if (ChartImpl.prototype.updaters.hasOwnProperty(updateData)) {
		var dep=ChartImpl.prototype.updaters[updateType];
		dep.update(this, updateData);
		console.log(JSON.stringify(this)); // TOGLIERE
	}
};

// for dependency injection:
var BarChartImpl = require('./BarChartImpl.js');
var LineChartImpl = require('./LineChartImpl.js');
var MapChartImpl = require('./MapChartImpl.js');
var TableImpl = require('./TableImpl.js');

/*
/**
 * ChartModel.prototype.set allows you to set the ChartModel's settings property.
 *
 * @param param descrizione paramentro
 * @param info descrizione paramentro
 * @return descrizione tipo ritornato
 * /
ChartModel.prototype.set = function (param, info) {
	if(typeof param == 'object') {
		for(var key in param) {
			if(param.hasOwnProperty(key)) {
				this.settings[key] = param[key];
			}
		}
	} else {
		this.settings[param] = info;
	}
};

/**
 * ChartModel.prototype.get allows you to get the ChartModel's settings property.
 * @param key descrizione paramentro
 * @return descrizione tipo ritornato
 * /
ChartModel.prototype.get = function (param) {
	if (param != '')
		return this.settings[param];
	else
		return this.settings;
};
*/

