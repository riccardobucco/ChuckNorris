/*
 * Name: {ChartRef.js}
 * Module: {ExternalAPIManager}
 * Location: {Norris/Main/ExternalAPIManager}
 * Date: {2015-05-24}
 * Version: {v0.01}
 *
 * History:
 *
 * ================================================================================
 * Version  Date        Author              Changes
 * ================================================================================
 * 0.01     2015-05-24  Chiara Bigarella    {creation}
 * ================================================================================
 */

var events=require('events');
var NorrisChart = require('../DataModel/NorrisChart');

module.exports = ChartRef;


/**
 * Creates a new ChartRef.
 * @constructor
 * @param {ChartImpl} chart - a ChartImpl, i.e. 'barchart', 'linechart', 'mapchart', 'table';
 */
function ChartRef (chart) {
    if (!(this instanceof ChartRef)) return new ChartRef(chart);
    events.EventEmitter.call(this); //ChartRef inherits from events.EventEmitter
    if ((chart instanceof NorrisChart)) {
        this.chart = chart;
    }
    else {
        this.chart=null;
        console.log("ERROR: chart is not a ChartImpl");
    }
}

ChartRef.prototype.__proto__=events.EventEmitter.prototype;

/**
 * Gets the chart's ID.
 *
 * @return {String} the chart's ID.
 */
ChartRef.prototype.getId = function() {
    return this.chart.getId();
};

/**
 * Gets the chart's type.
 *
 * @return {String} the chart's type.
 */
ChartRef.prototype.getType = function() {
    return this.chart.getType();
};

/**
 * Gets the chart's data.
 *
 * @return 	{ChartData} the chart's data.
 */
ChartRef.prototype.getData = function() {
    return this.chart.getData();
};

/**
 * Gets the chart's settings.
 *
 * @return 	{ChartSettings} the chart's settings.
 */
ChartRef.prototype.getSettings = function() {
    return this.chart.getSettings();
};