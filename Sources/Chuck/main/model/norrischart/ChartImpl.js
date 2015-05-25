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

angular.module('chuck-chart', ['norris-chartupdater'])

.factory('ChartImpl', [function () {

	/**
	 * Creates a new chart.
	 * @constructor
	 * @param {String} chartType - the chart's type, i.e. 'barchart', 'linechart', 'mapchart', 'table';
	 * @param {String} id - the chart's id.
	 */
	function ChartImpl (chartType, id) {
		if (!(this instanceof ChartImpl)) return new ChartImpl(chartType,id);
		this.uid = id;
		this.type=chartType;
		this.settings = {title : '' , description : 'This is a chart.'};
		this.data = {};
	};

	ChartImpl.prototype.factories = {}; // factories is a static variable

	ChartImpl.prototype.updaters = {}; // updaters is a static variable

	/**
	 * A static method which registers the correspondence between a chart's type and its factory.
	 *
	 * @param {String} chartType - the chart's type, i.e. 'barchart', 'linechart', 'mapchart', 'table';
	 * @param {ChartFactory} factory - the factory instance which corresponds to the type in chartType.
	 */
	ChartImpl.registerFactory = function(chartType, factory) {
		ChartImpl.prototype.factories[chartType] = factory; /* EXPLICITLY assign to prototype property,
		otherwise it won't act as a static variable */
	};

	/**
	 * A static method which allows you to create specific kinds of chart.
	 *
	 * @param {String} chartType - the chart's type, i.e. 'barchart', 'linechart', 'mapchart', 'table';
	 * @param {String} chartId - the chart's ID;
	 * @return {ChartImpl} the created chart.
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
	 * A static method which registers the correspondence between an updating type and its updater.
	 *
	 * @param {String} updateType - the chart's updating type, i.e. 'linechart:stream', 'barchart:inplace',
	 * 'mapchart:movie', and so on;
	 * @param {ChartUpdater} updater - the updater instance which corresponds to the updating type in updateType.
	 */
	ChartImpl.registerUpdater = function(updateType, updater) {
		ChartImpl.prototype.updaters[updateType] = updater; /* EXPLICITLY assign to prototype property,
		 otherwise it won't act as a static variable */
	};

	/**
	 * Gets the chart's ID.
	 *
	 * @return {String} the chart's ID.
	 */
	ChartImpl.prototype.getId = function() {
		return this.uid;
	};

	/**
	 * Gets the chart's type.
	 *
	 * @return {String} the chart's type.
	 */
	ChartImpl.prototype.getType = function() {
		return this.type;
	};

	/**
	 * Sets the chart's data.
	 *
	 * @param {ChartData} data - a JSON object containing the chart's data.
	 */
	ChartImpl.prototype.setData = function(data) {
		this.data=data;
	};

	/**
	 * Gets the chart's data.
	 *
	 * @return 	{ChartData} the chart's data.
	 */
	ChartImpl.prototype.getData = function() {
		return this.data;
	};

	/**
	 * Sets the chart's settings. You're allowed to change value to the default properties, but you cannot add
	 * new properties to the chart's settings.
	 *
	 * @param {ChartSettings} settings - a JSON object containing the chart's settings you wish to add.
	 */
	ChartImpl.prototype.setSettings = function(settings) {
		if(typeof settings == 'object') {
			for(var key in settings) {
				if(this.settings.hasOwnProperty(key)) {
					this.settings[key] = settings[key];
				}
			}
		}
	};

	/**
	 * Gets the chart's settings.
	 *
	 * @return 	{ChartSettings} the chart's settings.
	 */
	ChartImpl.prototype.getSettings = function() {
		return this.settings;
	};

	/**
	 * Updates the chart's data.
	 *
	 * @param {String} updateType - the chart's updating type, i.e. 'stream', 'inplace', 'movie';
	 * @param {ChartUpdate} updateData - contains the new data and the information needed to update the chart.
	 */
	ChartImpl.prototype.update = function(updateType, updateData) {
		var type=this.getType()+":"+updateType;
		if (ChartImpl.prototype.updaters.hasOwnProperty(type)) {
			var dep=ChartImpl.prototype.updaters[type];
			dep.update(this, updateData);
		}
		else {
			console.log("ERROR: wrong updating type." );

		}
	};

	return ChartImpl;

}]);