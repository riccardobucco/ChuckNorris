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
var events=require('events');

module.exports = ChartImpl;

function ChartImpl (chartType, id) {
	if (!(this instanceof ChartImpl)) return new ChartImpl(id);
	events.EventEmitter.call(this); //ChartImpl inherits from events.EventEmitter
	this.uid = id;
	this.type=chartType;
	this.settings = {};
	this.data = {};
}

ChartImpl.prototype.__proto__=events.EventEmitter.prototype;

ChartImpl.prototype.factories = {}; // factories is a static variable

ChartImpl.prototype.updaters = {}; // updaters is a static variable

/**
 * ChartImpl.registerFactory is a static method which registers the correspondence between a chart's
 * type and its factory.
 *
 * @param chartType represents the chart's type, i.e. 'barchart', 'linechart', 'mapchart', 'table';
 * @param factory is the factory instance which corresponds to the chartType type.
 */
ChartImpl.registerFactory = function(chartType, factory) {
	ChartImpl.prototype.factories[chartType] = factory; /* EXPLICITLY assign to prototype property,
	otherwise it won't act as a static variable */
};

/**
 * ChartImpl.create is a static method which allows you to create specific kind of chart.
 *
 * @param chartType represents the chart's type, i.e. 'barchart', 'linechart', 'mapchart', 'table';
 * @param chartId the chart's ID;
 * @return 	a specific chart object.
*/
ChartImpl.createChart = function(chartType, chartId) {
	if (ChartImpl.prototype.factories.hasOwnProperty(chartType)) {
		var dep = ChartImpl.prototype.factories[chartType];
		return dep.createChart(chartId);
	}
	else
	return null;
};

/**
 * ChartImpl.registerUpdater is a static method which registers the correspondence between an updating
 * type and its updater.
 *
 * @param updateType represents the chart's updating type, i.e. 'stream', 'inplace', 'movie';
 * @param updater is the updater instance which corresponds to the updateType.
 */
ChartImpl.registerUpdater = function(updateType, updater) {
	ChartImpl.prototype.updaters[updateType] = updater; /* EXPLICITLY assign to prototype property,
	 otherwise it won't act as a static variable */
};

/**
 * ChartImpl.prototype.getId allows you to get the chart's ID.
 *
 * @return 	the chart's ID.
 */
ChartImpl.prototype.getId = function() {
	return this.uid;
};

/**
 * ChartImpl.prototype.getType allows you to get the chart's type.
 *
 * @return 	the chart's type.
 */
ChartImpl.prototype.getType = function() {
	return this.type;
};

/**
 * ChartImpl.prototype.setData allows you to set the chart's data.
 *
 * @param data is a JSON object containing chart's data.
 */
ChartImpl.prototype.setData = function(data) {
	this.data=data;
};

/**
 * ChartImpl.prototype.getData allows you to get the chart's data.
 *
 * @return 	the chart's data.
 */
ChartImpl.prototype.getData = function() {
	return this.data;
};

/**
 * ChartImpl.prototype.setSettings allows you to set the chart's settings. You're allowed to change value to
 * the default properties, but you cannot add new properties to chart's settings.
 *
 * @param settings is a JSON object containing chart's settings you wish to add.
 */
ChartImpl.prototype.setSettings = function(settings) {
	if(typeof settings == 'object') {
		for(var key in settings) {
			if(settings.hasOwnProperty(key)) {
				this.settings[key] = settings[key];
			}
		}
	}
};

/**
 * ChartImpl.prototype.getSettings allows you to get the chart's settings.
 *
 * @return 	the chart's settings.
 */
ChartImpl.prototype.getSettings = function() {
	return this.settings;
};

/**
 * ChartImpl.prototype.update allows you to update the chart's data.
 *
 * @param updateType represents the chart's updating type, i.e. 'stream', 'inplace', 'movie';
 * @param updateData contains new data and the information needed to update the chart.
 */
ChartImpl.prototype.update = function(updateType, updateData) {
	var type=this.getType()+":"+updateType;
	if (ChartImpl.prototype.updaters.hasOwnProperty(type)) {
		var dep=ChartImpl.prototype.updaters[type];
		dep.update(this, updateData);
		this.emit('update', updateType, updateData); // emits an 'update' signal
		console.log(JSON.stringify(this)); // TOGLIERE
	}
	else {
		console.log("ERROR: wrong updating type." );

	}
};

// For dependency injection:
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
